package com.realdolmen.spring;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceProvider;
import javax.sql.DataSource;

@ComponentScan
@EnableTransactionManagement
public class ZooConfig {
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    // TODO: Configure a DataSource for MySQL in the production profile (BasicDataSource)
    @Bean
    public BasicDataSource basicDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");
        basicDataSource.setInitialSize(20);
        basicDataSource.setMaxActive(30);
        return basicDataSource;
    }

    // TODO: configure an embedded DataSource for H2 in the test profile
    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder() .setType(EmbeddedDatabaseType.H2) .addScript("classpath:schema.sql") .addScript("classpath:test-data.sql") .build();
    }

    // TODO: Configure an EntityManagerFactory bean for use with Hibernate
    @Profile("production")
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(basicDataSource());

        HibernateJpaVendorAdapter jpaVA = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVA);
        jpaVA.setDatabase(Database.MYSQL);

        return em;
    }

    @Profile("test")
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryTest(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(basicDataSource());

        HibernateJpaVendorAdapter jpaVA = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(jpaVA);
        jpaVA.setDatabase(Database.H2);

        return em;
    }

    // TODO: Make sure your EntityManagerFactoryBean is set up for using dialect H2 in test and dialect MySQL in production

}

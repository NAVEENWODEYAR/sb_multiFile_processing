package com.example.demo.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.*;

import com.example.demo.log.SQLLoggingInterceptor;


/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:24:31 am
 */

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();
        
        // Set Hibernate properties (data source, dialect, etc.)
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        // Add other properties and entity classes

        // Set the statement inspector
        configuration.setStatementInspector(new SQLLoggingInterceptor());

        // Build the session factory
        return configuration.buildSessionFactory(new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build());
    }
}

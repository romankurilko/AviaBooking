package com.courses.spalah.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Created by Roman on 24.11.2016.
 */
@Configuration
@EnableTransactionManagement
public class PersistenceConfiguration {
    private static final String ENTITY_PACKAGE_TO_SCAN = "com.courses.spalah.domain";

    private static final String PROP_HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String PROP_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String PROP_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";

    @Bean
    public JpaTransactionManager jpaTransactionManager() {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());

        return jpaTransactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        factoryBean.setPackagesToScan(ENTITY_PACKAGE_TO_SCAN);
        factoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        factoryBean.setDataSource(dataSource());

        //factoryBean.setValidationMode(ValidationMode.CALLBACK);

        return factoryBean;
    }

    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put(PROP_HIBERNATE_DIALECT, "org.hibernate.dialect.MySQL5Dialect");
        properties.put(PROP_HIBERNATE_SHOW_SQL, "true");
        properties.put(PROP_HIBERNATE_HBM2DDL_AUTO, "validate");

        return properties;
    }

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        FileInputStream inputStream;
        Properties properties = new Properties();
        try {
            inputStream = new FileInputStream("C:/final_db.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String host = properties.getProperty("url");
        String login = properties.getProperty("username");
        String password = properties.getProperty("password");

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(host);
        dataSource.setUsername(login);
        dataSource.setPassword(password);

        return dataSource;
    }
}

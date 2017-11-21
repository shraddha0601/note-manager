package com.demo.keeptuit.db.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Configuration
@ComponentScan("com.demo.keeptuit.db")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.demo.keeptuit.db")
public class DbConfiguration {

    @Autowired
    private DataSource dataSource;

    @Value("${keeptuit.datastore.sessionFactory.hibernate.dialect:org.hibernate.dialect.H2Dialect}")
    private String dialect;

//    @Value("${keeptuit.datastore.schema:keeptuit}")
//    private String schema;

    @Value("${keeptuit.id.new.generator.mappings:true}")
    private boolean isSequenceGen;

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        jpaVendorAdapter.setDatabasePlatform(dialect);
        jpaVendorAdapter.setDatabase(Database.H2);
        jpaVendorAdapter.setGenerateDdl(true);
        return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean lemfb = new LocalContainerEntityManagerFactoryBean();
        lemfb.setDataSource(dataSource);
        lemfb.setJpaVendorAdapter(jpaVendorAdapter());
        lemfb.setJpaProperties(hibernateProperties());
        lemfb.setPackagesToScan("com.demo.keeptuit.db.entity");
        return lemfb;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.connection.characterEncoding", "UTF-8");
        properties.put("hibernate.jdbc.batch_size", 0);
        properties.put("hibernate.globally_quoted_identifiers", true);
        properties.put("hibernate.cache.auto_evict_collection_cache", true);
        properties.put("hibernate.connection.useUnicode", true);
//        properties.put("hibernate.default_schema", schema);
        properties.put("hibernate.dialect", dialect);
        properties.put("hibernate.id.new_generator_mappings", isSequenceGen);
        return properties;
    }
}
//package com.backendservice.configs;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.*;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import com.backendservice.configs.DatabaseProperty;
//
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Objects;
//
//@Configuration
//@EnableJpaRepositories(
//        basePackages = BackendDBConfig.JPA_REPOSITORY_PACKAGE,
//        entityManagerFactoryRef = BackendDBConfig.ENTITY_MANAGER_FACTORY,
//        transactionManagerRef =  BackendDBConfig.TRANSACTION_MANAGER
//)
//public class BackendDBConfig {
//
//    public static final String PROPERTY_PREFIX = "com.backendservice.backenddb";
//    public static final String JPA_REPOSITORY_PACKAGE = "com.backendservice.databases.backenddb.repositories";
//    public static final String ENTITY_PACKAGE = "com.backendservice.databases.backenddb.entities";
//    public static final String ENTITY_MANAGER_FACTORY = "backendEntityManagerFactory";
//    public static final String DATA_SOURCE = "backendDataSource";
//    public static final String DATABASE_PROPERTY = "backendDatabaseProperty";
//    public static final String TRANSACTION_MANAGER = "backendTransactionManager";
//    private static final Logger log = LoggerFactory.getLogger(BackendDBConfig.class);
//
//
//    @Bean(DATABASE_PROPERTY)
//    @ConfigurationProperties(prefix = PROPERTY_PREFIX)
//    public DatabaseProperty appDatabaseProperty(){
//        return new DatabaseProperty();
//    }
//
//    @Bean(DATA_SOURCE)
//    public DataSource appDataSource(@Qualifier(DATABASE_PROPERTY) DatabaseProperty databaseProperty){
//        return DataSourceBuilder
//                .create()
//                .username(databaseProperty.getUsername())
//                .password(databaseProperty.getPassword())
//                .url(databaseProperty.getUrl())
//                .driverClassName(databaseProperty.getClassDriver())
//                .build();
//    }
//
//    @Bean(ENTITY_MANAGER_FACTORY)
//    public LocalContainerEntityManagerFactoryBean appEntityManager(@Qualifier(DATA_SOURCE) DataSource dataSource){
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setPackagesToScan(ENTITY_PACKAGE);
//        factoryBean.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
//        factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
//
//        HashMap<String,Object> properties = new HashMap<>();
//        properties.put("javax.persistence.validation.mode", "none");
//        properties.put("hibernate.hbm2ddl.auto", "update");
//
//        factoryBean.setJpaPropertyMap(properties);
//        return factoryBean;
//    }
//
//    @Primary
//    @Bean(TRANSACTION_MANAGER)
//    public PlatformTransactionManager sqlSessionTemplate(
//            @Qualifier(ENTITY_MANAGER_FACTORY) LocalContainerEntityManagerFactoryBean entityManager,
//            @Qualifier(DATA_SOURCE) DataSource dataSource
//    ){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManager.getObject());
//        transactionManager.setDataSource(dataSource);
//        log.info("Transaction manager resolution: " + Objects.equals(transactionManager,null));
//        return transactionManager;
//    }
//}

package com.backendservice.configs;


import com.backendservice.configs.DatabaseProperty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@EnableJpaRepositories(
        entityManagerFactoryRef = BackendDBConfig.ENTITY_MANAGER_FACTORY,
        transactionManagerRef = BackendDBConfig.TRANSACTION_MANAGER,
        basePackages = BackendDBConfig.JPA_REPOSITORY_PACKAGE
)
@Configuration
public class BackendDBConfig {

  public static final String PROPERTY_PREFIX = "com.backendservice.backenddb";
    public static final String JPA_REPOSITORY_PACKAGE = "com.backendservice.databases.backenddb.repositories";
    public static final String ENTITY_PACKAGE = "com.backendservice.databases.backenddb.entities";
    public static final String ENTITY_MANAGER_FACTORY = "backendEntityManagerFactory";
    public static final String DATA_SOURCE = "backendDataSource";
    public static final String DATABASE_PROPERTY = "backendDatabaseProperty";
    public static final String TRANSACTION_MANAGER = "backendTransactionManager";
//    private static final Logger log = LoggerFactory.getLogger(BackendDBConfig.class);

    @Bean(DATABASE_PROPERTY)
    @ConfigurationProperties(prefix = PROPERTY_PREFIX)
    public DatabaseProperty databaseProperty() {
        return new DatabaseProperty();
    }

    @Bean(DATA_SOURCE)
    public DataSource databaseDataSource(@Qualifier(DATABASE_PROPERTY) DatabaseProperty databaseProperty) {
        return DataSourceBuilder
                .create()
                .username(databaseProperty.getUsername())
                .password(databaseProperty.getPassword())
                .url(databaseProperty.getUrl())
                .driverClassName(databaseProperty.getClassDriver())
                .build();
    }

    @Bean(ENTITY_MANAGER_FACTORY)
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier(DATA_SOURCE) DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setDataSource(dataSource);
        bean.setPackagesToScan(ENTITY_PACKAGE);
        bean.setPersistenceUnitName(ENTITY_MANAGER_FACTORY);
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.validation.mode", "none");
        properties.put("hibernate.hbm2ddl.auto", "update");
        bean.setJpaPropertyMap(properties);
        return bean;
    }

    @Primary
    @Bean(TRANSACTION_MANAGER)
    public PlatformTransactionManager transactionManager(
            @Qualifier(ENTITY_MANAGER_FACTORY) LocalContainerEntityManagerFactoryBean entityManager,
            @Qualifier(DATA_SOURCE) DataSource dataSource) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManager.getObject());
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
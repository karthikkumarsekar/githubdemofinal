package com.karthik.github.demo.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "h2EntityManagerFactory",
        transactionManagerRef = "h2TransactionManager",
        basePackages = "com.karthik.github.demo.h2"
)
public class H2Config {

    @Bean(name = "h2DataSource")
    @Primary
    DataSource h2DataSource(){
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:file:~/test");
        dataSource.setPassword("");
        dataSource.setUsername("sa");
        return dataSource;
    }

    @Bean(name="h2EntityManagerFactory")
    EntityManagerFactory entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setDataSource(h2DataSource());
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        lef.setJpaVendorAdapter(vendorAdapter);
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProperties.put("hibernate.show_sql",true);
        jpaProperties.put("hibernate.hbm2ddl.auto","update");
        lef.setJpaProperties(jpaProperties);
        lef.setPackagesToScan("com.karthik.github.demo");
        lef.setPersistenceUnitName("h2PersistenceUnit");
        lef.afterPropertiesSet();

        return lef.getObject();
    }

    @Bean(name="h2TransactionManager")
    @Primary
    PlatformTransactionManager platformTransactionManager(){
        return new JpaTransactionManager(entityManagerFactory());
    }
}

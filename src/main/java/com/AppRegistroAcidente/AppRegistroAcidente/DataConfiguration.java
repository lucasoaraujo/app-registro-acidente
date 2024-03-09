package com.AppRegistroAcidente.AppRegistroAcidente;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;


@Configuration
public class DataConfiguration {

    @Bean	
	public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/AppRegistroAcidente?useTimezone=true&serverTimezone=UTC");
    	dataSource.setUsername("root");
    	dataSource.setPassword("admin");
    	return dataSource;	   
    }
    
    @Bean
    public AbstractJpaVendorAdapter jpaVendorAdapter() {
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setDatabase(Database.MYSQL);
    	adapter.setShowSql(true);
    	adapter.setGenerateDdl(true);
    	adapter.setDatabasePlatform("org.hibernate.dialect.MariaDBDialect");
    	adapter.setPrepareConnection(true);
    	return adapter;
    	
    }
	
}
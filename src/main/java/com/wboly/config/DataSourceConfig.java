package com.wboly.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
    
 	// Orcale 数据库
 	// 这里的 bean 名字要和上面自定义的名字一样
	@Bean(name = "hnkyyy")
    @ConfigurationProperties(prefix = "spring.datasource.hnkyyy") // application.properteis中对应属性的前缀
    public DataSource dataSourceCrm() {
        return DataSourceBuilder.create().build();
    }
    
	// mysql 数据库
	@Bean(name = "logapi")
    @ConfigurationProperties(prefix = "spring.datasource.logapi") // application.properteis中对应属性的前缀
    public DataSource dataSourcelogapi() {
        return DataSourceBuilder.create().build();
    }
}


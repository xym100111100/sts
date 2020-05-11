package com.wboly.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.wboly.mapper.user"}, sqlSessionFactoryRef = "sqlSessionFactorylogapi")
public class MybatisDbLogApiConfig {
	
	@Autowired
    @Qualifier("logapi")
    private DataSource logapi;

    @Bean
    public SqlSessionFactory sqlSessionFactorylogapi() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(logapi); // 连接 logapi 库
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplatelogapi() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactorylogapi()); // 使用上面配置的Factory
        return template;
    }
}


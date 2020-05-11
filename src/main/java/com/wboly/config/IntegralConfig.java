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
@MapperScan(basePackages = {"com.wboly.mapper.integral"}, sqlSessionFactoryRef = "sqlSessionFactoryIntegral")
public class IntegralConfig {
	@Autowired
    @Qualifier("integral")
    private DataSource integral;

    @Bean
    public SqlSessionFactory sqlSessionFactoryIntegral() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(integral); // 连接 order 库
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateIntegral() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryIntegral()); // 使用上面配置的Factory
        return template;
    }
}

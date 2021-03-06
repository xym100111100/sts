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
@MapperScan(basePackages = {"com.wboly.mapper.order"}, sqlSessionFactoryRef = "sqlSessionFactoryOrder")
public class OrderConfig {
	@Autowired
    @Qualifier("order")
    private DataSource order;

    @Bean
    public SqlSessionFactory sqlSessionFactoryOrder() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(order); // 
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateOrder() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryOrder()); // 使用上面配置的Factory
        return template;
    }
}

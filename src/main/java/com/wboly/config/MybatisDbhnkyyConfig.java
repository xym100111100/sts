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
@MapperScan(basePackages = {"com.wboly.mapper"}, sqlSessionFactoryRef = "sqlSessionFactoryCrm")
public class MybatisDbhnkyyConfig {
	@Autowired
    @Qualifier("hnkyyy")
    private DataSource hnkyyy;

    @Bean
    public SqlSessionFactory sqlSessionFactoryCrm() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(hnkyyy); // 连接 hnkyyy 库
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateCrm() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactoryCrm()); // 使用上面配置的Factory
        return template;
    }
}

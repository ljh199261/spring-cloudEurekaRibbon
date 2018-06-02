package com.config;


import com.github.pagehelper.PageHelper;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.mapper.master",sqlSessionFactoryRef ="masterSqlSessionFactory")
public class MasterDataSourceConfig {
    @Value("${spring.master.datasource.url}")
    private String url;
    @Value("${spring.master.datasource.username}")
    private String username;
    @Value("${spring.master.datasource.password}")
    private String password;
    @Value("${spring.master.datasource.driver-class-name}")
    private String driverClassName;

    @Bean(name = "masterDataSource")
    @Primary
    public DataSource masterDataSource(){
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(password);
//        DruidDataSource dataSource = new  DruidDataSource();
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource)throws
            Exception {
        final SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        //分页拦截器
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum","true");
        properties.setProperty("rowBoundsWithCount","true");
        properties.setProperty("reasonable","true");
        properties.setProperty("dialect","mysql");
        pageHelper.setProperties(properties);
        sqlSessionFactory.setPlugins(new Interceptor[]{pageHelper});
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath*:mybatis/master/*.xml"));
        return sqlSessionFactory.getObject();
    }


    //配置mybatis的分页插件pageHelper

//    @Bean
//    @Primary
//    public PageHelper pageHelper(){
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum","true");
//        properties.setProperty("rowBoundsWithCount","true");
//        properties.setProperty("reasonable","true");
//        properties.setProperty("dialect","mysql");
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }
}

package com.stone.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by chenchen on 2017/6/4.
 */
@Configuration
@MapperScan(basePackages = TestDataSourceConfig.BASEPACKAGE, sqlSessionFactoryRef="testSqlSessionFactory")
public class TestDataSourceConfig {

    static final String BASEPACKAGE = "com.stone.dao.test";
    static final String MAPPER_LOCATIONS = "classpath:mapper/test/*.xml";

    @Value("${test.datasource.url}")
    private String url;

    @Value("${test.datasource.username}")
    private String userName;

    @Value("${test.datasource.password}")
    private String passWord;

    @Value("${test.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name="testDataSource")
    public DataSource testDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(passWord);
        return druidDataSource;
    }

    @Bean(name = "testTransactionManager")
    public DataSourceTransactionManager testTransactionManager(){
        return new DataSourceTransactionManager(testDataSource());
    }

    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource") DataSource testDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(testDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                                                    .getResources(TestDataSourceConfig.MAPPER_LOCATIONS));
        return sqlSessionFactoryBean.getObject();
    }
}

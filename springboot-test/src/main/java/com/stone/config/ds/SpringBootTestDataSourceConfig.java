package com.stone.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
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

/**
 * Created by chenchen on 2017/6/4.
 */
@Configuration
@MapperScan(basePackages = SpringBootTestDataSourceConfig.BASEPACKAGE, sqlSessionFactoryRef="springBootTestSqlSessionFactory")
public class SpringBootTestDataSourceConfig {

    static final String BASEPACKAGE = "com.stone.dao.springboottest";
    static final String MAPPER_LOCATIONS = "classpath:mapper/springboottestdb/*.xml";

    @Value("${spring_boot_db.datasource.url}")
    private String url;

    @Value("${spring_boot_db.datasource.username}")
    private String userName;

    @Value("${spring_boot_db.datasource.password}")
    private String passWord;

    @Value("${spring_boot_db.datasource.driver-class-name}")
    private String driverClass;

    @Bean(name="springBootTestDataSource")
    @Primary
    public DataSource springBootTestDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClass);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(passWord);
        return druidDataSource;
    }

    @Bean(name = "springBootTestTransactionManager")
    @Primary
    public DataSourceTransactionManager springBootTestTransactionManager(){
        return new DataSourceTransactionManager(springBootTestDataSource());
    }

    @Bean(name = "springBootTestSqlSessionFactory")
    @Primary
    public SqlSessionFactory springBootTestSqlSessionFactory(@Qualifier("springBootTestDataSource") DataSource springBootTestDataSource) throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(springBootTestDataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                                                    .getResources(SpringBootTestDataSourceConfig.MAPPER_LOCATIONS));
        return sqlSessionFactoryBean.getObject();
    }
}

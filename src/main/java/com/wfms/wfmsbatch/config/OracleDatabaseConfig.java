package com.wfms.wfmsbatch.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.wfms.wfmsbatch.mapper.oracle", sqlSessionFactoryRef  = "oracleDataSessionFactory")
public class OracleDatabaseConfig {
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oracleDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean
    public SqlSessionFactory oracleDataSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/oracle/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate oracleSqlSessionTemplate(@Qualifier("oracleDataSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

@Configuration
@MapperScan(value = "com.wfms.wfmsbatch.mapper.mysql", sqlSessionFactoryRef  = "mysqlDataSessionFactory")
class MysqlDatabaseConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-sec")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory mysqlDataSessionFactory(@Qualifier("mysqlDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/mysql/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate mysqlSqlSessionTemplate(@Qualifier("mysqlDataSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}

@Configuration
@MapperScan(value = "com.wfms.wfmsbatch.mapper.maria", sqlSessionFactoryRef  = "mariaDataSessionFactory")
class MariaDatabaseConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-three")
    public DataSource mariaDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory mariaDataSessionFactory(@Qualifier("mariaDataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:mapper/maria/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate mariaSqlSessionTemplate(@Qualifier("mariaDataSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}


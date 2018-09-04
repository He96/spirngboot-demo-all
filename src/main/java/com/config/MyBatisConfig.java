package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.sql.SQLException;

public class MyBatisConfig {

    //1、数据源配置
    /*public static DruidDataSource druidDataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.0.196:3306/spm?useUnicode=true&amp;characterEncoding=utf8&amp;allowMultiQueries=true");
        dataSource.setUsername("root");
        dataSource.setPassword("he123123");
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(5);
        dataSource.setMaxActive(20);
        dataSource.setMaxWait(60*1000);
        //1分钟监测一次需要关闭的空闲连接
        dataSource.setTimeBetweenEvictionRunsMillis(60*1000);
        //一个连接池最小生命周期(5分钟)
        dataSource.setMinEvictableIdleTimeMillis(5*60*1000);
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setTestWhileIdle(true);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestOnReturn(false);
        //打开PSCache并指定每个连接上PSCache的大小
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //配置监控统计拦截的filters，去掉后监控界面SQL无法统计
        try{
            dataSource.setFilters("stat");
        }catch (SQLException sqlEx){
            throw new RuntimeException(sqlEx.getMessage(),sqlEx);
        };
        return dataSource;
    }

    //2、创建SQLSessionFactory
    public static SqlSessionFactoryBean sqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(druidDataSource());
        //sqlSessionFactory.setMapperLocations("classpath:com/mapperXml/xml/*.xml");
        //sqlSessionFactory.setConfigLocation("classpath:sqlConfig.xml");
        return sqlSessionFactory;
    }

    //3、配置扫描器，扫描指定路径的mapper生成数据库操作代理类
    public static MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
        scannerConfigurer.setBasePackage("com.mapperXml");
        scannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        return scannerConfigurer;
    }
    //
    public static DataSourceTransactionManager dataSourceTransactionManager(){
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(druidDataSource());
        return transactionManager;
    }*/
}

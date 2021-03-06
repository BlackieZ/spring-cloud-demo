package com.blackie.soa.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Configuration
@MapperScan(basePackages = "com.blackie.soa.dal.test.read.custom",sqlSessionFactoryRef = "sqlSessionFactoryRead")
@PropertySource(value = "classpath:jdbc.properties")
public class SqlSessionFactoryConfiguration{
    @Value("${spring.datasource.read.typeAliasPackage}")
    private String typeAliasPackageRead;
    @Value("${spring.datasource.read.mapperLocations}")
    private String mapperLocationsRead;
    @Resource(name = "dataSourceRead")
    private DataSource dataSourceRead;


    /**
     * 创建sqlSessionFactoryBean
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactoryRead")
    public SqlSessionFactory createSqlSessionReadFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceRead);
        bean.setTypeAliasesPackage(typeAliasPackageRead);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperLocationsRead));

        return bean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplateRead() throws Exception {
        return new SqlSessionTemplate(createSqlSessionReadFactoryBean());
    }
}

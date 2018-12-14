package com.blackie.soa.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by BlackieZ 365227949@qq.com
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.blackie.soa.dal.test.write.custom",sqlSessionFactoryRef = "sqlSessionFactoryWrite")
@PropertySource(value = "classpath:jdbc.properties")
public class SqlSessionFactoryConfigurationWrite implements TransactionManagementConfigurer {
    @Value("${spring.datasource.write.typeAliasPackage}")
    private String typeAliasPackageWrite;
    @Value("${spring.datasource.write.mapperLocations}")
    private String mapperLocationsWrite;
    @Resource(name = "dataSourceWrite")
    private DataSource dataSourceWrite;

    /**
     * 创建sqlSessionFactoryBean
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactoryWrite")
    public SqlSessionFactory createSqlSessionWriteFactoryBean() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceWrite);
        bean.setTypeAliasesPackage(typeAliasPackageWrite);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources(mapperLocationsWrite));

        return bean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplateWrite() throws Exception {
        return new SqlSessionTemplate(createSqlSessionWriteFactoryBean());
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSourceWrite);
    }
}

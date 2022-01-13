package programmer.lp.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan("programmer.lp")
@PropertySource("db.properties")
@MapperScan("${mybatis.mapperScanPackage}")
@EnableTransactionManagement
public class ApplicationConfiguration {
    @Value("${dev.driverClassName}")
    private String driverClassName;
    @Value("${dev.url}")
    private String url;
    @Value("${dev.username}")
    private String username;
    @Value("${dev.password}")
    private String password;
    @Value("${mybatis.typeAliasesPackage}")
    private String typeAliasesPackage;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setTypeAliasesPackage(typeAliasesPackage);
        return factoryBean;
    }

    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTxManager =
                new DataSourceTransactionManager();
        dataSourceTxManager.setDataSource(dataSource());
        return dataSourceTxManager;
    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        DataSourceTransactionManager dataSourceTxManager =
//                new DataSourceTransactionManager();
//        dataSourceTxManager.setDataSource(dataSource);
//        return dataSourceTxManager;
//    }

}

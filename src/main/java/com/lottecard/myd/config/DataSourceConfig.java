package com.lottecard.myd.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.lottecard.myd.test.model.vo.BookTbEntity;
import com.lottecard.myd.test.model.vo.COMMONCodeVO;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@EnableJdbcRepositories
//@EnableConfigurationProperties
//@PropertySource("classpath:application.properties")
public class DataSourceConfig extends AbstractJdbcConfiguration {

//	@Bean(name="dataSourcePostgrSQL",destroyMethod = "close")
	@Primary
	@Bean(name="dataSourceOracle")
	@ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSourceOracle() {

//        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//        return builder.setType(EmbeddedDatabaseType.HSQL).build();
//		DataSource dataSource = null;
//
//			BasicDataSource basicDataSource = new BasicDataSource();
//
//			basicDataSource.setDriverClassName("org.postgresql.Driver");
//			basicDataSource.setUrl("jdbc:postgresql://ec2-34-224-229-81.compute-1.amazonaws.com:5432/d97icin1itjhac");
//			basicDataSource.setUsername("unlgbicmbuawqz");
//			basicDataSource.setPassword("f85946722cd6a6119e0052b878a771c2395397b863f3ca7400529ba2d8c0c764");
//			basicDataSource.setMaxIdle(10);
//			basicDataSource.setMinIdle(5);
//
//			dataSource = basicDataSource;

		return DataSourceBuilder.create().type(HikariDataSource.class).build();
//			return dataSource;

    }

//    @Bean(name = "backofficeDataSource")
//
//    @ConfigurationProperties(prefix = "backoffice.datasource")
//
//    public DataSource backofficeDataSource() throws SQLException {
//
//        HikariDataSource hikariDataSource = new HikariDataSource();
//
//        return hikariDataSource;
//
//    }

//
//	@Bean(name="dataSourcePostgrSQLBatch")
//	@ConfigurationProperties("spring.datasource.hikari2")
//    public DataSource dataSourcePostgrSQLBatch() {
//		return DataSourceBuilder.create().type(HikariDataSource.class).build();
//    }
//


    @Bean
    NamedParameterJdbcOperations namedParameterJdbcOperations(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

//    @Primary
//    @Bean(name="txManagerPostgreSQL")
//    public TransactionManager txManagerPostgreSQL(@Qualifier("dataSourcePostgrSQL") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

//    @Bean(name="txManagerPostgreSQLBatch")
//    public TransactionManager txManagerPostgreSQLBatch(@Qualifier("dataSourcePostgrSQLBatch") DataSource dataSource) {
////    	DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
//        return new DataSourceTransactionManager(dataSource);
//    }

    @Primary
    @Bean(name="sqlSessionOracle")
    public SqlSessionFactoryBean sqlSessionFactoryOracle(@Qualifier("dataSourceOracle") DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setCacheEnabled(true);
		configuration.setLazyLoadingEnabled(true);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setCallSettersOnNulls(true);
		configuration.setDefaultExecutorType( ExecutorType.REUSE );		//	BATCH 세션으로 할 경우 처리 카운트를 얻을수 없음.
		sessionFactoryBean.setConfiguration(configuration);


    	sessionFactoryBean.setDataSource(dataSourceOracle());
//    	sessionFactoryBean.setTypeA
    	sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//				.getResources("classpath:/sqlmap/mappers/postgresql/**/" + dbType + "/**/*.xml"));
    			.getResources("classpath:/sqlmap/mappers/oracle/**/*.xml"));

    	sessionFactoryBean.setTypeAliases (new Class[] {
    			COMMONCodeVO.class,
    			BookTbEntity.class
//    			TMcGaHistVO.class,
//    			TMcSfCmpnMstVO.class
		});

//    	return sessionFactoryBean.getObject();
    	return sessionFactoryBean;

    }


    @Bean(name="sqlSessionOracleBatch")
    public SqlSessionFactoryBean sqlSessionFactoryOracleBatch(@Qualifier("dataSourceOracle") DataSource dataSource) throws Exception {
    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();

		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
		configuration.setCacheEnabled(true);
		configuration.setLazyLoadingEnabled(true);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setJdbcTypeForNull(JdbcType.NULL);
		configuration.setCallSettersOnNulls(true);
		configuration.setDefaultExecutorType( ExecutorType.BATCH );		//	BATCH 세션으로 할 경우 처리 카운트를 얻을수 없음.
		sessionFactoryBean.setConfiguration(configuration);


    	sessionFactoryBean.setDataSource(dataSourceOracle());
//    	sessionFactoryBean.setTypeA
    	sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//				.getResources("classpath:/sqlmap/mappers/postgresql/**/" + dbType + "/**/*.xml"));
    			.getResources("classpath:/sqlmap/mappers/oracle_batch/**/*.xml"));

    	sessionFactoryBean.setTypeAliases (new Class[] {
    			COMMONCodeVO.class,
    			BookTbEntity.class
//    			TMcGaHistVO.class,
//    			TMcSfCmpnMstVO.class
		});

//    	return sessionFactoryBean.getObject();
    	return sessionFactoryBean;

    }

//    @Bean(name="sqlSessionPostgresqlBatch")
//    public SqlSessionFactoryBean sqlSessionFactoryPostgresqlBatch(@Qualifier("dataSourcePostgrSQL") DataSource dataSource) throws Exception {
//    	SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
//
//		org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//		configuration.setCacheEnabled(true);
//		configuration.setLazyLoadingEnabled(true);
//		configuration.setMapUnderscoreToCamelCase(true);
//		configuration.setJdbcTypeForNull(JdbcType.NULL);
//		configuration.setCallSettersOnNulls(true);
//		configuration.setDefaultExecutorType( ExecutorType.BATCH );		//	BATCH 세션으로 할 경우 처리 카운트를 얻을수 없음.
//		sessionFactoryBean.setConfiguration(configuration);
//
//
//    	sessionFactoryBean.setDataSource(dataSourcePostgrSQL());
//    	sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
//    			.getResources("classpath:/sqlmap/mappers/postgresqlbatch/**/*.xml"));
//
//    	sessionFactoryBean.setTypeAliases (new Class[] {
//    			TMcCjMessageResponseVO.class,
//    			TMCCmpnMstVO.class
//		});
//
//    	return sessionFactoryBean;
//
//    }


}
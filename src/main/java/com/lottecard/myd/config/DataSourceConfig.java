package com.lottecard.myd.config;

import java.io.FileNotFoundException;

import javax.sql.DataSource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.lottecard.myd.test.model.vo.BookTbEntity;
import com.lottecard.myd.test.model.vo.COMMONCodeEntity;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
//@EnableJdbcRepositories
//@EnableConfigurationProperties
//@PropertySource("classpath:application.properties")
//@PropertySource("classpath:hikari-basic.properties")
@PropertySource("classpath:hikari.properties") 	
public class DataSourceConfig extends AbstractJdbcConfiguration {
	
	@Autowired
	Environment env;
	
	public Environment getEnv() {
		return env;
	}

	@Primary
	@Bean(name="dataSourceOracle")
//	@ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSourceOracle() throws  FileNotFoundException {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
		config.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
		config.setUsername(env.getProperty("spring.datasource.hikari.username"));
		config.setPassword(env.getProperty("spring.datasource.hikari.password"));
		config.setConnectionTimeout(env.getProperty("spring.datasource.hikari.connection-timeout", Integer.class));
	    config.setIdleTimeout(env.getProperty("spring.datasource.hikari.idleTimeout", Integer.class));
		config.setMaxLifetime(env.getProperty("spring.datasource.hikari.max-lifetime", Integer.class));
		config.setMinimumIdle(env.getProperty("spring.datasource.hikari.minimum-idle", Integer.class));
		config.setMaximumPoolSize(env.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.class));
		config.setAutoCommit(Boolean.parseBoolean(env.getProperty("spring.datasource.hikari.auto-commit")));
		config.setPoolName(env.getProperty("spring.datasource.hikari.pool.name"));

	    config.addDataSourceProperty("useServerPrepStmts", env.getProperty("spring.datasource.hikari.data-source-properties.useServerPrepStmts"));
	    config.addDataSourceProperty("cachePrepStmts", env.getProperty("spring.datasource.hikari.data-source-properties.cachePrepStmts"));
	    config.addDataSourceProperty("prepStmtCacheSize", env.getProperty("spring.datasource.hikari.data-source-properties.prepStmtCacheSize"));
	    config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("spring.datasource.hikari.data-source-properties.prepStmtCacheSqlLimit"));
//	    config.addDataSourceProperty("useLocalSessionState", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("rewriteBatchedStatements", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("cacheResultSetMetadata", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("cacheServerConfiguration", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("elideSetAutoCommits", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("maintainTimeStats", Boolean.FALSE.toString());
//	    config.addDataSourceProperty("netTimeoutForStreamingResults", 0);

		
	    HikariDataSource hikariDataSource = new HikariDataSource(config);
	    
//		HikariDataSource hikariDataSource = new HikariDataSource();
	    
//		DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.type(HikariDataSource);
        return hikariDataSource;

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

//		return DataSourceBuilder.create().type(HikariDataSource.class).build();
//			return dataSource;

    }
	
	@Bean(name="dataSourceOracleBatch")
//	@ConfigurationProperties("spring.datasource.hikari")
    public DataSource dataSourceOracleBatch() throws FileNotFoundException {
		
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("spring.datasource.hikari.driver-class-name"));
		config.setJdbcUrl(env.getProperty("spring.datasource.hikari.jdbc-url"));
		config.setUsername(env.getProperty("spring.datasource.hikari.username"));
		config.setPassword(env.getProperty("spring.datasource.hikari.password"));
		config.setConnectionTimeout(env.getProperty("batch.spring.datasource.hikari.connection-timeout", Integer.class));
	    config.setIdleTimeout(env.getProperty("batch.spring.datasource.hikari.idleTimeout", Integer.class));
		config.setMaxLifetime(env.getProperty("batch.spring.datasource.hikari.max-lifetime", Integer.class));
		config.setMinimumIdle(env.getProperty("batch.spring.datasource.hikari.minimum-idle", Integer.class));
		config.setMaximumPoolSize(env.getProperty("batch.spring.datasource.hikari.maximum-pool-size", Integer.class));
		config.setAutoCommit(Boolean.parseBoolean(env.getProperty("batch.spring.datasource.hikari.auto-commit")));
		config.setPoolName(env.getProperty("batch.spring.datasource.hikari.pool.name"));

	    config.addDataSourceProperty("useServerPrepStmts", env.getProperty("batch.spring.datasource.hikari.data-source-properties.useServerPrepStmts"));
	    config.addDataSourceProperty("cachePrepStmts", env.getProperty("batch.spring.datasource.hikari.data-source-properties.cachePrepStmts"));
	    config.addDataSourceProperty("prepStmtCacheSize", env.getProperty("batch.spring.datasource.hikari.data-source-properties.prepStmtCacheSize"));
	    config.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("batch.spring.datasource.hikari.data-source-properties.prepStmtCacheSqlLimit"));
//	    config.addDataSourceProperty("useLocalSessionState", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("rewriteBatchedStatements", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("cacheResultSetMetadata", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("cacheServerConfiguration", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("elideSetAutoCommits", Boolean.TRUE.toString());
//	    config.addDataSourceProperty("maintainTimeStats", Boolean.FALSE.toString());
//	    config.addDataSourceProperty("netTimeoutForStreamingResults", 0);
	    
	    HikariDataSource hikariDataSourceBatch = new HikariDataSource(config);
	    
	    
	    return hikariDataSourceBatch;

    }
	
	
	
//    HikariDataSource hikariDataSource = new HikariDataSource();
//    hikariDataSource.setJdbcUrl(sourceDataSourceProperties.getUrl());
//    hikariDataSource.setUsername(sourceDataSourceProperties.getUsername());
//    hikariDataSource.setPassword(sourceDataSourceProperties.getPassword());
//    hikariDataSource.setDriverClassName(sourceDataSourceProperties.getDriverClassName());
//    hikariDataSource.setAutoCommit(from(env.getProperty("spring.datasource.hikari.auto-commit")));
//    hikariDataSource.setConnectionTimeout(env.getProperty("spring.datasource.hikari.connection-timeout", Integer.class));
//    hikariDataSource.setMaximumPoolSize(env.getProperty("spring.datasource.hikari.maximum-pool-size", Integer.class));
//    hikariDataSource.setMaxLifetime(env.getProperty("spring.datasource.hikari.max-lifetime", Integer.class));
//    hikariDataSource.setMinimumIdle(env.getProperty("spring.datasource.hikari.minimum-idle", Integer.class));
//    hikariDataSource.setPoolName("SourceBatchHikariCP");
	
	

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
    			COMMONCodeEntity.class,
    			BookTbEntity.class
//    			TMcGaHistVO.class,
//    			TMcSfCmpnMstVO.class
		});

//    	return sessionFactoryBean.getObject();
    	return sessionFactoryBean;

    }


    @Bean(name="sqlSessionOracleBatch")
    public SqlSessionFactoryBean sqlSessionFactoryOracleBatch(@Qualifier("dataSourceOracleBatch") DataSource dataSource) throws Exception {
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
    			COMMONCodeEntity.class,
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
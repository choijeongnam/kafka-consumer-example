package com.lottecard.config;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ClientIdentifierController  {

	   private String prepSql = "{ call DBMS_SESSION.SET_IDENTIFIER(?) }";
	   private static final Logger logger = LoggerFactory.getLogger(ClientIdentifierController.class);
//	    @Autowired
//	    private UserService userService;
	   private static final String APP_ID = "TEST_ID";

//	    @AfterReturning(pointcut= "execution(* javax.sql.DataSource.getConnection(..))", returning = "connection")
	    @AfterReturning(pointcut= "execution(* com.zaxxer.hikari.HikariDataSource.getConnection(..))", returning = "connection")
	    public Connection setClientIdentifier(Connection connection) throws SQLException {
	    	logger.info("Get Connection Hikari!!!!!!!!!!!!!!!!!!!!!!!!");
	    
	        CallableStatement cs = connection.prepareCall(prepSql);
	        cs.setString(1,APP_ID);
	        cs.execute();
	        cs.close();
	        return connection;
	    }
	    
}

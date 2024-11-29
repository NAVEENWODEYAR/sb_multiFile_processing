package com.example.demo.log;
/**
 * @author Naveen Wodeyar
 * @date 25-Oct-2024
 * @time 1:20:15 am
 */
import org.hibernate.resource.jdbc.internal.EmptyStatementInspector;
import org.springframework.stereotype.Component;

@Component
public class SQLLoggingInterceptor extends EmptyStatementInspector {

	private static final long serialVersionUID = 1L;

	@Override
	    public String inspect(String sql) {
	        // Log the SQL query
	        System.out.println("Executing SQL: " + sql);
	        return sql; 
	    }
}

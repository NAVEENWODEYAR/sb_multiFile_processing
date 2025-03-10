package com.example.demo.log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Naveen Wodeyar
 * @date 10-Mar-2025
 * @time 10:09:52 pm
 */

class SQLLoggingInterceptorTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	private SQLLoggingInterceptor sqlLoggingInterceptor;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    
    @BeforeEach
    public void setUp() {
        // Redirecting System.out to capture printed output
        System.setOut(new PrintStream(outContent));
        
        sqlLoggingInterceptor = new SQLLoggingInterceptor();
    }

    @Test
    void testInspect_logsSqlCorrectly() {
        // Given a sample SQL query
        String sqlQuery = "SELECT * FROM users WHERE id = 1";
        
        // When calling the inspect method
        sqlLoggingInterceptor.inspect(sqlQuery);
        
        // Then the output should contain the correct SQL query
        assertTrue(outContent.toString().contains("Executing SQL: " + sqlQuery));
    }

    @Test
    void testInspect_returnsSqlUnchanged() {
        // Given a sample SQL query
        String sqlQuery = "SELECT * FROM users WHERE id = 1";
        
        // When calling the inspect method
        String returnedSql = sqlLoggingInterceptor.inspect(sqlQuery);
        
        // Then it should return the same SQL query
        assertEquals(sqlQuery, returnedSql);
    }

}

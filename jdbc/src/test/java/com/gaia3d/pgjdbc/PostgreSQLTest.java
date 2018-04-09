package com.gaia3d.pgjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class PostgreSQLTest {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://localhost:5432/mago3d";
	private static final String USER = "postgres";
	private static final String PW = "postgres";
	
	@Test
	public void jdbc연결테트스() throws Exception {
		Class.forName(DRIVER);
		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

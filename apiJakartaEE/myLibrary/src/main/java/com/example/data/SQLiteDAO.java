package com.example.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.sqlite.SQLiteConfig;

public class SQLiteDAO {
	
	protected static final String DB_PATH = "/opt/apps/data/myLibrary.db";
	
	protected Connection openConnection(String filepath) {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			
			// Enforces Referential Integrity
			SQLiteConfig config = new SQLiteConfig();	
			config.enforceForeignKeys(true);	
			
			conn = DriverManager.getConnection("jdbc:sqlite:" + filepath, config.toProperties());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	protected int getNewId(Connection conn) {
			// Warning: This mechnisim is not good in multi-thread env, since another table/entyr may have been added
			//		but this didn't work: 
			//		select seq from sqlite_sequuence wher name = 'table_name'
		String sql = " SELECT last_insert_rowid()";
		int newId = 0;
		try ( 	Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);){
			
			while (rs.next()) {
				newId = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newId;
	}
	
}

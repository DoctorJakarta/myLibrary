package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Author {
	public static final String SQL_INSEWRT_FIELDS = " ( authorId, name) ";
	public static final String SQL_INSERT_FIELDS = " VALUES (?,?) ";
	public static final String SQL_UPDATE_FIELDS = " authorId=?, name=? ";

	private int _id;
	private String _name;

	public Author() {}  // This is required for jersey-media-json-jackson binding for the doPost (Author author)

	public Author(ResultSet rs) throws SQLException {
		_id =  rs.getInt("authorId");
		_name = rs.getString("name");
	}

	public Author(int authorId, String name) {
		_id = authorId;
		_name = name;
	}
	
	//
	// Generated Getters and Setters
	//

	public int getId() {
		return _id;
	}
	public void setId(int id) {
		_id = id;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
}

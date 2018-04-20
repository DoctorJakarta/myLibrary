package com.example.model;

public class Tag {
	public static final String SQL_INSEWRT_FIELDS = " ( tagId, name) ";
	public static final String SQL_INSERT_FIELDS = " VALUES (?,?) ";
	public static final String SQL_UPDATE_FIELDS = " tagId=?, name=? ";

	private int _id;
	private String _name;
	
	public Tag() {} 	// This is required for jersey-media-json-jackson binding for the doPost (Tag tag)


	
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

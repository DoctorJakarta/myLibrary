package com.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Book {
	
	public static enum SECTION { BIOGRAPHY(1), BUSINESS(2), CHILDREN(3), COOKBOOK(4), HISTORY(5), LITERATURE(6), MYSTERY(7),  SCIENCE(8), UNCLASSIFIED(0);
		private int dbValue;
		SECTION(int value) {dbValue=value;}
		public static SECTION get(int iSection) {
			for (SECTION section: values()) {
				if (section.getValue() == iSection) {
					return section;
				}
			}
			return UNCLASSIFIED;		
		}
		public int getValue() { return dbValue; }
		public String toString() { return ""+dbValue;}
	}
	
	public static final String SQL_INSERT_FIELDS = " ( bookId, authorId, title, year, section) ";
	public static final String SQL_INSERT_VALUES = " VALUES (?,?,?,?,?) ";
	public static final String SQL_UPDATE_FIELDS = " bookId=?, authorId=?, title=?, year=?, section=? ";
	
	private int _id;
	private Author _author;
	private String _title;
	private int _year;
	private SECTION _section;

	public Book() {} // This is required for jersey-media-json-jackson binding for the doPost (Book book)
	
	public Book(ResultSet rs) throws SQLException {
		_id =  rs.getInt("bookId");
		_author = new Author( rs.getInt("authorId"), rs.getString("name"));
		_title = rs.getString("title");
		_year = rs.getInt("year");
		_section = SECTION.get(rs.getInt("section"));
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
	public Author getAuthor() {
		return _author;
	}
	public void setAuthor(Author author) {
		_author = author;
	}
	public String getTitle() {
		return _title;
	}
	public void setTitle(String title) {
		_title = title;
	}
	public int getYear() {
		return _year;
	}
	public void setYear(int year) {
		_year = year;
	}
	public SECTION getSection() {
		return _section;
	}
	public void setSection(SECTION section) {
		_section = section;
	}
	
}

package com.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Author;

public class AuthorDAO extends SQLiteDAO{
	private static final String SQL_GET_AUTHORS = "SELECT * FROM author;";
	
	public List<Author> getAuthors(){
		List<Author> authors = new ArrayList<>();
		try(
				Connection conn = openConnection(DB_PATH);
				PreparedStatement getPS = conn.prepareStatement(SQL_GET_AUTHORS);){
		
			ResultSet rs = getPS.executeQuery();
			while (rs.next()) {
				authors.add(new Author(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authors;
	}

}

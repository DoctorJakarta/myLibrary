package com.example.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.exceptions.DatabaseException;
import com.example.model.Book;

public class BookDAO extends SQLiteDAO{
	private static final String SQL_SELECT_BOOKS = "SELECT * FROM book INNER JOIN author USING (authorId);";
	private static final String SQL_INSERT_BOOK = "INSERT INTO book"  + Book.SQL_INSERT_FIELDS + Book.SQL_INSERT_VALUES;
	
	public List<Book> getBooks(){
		List<Book> books = new ArrayList<>();
		try(
				Connection conn = openConnection(DB_PATH);
				PreparedStatement getPS = conn.prepareStatement(SQL_SELECT_BOOKS);){
		
			ResultSet rs = getPS.executeQuery();
			while (rs.next()) {
				books.add(new Book(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

	public int insertBook(Book b) throws DatabaseException{
		try(
				Connection conn = openConnection(DB_PATH);
				PreparedStatement insertPS = conn.prepareStatement(SQL_INSERT_BOOK);){
		
			insertPS.setInt( 	1, b.getAuthor().getId());
			insertPS.setString( 2, b.getTitle());
			insertPS.setInt( 	3, b.getYear());
			insertPS.setInt( 	4, b.getSection().getValue());
			int numRows = insertPS.executeUpdate();
			int newId = getNewId(conn);
			return newId;

		} catch (SQLException e) {
			throw new DatabaseException("Insert Book was not successful.",e);
		}
	}
}

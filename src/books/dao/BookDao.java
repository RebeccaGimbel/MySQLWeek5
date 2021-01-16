package books.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import books.entity.Book;

public class BookDao {

	public void addBook(String title) throws SQLException {
		String sql = "INSERT INTO book (title) VALUES (?)";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		connection = DbConnection.getInstance().getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, title);
		
		statement.executeUpdate();
		}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(statement != null) {
				connection.close();
			}
		}
	}
	
	public List<Book> listBooks() throws SQLException{
		String sql = "SELECT * FROM book";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Book> books = new ArrayList<>();
		
		try {
			connection = DbConnection.getInstance().getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int bookId = resultSet.getInt("bookId");
				String title = resultSet.getString("title");
				Book book = new Book(bookId, title);
				books.add(book);
			}
			return books;
		}
		finally {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(statement != null) {
				connection.close();
			}
		}	
	}
	
	public void modifyBook(int bookId, String title) throws SQLException {
		String sql = "UPDATE book SET title = ? WHERE bookId = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		connection = DbConnection.getInstance().getConnection();
		statement = connection.prepareStatement(sql);
		statement.setString(1, title);
		statement.setInt(2, bookId);
		
		
		statement.executeUpdate();
		}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(statement != null) {
				connection.close();
			}
		}
	}
	
	public void deleteBook(int bookId) throws SQLException {
		String sql = "DELETE FROM book WHERE bookId = ?";
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
		connection = DbConnection.getInstance().getConnection();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, bookId);
		
		
		statement.executeUpdate();
		}
		finally {
			if(statement != null) {
				statement.close();
			}
			if(statement != null) {
				connection.close();
			}
		}
	}
}

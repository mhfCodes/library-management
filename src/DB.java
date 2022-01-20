import java.sql.*;

public class DB {
	
	public static Connection connect() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "rekaeil");
			return connection;
	
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}	
		return null;
	}
	
	public static void addBook(String title, String author, String genre, int price) {
		Connection connection = connect();
		try {
			String sql = "INSERT INTO books (title, author, genre, price) VALUES (?, ?, ?, ?)";
			PreparedStatement prepStatement = connection.prepareStatement(sql);
			prepStatement.setString(1, title);
			prepStatement.setString(2, author);
			prepStatement.setString(3, genre);
			prepStatement.setInt(4, price);
			int rows = prepStatement.executeUpdate();
			if (rows > 0) {
				System.out.println("Book Added Succefully");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

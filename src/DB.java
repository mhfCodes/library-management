import java.sql.*;

public class DB {
	
	public static Connection connect() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library", "postgres", "xxxx");
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
			System.out.println("Connection Failed at Adding Books");
			e.printStackTrace();
		}
	}
	
	public static void getBooks() {
		Connection connection = connect();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM books");
			while (rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				int price = rs.getInt("price");
				System.out.println(title + " - " + author + " - " + genre + " - " + price);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed at Getting Books");
			e.printStackTrace();
		}
	}

}

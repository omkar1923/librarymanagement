package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class bookCurd {
	public Connection loadDriver() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");
		return connection;
	}

	public int addBook(BookMain bookMain) throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "insert into books values(?,?,?,?,?);";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, bookMain.getId());
		preparedStatement.setString(2, bookMain.getTitle());
		preparedStatement.setString(3, bookMain.getAuthor());
		preparedStatement.setString(4, bookMain.getGenre());
		preparedStatement.setInt(5, bookMain.getQuantity());
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;

	}

	public List<BookMain> displayBook() throws ClassNotFoundException, SQLException {
		Connection connection = loadDriver();
		String query = "select * from books;";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet set = preparedStatement.executeQuery();
		List<BookMain> list = new ArrayList<BookMain>();
		
		while (set.next()) {
			BookMain bookMain = new BookMain();
			bookMain.setId(set.getInt("id"));
			bookMain.setTitle(set.getString("title"));
			bookMain.setAuthor(set.getString("author"));

			bookMain.setGenre(set.getString("genre"));
			bookMain.setQuantity(set.getInt("quantity"));
			list.add(bookMain);
		}
		System.out.println(list);
		connection.close();
		return list;

	}

	public BookMain updateDetaile(int id) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String querry="Select * from books where id=?;";
		PreparedStatement preparedStatement=connection.prepareStatement(querry);
		preparedStatement.setInt(1, id);
		BookMain bookMain=new BookMain();
		ResultSet set=preparedStatement.executeQuery();
		while(set.next()) {
			bookMain.setId(set.getInt("id"));
			bookMain.setTitle(set.getString("title"));
			bookMain.setAuthor(set.getString("author"));
			bookMain.setGenre(set.getString("genre"));
			bookMain.setQuantity(set.getInt("quantity"));
			
		}
		connection.close();
		return bookMain;
	}

	public int displayUpdate(BookMain bookMain) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String querry="update books set title=?,author=?,genre=?,quantity=? where id=?;";
		PreparedStatement preparedStatement=connection.prepareStatement(querry);
		preparedStatement.setString(1,bookMain.getTitle());
		preparedStatement.setString(2, bookMain.getAuthor());
		preparedStatement.setString(3, bookMain.getGenre());
		preparedStatement.setInt(4, bookMain.getQuantity());
		preparedStatement.setInt(5, bookMain.getId());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
	
	}

	public int deleteData(int id) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String querry="delete from books where id=?;";
		PreparedStatement preparedStatement=connection.prepareStatement(querry);
		preparedStatement.setInt(1, id);
		int result=preparedStatement.executeUpdate();
		return result;
	}
}

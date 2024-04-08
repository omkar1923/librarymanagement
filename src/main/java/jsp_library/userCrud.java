package jsp_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userCrud {
	public Connection loadDriver() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb", "root", "root");
		return connection;
	}

	public int resister(User user) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		
		String query="insert into user values (?,?,?,?,?,?); ";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1,user.getId());
		preparedStatement.setString(2,user.getName());
		preparedStatement.setLong(3,user.getPhone());
		preparedStatement.setString(4,user.getAddress());
		preparedStatement.setString(5,user.getEmail());
		preparedStatement.setString(6,user.getPassword());
		int result=preparedStatement.executeUpdate();
		connection.close();
		return result;
		
		
		
		

	}
	public String logIn(String email) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String query="select password from user where email=?";
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setString(1, email);
ResultSet set=preparedStatement.executeQuery();
		String password=null;
		System.out.println(password);
		while(set.next()){
			password=set.getString("password");
			
		}
		System.err.println(password);
		connection.close();
		return password;
		
	}

	public int updatePassword(int id, String newPassword) throws ClassNotFoundException, SQLException {
		Connection connection=loadDriver();
		String querry="update user set password=? where id=?;";
		PreparedStatement preparedStatement=connection.prepareStatement(querry);
		preparedStatement.setString(1, newPassword);
		preparedStatement.setInt(2, id);
		int result=preparedStatement.executeUpdate();
		connection.close();
		
		return result;
	}


}

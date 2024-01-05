package registration_model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
	
	private Connection con;
	private Statement stmnt;
	

	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/reg_db_app","root","amit9934");
			 stmnt = con.createStatement();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ResultSet readAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteByEmail(String email) {
		try {
			stmnt.executeUpdate("Delete From registration where email = '"+email+"' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
      
	}

	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration set mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

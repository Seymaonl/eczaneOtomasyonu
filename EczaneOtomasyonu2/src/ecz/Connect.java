package ecz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	
	static Connection c;
	static Statement s;

	static ResultSet yap() {
		ResultSet r = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/giris","root","root"); //Try catch içine Database urlsi kopyalanarak bağlantı sağlandı.
			s = c.createStatement();
			r = s.executeQuery("select * from giris"); // Query sadece seçme işlemleri içindir.
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	

	 static ResultSet sorgula(String sql_sorgu) { 
		ResultSet r = null;
		try {
			r=s.executeQuery(sql_sorgu);
		} catch (SQLException e)
		{ e.printStackTrace();
		}
		return r;
		
	}
	 
	 public static String StringGetSQL(String query, String label) {
	        String temp = null;
	        try {
	            //Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giris", "root", "root");
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                temp = rs.getString(label);
	            }

	        } catch (Exception e) {
	            System.out.println("hasta ismi bulunamadi");
	        }
	        return temp;
	    }
	 public static int IntGetSQL(String query, String label) {
	        int temp = 0;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giris", "root", "root");
	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                temp = rs.getInt(label);
	            }

	        } catch (Exception e) {
	        	//expception ignored olmali
	            e.printStackTrace();
	        }
	        return temp;
	    }
	 
	 
	
		    public static ResultSet getResult(String query) {

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giris", "root", "root");
		            Statement stmt = con.createStatement();
		            return stmt.executeQuery(query);

		        } catch (Exception e) {
		            return null;
		        }

		    }
	 
	 

}

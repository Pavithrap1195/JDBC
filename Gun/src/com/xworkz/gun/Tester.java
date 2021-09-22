package com.xworkz.gun;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {
	
	public static void main(String[] args) {
		Tester.save();
		Tester.update();
		Tester.delete();
	}
	
	public static void save() {
		
		try {
			//1.Load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//2.create connection
			//jdbc:databasename://IP address:port/schema name
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			//3.Create Statement
			Statement statement = con.createStatement();
			//4.Execute statement
			boolean saved=statement.execute("insert into gun_details values(3,'APW',1500000)");
			if(saved == false) {
				System.out.println("Data saved");
			}else {
				System.out.println("Data not saved");
			}
			//5.close connection
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			//System.err.println(e.getMessage());
		}
	}
	
	public static void update() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
		Statement state = connect.createStatement();
		boolean updated = state.execute("update gun_details set gun_price=3000000 where gun_id =2");
		if(updated == false){
			System.out.println("Data updated");
		}else {
			System.out.println("Data not updated");
		}
		connect.close();
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void delete() {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
		Statement stat = connection.createStatement();
		boolean deleted = stat.execute("Delete from gun_details where gun_id =3");
		if(deleted == false) {
			System.out.println("Data deleted");
		}else {
			System.out.println("Data not deleted");
		}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}

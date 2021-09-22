package com.xworkz.account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BankAccount {

	public static void main(String[] args) {
		BankAccount.save();
		BankAccount.update();
		BankAccount.delete();
	}

	public static void save() {

		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Pavixworkz130621");
			Statement stat = con.createStatement();
			boolean saved = stat.execute("insert into bank_account_details values(1,'Pavithra','Savings',10185963412)");
			boolean saved1 = stat.execute("insert into bank_account_details values(2,'Akash','Savings',10255963412)");
			boolean saved2 = stat.execute("insert into bank_account_details values(3,'Girish','Savings',10555963412)");
			boolean saved3 = stat.execute("insert into bank_account_details values(4,'Hemanth','Savings',10569963412)");

			if (saved == false) {
				System.out.println("Data saved");
			} else {
				System.out.println("Data not saved");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = con.createStatement();
			boolean updated = st.execute("update bank_account_details set account_type='Current' where customer_id=4");
			if(updated == false) {
				System.out.println("Data updated"); 
			}else {
				System.out.println("Data not updated");
				}
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete() {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = conn.createStatement();
			boolean deleted = st.execute("delete from bank_account_details where customer_name='Pavithra'");
			if(deleted == false) {
				System.out.println("Data deleted");
			}else {
				System.out.println("Date not deleted");
			}
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.xworkz.markscard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tester {

	public static void main(String[] args) {

		/*save();
		update();
		delete();*/
		getAll();
	}

	public static void getAll() {

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select*from student_markscard");
			while(res.next()) {
				int std_id = res.getInt(1);
				String std_name = res.getString(2);
				int std_marks = res.getInt(3);
				int total_marks = res.getInt(4);
				System.out.println(std_id+" "+std_name+" "+std_marks+" "+total_marks);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void save() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root",
					"Pavixworkz130621");
			Statement statement = con.createStatement();
			boolean saved = statement.execute("insert into student_markscard values(1,'Archana',600,625)");
			boolean saved1 = statement.execute("insert into student_markscard values(2,'Pavithra',612,625)");
			boolean saved2 = statement.execute("insert into student_markscard values(3,'Rajini',620,625)");

			if (saved == false) {
				System.out.println("Data Saved");
			} else {
				System.out.println("Data not saved");
			}

			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static void update() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root",
					"Pavixworkz130621");
			Statement stat = conn.createStatement();
			boolean updated = stat.execute("update student_markscard set std_marks=618 where std_id=1");
			if (updated == false) {
				System.out.println("Data updated");
			} else {
				System.out.println("Dat not updated");
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static void delete() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root",
					"Pavixworkz130621");
			Statement stat = connect.createStatement();
			boolean deleted = stat.execute("Delete from student_markscard where std_id=3");
			if (deleted == false) {
				System.out.println("Data deleted");
			} else {
				System.out.println("Data not deleted");
			}
			connect.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}

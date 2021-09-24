package com.xworkz.mobiledetails.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.mobiledetails.dto.MobileDetailsDTO;

public class MobileDetailsDAOImpl implements MobileDetailsDAO {

	@Override
	public boolean save(MobileDetailsDTO dto) {
		boolean saved = false;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement stat = con.createStatement();
			saved = stat.execute(
					"insert into mobile_details values(1,'Redmi note5 pro',20000,'4G'),(2,'Realme',15000,'5G'),(3,'Oppo',18000,'4G'),(4,'OneplusT',40000,'5G')");
			if (saved == false) {
				System.out.println("Data Saved");
			} else {
				System.out.println("Data not saved");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return saved;
	}

	@Override
	public boolean updatePriceByName(String name, double price) {
		boolean updated = false;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = con.createStatement();
			updated = st.execute("update mobile_details set mobile_price = 22000 where mobile_name='Realme'");
			if (updated == false) {
				System.out.println("Data updated");
			} else {
				System.out.println("Data not updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<MobileDetailsDTO> getAll() {
		List<MobileDetailsDTO> list = new ArrayList<MobileDetailsDTO>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root",
					"Pavixworkz130621");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select* from mobile_details");
			while (rs.next()) {
				MobileDetailsDTO dto = new MobileDetailsDTO();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				long price = rs.getLong(3);
				String type = rs.getString(4);
				dto.setMobileId(id);
				dto.setName(name);
				dto.setPrice(price);
				dto.setNetwork(type);

				list.add(dto);
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public MobileDetailsDTO getByName(String name) {
		MobileDetailsDTO dto = new MobileDetailsDTO();
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			PreparedStatement stat = con.prepareStatement("select*from mobile_details where mobile_name=?");
			stat.setString(1, name);
			ResultSet rs = stat.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String mobile_name = rs.getString(2);
				long price = rs.getLong(3);
				String type = rs.getString(4);
				dto.setMobileId(id);
				dto.setName(mobile_name);
				dto.setPrice(price);
				dto.setNetwork(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return dto;
	}

	@Override
	public List<MobileDetailsDTO> getByPrice(double price) {
		List<MobileDetailsDTO> list = new ArrayList<MobileDetailsDTO>();
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select*from mobile_details where mobile_price='"+price+"'");
			while(rs.next()) {
				MobileDetailsDTO dto = new MobileDetailsDTO();
				int id = rs.getInt(1);
				String mobile_name = rs.getString(2);
				long amount = rs.getLong(3);
				String type = rs.getString(4);
				dto.setMobileId(id);
				dto.setName(mobile_name);
				dto.setPrice(amount);
				dto.setNetwork(type);
				list.add(dto);
			}
		} catch (SQLException e) {
			System.err.println(e.getClass());
			System.err.println(e.getMessage());
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e.getClass());
				System.err.println(e.getMessage());
			}
		}
		return list;
	}

}

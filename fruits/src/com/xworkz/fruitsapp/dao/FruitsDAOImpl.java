package com.xworkz.fruitsapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.fruitsapp.dto.FruitsDTO;

public class FruitsDAOImpl implements FruitsDAO {

	@Override
	public boolean save(FruitsDTO dto) {
		boolean saved = false;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root",
					"Pavixworkz130621");
			Statement st = con.createStatement();
			saved = st.execute(
					"insert into fruits_details values(1,'Mango',120.00),(2,'Apple',100.00),(3,'Orange',150.00)");
			if (saved == false) {
				System.out.println("Data saved");
			} else {
				System.out.println("Data not saved");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return saved;
	}

	@Override
	public boolean updatePriceByName(String name, double price) {
		boolean updated = false;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Pavixworkz130621");
		Statement st = con.createStatement();
		updated = st.execute("update fruits_details set fruit_price = 150.00 where fruit_name = 'Mango'");
		if(updated == false) {
			System.out.println("Data saved");
		}else {
			System.out.println("Data not saved");
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updated;
	}

	@Override
	public List<FruitsDTO> getAll() {
		List<FruitsDTO> list = new ArrayList<FruitsDTO>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Pavixworkz130621");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select*from fruits_details");
		while(rs.next()) {
			FruitsDTO dto = new FruitsDTO();
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double price = rs.getDouble(3);
			dto.setFruitId(id);
			dto.setName(name);
			dto.setPricePerKg(price);
			list.add(dto);
		}
		con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public FruitsDTO getByName(String name) {
		FruitsDTO dto = new FruitsDTO();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Pavixworkz130621");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select*  from fruits_details where fruit_name='"+name+"'");
		while(rs.next()) {
			int id = rs.getInt(1);
			String fruitName = rs.getString(2);
			double price = rs.getDouble(3);
			dto.setFruitId(id);
			dto.setName(fruitName);
			dto.setPricePerKg(price);
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<FruitsDTO> getByPrice(double price) {
		List<FruitsDTO> list = new ArrayList<FruitsDTO>();
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root","Pavixworkz130621");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select*  from fruits_details where fruit_price='"+price+"'");
		while(rs.next()) {
			FruitsDTO dto = new FruitsDTO();
			int id = rs.getInt(1);
			String name = rs.getString(2);
			double amount = rs.getDouble(3);
			dto.setFruitId(id);
			dto.setName(name);
			dto.setPricePerKg(amount);
			list.add(dto);
		}
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}

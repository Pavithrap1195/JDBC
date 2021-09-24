package com.xworkz.gun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xworkz.gun.dto.GunDetailsDTO;

public class GunDetailsDAOImpl implements GunDetailsDAO {

	@Override
	public List<GunDetailsDTO> getAll() {
		List<GunDetailsDTO> list = new ArrayList<GunDetailsDTO>();
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement stat = con.createStatement();
			ResultSet result = stat.executeQuery("select*from gun_details");
			// convert resultset to list bcoz our data is there in resultset
			while (result.next()) {

				// Here creating an object bcoz to transfer data from resultset to dto
				GunDetailsDTO dto = new GunDetailsDTO();
				int id = result.getInt(1);
				String model = result.getString(2);
				int price = result.getInt(3);

				// Here i am setting the data into the dto
				dto.setGun_id(id);
				dto.setGun_model(model);
				dto.setGun_price(price);

				// Now dto contains all data so i am adding this dto to list and will return
				// list
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public GunDetailsDTO getByModel(String model) {
		GunDetailsDTO dto = new GunDetailsDTO();
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery("select * from gun_details where gun_model='" + model + "'");
			while (res.next()) {
				int id = res.getInt(1);
				String model_name = res.getString(2);
				int price = res.getInt(3);
				dto.setGun_id(id);
				dto.setGun_model(model_name);
				dto.setGun_price(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dto;
	}

	@Override
	public List<GunDetailsDTO> getByPrice(int price) {
		List<GunDetailsDTO> list = new ArrayList<GunDetailsDTO>();
		Connection connect = null;
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			Statement stat = connect.createStatement();
			ResultSet set = stat.executeQuery("select * from gun_details where gun_price='" + price + "'");
			while (set.next()) {
				GunDetailsDTO dto = new GunDetailsDTO();
				int id = set.getInt(1);
				String model = set.getString(2);
				int amount = set.getInt(3);
				dto.setGun_id(id);
				dto.setGun_model(model);
				dto.setGun_price(amount);

				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	@Override
	public boolean saveAll(List<GunDetailsDTO> list) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			// Transaction management method
			//Transaction management-executing the all queries at the same time
			//Here we are unabling auto commit
			con.setAutoCommit(false);
			PreparedStatement preparedStatement = con.prepareStatement("insert into gun_details values(?,?,?)");
			for (GunDetailsDTO gunDetailsDTO : list) {
				preparedStatement.setInt(1, gunDetailsDTO.getGun_id());
				preparedStatement.setString(2, gunDetailsDTO.getGun_model());
				preparedStatement.setInt(3, gunDetailsDTO.getGun_price());
				preparedStatement.execute();
			}
			// Transaction management method
			// It will update above query at same time
			// to save the data
			con.commit();
			return true;

		} catch (SQLException e) {
			try {
				// This is used to cancel the last updated data in the database
				con.rollback();

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				// During inserting if we get any exception in queries
				// atleast the right queries should be executed so we are adding this line in
				// catch block
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}

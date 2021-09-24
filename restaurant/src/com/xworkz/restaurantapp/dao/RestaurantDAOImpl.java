package com.xworkz.restaurantapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.xworkz.restaurantapp.dto.RestaurantDTO;

public class RestaurantDAOImpl implements RestaurantDAO {

	@Override
	public boolean saveAll(List<RestaurantDTO> list) {
		
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			con.setAutoCommit(false);
			PreparedStatement st = con.prepareStatement("insert into restaurant_details values(?,?,?)");
			for (RestaurantDTO restaurantDTO : list) {
			st.setInt(1, restaurantDTO.getRestaurantId());
			st.setString(2, restaurantDTO.getName());
			st.setString(3, restaurantDTO.getLocation());
			st.execute();
			}
			con.commit();
			return true;
		} catch (SQLException e) {
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
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

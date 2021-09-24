package com.xworkz.moviesapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.xworkz.moviesapp.dto.MoviesDTO;

public class MoviesDAOImpl implements MoviesDAO {

	@Override
	public boolean saveAll(List<MoviesDTO> list) {

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Pavixworkz130621");
			con.setAutoCommit(false);
			PreparedStatement stat = con.prepareStatement("insert into movies_details values(?,?,?)");
			for (MoviesDTO moviesDTO : list) {
				stat.setInt(1, moviesDTO.getMoviesId());
				stat.setString(2, moviesDTO.getName());
				stat.setString(3, moviesDTO.getActor());
				stat.execute();
			}
			con.commit();
			return true;
			
		} catch (SQLException e) {
			/*try {
				con.rollback();
			} catch (SQLException e1) {
				System.err.println(e.getClass());
				System.err.println(e.getMessage());
				
//				e1.printStackTrace();
			}*/
			e.printStackTrace();
		} finally {
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				System.err.println(e.getClass());
				System.err.println(e.getMessage());
				
//				e.printStackTrace();
			}

		}
		return false;
	}

}

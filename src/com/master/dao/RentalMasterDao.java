package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.RentalModel;

public class RentalMasterDao {

	DBConnection connection = new DBConnection();
	Connection conn = connection.getConnection();

	public int delete_rental_master(RentalModel rental_modal, String delete_rental_id) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			PreparedStatement pst = conn
					.prepareStatement("DELETE FROM `rental_master` WHERE id=" + delete_rental_id + "");
			i = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<RentalModel> fetchForUpdateRentalDetailss(RentalModel rental_modal, String rental_id) {
		// TODO Auto-generated method stub
		List<RentalModel> list = new ArrayList<RentalModel>();

		try {
			PreparedStatement pst = conn.prepareStatement(
					"SELECT `id`, `rental_name`, `rental_description` from rental_master WHERE id='" + rental_id + "'");
			ResultSet rs = pst.executeQuery();
			System.out.println("pst ---- " + pst);
			while (rs.next()) {
				RentalModel rentalModel = new RentalModel();
				rentalModel.setRental_id(rs.getString(1));
				rentalModel.setRental_name(rs.getString(2));
				rentalModel.setRental_description(rs.getString(3));
				list.add(rentalModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int insert_rental_Details(RentalModel rentalmodel) {

		System.out.println(rentalmodel.getRental_name() + "rrrrrrrrrrrr");
		// TODO Auto-generated method stub
		int i = 0;
//		try {
//			System.out.println("zzzzzzzzzzzzzzz");
//			PreparedStatement psac = conn.prepareStatement(
//					"select * from rental_master where rental_name = '" + rentalmodel.getRental_name() + "'");
//			ResultSet rsac = psac.executeQuery();
//
//			if (rsac.next()) {
//				return -1;
//			}
//			System.out.println("fffffffffffffff");
//			PreparedStatement pst = conn
//					.prepareStatement("insert into `rental_master` (`rental_name`,  `rental_description`) values(?,?)");
//
//			pst.setString(1, rentalmodel.getRental_name());
//			pst.setString(2, rentalmodel.getRental_description());
//			i = pst.executeUpdate();
//
//			System.out.println("i: " + i + "\npst: " + pst);
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return i;
	}

	public List<RentalModel> fetchRentalMasterDetails(RentalModel rental_model) {
		// TODO Auto-generated method stub
		List<RentalModel> list = new ArrayList<RentalModel>();

		try {
			PreparedStatement pst = conn
					.prepareStatement("SELECT `id`, `rental_name`, `rental_description` FROM `rental_master`");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				RentalModel rentalModel = new RentalModel();

				rentalModel.setRental_id(rs.getString(1));
				rentalModel.setRental_name(rs.getString(2));
				rentalModel.setRental_description(rs.getString(3));
				list.add(rentalModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

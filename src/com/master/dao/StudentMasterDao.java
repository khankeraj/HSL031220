package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.StudentModel;

public class StudentMasterDao {

	DBConnection connection = new DBConnection();
	Connection conn = connection.getConnection();

	public int insert_student_master_details(StudentModel student_model) {
		int i = 0;
		try {

			PreparedStatement psac = conn
					.prepareStatement("select * from student_details where name = '" + student_model.getName() + "'");
			ResultSet rsac = psac.executeQuery();

			if (rsac.next()) {
				return -1;
			}

			PreparedStatement pstmt = conn.prepareStatement(
					"INSERT INTO `student_details`(`name`, `address`, `city`, `mobile`, `email`, `department`, `gender`, `language`) VALUES (?,?,?,?,?,?,?,?)");

			pstmt.setString(1, student_model.getName());
			pstmt.setString(2, student_model.getAddress());
			pstmt.setString(3, student_model.getCity());
			pstmt.setLong(4, student_model.getMobile());
			pstmt.setString(5, student_model.getEmail());
			pstmt.setString(6, student_model.getDepartment());
			pstmt.setString(7, student_model.getGender());
			pstmt.setString(8, student_model.getLanguage());

			i = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBConnection.closeConnection();
		return i;

	}

	public List<StudentModel> fetchStudentMasterDetails(StudentModel student_model) {
		// TODO Auto-generated method stub
		List<StudentModel> list = new ArrayList<StudentModel>();

		try {
			Connection conn = connection.getConnection();
			PreparedStatement pst = conn.prepareStatement(
					"SELECT `name`, `address`, `city`, `mobile`, `email`, `department`, `gender`, `language`, `student_id` FROM `student_details`");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StudentModel studentModel = new StudentModel();

				studentModel.setName(rs.getString(1));
				studentModel.setAddress(rs.getString(2));
				studentModel.setCity(rs.getString(3));
				studentModel.setMobile(rs.getLong(4));
				studentModel.setEmail(rs.getString(5));
				studentModel.setDepartment(rs.getString(6));
				studentModel.setGender(rs.getString(7));
				studentModel.setLanguage(rs.getString(8));
				studentModel.setStudent_id(rs.getInt(9));

				list.add(studentModel);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int delete_student_master(StudentModel student_model, String delete_student_id) {
		// TODO Auto-generated method stub
		int i = 0;
		try {
			PreparedStatement pst = conn
					.prepareStatement("DELETE FROM `student_details` WHERE student_id=" + delete_student_id + "");
			i = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	
	public List<StudentModel> fetchForUpdateStudentDetails(StudentModel student_model, String student_id) {
		// TODO Auto-generated method stub
		List<StudentModel> list = new ArrayList<StudentModel>();

		try {
			PreparedStatement pst = conn.prepareStatement(
					"SELECT `student_id`, `name`, `address`, `city`, `mobile`, `email`, `department`, `gender`, `language` FROM `student_details` WHERE student_id="+ student_id + "");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				StudentModel studentModel = new StudentModel();

				studentModel.setStudent_id(rs.getInt(1));
				studentModel.setName(rs.getString(2));
				studentModel.setAddress(rs.getString(3));
				studentModel.setCity(rs.getString(4));
				studentModel.setMobile(rs.getLong(5));
				studentModel.setEmail(rs.getString(6));
				studentModel.setDepartment(rs.getString(7));
				studentModel.setGender(rs.getString(8));
				studentModel.setLanguage(rs.getString(9));

				list.add(studentModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public int update_student_details(StudentModel student_model, String update_student) {
		// TODO Auto-generated method stub
		int i = 0;
		int student_id = Integer.parseInt(update_student);

		try {
			PreparedStatement pst = conn.prepareStatement(
					"UPDATE `student_details` SET `name`=?,`address`=?,`city`=?,`mobile`=?,`email`=?,`department`=?,`gender`=?,`language`=? WHERE `student_id`=?");

			pst.setString(1, student_model.getName());
			pst.setString(2, student_model.getAddress());
			pst.setString(3, student_model.getCity());
			pst.setLong(4, student_model.getMobile());
			pst.setString(5, student_model.getEmail());
			pst.setString(6, student_model.getDepartment());
			pst.setString(7, student_model.getGender());
			pst.setString(8, student_model.getLanguage());
			pst.setInt(9, student_id);

			i = pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}

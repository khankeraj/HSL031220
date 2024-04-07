package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.LabChemMicroBioReportsModel;

public class LabChemMicroBioREportsDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public List<LabChemMicroBioReportsModel> fetchLabChemicalMicrobiology(LabChemMicroBioReportsModel lab) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioReportsModel> list=new ArrayList<LabChemMicroBioReportsModel>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lab_id`,`quotation_name` FROM `lab_chem_micro_config_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioReportsModel labReports=new LabChemMicroBioReportsModel();
				labReports.setLab_id(rs.getInt(1));
				labReports.setQuotation_name(rs.getString(2));
				list.add(labReports);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}

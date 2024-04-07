package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.VisitorFormModel;

public class VisitorFormDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	public int insert_site_visitor(VisitorFormModel visitorModel,int finalization_id,String lead_no) {
		int i=0;
		int max_count=0;
		
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `site_visit`(`finalization_id`,`lead_no`,`client_name`, `requiredDate`, `client_address`, `customer_mobile`, `customer_email`, `project_coordinator`, `plot_type`, `plot_area`, `water_source`, `electricity_source`, `road_connectivity`, `contruction_type`, `construction_area`, `reject_water`, `bis_circle`, `pro_coordinator_remarks`, `actual_photo`, `finalized_amount`, `token_amount`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
					pst.setInt(1, finalization_id);
					pst.setString(2, lead_no);
					pst.setString(3, visitorModel.getClient_name());
					pst.setString(4, visitorModel.getRequiredDate());
					pst.setString(5, visitorModel.getClient_address());
					pst.setString(6, visitorModel.getCustomer_mobile());
					pst.setString(7, visitorModel.getCustomer_email());
					pst.setString(8, visitorModel.getProject_coordinator());
					pst.setString(9, visitorModel.getPlot_type());
					pst.setString(10, visitorModel.getPlot_area());
					pst.setString(11, visitorModel.getWater_source());
					pst.setString(12, visitorModel.getElectricity_Source());
					pst.setString(13, visitorModel.getRoad_connectivity());
					pst.setString(14, visitorModel.getConstruction_area());
					pst.setString(15, visitorModel.getConstruction_area());
					pst.setString(16, visitorModel.getReject_water());
					pst.setString(17, visitorModel.getBis_circle());
					pst.setString(18, visitorModel.getProject_coordinator_remarks());
					pst.setString(19, visitorModel.getActual_phoograph_of_site());
					pst.setString(20, visitorModel.getFinalized_amt());
					pst.setString(21, visitorModel.getToken_amt());
					
					i=pst.executeUpdate();
					
					//finalization reports after submit site visit
					PreparedStatement pst1=conn.prepareStatement("UPDATE `finalized_quotation_master` SET `finalized_status`=2 WHERE `id`="+finalization_id+"");
					pst1.executeUpdate();
					
					PreparedStatement pst11=conn.prepareStatement("UPDATE `status_master` SET `sitevisit`='YES' WHERE lead_no='"+lead_no+"'");
					int j=pst11.executeUpdate();
					if(j>0)
					{
						System.out.println("status Updated Successfully");
					}
					
					
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public List<VisitorFormModel> fetchVisitorReports(VisitorFormModel visitorModel) {
		// TODO Auto-generated method stub
		List<VisitorFormModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `finalization_id`,`lead_no`,`client_name`, `requiredDate`, `client_address`, `customer_mobile`, `customer_email` FROM `site_visit` WHERE status=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				VisitorFormModel visitorModal=new VisitorFormModel();
				visitorModal.setFinalization_id(rs.getInt(1));
				visitorModal.setLead_no(rs.getString(2));
				visitorModal.setClient_name(rs.getString(3));
				visitorModal.setRequiredDate(rs.getString(4));
				visitorModal.setClient_address(rs.getString(5));
				visitorModal.setCustomer_mobile(rs.getString(6));
				visitorModal.setCustomer_email(rs.getString(7));
				
				/*visitorModal.setProject_coordinator(rs.getString(7));
				visitorModal.setPlot_type(rs.getString(8));
				visitorModal.setPlot_area(rs.getString(9));
				visitorModal.setWater_source(rs.getString(10));
				visitorModal.setElectricity_Source(rs.getString(11));
				visitorModal.setRoad_connectivity(rs.getString(12));
				visitorModal.setCosntruction_type(rs.getString(13));
				visitorModal.setConstruction_area(rs.getString(14));
				visitorModal.setReject_water(rs.getString(15));
				visitorModal.setBis_circle(rs.getString(16));
				visitorModal.setProject_coordinator_remarks(rs.getString(17));
				visitorModal.setActual_phoograph_of_site(rs.getString(18));*/
				list.add(visitorModal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


	public int deleteVisitorDetails(VisitorFormModel visitorModel, String site_visit_id) {
		// TODO Auto-generated method stub
		int i=0;
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `site_visit` WHERE visitor_id=?");
			pst.setInt(1, Integer.parseInt(site_visit_id));
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<VisitorFormModel> fetchForSiteVisit(VisitorFormModel visitorModel, String edit_id) {
		// TODO Auto-generated method stub
		List<VisitorFormModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `visitor_id`, `client_name`, `requiredDate`, `client_address`, `customer_mobile`, `customer_email`, `project_coordinator`, `plot_type`, `plot_area`, `water_source`, `electricity_source`, `road_connectivity`, `contruction_type`, `construction_area`, `reject_water`, `bis_circle`, `pro_coordinator_remarks`, `actual_photo` FROM `site_visit` WHERE visitor_id="+edit_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				VisitorFormModel visitorModal=new VisitorFormModel();
				visitorModal.setVisitor_id(rs.getInt(1));
				visitorModal.setClient_name(rs.getString(2));
				visitorModal.setRequiredDate(rs.getString(3));
				visitorModal.setClient_address(rs.getString(4));
				visitorModal.setCustomer_mobile(rs.getString(5));
				visitorModal.setCustomer_email(rs.getString(6));
				visitorModal.setProject_coordinator(rs.getString(7));
				visitorModal.setPlot_type(rs.getString(8));
				visitorModal.setPlot_area(rs.getString(9));
				visitorModal.setWater_source(rs.getString(10));
				visitorModal.setElectricity_Source(rs.getString(11));
				visitorModal.setRoad_connectivity(rs.getString(12));
				visitorModal.setCosntruction_type(rs.getString(13));
				visitorModal.setConstruction_area(rs.getString(14));
				visitorModal.setReject_water(rs.getString(15));
				visitorModal.setBis_circle(rs.getString(16));
				visitorModal.setProject_coordinator_remarks(rs.getString(17));
				visitorModal.setActual_phoograph_of_site(rs.getString(18));
				list.add(visitorModal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<VisitorFormModel> fetchForSiteVisit1(VisitorFormModel visitorModel) {
		// TODO Auto-generated method stub
		List<VisitorFormModel> list=new ArrayList<>();
		int max_count=0;
		try {
			
			PreparedStatement pst1=conn.prepareStatement("SELECT MAX(site_visit.visitor_id) AS max_row FROM site_visit");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				max_count=rs1.getInt(1);
			}
			
			PreparedStatement pst=conn.prepareStatement("SELECT `client_name`, `requiredDate`, `client_address`, `customer_mobile`, `customer_email`, `project_coordinator`, `plot_type`, `plot_area`, `water_source`, `electricity_source`, `road_connectivity`, `contruction_type`, `construction_area`, `reject_water`, `bis_circle`, `pro_coordinator_remarks`, `actual_photo` FROM `site_visit` WHERE visitor_id="+max_count+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				VisitorFormModel visitorModal=new VisitorFormModel();
				
				visitorModal.setClient_name(rs.getString(1));
				visitorModal.setRequiredDate(rs.getString(2));
				visitorModal.setClient_address(rs.getString(3));
				visitorModal.setCustomer_mobile(rs.getString(4));
				visitorModal.setCustomer_email(rs.getString(5));
				visitorModal.setProject_coordinator(rs.getString(6));
				visitorModal.setPlot_type(rs.getString(7));
				visitorModal.setPlot_area(rs.getString(8));
				visitorModal.setWater_source(rs.getString(9));
				visitorModal.setElectricity_Source(rs.getString(10));
				visitorModal.setRoad_connectivity(rs.getString(11));
				visitorModal.setCosntruction_type(rs.getString(12));
				visitorModal.setConstruction_area(rs.getString(13));
				visitorModal.setReject_water(rs.getString(14));
				visitorModal.setBis_circle(rs.getString(15));
				visitorModal.setProject_coordinator_remarks(rs.getString(16));
				visitorModal.setActual_phoograph_of_site(rs.getString(17));
				list.add(visitorModal);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int updateSiteVisitForm(VisitorFormModel visitorModel, String site_visit_id) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `site_visit` SET `client_name`=?,`requiredDate`=?,`client_address`=?,`customer_mobile`=?,`customer_email`=?,`project_coordinator`=?,`plot_type`=?,`plot_area`=?,`water_source`=?,`electricity_source`=?,`road_connectivity`=?,`contruction_type`=?,`construction_area`=?,`reject_water`=?,`bis_circle`=?,`pro_coordinator_remarks`=?,`actual_photo`=? WHERE `visitor_id`=?");
			pst.setString(1, visitorModel.getClient_name());
			pst.setString(2, visitorModel.getRequiredDate());
			pst.setString(3, visitorModel.getClient_address());
			pst.setString(4, visitorModel.getCustomer_mobile());
			pst.setString(5, visitorModel.getCustomer_email());
			pst.setString(6, visitorModel.getProject_coordinator());
			pst.setString(7, visitorModel.getPlot_type());
			pst.setString(8, visitorModel.getPlot_area());
			pst.setString(9, visitorModel.getWater_source());
			pst.setString(10, visitorModel.getElectricity_Source());
			pst.setString(11, visitorModel.getRoad_connectivity());
			pst.setString(12, visitorModel.getCosntruction_type());
			pst.setString(13, visitorModel.getConstruction_area());
			pst.setString(14, visitorModel.getReject_water());
			pst.setString(15, visitorModel.getBis_circle());
			pst.setString(16, visitorModel.getProject_coordinator_remarks());
			pst.setString(17, visitorModel.getActual_phoograph_of_site());
			pst.setInt(18, Integer.parseInt(site_visit_id));
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	

}

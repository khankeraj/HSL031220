package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.SalesAgreementModal;

public class SalesAgreementDAO {
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	public int insert_sales_agreement(SalesAgreementModal salesAgreement,String lead_no,String token_id) {
		// TODO Auto-generated method stub
		 int i=0;
		 
		try {
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `sales_agreement_master`(`lead_no`,`aggrement_subject`, `name`, `firm_name`, `reg_no`, `office_address`, `city`, `pincode`, `authorized_signatory`, `quotation_no`, `date_of_quotation`, `order_no`, `second_part_payment`,`status`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,1)");
		    pst.setString(1, lead_no);
			pst.setString(2, salesAgreement.getAgreement_subject());
		    pst.setString(3, salesAgreement.getName());
		    pst.setString(4, salesAgreement.getFirm_name());
		    pst.setString(5, salesAgreement.getReg_no());
		    pst.setString(6, salesAgreement.getOffice_address());
		    pst.setString(7, salesAgreement.getCity());
		    pst.setString(8, salesAgreement.getPincode());
		    pst.setString(9, salesAgreement.getAuthorized_signatory());
		    pst.setString(10, salesAgreement.getQuotation_no());
		    pst.setString(11, salesAgreement.getDate_of_quotation());
		    pst.setString(12, salesAgreement.getOrder_no());
		    pst.setString(13, salesAgreement.getSecond_part_payment());
			i=pst.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			PreparedStatement pst1=conn.prepareStatement("UPDATE `status_master` SET `token_amount`=1 WHERE `lead_no`='"+lead_no+"'");
			i=pst1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			PreparedStatement pst2=conn.prepareStatement("UPDATE `token_amount_details` SET `status`=2 WHERE `token_id`="+token_id+"");
			i=pst2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public List<SalesAgreementModal> fetch_agreements_details(SalesAgreementModal salesAgreement) {
		// TODO Auto-generated method stub
		
		List<SalesAgreementModal> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `aggrement_subject`, `name`, `firm_name`,`quotation_no`, `date_of_quotation`,`sales_agg_id`,`lead_no` FROM `sales_agreement_master` WHERE status=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				SalesAgreementModal sales=new SalesAgreementModal();
				sales.setAgreement_subject(rs.getString(1));
				sales.setName(rs.getString(2));
				sales.setFirm_name(rs.getString(3));
				sales.setQuotation_no(rs.getString(4));
				sales.setDate_of_quotation(rs.getString(5));
				sales.setSales_agg_id(rs.getInt(6));
				sales.setLead_no(rs.getString(7));
				list.add(sales);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public List<SalesAgreementModal> set_agreement_details(SalesAgreementModal salesAgreement) {
		// TODO Auto-generated method stub
		List<SalesAgreementModal> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `aggrement_subject`, `name`, `firm_name`, `reg_no`, `office_address`, `city`, `pincode`, `authorized_signatory`, `quotation_no`, `date_of_quotation`, `order_no`, `second_part_payment` FROM `sales_agreement_master`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				SalesAgreementModal salesAgg=new SalesAgreementModal();
				salesAgg.setAgreement_subject(rs.getString(1));
				salesAgg.setName(rs.getString(2));
				salesAgg.setFirm_name(rs.getString(3));
				salesAgg.setReg_no(rs.getString(4));
				salesAgg.setOffice_address(rs.getString(5));
				salesAgg.setCity(rs.getString(6));
				salesAgg.setPincode(rs.getString(7));
				salesAgg.setAuthorized_signatory(rs.getString(8));
				salesAgg.setQuotation_no(rs.getString(9));
				salesAgg.setDate_of_quotation(rs.getString(10));
				salesAgg.setOrder_no(rs.getString(11));
				salesAgg.setSecond_part_payment(rs.getString(12));
				list.add(salesAgg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<SalesAgreementModal> set_agreementdet(SalesAgreementModal salesAgreement,String sales_agg_id) {
		// TODO Auto-generated method stub
		List<SalesAgreementModal> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `aggrement_subject`, `name`, `firm_name`, `reg_no`, `office_address`, `city`, `pincode`, `authorized_signatory`, `quotation_no`, `date_of_quotation`, `order_no`, `second_part_payment` FROM `sales_agreement_master` WHERE sales_agg_id="+sales_agg_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				SalesAgreementModal salesAgg=new SalesAgreementModal();
				salesAgg.setAgreement_subject(rs.getString(1));
				salesAgg.setName(rs.getString(2));
				salesAgg.setFirm_name(rs.getString(3));
				salesAgg.setReg_no(rs.getString(4));
				salesAgg.setOffice_address(rs.getString(5));
				salesAgg.setCity(rs.getString(6));
				salesAgg.setPincode(rs.getString(7));
				salesAgg.setAuthorized_signatory(rs.getString(8));
				salesAgg.setQuotation_no(rs.getString(9));
				salesAgg.setDate_of_quotation(rs.getString(10));
				salesAgg.setOrder_no(rs.getString(11));
				salesAgg.setSecond_part_payment(rs.getString(12));
				list.add(salesAgg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	

}

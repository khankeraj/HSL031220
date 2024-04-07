package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.InvestmentAndExpencesModel;

public class InvestmentAndExpencesDAO {
	DBConnection connection=new DBConnection();
	public int insertInvestmentAndExp(InvestmentAndExpencesModel investAndExpences,int quotation_id,String lead_no) {
		
		System.out.println("invest and expences");
		
		int i=0;
		
		int max_count=0;
		try {
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `investmt_exp_config_master`(`customer_id`, `lead_no`, `name_of_index`, `sub_name_of_index`, `quotation_name`, `heading3`, `heading4`, `total1`, `total2`, `total3`) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,quotation_id);
			pst.setString(2, lead_no);
			pst.setString(3,investAndExpences.getName());
			pst.setString(4, investAndExpences.getSubname());
			pst.setString(5, investAndExpences.getHeading3());
			pst.setString(6, investAndExpences.getHeading4());
			pst.setString(7, investAndExpences.getQuotation_name());
			pst.setString(8, investAndExpences.getTot1());
			pst.setString(9, investAndExpences.getTot2());
			pst.setString(10, investAndExpences.getTot3());
			
			i=pst.executeUpdate();
			
			if(i>0)
			{
				System.out.println("inserted...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(invest_exp_id) as maxCount FROM investmt_exp_config_master");
				
				ResultSet rs=pst1.executeQuery();
				
				while(rs.next())
				{
					max_count=Integer.parseInt(rs.getString(1));
					
					for(int j=0;j<investAndExpences.getParticulars().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `invest_exp_details_config_001`(`particulars`, `expences`, `gst%`, `gst_amount`, `total`, `invest_exp_id`) VALUES (?,?,?,?,?,?)");
						
						pst11.setString(1, investAndExpences.getParticulars()[j]);
						
						pst11.setString(2, investAndExpences.getExpences()[j]);
						
						pst11.setString(3, investAndExpences.getGstPer()[j]);
						
						pst11.setString(4, investAndExpences.getGstAmount()[j]);
						
						pst11.setString(5, investAndExpences.getTotal()[j]);
						
						pst11.setInt(6,max_count);
						
						i=pst11.executeUpdate();
					}
				}
				
				
			}
			
			
			///For status master 
			
			PreparedStatement pst11=conn.prepareStatement("UPDATE `status_master` SET `quotation`='YES' WHERE lead_no='"+lead_no+"'");
			int j=pst11.executeUpdate();
			if(j>0)
			{
				System.out.println("status Updated Successfully");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public List<InvestmentAndExpencesModel> fetchInvestmentAndExp(InvestmentAndExpencesModel investAndExpences) {
		// TODO Auto-generated method stub
		
		List<InvestmentAndExpencesModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `sub_name_of_index`,`heading3`, `heading4`, `total1`, `total2`, `total3` FROM `investmentandexpmaster`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpencesModel investexp=new InvestmentAndExpencesModel();
				
				investexp.setName(rs.getString(1));
				investexp.setSubname(rs.getString(2));
				investexp.setHeading3(rs.getString(3));
				investexp.setHeading4(rs.getString(4));
				investexp.setTot1(rs.getString(5));
				investexp.setTot2(rs.getString(6));
				investexp.setTot3(rs.getString(7));
				
				list.add(investexp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<InvestmentAndExpencesModel> fetchInvestmenexp(InvestmentAndExpencesModel investAndExpences) {
		// TODO Auto-generated method stub
		List<InvestmentAndExpencesModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `expences`, `gst%`, `gst_amount`, `total` FROM `investmentandexpspdetails1`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpencesModel investExp=new InvestmentAndExpencesModel();
				investExp.setParti(rs.getString(1));
				investExp.setExp(rs.getString(2));
				investExp.setGstP(rs.getString(3));
				investExp.setGstAmt(rs.getString(4));
				investExp.setTot(rs.getString(5));
				
				list.add(investExp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<InvestmentAndExpencesModel> fetchInvestmentAndExp2(InvestmentAndExpencesModel investAndExpences,String investmentAndExpId) {
		// TODO Auto-generated method stub
		List<InvestmentAndExpencesModel> list=new ArrayList<>();
		int investmentAndExp=Integer.parseInt(investmentAndExpId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `invest_exp_id`, `name_of_index`, `sub_name_of_index`, `heading3`, `heading4`, `quotation_name`, `total1`, `total2`, `total3` FROM `investmt_exp_config_master` WHERE invest_exp_id=?");
			pst.setInt(1, investmentAndExp);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpencesModel investexp=new InvestmentAndExpencesModel();
				investexp.setInvest_exp_id(rs.getInt(1));
				investexp.setName(rs.getString(2));
				investexp.setSubname(rs.getString(3));
				investexp.setHeading3(rs.getString(4));
				investexp.setHeading4(rs.getString(5));
				investexp.setQuotation_name(rs.getString(6));
				investexp.setTot1(rs.getString(7));
				investexp.setTot2(rs.getString(8));
				investexp.setTot3(rs.getString(9));
				
				list.add(investexp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<InvestmentAndExpencesModel> fetchInvestmenexp3(InvestmentAndExpencesModel investAndExpences,String investmentAndExpId) {
		// TODO Auto-generated method stub
		List<InvestmentAndExpencesModel> list=new ArrayList<>();
		int investmentAndExp=Integer.parseInt(investmentAndExpId);
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `invest_exp_sp_id`, `particulars`, `expences`, `gst%`, `gst_amount`, `total`, `invest_exp_id` FROM `invest_exp_details_config_001` WHERE invest_exp_id=?");
			pst.setInt(1, investmentAndExp);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpencesModel investExp=new InvestmentAndExpencesModel();
				investExp.setParti(rs.getString(1));
				investExp.setExp(rs.getString(2));
				investExp.setGstP(rs.getString(3));
				investExp.setGstAmt(rs.getString(4));
				investExp.setTot(rs.getString(5));
				
				list.add(investExp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public int updateInvestmentAndExpenses(InvestmentAndExpencesModel investAndExpences, String investmentAndExpId) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
		
		int investmentExpId=Integer.parseInt(investmentAndExpId);
		Connection conn=connection.getConnection();
		
		try {
			
			PreparedStatement pst=conn.prepareStatement("UPDATE `investmt_exp_config_master` SET `name_of_index`=?,`sub_name_of_index`=?,`heading3`=?,`heading4`=?,`quotation_name`=?,`total1`=?,`total2`=?,`total3`=? WHERE `invest_exp_id`=?");
			
			pst.setString(1,investAndExpences.getName());
			pst.setString(2, investAndExpences.getSubname());
			pst.setString(3, investAndExpences.getHeading3());
			pst.setString(4, investAndExpences.getHeading4());
			pst.setString(5, investAndExpences.getQuotation_name());
			pst.setString(6, investAndExpences.getTot1());
			pst.setString(7, investAndExpences.getTot2());
			pst.setString(8, investAndExpences.getTot3());
			
			pst.setInt(11, investmentExpId);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		try {
					
					PreparedStatement pst2=conn.prepareStatement("DELETE FROM ` invest_exp_details_config_001` WHERE invest_exp_id=?");
					pst2.setInt(1, investmentExpId);
					i=pst2.executeUpdate();
					
					for(int j=0;j<investAndExpences.getParticulars().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO ` invest_exp_details_config_001`(`particulars`, `expences`, `gst%`, `gst_amount`, `total`, `invest_exp_id`) VALUES (?,?,?,?,?,?)");
						
						pst11.setString(1, investAndExpences.getParticulars()[j]);
						
						pst11.setString(2, investAndExpences.getExpences()[j]);
						
						pst11.setString(3, investAndExpences.getGstPer()[j]);
						
						pst11.setString(4, investAndExpences.getGstAmount()[j]);
						
						pst11.setString(5, investAndExpences.getTotal()[j]);
						
						pst11.setInt(6,investmentExpId);
						
						i=pst11.executeUpdate();
					}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public int deleteInvestAndExp(InvestmentAndExpencesModel investAndExpences, String investmentAndExpId) {
		// TODO Auto-generated method stub
		int i=0;
		int investmentExpId=Integer.parseInt(investmentAndExpId);
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `investmt_exp_config_master` WHERE invest_exp_id=?");
			pst.setInt(1, investmentExpId);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM ` invest_exp_details_config_001` WHERE invest_exp_id=?");
			pst.setInt(1, investmentExpId);
			i=pst.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

}

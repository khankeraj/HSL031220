package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.HeaderTokenizer.Token;

import com.DB.DBConnection;
import com.quotation.model.TokenAmountModel;

public class TokenAmountDAO {
	
	DBConnection conn=new DBConnection();
	Connection connection=conn.getConnection();

	public int insert_cash_amount(TokenAmountModel tokenAmt,int site_visitor_id,String lead_no) {
		// TODO Auto-generated method stub
		int i=0;
	try {
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `token_amount_details`(`site_visit_id`,`lead_no`,`finalized_amount`, `token_amount`, `paymode`, `net_amount`,`status`) VALUES (?,?,?,?,?,?,1)");
			pst.setInt(1, site_visitor_id);
			pst.setString(2, lead_no);
			pst.setString(3, tokenAmt.getFinalized_amount());
			pst.setString(4, tokenAmt.getToken_amount());
			pst.setString(5, tokenAmt.getPaymode());
			pst.setString(6, tokenAmt.getNet_amount());
			i=pst.executeUpdate();
		} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			PreparedStatement pst=connection.prepareStatement("UPDATE `site_visit` SET  `status`=2 WHERE `visitor_id`="+site_visitor_id+"");
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int insert_card_amount(TokenAmountModel tokenAmt,int site_visitor_id,String lead_no) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `token_amount_details`(`site_visit_id`,`lead_no`,`finalized_amount`, `token_amount`, `paymode`, `card_net_amount`, `card_transaction_id`,`status`) VALUES (?,?,?,?,?,1)");
			pst.setInt(1, site_visitor_id);
			pst.setString(2, lead_no);
			pst.setString(3, tokenAmt.getFinalized_amount());
			pst.setString(4, tokenAmt.getToken_amount());
			pst.setString(5, tokenAmt.getPaymode());
			pst.setString(6, tokenAmt.getCardnet_amount());
			pst.setString(7, tokenAmt.getCard_trans_id());
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst=connection.prepareStatement("UPDATE `site_visit` SET  `status`=2 WHERE `visitor_id`="+site_visitor_id+"");
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int insert_cheque_amount(TokenAmountModel tokenAmt,int site_visitor_id,String lead_no) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `token_amount_details`(`site_visit_id`,`lead_no`,`finalized_amount`, `token_amount`, `paymode`,`bank_name`, `cheque_no`, `cheque_amount`, `cheque_date`,`status`) VALUES (?,?,?,?,?,?,?,1)");
			pst.setInt(1, site_visitor_id);
			pst.setString(2, lead_no);
			pst.setString(3, tokenAmt.getFinalized_amount());
			pst.setString(4, tokenAmt.getToken_amount());
			pst.setString(5, tokenAmt.getPaymode());
			pst.setString(6, tokenAmt.getBank_name());
			pst.setString(7, tokenAmt.getCheque_no());
			pst.setString(8, tokenAmt.getCheque_amount());
			pst.setString(9, tokenAmt.getCheque_date());
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst1=connection.prepareStatement("UPDATE `status_master` SET `token_amount`=1 WHERE `lead_no`='"+lead_no+"'");
			i=pst1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst2=connection.prepareStatement("UPDATE `site_visit` SET  `status`=2 WHERE `visitor_id`="+site_visitor_id+"");
			i=pst2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public int insert_cash_card_amount(TokenAmountModel tokenAmt,int site_visitor_id,String lead_no) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `token_amount_details`(`site_visit_id`,`lead_no`,`finalized_amount`, `token_amount`, `paymode`,`total_amount`, `cash_amount`, `credit_card_amount`, `transaction_id`) VALUES (?,?,?,?,?,?,?)");
			pst.setInt(1, site_visitor_id);
			pst.setString(2, lead_no);
			pst.setString(3, tokenAmt.getFinalized_amount());
			pst.setString(4, tokenAmt.getToken_amount());
			pst.setString(5, tokenAmt.getPaymode());
			pst.setString(6, tokenAmt.getTotal_amount());
			pst.setString(7, tokenAmt.getCash_amount());
			pst.setString(8, tokenAmt.getCreditcard_amount());
			pst.setString(9, tokenAmt.getTransction_id());
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	

	public List<TokenAmountModel> fetchTokenReports(TokenAmountModel tokenAmt) {
		// TODO Auto-generated method stub
		List<TokenAmountModel> list=new ArrayList<TokenAmountModel>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT token_amount_details.token_id,lead_deatils.customer_name,token_amount_details.finalized_amount,token_amount_details.token_amount,token_amount_details.paymode,token_amount_details.lead_no FROM lead_deatils,token_amount_details WHERE token_amount_details.status=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TokenAmountModel tokenAmount=new TokenAmountModel();
				tokenAmount.setToken_id(rs.getInt(1));
				tokenAmount.setCustomer_name(rs.getString(2));
				tokenAmount.setFinalized_amount(rs.getString(3));
				tokenAmount.setToken_amount(rs.getString(4));
				tokenAmount.setPaymode(rs.getString(5));
				tokenAmount.setLead_no(rs.getString(6));
				list.add(tokenAmount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<TokenAmountModel> getFinalizationAmttokenamt(int site_visitor_id) {
		// TODO Auto-generated method stub
		
		List<TokenAmountModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `finalized_amount`, `token_amount` FROM `finalized_quotation_master` WHERE quotation_id="+site_visitor_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TokenAmountModel token=new TokenAmountModel();
				token.setFinalizaed_amt(rs.getString(1));
				token.setToken_amt(rs.getString(2));
				list.add(token);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
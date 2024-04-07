package com.quotationPages.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotationPages.modal.QuotationPagesModal;

public class QuotationPagesDAO {

	DBConnection connection=new DBConnection();
	
	public List<QuotationPagesModal> fetchQuotationPages(QuotationPagesModal quotationPages) {
		
		List<QuotationPagesModal> list=new ArrayList<>();
		
		try {
			
			Connection conn=connection.getConnection();
			
			PreparedStatement pst=conn.prepareStatement("SELECT quotation_pages.page_id,quotation_pages.index_name FROM quotation_pages ");
			System.out.println("Pst:"+pst);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationPagesModal quortationPages=new QuotationPagesModal();
				
				quortationPages.setPage_id(rs.getInt(1));
				quortationPages.setIndex_name(rs.getString(2));
				
				list.add(quortationPages);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

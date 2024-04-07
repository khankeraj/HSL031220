package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.DB.DBConnection;
//import com.aqua.dao.DaoHelper;
//import com.aqua.util.SystemDateTime;
//import com.aqua.util.SystemDateTime;
//import com.aqua.model.LoginBean;
//import com.aqua.model.Purchase_Order_bean1;
//import com.aqua.model.Purchase_Order_bean1;
//import com.aqua.model.Purchase_Order_bean1;
import com.master.model.MaterialReceivedModel;
import com.master.model.invoicebean;

public class MAterialReceivedDAO {
	
	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();

	public List<MaterialReceivedModel> insert_material_details(String pono, MaterialReceivedModel materialReceived) {
		// TODO Auto-generated method stub
		
		List<MaterialReceivedModel> products = new ArrayList<MaterialReceivedModel>();
		List<MaterialReceivedModel> stock = new ArrayList<MaterialReceivedModel>();
		
		int i=0;
		try {
			
			PreparedStatement preparedStatement1 = conn
					.prepareStatement("select * from purchase_order_details where pono=? and remaining_quantity>0 ");
			
			preparedStatement1.setString(1, pono);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			System.out.println(preparedStatement1);
			
			while (resultSet1.next()) {

				MaterialReceivedModel m_bean = new MaterialReceivedModel();

				m_bean.setMaterial_code1(resultSet1.getString("descrip"));
				m_bean.setRemain(resultSet1.getString("remaining_quantity"));
				
				m_bean.setBalance_qty(resultSet1.getString("quantity"));
				
				
//				materialReceived.setMaterial_code(resultSet1.getString("descrip"));
//				materialReceived.setRemain(resultSet1.getString("remaining_quantity"));
//				
//				materialReceived.setBalance_qty(resultSet1.getString("quantity"));
				
				
				
//				PreparedStatement pst1 = connection
//						.prepareStatement("select * from material_master where material='"+resultSet1.getString("description")+"' ");
//
//				ResultSet rs1 = pst1.executeQuery();
				
				
//				if (rs1.next()) {
//					
//					p_bean.setHsn1(rs1.getString("hsn"));
//					p_bean.setTax1(rs1.getString("tax"));	
//						
//					}


			products.add(m_bean);
//			products.add(materialReceived);
			i++;
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return products;
	}
			
//			PreparedStatement pst=conn.prepareStatement("INSERT INTO material_received(material_received_status,customer_name) VALUES (?,?)");
//			pst.setString(1, materialReceived.getReceived_material_status());
//			pst.setString(2, materialReceived.getCustomer_name());
//			i=pst.executeUpdate();
//			if(i>0)
//			{
//				System.out.println("inserted Succesfully");
//				 PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+materialReceived.getCustomer_name()+"'");
//				 ResultSet rs=pst1.executeQuery();
//				 if(rs.next())
//				 {
//					 int lead_id=Integer.parseInt(rs.getString(1));
////					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `matreceived`='YES' WHERE status_master.lead_id="+lead_id+"");
//					 PreparedStatement pst2=conn.prepareStatement("UPDATE `status_master` SET `matreceived`='YES' WHERE status_master.status_id="+lead_id+"");
//				     i=pst2.executeUpdate();
//					 if(i>0)
//					 {
//						 System.out.println("Updated SuccessFully...!!!");
//					 }
//				 }
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//				
		
	
	
	
	public String insertMaterialDetails(MaterialReceivedModel mrm) throws SQLException
	{
		
		String response = "";
		
		try {
		String stringValue = "";
		String stringValue1 = "";
		
		int len = 0;
		PreparedStatement preparedStatement1 = conn
				.prepareStatement("select  max(SUBSTRING(mr_no,-4)) as myval1 from material_received  ");
		
		
		String mystr1 = "";
		int myval1 = 0;
		ResultSet resultSet1 = preparedStatement1.executeQuery();
		
		if (resultSet1.next()) {
			try {
				mystr1 = resultSet1.getString("myval1");
				myval1 = Integer.parseInt(mystr1);
				myval1 = myval1 + 1;
			} catch (Exception e) {
				// TODO: handle exception
				myval1 = 1;
				mystr1 = "";
			}
		}
		
		
		int size = len + 1;
		stringValue = String.valueOf(myval1);
		
		if (stringValue.length() == 1) {
			stringValue = "MR/" + "000" + stringValue;
		} else if (stringValue.length() == 2) {
			stringValue = "MR/" + "00" + stringValue;
		} else if (stringValue.length() == 3) {
			stringValue = "MR/" + "0" + stringValue;
		} else {
			stringValue = "MR/" + stringValue;
		}
		
		mrm.setMaterial_num(stringValue);
		
		
		
		int j = 0;
		PreparedStatement pst1 = conn.prepareStatement(
				"insert into material_received(mr_no, customer_name, date, pono, customer_code, supplier) values(?,?,?,?,?,?)");
		
		pst1.setString(1, mrm.getMaterial_num());
		pst1.setString(2, mrm.getCustomer_name());
		pst1.setString(3, mrm.getDate());
		pst1.setString(4, mrm.getPono());
		pst1.setString(5, mrm.getCustomer_code());
		pst1.setString(6, mrm.getSupplier());
		
		j=pst1.executeUpdate();
		
		int k = 0;
		
		PreparedStatement pst2 = conn.prepareStatement(
				"insert into material_rec_details(mr_no, pono, descrip, quantity, received_quantity) values(?,?,?,?,?)");
		
		
		try {
			for (int l = 0; l < mrm.getDescription().length; l++) {
				
				if ((mrm.getDescription()[l] != "")) {
					
					pst2.setString(1, mrm.getMaterial_num());
					pst2.setString(2, mrm.getPono());
					pst2.setString(3, mrm.getDescription()[l]);
				
					pst2.setString(4, mrm.getQuantity()[l]);
					pst2.setString(5, mrm.getReceivedquantity()[l]);
		
//					pst2.setString(6, bean.getUsername());
//					pst2.setString(7, SystemDateTime.CurrentDateTime());
					
					k = pst2.executeUpdate();
				}
			}

		} catch (Exception e) {
		}
		
		try {
			for (int l = 0; l < mrm.getDescription().length; l++) {
				if (mrm.getDescription()[l] != "") {

					PreparedStatement preparedStatement11 = conn
							.prepareStatement("select * from stock_details where description=?");
					
					preparedStatement11.setString(1, String.valueOf(mrm.getDescription()[l]));
					
					ResultSet resultSet11 = preparedStatement11.executeQuery();
					
					
					if (resultSet11.next()) {
//						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//						Date updatedate = new Date();

						PreparedStatement pst11 = conn.prepareStatement(
								"Update stock_details set qty=qty+" + mrm.getReceivedquantity()[l]
										+ " where description='"+mrm.getDescription()[l]+"' " );

						k = pst11.executeUpdate();
					}
					else {
						PreparedStatement pst11 = conn.prepareStatement(
								"insert into stock_details(description, qty) values(?,?)");

						pst11.setString(1, mrm.getDescription()[l]);
						pst11.setString(2, mrm.getReceivedquantity()[l]);
//						pst11.setString(3, prb.getUnitno()[l]);
						k = pst11.executeUpdate();

					}
					
				}
			}

		} catch (Exception e) {
		}
		
		
		
		
//		try {
//			//	Connection con = DaoHelper.getConnection();
//
//				String q1 = "update purchase_order set done_status='1',username=?,datetime=? where pono='" + prb.getPo_no() + "'";
//
//				PreparedStatement ps = connection.prepareStatement(q1);
//				ps.setString(1, bean.getUsername());
//				ps.setString(2, SystemDateTime.CurrentDateTime());
//
//				ps.executeUpdate();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		
		
		
		int flag1=1;
		try {
			for (int l = 0; l < mrm.getDescription().length; l++) {
				
				if (mrm.getDescription()[l] != "") {

					PreparedStatement preparedStatement11 = conn
							.prepareStatement("select * from purchase_order_details where descrip=? and pono='"
									+ mrm.getPono() + "' ");
					
					preparedStatement11.setString(1, String.valueOf(mrm.getDescription()[l]));
					
				
					
					
					
					
					ResultSet resultSet11 = preparedStatement11.executeQuery();
					
					if (resultSet11.next()) {
						
						PreparedStatement pst11 = conn.prepareStatement("Update purchase_order_details set remaining_quantity=remaining_quantity-" + mrm.getReceivedquantity()[l]+ " where descrip='"
										+ mrm.getDescription()[l] + "' and pono='" + mrm.getPono() + "'    ");

						
//						pst11.setString(1, bean.getUsername());
//						pst11.setString(2, SystemDateTime.CurrentDateTime());
						k = pst11.executeUpdate();
						
					
					} 

				}
			}
		} catch (Exception e) {
		}

		
		for (int l = 0; l < mrm.getDescription().length; l++) {
			
			if (mrm.getDescription()[l] != "") {
			
			PreparedStatement preparedStatement11 = conn
					.prepareStatement("select * from purchase_order_details where descrip=? and pono='"
							+ mrm.getPono() + "' ");
			
			preparedStatement11.setString(1, String.valueOf(mrm.getDescription()[l]));
			
			ResultSet resultSet11 = preparedStatement11.executeQuery();
			
			if (resultSet11.next()) {
			
				
				 String remain = resultSet11.getString("remaining_quantity");
				
				
				 double remain_qty=Double.parseDouble(remain);
				 
				 if(remain_qty==0)
				 {
					
						flag1=0;
					 
				 }
				 
				 else{
					 flag1=1;
					 break;
					 
				 }
				 
			}
			
			
		}
	}
	
		if(flag1==0)
		{	
		//Connection con = DaoHelper.getConnection();

		//String q1 = "update material_received set material_received_status='1', date=? where pono='" + mrm.getPono() + "'";
		String q1 = "update material_received set material_received_status='1' where pono='" + mrm.getPono() + "'";

		PreparedStatement ps = conn.prepareStatement(q1);
		
//		ps.setString(1, SystemDateTime.CurrentDateTime());

		ps.executeUpdate();
		
		
	
		//response = "success";
		}
//	else {
//		response = "Already";
//	}
		response = "success";
	} catch (Exception e) {

	response = "fail";
}

//DaoHelper.closeConnection();
//return response;
//}
		return response;
	}

	public List<MaterialReceivedModel> taxInvoiceReport() {
		// TODO Auto-generated method stub
		List<MaterialReceivedModel> list = new ArrayList<>();
		try {
			
			PreparedStatement pst = conn.prepareStatement("select * from material_received group by pono");
			ResultSet rs = pst.executeQuery();
			System.out.println(pst);
			while(rs.next())
			{
				
				System.out.println(rs.getString("material_received_status")+"   "+rs.getString("customer_code"));
				
				if(rs.getString("material_received_status")!=null)
				{
					if(rs.getString("material_received_status").equals("1"))
					{
						MaterialReceivedModel model = new MaterialReceivedModel();
						model.setCustomer_code(rs.getString("customer_code"));
						model.setCustomer_name(rs.getString("customer_name"));
						model.setPono(rs.getString("pono"));
						model.setDate(rs.getString("date"));
						
							model.setSupplier(rs.getString("supplier"));
							PreparedStatement pst1 = conn.prepareStatement("select company_id from company_master where company_name ='"+rs.getString("supplier")+"'");
							ResultSet rs1 = pst1.executeQuery();
							System.out.println(pst1);
							while(rs1.next())
							{
								model.setSupplier_id(rs1.getString(1));
							}
						
						
		
						
						System.out.println(model);
						list.add(model);
					}
				}
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(list.size());
		return list;
	}

	public List<invoicebean> invoiceFormDetails(String pono) {
		// TODO Auto-generated method stub
		List<invoicebean> products = new ArrayList<invoicebean>();
		try {
			
					PreparedStatement preparedStatement1 = conn
							.prepareStatement("select * from material_rec_details where pono=?");
					
					preparedStatement1.setString(1, pono);
					ResultSet resultSet1 = preparedStatement1.executeQuery();
					
					System.out.println(preparedStatement1);
					double total =0;
					while (resultSet1.next()) {
		
						invoicebean ibean = new invoicebean();
						
						
						ibean.setDescription(resultSet1.getString("descrip"));
						ibean.setQuantity(resultSet1.getString("received_quantity"));
						
						PreparedStatement preparedStatement2 = conn.prepareStatement("select * from item_master where item_name='"+ibean.getDescription()+"'");
						ResultSet resultSet2 = preparedStatement2.executeQuery();
						
						
						
						
						while(resultSet2.next()) {
							
							ibean.setRate(resultSet2.getString("sale_price"));
							ibean.setHsn(resultSet2.getString("hsn_code"));
							
							int crate = Integer.parseInt(resultSet2.getString("tax_per"))/2;
							int srate = Integer.parseInt(resultSet2.getString("tax_per"))/2;
							ibean.setCrate(String.valueOf(crate));
							ibean.setSrate(String.valueOf(srate));
							
							double cgst = 0;
							double sgst = 0;
							
							double amount = (Integer.parseInt(ibean.getQuantity()) * Integer.parseInt(ibean.getRate()));
							ibean.setAmount(String.valueOf(amount));
							
							double cgstamt = (amount *crate)/100;
							cgst = cgst + cgstamt;
							/*System.out.println("amount - "+amount);
							System.out.println("cgstamount : "+cgstamt);*/
							double sgstamt = (amount *srate)/100;
							sgst = sgst + sgstamt;
							
							ibean.setCgstamt(String.valueOf(cgstamt));
							ibean.setSgstamt(String.valueOf(sgstamt));
							
							ibean.setCgst(String.valueOf(cgst));
							ibean.setSgst(String.valueOf(sgst));
							
							
							double netamt = amount + cgstamt + sgstamt;
							ibean.setNet_amount(String.valueOf(netamt));
							
							double tot_tax_amt = cgstamt + sgstamt; 
							ibean.setTot_tax_amt(String.valueOf(tot_tax_amt));
							
							
							total = total + netamt;
							ibean.setTotal(String.valueOf(total));
							
						}
		
					System.out.println("Total--"+total);
		
					products.add(ibean);
		//			products.add(materialReceived);
					
					}
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
		
		
		
		
		
		return products;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.QuotationIndexModel;
import com.quotation.model.ROWaterTPModel;

public class QuotationIndexDAO {

	DBConnection connection=new DBConnection();
	Connection conn=connection.getConnection();
	
	
	public List<QuotationIndexModel> fetchQuotationIndexList(QuotationIndexModel quotationmodel, String quotation_name) {
		// TODO Auto-generated method stub
		List<QuotationIndexModel> list=new ArrayList<>();
		System.out.println("Quotation name in dao:"+quotation_name);
		
		try {
			
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("SELECT `index_id`,`name_of_index` FROM `quotation_index_config_001` WHERE quotation_name=?");
			pst.setString(1, quotation_name);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				QuotationIndexModel quotationmodel1=new QuotationIndexModel();
				
				quotationmodel.setIndex_id(rs.getInt(1));
				quotationmodel.setName_of_index(rs.getString(2));
				list.add(quotationmodel1);
				
				System.out.println("name_of_index:"+rs.getString(2));
			}
			
			/*System.out.println("index+id:"+rs.getInt(1));
			PreparedStatement pst1=connection.prepareStatement("SELECT `sub_name_of_index` FROM `quotation_ndex_details_config_002` WHERE `name_of_index_id`="+rs.getInt(rs.getInt(1))+"");
			ResultSet rs1=pst1.executeQuery();
			while(rs1.next())
			{
				QuotationIndexModel quotation=new QuotationIndexModel();
				quotation.setSubindex(rs.getString(1));
				list.add(quotation);
				
				System.out.println("quotation sub name:"+rs1.getString(1));
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert_Quotation_Index(QuotationIndexModel quotationIndex) {
		int i = 0;
	//	String sub_name[]=new String[100];
		int count = 0;
		try {
			PreparedStatement pst=conn.prepareStatement("INSERT INTO `quotation_index_config_001`(`name_of_index`, `quotation_name`) VALUES (?,?)");
			pst.setString(1,quotationIndex.getName_of_index());
			pst.setString(2, quotationIndex.getQuotation_name());
			i=pst.executeUpdate();
			if(i>0)
			{
				System.out.println("index name details inserted successfully...!!!");
				
				PreparedStatement pst1=conn.prepareStatement("SELECT MAX(quotation_index_config_001.index_id) AS indexCount FROM quotation_index_config_001");
				ResultSet rs=pst1.executeQuery();
				if(rs.next())
				{
					count=Integer.parseInt(rs.getString(1));
				}
				
				System.out.println("Count ::"+count);
				
				for(int j=0;j<quotationIndex.getSub_name_of_index().length;j++)
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `quotation_ndex_details_config_002`(`sub_name_of_index`, `name_of_index_id`) VALUES (?,?)");
					pst11.setString(1, quotationIndex.getSub_name_of_index()[j]);
					pst11.setInt(2, count);
					i=pst11.executeUpdate();
					if(i>0)
					{
						System.out.println("successFully Inserted subname of index...!!!");
					}
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public List<QuotationIndexModel> fetchQuotationIndex(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		List<QuotationIndexModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index` FROM `quotation_index`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel qindexmodel=new QuotationIndexModel();
				qindexmodel.setName_of_index(rs.getString(1));
				list.add(qindexmodel);
				System.out.println("list of index:"+rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<QuotationIndexModel> fetchQuotationIndex1(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		
		List<QuotationIndexModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `sub_name_of_index` FROM `quotation_index_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel qindexmodel=new QuotationIndexModel();
				qindexmodel.setSubindex(rs.getString(1));
				list.add(qindexmodel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<QuotationIndexModel> fetchQuotationIndexReportsDetails(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		List<QuotationIndexModel> list=new ArrayList<>();
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `index_id`,`quotation_name` FROM `quotation_index_config_001`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel index=new QuotationIndexModel();
				index.setIndex_id(rs.getInt(1));
				index.setQuotation_name(rs.getString(2));
				list.add(index);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<QuotationIndexModel> fetchForUpdateQuoIndex(QuotationIndexModel quoindexModel,String updateQuotationIndexId) {
		// TODO Auto-generated method stub
		int indexId=Integer.parseInt(updateQuotationIndexId);
		List<QuotationIndexModel> list=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `index_id`,`name_of_index`, `quotation_name` FROM `quotation_index_config_001` WHERE index_id=?");
			pst.setInt(1, indexId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel qindexmodel=new QuotationIndexModel();
				qindexmodel.setIndex_id(rs.getInt(1));
				qindexmodel.setName_of_index(rs.getString(2));
				qindexmodel.setQuotation_name(rs.getString(3));
				list.add(qindexmodel);
				System.out.println("list of index:"+rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<QuotationIndexModel> fetchForUpdateQuoIndex1(QuotationIndexModel quotationIndex,String updateQuotationIndexId) {
		// TODO Auto-generated method stub
		List<QuotationIndexModel> list=new ArrayList<>();
		int updateQuoIndex=Integer.parseInt(updateQuotationIndexId);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `sub_name_of_index` FROM `quotation_ndex_details_config_002` WHERE name_of_index_id=?");
			pst.setInt(1, updateQuoIndex);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel qindexmodel=new QuotationIndexModel();
				qindexmodel.setSubindex(rs.getString(1));
				list.add(qindexmodel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int updateQuotationIndex(QuotationIndexModel quotationIndex, String updateQuotationIndexId) {
		// TODO Auto-generated method stub
		
		int quo_index_up=Integer.parseInt(updateQuotationIndexId);
		
		int i = 0;
		//	String sub_name[]=new String[100];
			int count = 0;
			try {
				PreparedStatement pst=conn.prepareStatement("UPDATE `quotation_index_config_001` SET `name_of_index`=?,`quotation_name`=? WHERE `index_id`=?");
				pst.setString(1,quotationIndex.getName_of_index());
				pst.setString(2, quotationIndex.getQuotation_name());
				pst.setInt(3, quo_index_up);
				i=pst.executeUpdate();
				if(i>0)
				{
					System.out.println("index name details inserted successfully...!!!");
					
					
					try {
						PreparedStatement pstmt=conn.prepareStatement("DELETE FROM `quotation_ndex_details_config_002` WHERE name_of_index_id=?");
						pstmt.setInt(1, quo_index_up);
						i=pstmt.executeUpdate();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
					for(int j=0;j<quotationIndex.getSub_name_of_index().length;j++)
					{
						PreparedStatement pst11=conn.prepareStatement("INSERT INTO `quotation_ndex_details_config_002`(`sub_name_of_index`, `name_of_index_id`) VALUES (?,?)");
						pst11.setString(1, quotationIndex.getSub_name_of_index()[j]);
						pst11.setInt(2, quo_index_up);
						i=pst11.executeUpdate();
						if(i>0)
						{
							System.out.println("successFully Inserted subname of index...!!!");
						}
					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
	}

	public int deleteQuotationIndex(QuotationIndexModel quotationIndex, String updateQuotationIndexId) {
		// TODO Auto-generated method stub
	int i=0;
		int updateQuoIndex=Integer.parseInt(updateQuotationIndexId);
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `quotation_index_config_001` WHERE index_id=?");
			pst.setInt(1, updateQuoIndex);
			i=pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `quotation_ndex_details_config_002` WHERE name_of_index_id=?");
			pst1.setInt(1, updateQuoIndex);
			i=pst1.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

	public List<QuotationIndexModel> fetchQ1(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		
		List<QuotationIndexModel> qlist=new ArrayList<>();
		int index_id=0;
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `index_id`, `name_of_index` FROM `quotation_index`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel index=new QuotationIndexModel();
				index_id=rs.getInt(1);
				index.setName_of_index(rs.getString(2));
				qlist.add(index);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qlist;
		
	}
	
	public List<QuotationIndexModel> fetchQ2(QuotationIndexModel quotationIndex,String quotation_id) {
		// TODO Auto-generated method stub
		PreparedStatement pst1;
		//int quotation_id=0;
		/*try {
			pst1 = conn.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				int id=rs1.getInt(1);
				quotation_id=id+1;
				System.out.println("quottaion_id:"+quotation_id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		int quot_id=Integer.parseInt(quotation_id);
		
		String mycheckbox="checked";
		
		List<QuotationIndexModel> qlist=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `index_id`, `sub_name_of_index`  FROM `quotation_index_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel index1=new QuotationIndexModel();
				
				String myarr[]=new String[1000];
				
				String setquotation[]=new String[1000];
				
				index1.setIndex_id(rs.getInt(1));
				
				index1.setSubindex(rs.getString(2));
				
				String select_quot[]=new String[1000]; 
				

				if(rs.getString(2).equals("RO WATER TREATMENT PLANT"))
				{
					String sel_quot="";
					PreparedStatement pst2=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='RO WATER TREATMENT PLANT' AND quotation_id="+quot_id+"");
					ResultSet rs2=pst2.executeQuery();
					if(rs2.next())
					{
						sel_quot=rs2.getString(1);
						
					}
					
					System.out.println("select_quot:"+select_quot);
					
					PreparedStatement pst11=conn.prepareStatement("SELECT `quotation_name` FROM `ro_config_master`");
					ResultSet rs11=pst11.executeQuery();
					
					int i=0;
					while(rs11.next())
					{
						myarr[i]=rs11.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					System.out.println("select_quot in if:"+select_quot[i]);
					
					
					/*if(myarr[i].equals(select_quot))
					{
						index1.setSelect_quot("selected");
					}else
					{
						index1.setSelect_quot("");
					}*/
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					
					index1.setMysize(i);
				} 
				
				else if(rs.getString(2).equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))
				{
					
					String sel_quot="";
					PreparedStatement pst3=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='FULLY AUTO RINSSING, FILLING AND CAPING MACHINE' AND quotation_id="+quot_id+"");
					ResultSet rs3=pst3.executeQuery();
					if(rs3.next())
					{
						sel_quot=rs3.getString(1);
						
					}
					
					PreparedStatement pst2=conn.prepareStatement("SELECT `quotation_name` FROM `fab_rfc_master`");
					ResultSet rs21=pst2.executeQuery();
					
					int i=0;
					while(rs21.next())
					{
						myarr[i]=rs21.getString(1);
						
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Fully Auto Bottle Labelling Machine"))
				{
					
					String sel_quot="";
					PreparedStatement pst4=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Fully Auto Bottle Labelling Machine' AND quotation_id="+quot_id+"");
					ResultSet rs4=pst4.executeQuery();
					if(rs4.next())
					{
						sel_quot=rs4.getString(1);
						
					}
					
					PreparedStatement pst3=conn.prepareStatement("SELECT `quotation_name` FROM `fab_labeling_mc_config_001`");
					ResultSet rs3=pst3.executeQuery();
					
					int i=0;
					while(rs3.next())
					{
						myarr[i]=rs3.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Hot Fill Fully Auto Blow Molding Machine"))
				{
					
					String sel_quot="";
					PreparedStatement pst5=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Hot Fill Fully Auto Blow Molding Machine' AND quotation_id="+quot_id+"");
					ResultSet rs5=pst5.executeQuery();
					if(rs5.next())
					{
						sel_quot=rs5.getString(1);
						
					}
					
					PreparedStatement pst4=conn.prepareStatement("SELECT `quotation_name` FROM `hotfabmold_config_master`");
					ResultSet rs4=pst4.executeQuery();
					int i=0;
					while(rs4.next())
					{
						myarr[i]=rs4.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("High Pressure Compressor"))
				{
					
					String sel_quot="";
					PreparedStatement pst6=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='High Pressure Compressor' AND quotation_id="+quot_id+"");
					ResultSet rs6=pst6.executeQuery();
					if(rs6.next())
					{
						sel_quot=rs6.getString(1);
						
					}
					
					PreparedStatement pst5=conn.prepareStatement("SELECT `quotation_name` FROM `hpc_config_master`");
					ResultSet rs5=pst5.executeQuery();
					int i=0;
					while(rs5.next())
					{
						myarr[i]=rs5.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Low Pressure Compressor"))
				{
					
					String sel_quot="";
					PreparedStatement pst7=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Low Pressure Compressor' AND quotation_id="+quot_id+"");
					ResultSet rs7=pst7.executeQuery();
					if(rs7.next())
					{
						sel_quot=rs7.getString(1);
					}
					
					PreparedStatement pst6=conn.prepareStatement("SELECT `quotation_name` FROM `lpc_config_master`");
					ResultSet rs6=pst6.executeQuery();
					int i=0;
					while(rs6.next())
					{
						myarr[i]=rs6.getString(1);
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("SHRINK MACHINE"))
				{
					
					String sel_quot="";
					PreparedStatement pst8=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='SHRINK MACHINE' AND quotation_id="+quot_id+"");
					ResultSet rs8=pst8.executeQuery();
					if(rs8.next())
					{
						sel_quot=rs8.getString(1);
					}
					
					PreparedStatement pst7=conn.prepareStatement("SELECT `quotation_name` FROM `shrink_machine_config_master`");
					ResultSet rs7=pst7.executeQuery();
					int i=0;
					while(rs7.next())
					{
						myarr[i]=rs7.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Autocase Packer"))
				{
					String sel_quot="";
					PreparedStatement pst9=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Autocase Packer' AND quotation_id="+quot_id+"");
					ResultSet rs9=pst9.executeQuery();
					if(rs9.next())
					{
						sel_quot=rs9.getString(1);
					}
					
					PreparedStatement pst8=conn.prepareStatement("SELECT `quotation_name` FROM `autocase_packer_config_master`");
					ResultSet rs8=pst8.executeQuery();
					int i=0;
					while(rs8.next())
					{
						myarr[i]=rs8.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Laboratories : Chemical & Microbiology"))
				{
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Laboratories : Chemical & Microbiology' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst9=conn.prepareStatement("SELECT `quotation_name` FROM `lab_chem_micro_config_master`");
					ResultSet rs9=pst9.executeQuery();
					int i=0;
					while(rs9.next())
					{
						myarr[i]=rs9.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
						
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				/*else if(rs.getString(2).equals("Investment And Expences For Project As Per Bis"))
				{
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Investment And Expences For Project As Per Bis' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst10=conn.prepareStatement("SELECT `quotation_name` FROM `investmt_exp_config_master`");
					ResultSet rs10=pst10.executeQuery();
					int i=0;
					while(rs10.next())
					{
						myarr[i]=rs10.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					index1.setCheckbox("checked");
					index1.setMysize(i);
				}*/
				else if(rs.getString(2).equals("Commercial Terms And Conditions"))
				{
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Commercial Terms And Conditions' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst11=conn.prepareStatement("SELECT `quotation_name` FROM `terms_conditions_config_master`");
					ResultSet rs11=pst11.executeQuery();
					int i=0;
					while(rs11.next())
					{
						myarr[i]=rs11.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Product Wise Production Cost"))
				{
					System.out.println("quotation_product_wise:"+rs.getString(2));
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Product Wise Production Cost' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst12=conn.prepareStatement("SELECT `quotation_name` FROM `product_wise_prod_cost_config_master`");
					ResultSet rs12=pst12.executeQuery();
					int i=0;
					while(rs12.next())
					{
						System.out.println("quotation_name_pdwp:"+rs12.getString(1));
						myarr[i]=rs12.getString(1);
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
				}
				
				else if(rs.getString(2).equals("Manufacturing Process Flow Chart"))
				{
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Manufacturing Process Flow Chart' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst13=conn.prepareStatement("SELECT `quotation_name` FROM `flow_chart_config`");
					ResultSet rs13=pst13.executeQuery();
					int i=0;
					while(rs13.next())
					{
						myarr[i]=rs13.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				
				index1.setMyarrays(myarr);
				index1.setSelect_quot(select_quot);
				
				qlist.add(index1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qlist;
		
	}

	
	public List<QuotationIndexModel> fetchQ2(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		PreparedStatement pst1;
		int quotation_id=0;
		try {
			pst1 = conn.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				int id=rs1.getInt(1);
				quotation_id=id+1;
				System.out.println("quottaion_id:"+quotation_id);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int quot_id=quotation_id;
		
		String mycheckbox="checked";
		
		List<QuotationIndexModel> qlist=new ArrayList<>();
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `index_id`, `sub_name_of_index`  FROM `quotation_index_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel index1=new QuotationIndexModel();
				
				String myarr[]=new String[1000];
				
				String setquotation[]=new String[1000];
				
				index1.setIndex_id(rs.getInt(1));
				
				index1.setSubindex(rs.getString(2));
				
				String select_quot[]=new String[1000]; 
				

				if(rs.getString(2).equals("RO WATER TREATMENT PLANT"))
				{
					String sel_quot="";
					PreparedStatement pst2=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='RO WATER TREATMENT PLANT' AND quotation_id="+quot_id+"");
					ResultSet rs2=pst2.executeQuery();
					if(rs2.next())
					{
						sel_quot=rs2.getString(1);
						
					}
					
					System.out.println("select_quot:"+select_quot);
					
					PreparedStatement pst11=conn.prepareStatement("SELECT `quotation_name` FROM `ro_config_master`");
					ResultSet rs11=pst11.executeQuery();
					
					int i=0;
					while(rs11.next())
					{
						myarr[i]=rs11.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					System.out.println("select_quot in if:"+select_quot[i]);
					
					
					/*if(myarr[i].equals(select_quot))
					{
						index1.setSelect_quot("selected");
					}else
					{
						index1.setSelect_quot("");
					}*/
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					
					index1.setMysize(i);
				} 
				
				else if(rs.getString(2).equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))
				{
					
					String sel_quot="";
					PreparedStatement pst3=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='FULLY AUTO RINSSING, FILLING AND CAPING MACHINE' AND quotation_id="+quot_id+"");
					ResultSet rs3=pst3.executeQuery();
					if(rs3.next())
					{
						sel_quot=rs3.getString(1);
						
					}
					
					PreparedStatement pst2=conn.prepareStatement("SELECT `quotation_name` FROM `fab_rfc_master`");
					ResultSet rs21=pst2.executeQuery();
					
					int i=0;
					while(rs21.next())
					{
						myarr[i]=rs21.getString(1);
						
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Fully Auto Bottle Labelling Machine"))
				{
					
					String sel_quot="";
					PreparedStatement pst4=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Fully Auto Bottle Labelling Machine' AND quotation_id="+quot_id+"");
					ResultSet rs4=pst4.executeQuery();
					if(rs4.next())
					{
						sel_quot=rs4.getString(1);
						
					}
					
					PreparedStatement pst3=conn.prepareStatement("SELECT `quotation_name` FROM `fab_labeling_mc_config_001`");
					ResultSet rs3=pst3.executeQuery();
					
					int i=0;
					while(rs3.next())
					{
						myarr[i]=rs3.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Hot Fill Fully Auto Blow Molding Machine"))
				{
					
					String sel_quot="";
					PreparedStatement pst5=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Hot Fill Fully Auto Blow Molding Machine' AND quotation_id="+quot_id+"");
					ResultSet rs5=pst5.executeQuery();
					if(rs5.next())
					{
						sel_quot=rs5.getString(1);
						
					}
					
					PreparedStatement pst4=conn.prepareStatement("SELECT `quotation_name` FROM `hotfabmold_config_master`");
					ResultSet rs4=pst4.executeQuery();
					int i=0;
					while(rs4.next())
					{
						myarr[i]=rs4.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("High Pressure Compressor"))
				{
					
					String sel_quot="";
					PreparedStatement pst6=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='High Pressure Compressor' AND quotation_id="+quot_id+"");
					ResultSet rs6=pst6.executeQuery();
					if(rs6.next())
					{
						sel_quot=rs6.getString(1);
						
					}
					
					PreparedStatement pst5=conn.prepareStatement("SELECT `quotation_name` FROM `hpc_config_master`");
					ResultSet rs5=pst5.executeQuery();
					int i=0;
					while(rs5.next())
					{
						myarr[i]=rs5.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				
				else if(rs.getString(2).equals("Low Pressure Compressor"))
				{
					
					String sel_quot="";
					PreparedStatement pst7=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Low Pressure Compressor' AND quotation_id="+quot_id+"");
					ResultSet rs7=pst7.executeQuery();
					if(rs7.next())
					{
						sel_quot=rs7.getString(1);
					}
					
					PreparedStatement pst6=conn.prepareStatement("SELECT `quotation_name` FROM `lpc_config_master`");
					ResultSet rs6=pst6.executeQuery();
					int i=0;
					while(rs6.next())
					{
						myarr[i]=rs6.getString(1);
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("SHRINK MACHINE"))
				{
					
					String sel_quot="";
					PreparedStatement pst8=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='SHRINK MACHINE' AND quotation_id="+quot_id+"");
					ResultSet rs8=pst8.executeQuery();
					if(rs8.next())
					{
						sel_quot=rs8.getString(1);
					}
					
					PreparedStatement pst7=conn.prepareStatement("SELECT `quotation_name` FROM `shrink_machine_config_master`");
					ResultSet rs7=pst7.executeQuery();
					int i=0;
					while(rs7.next())
					{
						myarr[i]=rs7.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Autocase Packer"))
				{
					String sel_quot="";
					PreparedStatement pst9=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Autocase Packer' AND quotation_id="+quot_id+"");
					ResultSet rs9=pst9.executeQuery();
					if(rs9.next())
					{
						sel_quot=rs9.getString(1);
					}
					
					PreparedStatement pst8=conn.prepareStatement("SELECT `quotation_name` FROM `autocase_packer_config_master`");
					ResultSet rs8=pst8.executeQuery();
					int i=0;
					while(rs8.next())
					{
						myarr[i]=rs8.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Laboratories : Chemical & Microbiology"))
				{
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Laboratories : Chemical & Microbiology' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst9=conn.prepareStatement("SELECT `quotation_name` FROM `lab_chem_micro_config_master`");
					ResultSet rs9=pst9.executeQuery();
					int i=0;
					while(rs9.next())
					{
						myarr[i]=rs9.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
						
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				/*else if(rs.getString(2).equals("Investment And Expences For Project As Per Bis"))
				{
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Investment And Expences For Project As Per Bis' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst10=conn.prepareStatement("SELECT `quotation_name` FROM `investmt_exp_config_master`");
					ResultSet rs10=pst10.executeQuery();
					int i=0;
					while(rs10.next())
					{
						myarr[i]=rs10.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					index1.setCheckbox("checked");
					index1.setMysize(i);
				}*/
				else if(rs.getString(2).equals("Commercial Terms And Conditions"))
				{
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Commercial Terms And Conditions' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst11=conn.prepareStatement("SELECT `quotation_name` FROM `terms_conditions_config_master`");
					ResultSet rs11=pst11.executeQuery();
					int i=0;
					while(rs11.next())
					{
						myarr[i]=rs11.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					
					index1.setMysize(i);
				}
				else if(rs.getString(2).equals("Product Wise Production Cost"))
				{
					System.out.println("quotation_product_wise:"+rs.getString(2));
					
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Product Wise Production Cost' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst12=conn.prepareStatement("SELECT `quotation_name` FROM `product_wise_prod_cost_config_master`");
					ResultSet rs12=pst12.executeQuery();
					int i=0;
					while(rs12.next())
					{
						System.out.println("quotation_name_pdwp:"+rs12.getString(1));
						myarr[i]=rs12.getString(1);
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
				}
				
				else if(rs.getString(2).equals("Manufacturing Process Flow Chart"))
				{
					String sel_quot="";
					PreparedStatement pstmt=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE name_of_index='Manufacturing Process Flow Chart' AND quotation_id="+quot_id+"");
					ResultSet res=pstmt.executeQuery();
					if(res.next())
					{
						sel_quot=res.getString(1);
					}
					
					PreparedStatement pst13=conn.prepareStatement("SELECT `quotation_name` FROM `flow_chart_config`");
					ResultSet rs13=pst13.executeQuery();
					int i=0;
					while(rs13.next())
					{
						myarr[i]=rs13.getString(1);
						
						if(myarr[i].equals(sel_quot))
						{
							select_quot[i]="selected";
						}else
						{
							select_quot[i]="";
						}
						
						i++;
					}
					if(sel_quot.isEmpty())
					{
						index1.setCheckbox("");
					}else
					{
						index1.setCheckbox("checked");
					}
					index1.setMysize(i);
				}
				
				index1.setMyarrays(myarr);
				index1.setSelect_quot(select_quot);
				
				qlist.add(index1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return qlist;
		
	}
	
	public List<QuotationIndexModel> fetchFinalizationReports(QuotationIndexModel quotationIndex) {
		// TODO Auto-generated method stub
		
		List<QuotationIndexModel> list=new ArrayList<>();
		try {
				PreparedStatement pst=conn.prepareStatement("SELECT lead_deatils.customer_name,finalized_quotation_master.lead_no,finalized_quotation_master.quotation_id,finalized_quotation_master.finalized_amount,finalized_quotation_master.token_amount FROM lead_deatils,finalized_quotation_master WHERE finalized_quotation_master.finalized_status=1");
				ResultSet rs=pst.executeQuery();
				while(rs.next())
				{
					QuotationIndexModel finalization=new QuotationIndexModel();
					
					finalization.setCustomer_name(rs.getString(1));
					finalization.setLead_no(rs.getString(2));
					finalization.setId(rs.getInt(3));
					finalization.setFinalized_amount(rs.getString(4));
					finalization.setToken_amount(rs.getString(5));
					list.add(finalization);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
	}

	/*public List<QuotationIndexModel> fetchQuotationIndex2(QuotationIndexModel quotationIndex,String fetquotationIndex) {
		
		List<QuotationIndexModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `select_quotation` FROM `edit_quotation_index` WHERE quotation_id="++"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel quotationindexmodal=new QuotationIndexModel();
				quotationindexmodal.setIndex_id(rs.getInt(1));
				quotationindexmodal.setSelect_quoatation_name(rs.getString(2));
				list.add(quotationindexmodal);
				
				System.out.println("select_quotation:"+quotationindexmodal.getSelect_quoatation_name());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}*/

}

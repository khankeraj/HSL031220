package com.quotation.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.quotation.model.ROWaterTPModel;


public class ROWaterTPDAO extends HttpServlet {
	
	DBConnection connection=new DBConnection();
	
	public int insert_ro_water_tp(ROWaterTPModel rowater) throws IOException {
		
		System.out.println("in dao");
		
		String quotationName = null;
		
		int i=0;
		int max_ro_id = 0;
		try {
				Connection conn=connection.getConnection();
				
				PreparedStatement pst=conn.prepareStatement("INSERT INTO `ro_config_master`(`name_of_index`, `subname_of_index`, `select_image`, `subheading1`, `subheading2`, `summary`, `name_of_index1`, `quotation_name`) VALUES (?,?,?,?,?,?,?,?)");
				pst.setString(1, rowater.getName_of_index());
				pst.setString(2, rowater.getSub_name_of_index());
				pst.setString(3, rowater.getSelect_image());
				pst.setString(4, rowater.getSubHeading1());
				pst.setString(5, rowater.getSubHeading2());
				pst.setString(6, rowater.getSummary());
				pst.setString(7, rowater.getName_of_index1());
				pst.setString(8, rowater.getQuotation_name());
				i=pst.executeUpdate();
				if(i>0)
				{
					System.out.println(" Master inserted Successfully...!!!");
					
					PreparedStatement pst1=conn.prepareStatement("SELECT MAX(ro_id) FROM ro_config_master ");
					ResultSet rs=pst1.executeQuery();
					if(rs.next())
					{
						max_ro_id=Integer.parseInt(rs.getString(1));
					
						System.out.println("Max Count From Master :"+max_ro_id);
					}
						
						for(int j=0;j<rowater.getSpecification().length;j++)
						{
							PreparedStatement pst11=conn.prepareStatement("INSERT INTO `ro_config_001`(`spefication`, `quantity`, `ro_id`) VALUES (?,?,?)");
							
							System.out.println("pst11:"+pst11);
							
							pst11.setString(1, rowater.getSpecification()[j]);
							pst11.setString(2, rowater.getQuantity()[j]);
							pst11.setInt(3, max_ro_id);
							i=pst11.executeUpdate();
							if(i>0)
							{
								System.out.println("inserted part1");
							}
						}
						
						for(int k=0;k<rowater.getSpecification1().length;k++)
						{
							PreparedStatement pst111=conn.prepareStatement("INSERT INTO `ro_config_002`(`specification`, `quantity`, `ro_id`) VALUES (?,?,?)");
							pst111.setString(1, rowater.getSpecification1()[k]);
							pst111.setString(2, rowater.getQuantity1()[k]);
							pst111.setInt(3, max_ro_id);
							i=pst111.executeUpdate();
							if(i>0)
							{
								System.out.println("inserted part2");
							}
						}
						
						for(int m=0;m<rowater.getSpecification2().length;m++)
						{
							PreparedStatement pmst=conn.prepareStatement("INSERT INTO `ro_config_003`(`specifications3`, `quantity3`, `ro_id`) VALUES (?,?,?)");
							pmst.setString(1, rowater.getSpecification2()[m]);
							pmst.setString(2, rowater.getQuantity2()[m]);
							pmst.setInt(3, max_ro_id);
							i=pmst.executeUpdate();
							System.out.println("inserted part3");
						}
						
						for(int n=0;n<rowater.getSpecification3().length;n++)
						{
							PreparedStatement pmst1=conn.prepareStatement("INSERT INTO `ro_config_004`(`specifications4`, `quantity4`, `ro_id`) VALUES (?,?,?)");
							pmst1.setString(1, rowater.getSpecification3()[n]);
							pmst1.setString(2, rowater.getQuantity3()[n]);
							pmst1.setInt(3, max_ro_id);
							i=pmst1.executeUpdate();
							System.out.println("inserted part4");
						}
						
						for(int l=0;l<rowater.getFlag().length;l++)
						{
							int max_count=0;
							String flag1=rowater.getFlag()[l];
							String ro_qty=rowater.getRo_techQuanty()[l];
							
							System.out.println("flag1:"+flag1);
							
							if(flag1.equals("1") && ro_qty.isEmpty())
							{
								String heading=rowater.getRo_techSPefic()[l];
								
								PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `ro_config_005_heading`(`heading_nme`,`ro_id`) VALUES (?,?)");
								pst1111.setString(1, heading);
								pst1111.setInt(2, max_ro_id);
								pst1111.executeUpdate();
							}
							
							PreparedStatement pmst=conn.prepareStatement("SELECT MAX(heading_id) FROM ro_config_005_heading ");
							ResultSet rs1=pmst.executeQuery();
							if(rs1.next())
							{
								max_count=rs1.getInt(1);
							}
							
							if(flag1.equals("0") && ro_qty!=null)
							{
								PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `ro_config_005`(`rosp_specification`, `rosp_quantity`, `heading_id`) VALUES (?,?,?)");
								
								pst1111.setString(1,rowater.getRo_techSPefic()[l]);
								pst1111.setString(2, rowater.getRo_techQuanty()[l]);
								pst1111.setInt(3, max_count);
								pst1111.executeUpdate();
								
								System.out.println("inserted part5");
							}
							
						}
				}
			/*}
				}*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
		return i;
	}

	public List<ROWaterTPModel> fetchROConfiguration(ROWaterTPModel rowater) {
		// TODO Auto-generated method stub
		
		List<ROWaterTPModel> list=new ArrayList<>();
		
		try {
			Connection conn1=connection.getConnection();
			
			PreparedStatement pmst=conn1.prepareStatement("SELECT `ro_id`, `name_of_index`, `subname_of_index`, `select_image`, `subheading1`, `subheading2`, `summary`, `name_of_index1` FROM `ro_master`");
			System.out.println("pst 11:"+pmst);
			ResultSet rs=pmst.executeQuery();
			if(rs.next())
			{
				ROWaterTPModel rowater1=new ROWaterTPModel();
				
				rowater1.setRo_id(rs.getInt(1));
				rowater1.setName_of_index(rs.getString(2));
				rowater1.setSub_name_of_index(rs.getString(3));
				rowater1.setSelect_image(rs.getString(4));
				rowater1.setSubHeading1(rs.getString(5));
				rowater1.setSubHeading2(rs.getString(6));
				rowater1.setSummary(rs.getString(7));
				rowater1.setName_of_index1(rs.getString(8));
				HttpServletRequest request = ServletActionContext.getRequest();
				
				request.setAttribute("select_image", rs.getString(4));
				
				System.out.println("name_of_index:"+rs.getString(2)+"image:"+rs.getString(4));
				list.add(rowater1);	
				
				/*PreparedStatement pst=conn1.prepareStatement("SELECT `spefication`, `quantity` FROM `ro_specifications_part1`");
				ResultSet rs1=pst.executeQuery();
				
				while(rs1.next())
				{
					ROWaterTPModel rowater11=new ROWaterTPModel();
					
					rowater11.setSpecifi(rs1.getString(1));
					rowater11.setQty(rs1.getString(2));
					
					System.out.println("specifi:"+rs1.getString(1));
					System.out.println("qty:"+rs1.getString(2));
					
					list.add(rowater11);
				}*/
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ROWaterTPModel> fetchROConfiguration1(ROWaterTPModel rowater) {
		
		List<ROWaterTPModel> list1=new ArrayList<>();
		
		Connection conn2=connection.getConnection();
		
		try {
			
			PreparedStatement pst = conn2.prepareStatement("SELECT `spefication`, `quantity` FROM `ro_specifications_part1`");
			
			ResultSet rs1=pst.executeQuery();
			
			while(rs1.next())
			{
				ROWaterTPModel rowater11=new ROWaterTPModel();
				
				rowater11.setSpecifi(rs1.getString(1));
				rowater11.setQty(rs1.getString(2));

				list1.add(rowater11);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list1;
	}

	public List<ROWaterTPModel> fetchROConfiguration2(ROWaterTPModel rowater) {
		
		List<ROWaterTPModel> list2=new ArrayList<>();
		
		Connection conn3=connection.getConnection();
		
		try {
			
			PreparedStatement pst1 = conn3.prepareStatement("SELECT  `specification`, `quantity` FROM `ro_specifications_part2` ");
			
			ResultSet rs11=pst1.executeQuery();
			
			while(rs11.next())
			{
				ROWaterTPModel rowater111=new ROWaterTPModel();
				
				rowater111.setSpecifi1(rs11.getString(1));
				rowater111.setQty1(rs11.getString(2));

				list2.add(rowater111);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list2;
	}

	public List<ROWaterTPModel> fetchROConfiguration3(ROWaterTPModel rowater) {
		
		List<ROWaterTPModel> list3=new ArrayList<>();
		
		Connection conn4=connection.getConnection();
		
		try {
			
			PreparedStatement prep = conn4.prepareStatement("SELECT `specifications3`, `quantity3` FROM `ro_specifications_part3`");
			
			ResultSet result=prep.executeQuery();
			
			while(result.next())
			{
				ROWaterTPModel row=new ROWaterTPModel();
				
				row.setSpecifi2(result.getString(1));
				row.setQty2(result.getString(2));
				
				list3.add(row);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list3;
	}

	public List<ROWaterTPModel> fetchROConfiguration4(ROWaterTPModel rowater) {
		
		List<ROWaterTPModel> list4=new ArrayList<>();
		
		Connection conn5=connection.getConnection();
		
		try {
			
			PreparedStatement prep1 = conn5.prepareStatement("SELECT `specifications4`, `quantity4` FROM `ro_specifications_part4`");
			
			ResultSet result1=prep1.executeQuery();
			
			while(result1.next())
			{
				ROWaterTPModel row1=new ROWaterTPModel();
				
				row1.setSpecifi3(result1.getString(1));
				row1.setQty3(result1.getString(2));
				
				list4.add(row1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list4;
}

	public List<ROWaterTPModel> fetchROConfiguration5(ROWaterTPModel rowater) {
		
		List<ROWaterTPModel> list5=new ArrayList<>();
		
		Connection conn6=connection.getConnection();
		
		try {
			
			PreparedStatement prep2 = conn6.prepareStatement("SELECT DISTINCT heading FROM ro_tech_sp_details");
			
			ResultSet result2=prep2.executeQuery();
			
			while(result2.next())
			{
				String flag="1";
				ROWaterTPModel row1=new ROWaterTPModel();//first bean object1
				row1.setStatus(flag);
				row1.setHeading(result2.getString("heading"));
				list5.add(row1);
				
				PreparedStatement prep3 = conn6.prepareStatement("SELECT `rosp_specification`, `rosp_quantity` FROM `ro_tech_sp_details` WHERE heading='"+result2.getString(1)+"'");
				
				ResultSet rs=prep3.executeQuery();
				while(rs.next())
				{
					    ROWaterTPModel row=new ROWaterTPModel();//second bean object2
					    String flag1="0";
					    row.setStatus(flag1);
					    row.setHeading(rs.getString("rosp_specification"));
						row.setValue(rs.getString("rosp_quantity"));
						
						list5.add(row);
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list5;
	}

	public String checkQuotationName(ROWaterTPModel rowater,String quotation_name) {
		// TODO Auto-generated method stub
		
		String response="";
		
		Connection connect=connection.getConnection();
		try {
			
			PreparedStatement pstmt=connect.prepareStatement("SELECT quotation_name FROM ro_config_master WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
					if(rs.getString("quotation_name").equals(quotation_name))
						{
							response="Name Of Quotation Already Exits!";
						}else
						{
							System.out.println("conniee...");
						}
						
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}

	public int updateROWaterTP(ROWaterTPModel rowater,String ro_id) {
		// TODO Auto-generated method stub
		
		int i = 0;
		int max_ro_id=0;
		
		int roId=Integer.parseInt(ro_id);
		Connection conn=connection.getConnection();
		try {
			PreparedStatement pst=conn.prepareStatement("UPDATE `ro_config_master` SET `name_of_index`=?,`subname_of_index`=?,`select_image`=?,`subheading1`=?,`subheading2`=?,`summary`=?,`name_of_index1`=?,`quotation_name`=? WHERE `ro_id`=?");
			pst.setString(1, rowater.getName_of_index());
			pst.setString(2, rowater.getSub_name_of_index());
			pst.setString(3, rowater.getSelect_image());
			pst.setString(4, rowater.getSubHeading1());
			pst.setString(5, rowater.getSubHeading2());
			pst.setString(6, rowater.getSummary());
			pst.setString(7, rowater.getName_of_index1());
			pst.setString(8, rowater.getQuotation_name());
			pst.setInt(9, roId);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		try{
			
			PreparedStatement pstmt1=conn.prepareStatement("DELETE FROM `ro_config_001` WHERE ro_id="+roId+"");
			i=pstmt1.executeUpdate();
			
				for(int j=0;j<rowater.getSpecification().length;j++)
				{
					PreparedStatement pst11=conn.prepareStatement("INSERT INTO `ro_config_001`(`spefication`, `quantity`, `ro_id`) VALUES (?,?,?)");
					
					System.out.println("pst11:"+pst11);
					
					pst11.setString(1, rowater.getSpecification()[j]);
					pst11.setString(2, rowater.getQuantity()[j]);
					pst11.setInt(3, roId);
					i=pst11.executeUpdate();
					if(i>0)
					{
						System.out.println("inserted part1");
					}
				}
				
				PreparedStatement pstmt2=conn.prepareStatement("DELETE FROM `ro_config_002` WHERE ro_id=?");
				pstmt2.setInt(1, roId);
				i=pstmt2.executeUpdate();
				
				for(int k=0;k<rowater.getSpecification1().length;k++)
				{
					PreparedStatement pst111=conn.prepareStatement("INSERT INTO `ro_config_002`(`specification`, `quantity`, `ro_id`) VALUES (?,?,?)");
					pst111.setString(1, rowater.getSpecification1()[k]);
					pst111.setString(2, rowater.getQuantity1()[k]);
					pst111.setInt(3, roId);
					i=pst111.executeUpdate();
					if(i>0)
					{
						System.out.println("inserted part2");
					}
				}
				
				PreparedStatement pstmt3=conn.prepareStatement("DELETE FROM `ro_config_003` WHERE ro_id=?");
				pstmt3.setInt(1, roId);
				i=pstmt3.executeUpdate();
				
				for(int m=0;m<rowater.getSpecification2().length;m++)
				{
					PreparedStatement pmst=conn.prepareStatement("INSERT INTO `ro_config_003`(`specifications3`, `quantity3`, `ro_id`) VALUES (?,?,?)");
					pmst.setString(1, rowater.getSpecification2()[m]);
					pmst.setString(2, rowater.getQuantity2()[m]);
					pmst.setInt(3, roId);
					i=pmst.executeUpdate();
					System.out.println("inserted part3");
				}
				
				PreparedStatement pstmt4=conn.prepareStatement("DELETE FROM `ro_config_004` WHERE ro_id=?");
				pstmt4.setInt(1, roId);
				i=pstmt4.executeUpdate();
				
				for(int n=0;n<rowater.getSpecification3().length;n++)
				{
					PreparedStatement pmst1=conn.prepareStatement("INSERT INTO `ro_config_004`(`specifications4`, `quantity4`, `ro_id`) VALUES (?,?,?)");
					pmst1.setString(1, rowater.getSpecification3()[n]);
					pmst1.setString(2, rowater.getQuantity3()[n]);
					pmst1.setInt(3, roId);
					i=pmst1.executeUpdate();
					System.out.println("inserted part4");
				}
				
				PreparedStatement pstmt6=conn.prepareStatement("DELETE ro_config_005_heading,ro_config_005 FROM ro_config_005_heading INNER JOIN ro_config_005 ON ro_config_005.heading_id=ro_config_005_heading.heading_id WHERE ro_config_005_heading.ro_id="+roId+"");
				i=pstmt6.executeUpdate();
				
				for(int l=0;l<rowater.getFlag().length;l++)
				{
					int max_count=0;
					String flag1=rowater.getFlag()[l];
					String ro_qty=rowater.getRo_techQuanty()[l];
					
					System.out.println("flag1:"+flag1);
					
					if(flag1.equals("1") && ro_qty.isEmpty())
					{
						String heading=rowater.getRo_techSPefic()[l];
						
						PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `ro_config_005_heading`(`heading_nme`,`ro_id`) VALUES (?,?)");
						pst1111.setString(1, heading);
						pst1111.setInt(2, roId);
						pst1111.executeUpdate();
					}
					
					PreparedStatement pmst=conn.prepareStatement("SELECT MAX(heading_id) FROM ro_config_005_heading ");
					ResultSet rs1=pmst.executeQuery();
					if(rs1.next())
					{
						max_count=rs1.getInt(1);
					}
					
					if(flag1.equals("0") && ro_qty!=null)
					{
						PreparedStatement pst1111=conn.prepareStatement("INSERT INTO `ro_config_005`(`rosp_specification`, `rosp_quantity`, `heading_id`) VALUES (?,?,?)");
						
						pst1111.setString(1,rowater.getRo_techSPefic()[l]);
						pst1111.setString(2, rowater.getRo_techQuanty()[l]);
						pst1111.setInt(3, max_count);
						pst1111.executeUpdate();
						
						System.out.println("inserted part5");
					}
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			return i;
		}
	
		public int deleteRoWatertp(ROWaterTPModel rowater, String ro_id) {
		
		int roId=Integer.parseInt(ro_id);
		System.out.println("delete_id:"+roId);
		
		int i = 0;
	
		DBConnection connection=new DBConnection();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `ro_config_master` WHERE ro_id=?");
			pst.setInt(1, roId);
			i=pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			PreparedStatement pst1=conn.prepareStatement("DELETE FROM `ro_config_001` WHERE ro_id=?");
			pst1.setInt(1, roId);
			i=pst1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst3=conn.prepareStatement("DELETE FROM `ro_config_003` WHERE ro_id=?");
			pst3.setInt(1, roId);
			i=pst3.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst4=conn.prepareStatement("DELETE FROM `ro_config_004` WHERE ro_id=?");
			pst4.setInt(1, roId);
			i=pst4.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try {
			PreparedStatement pst6=conn.prepareStatement("DELETE ro_config_005_heading,ro_config_005 FROM ro_config_005_heading INNER JOIN ro_config_005 ON ro_config_005.heading_id=ro_config_005_heading.heading_id WHERE ro_config_005_heading.ro_id="+roId+"");
			i=pst6.executeUpdate();
			System.out.println("pst:"+pst6);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
}


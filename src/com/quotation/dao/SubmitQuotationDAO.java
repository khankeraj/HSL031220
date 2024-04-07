package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.master.model.ContractModel;
import com.quotation.model.AutocasePackerModel;
import com.quotation.model.FABLabellingMachineModel;
import com.quotation.model.FABRFCModel;
import com.quotation.model.FlowChartModel;
import com.quotation.model.HighPressureCompressorModel;
import com.quotation.model.HotFABMoldingMachineModel;
import com.quotation.model.InvestmentAndExpencesModel;
import com.quotation.model.LabChemMicroBioModel;
import com.quotation.model.LowPressureCompressorModel;
import com.quotation.model.ProductWiseProductionCostModel;
import com.quotation.model.QuotationIndexModel;
import com.quotation.model.ROWaterTPModel;
import com.quotation.model.ShrinkMachineModel;
import com.quotation.model.TermsAndConditionsModel;

public class SubmitQuotationDAO {
	
	DBConnection conn=new DBConnection();
	Connection connection=conn.getConnection();
	
	public List<ContractModel> fetchCoverDetails(ContractModel contractmodel,int quot_id) {
		// TODO Auto-generated method stub
		List<ContractModel> list=new ArrayList<>();
		
		try {
			/*int contractor_id=0;
			PreparedStatement pst2=connection.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst2.executeQuery();
			if(rs1.next())
			{
				contractor_id=rs1.getInt(1);
			}*/
			
			PreparedStatement pst=connection.prepareStatement("SELECT `to`,`state`, `city`, `address` FROM `customer_master` WHERE quotation_id=?");
			pst.setInt(1, quot_id);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ContractModel contrctmodel=new ContractModel();
				contrctmodel.setTo(rs.getString(1));
				contrctmodel.setState(rs.getString(2));
				contractmodel.setCity(rs.getString(3));
				contrctmodel.setAddress(rs.getString(4));
				list.add(contrctmodel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ContractModel> getContractDetails(ContractModel contractmodel,int quot_id) {
		// TODO Auto-generated method stub
		
		List<ContractModel> list=new ArrayList<>();
		
		PreparedStatement pst;
		try {
			
			/*int contractor_id=0;
			PreparedStatement pst2=connection.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst2.executeQuery();
			if(rs1.next())
			{
				contractor_id=rs1.getInt(1);
			}*/
			
			pst = connection.prepareStatement("SELECT `ref_no`, `date`, `to`, `name1`, `name2`, `address`, `city`, `state`, `pincode`, `contact`, `email`, `subject`, `pro_co_ordi_name`, `pro_co_ordi_contact_no` FROM `customer_master` WHERE quotation_id=?");
			pst.setInt(1, quot_id);
			ResultSet rs=pst.executeQuery();
			System.out.println("pst in contract:"+pst);
			while(rs.next())
			{
				ContractModel contractmodel1=new ContractModel();
				
				contractmodel1.setRef_no(rs.getString(1));
				contractmodel1.setRequiredDate(rs.getString(2));
				contractmodel1.setTo(rs.getString(3));
				contractmodel1.setName1(rs.getString(4));
				contractmodel1.setName2(rs.getString(5));
				contractmodel1.setAddress(rs.getString(6));
				contractmodel1.setCity(rs.getString(7));
				contractmodel1.setState(rs.getString(8));
				contractmodel1.setPincode(rs.getString(9));
				contractmodel1.setContact(rs.getString(10));
				contractmodel1.setEmail(rs.getString(11));
				contractmodel1.setSubject(rs.getString(12));
				contractmodel1.setProCoOrdiName(rs.getString(13));
				contractmodel1.setProCoOrdiContactNo(rs.getString(14));
				
				list.add(contractmodel1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public List<QuotationIndexModel> fetchQuotationIndexList(QuotationIndexModel quotationmodel, String quotation_name) {
		// TODO Auto-generated method stub
		List<QuotationIndexModel> list=new ArrayList<>();
		try {
			
			PreparedStatement pst=connection.prepareStatement("SELECT `index_id`,`name_of_index` FROM `quotation_index_config_001` WHERE quotation_name='6000LPH'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				QuotationIndexModel quotationmodel1=new QuotationIndexModel();
				
				quotationmodel1.setIndex_id(rs.getInt(1));
				quotationmodel1.setName_of_index(rs.getString(2));
				list.add(quotationmodel1);
			
				PreparedStatement pst1=connection.prepareStatement("SELECT `sub_name_of_index` FROM `quotation_ndex_details_config_002` WHERE name_of_index_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					QuotationIndexModel quotationIndexmodel2=new QuotationIndexModel();
					quotationIndexmodel2.setSubindex(rs1.getString(1));
					list.add(quotationIndexmodel2);
				}
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<ROWaterTPModel> fetchROMaster(ROWaterTPModel rowater, String quotation_name) {
		// TODO Auto-generated method stub
		List<ROWaterTPModel> list=new ArrayList<>();
		
		System.out.println("quotation name in dao:"+quotation_name);
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `ro_id`, `name_of_index`, `subname_of_index`, `select_image`, `subheading1`, `subheading2`, `summary`, `name_of_index1` FROM `ro_config_master` WHERE quotation_name=?");
			pst.setString(1, quotation_name);
			ResultSet rs=pst.executeQuery();
			System.out.println(pst);
			while(rs.next())
			{
				if(!rs.getString(2).equals("") && !rs.getString(8).equals("")) {
				ROWaterTPModel rowater1=new ROWaterTPModel();
				rowater1.setRo_id(rs.getInt(1));
				rowater1.setName_of_index(rs.getString(2));
				rowater1.setSub_name_of_index(rs.getString(3));
				rowater1.setSelect_image(rs.getString(4));
				System.out.println("select_image:"+rs.getString(4));
				String treadtedwaterquality=rs.getString(5)+"<br>";
				rowater1.setSubHeading1(treadtedwaterquality);
				String subheadings[]=rs.getString(6).split("@");
				String subheadingAfterSplit=subheadings[0]+"<br>"+subheadings[1]+"<br>"+subheadings[2]+"<br>";
				rowater1.setSubHeading2(subheadingAfterSplit);
				String summary[]=rs.getString(7).split("@");
				String summary1=summary[0]+"<br>"+summary[1]+"<br>"+summary[2]+"<br>";
				rowater1.setSummary(summary1);
				rowater1.setName_of_index1(rs.getString(8));
				list.add(rowater1);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `spefication`, `quantity` FROM `ro_config_001` WHERE ro_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					if(!rs1.getString(1).equals("")) {
					ROWaterTPModel rowaterparts1=new ROWaterTPModel();
					
					rowaterparts1.setSpecifi(rs1.getString(1));
					rowaterparts1.setQty(rs1.getString(2));
					list.add(rowaterparts1);
					}
				}
				
				PreparedStatement  pst2=connection.prepareStatement("SELECT `specification`, `quantity` FROM `ro_config_002` WHERE ro_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					if(!rs2.getString(1).equals("")) {
					ROWaterTPModel rowaterparts2=new ROWaterTPModel();
					rowaterparts2.setSpecifi1(rs2.getString(1).trim());
					rowaterparts2.setQty1(rs2.getString(2));
					list.add(rowaterparts2);
					System.out.println(">>>>>>>>>>>>>>>>>>>>>..");
					}
				}
				
				PreparedStatement pst3=connection.prepareStatement("SELECT `specifications3`, `quantity3` FROM `ro_config_003` WHERE ro_id="+rs.getInt(1)+"");
				ResultSet rs3=pst3.executeQuery();
				while(rs3.next())
				{
					if(!rs3.getString(1).equals("")) {
					ROWaterTPModel rowaterParts3=new ROWaterTPModel();
					rowaterParts3.setSpecifi2(rs3.getString(1));
					rowaterParts3.setQty2(rs3.getString(2));
					list.add(rowaterParts3);
					}
					
					
				}
				
				PreparedStatement pst4=connection.prepareStatement("SELECT `specifications4`, `quantity4` FROM `ro_config_004` WHERE ro_id="+rs.getInt(1)+"");
				ResultSet rs4=pst4.executeQuery();
				while(rs4.next())
				{
					if(!rs4.getString(1).equals("")) {
					ROWaterTPModel rowaterParts4=new ROWaterTPModel();
					rowaterParts4.setSpecifi3(rs4.getString(1));
					rowaterParts4.setQty3(rs4.getString(2));
					list.add(rowaterParts4);
					}
					
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<ROWaterTPModel> fetchTechnicalSpecifications(List<ROWaterTPModel> romaster, String quotation_name) {
		// TODO Auto-generated method stub
		
		List<ROWaterTPModel> list=new ArrayList<>();
		System.out.println("fully auto bottle rfc:"+quotation_name);
		int ro_id = 0;
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `ro_id` FROM `ro_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				ROWaterTPModel rowater=new ROWaterTPModel();
				ro_id=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			PreparedStatement prep= connection.prepareStatement("SELECT `heading_id`, `heading_nme` FROM `ro_config_005_heading` WHERE ro_id="+ro_id+"");
			ResultSet res=prep.executeQuery();
			while(res.next())
			{
				if(!res.getString(1).equals("")) {
				ROWaterTPModel rowatertp=new ROWaterTPModel();
				rowatertp.setRo_id(res.getInt(1));
				rowatertp.setRo_heading(res.getString(2));
				
				System.out.println("roheading:"+res.getString(2));
				
				PreparedStatement pstmt1=connection.prepareStatement("SELECT `rosp_specification`, `rosp_quantity` FROM `ro_config_005` WHERE heading_id="+res.getInt(1)+"");
				ResultSet resultset=pstmt1.executeQuery();
				int i=0;
				String rosp[]=new String[1000];
				String roqty[]=new String[1000];
				
				while(resultset.next())
				{
					/*ROWaterTPModel row1=new ROWaterTPModel();
					row1.setRo_sp(resultset.getString(1));
					row1.setRo_qty(resultset.getString(2));*/
					rosp[i]=resultset.getString(1);
					roqty[i]=resultset.getString(2);
					i++;
				}
				rowatertp.setSize(i);
				rowatertp.setRosp(rosp);
				rowatertp.setRoqty(roqty);
				list.add(rowatertp);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<FABRFCModel> fetchFABRFCDetails(FABRFCModel fabrfc, String quotation_name) {
		// TODO Auto-generated method stub
		List<FABRFCModel> list=new ArrayList<>();
		
		try {
			
			PreparedStatement pst=connection.prepareStatement("SELECT `fab_rins_fill_cap_maid`, `fab_rfc_name`, `fab_rfc_subname`, `select_image`, `heading1`, `heading2`, `heading3` FROM `fab_rfc_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FABRFCModel fabrfc1=new FABRFCModel();
				fabrfc1.setFabrfc_id(rs.getInt(1));
				fabrfc1.setFab_rfc_name(rs.getString(2));
				fabrfc1.setFab_rfc_subname(rs.getString(3));
				fabrfc1.setSelect_image(rs.getString(4));
				fabrfc1.setHeading1(rs.getString(5));
				fabrfc1.setHeading2(rs.getString(6));
				fabrfc1.setHeading3(rs.getString(7));
				list.add(fabrfc1);
				
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `fab_rins_fill_cap_specifications`, `fab_rins_fill_cap_quantity` FROM `fab_rfc_sp_001` WHERE fab_rins_fill_cap_master_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					FABRFCModel fabrfc2=new FABRFCModel();
					fabrfc2.setFab_rfc_sp1(rs1.getString(1));
					fabrfc2.setQty1(rs1.getString(2));
					list.add(fabrfc2);
				}
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `specifications1`, `quantity1` FROM `fab_rfc_sp_002` WHERE fab_rfc_config_master_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					FABRFCModel fabrfc3=new FABRFCModel();
					fabrfc3.setFab_rfc_sp2(rs2.getString(1));
					fabrfc3.setQty2(rs2.getString(2));
					list.add(fabrfc3);
				}
				
				PreparedStatement pst3=connection.prepareStatement("SELECT `specifications2`, `quantity2` FROM `fab_rfc_sp_003` WHERE fab_rfc_config_master_id="+rs.getInt(1)+"");
				ResultSet rs3=pst3.executeQuery();
				while(rs3.next())
				{
					FABRFCModel fabrfc4=new FABRFCModel();
					fabrfc4.setFab_rfc_sp3(rs3.getString(1));
					fabrfc4.setQty3(rs3.getString(2));
					list.add(fabrfc4);
				}
				
				PreparedStatement pst4=connection.prepareStatement("SELECT `specifications3`, `quantity3` FROM `fab_rfc_sp_004` WHERE fab_rfc_config_master_id="+rs.getInt(1)+"");
				ResultSet rs4=pst4.executeQuery();
				while(rs4.next())
				{
					FABRFCModel fabrfc5=new FABRFCModel();
					fabrfc5.setFab_rfc_sp4(rs4.getString(1));
					fabrfc5.setQty4(rs4.getString(2));
					list.add(fabrfc5);
				}
				
			  }
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<FABLabellingMachineModel> fetchFABLabelingDetails(FABLabellingMachineModel fablabelingmc,
			String quotation_name) {
		// TODO Auto-generated method stub
		List<FABLabellingMachineModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `fab_labeling_id`, `fab_name`, `fab_subname`, `select_image`, `heading` FROM `fab_labeling_mc_config_001` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			
			while(rs.next())
			{
				FABLabellingMachineModel fablabeling=new FABLabellingMachineModel();
				
				fablabeling.setFab_labeling_id(rs.getInt(1));
				fablabeling.setFab_labeling_name(rs.getString(2));
				fablabeling.setFab_labeling_subname(rs.getString(3));
				fablabeling.setSelect_image(rs.getString(4));
				fablabeling.setHeading(rs.getString(5));
				list.add(fablabeling);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `fab_spefications`, `fab_quantity` FROM `fab_lableing_mc_det_config_002` WHERE fab_labeling_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				
				while(rs1.next())
				{
					FABLabellingMachineModel fablabeling1=new FABLabellingMachineModel();
					
					fablabeling1.setSpecifi(rs1.getString(1));
					fablabeling1.setQty(rs1.getString(2));
					list.add(fablabeling1);
				}
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `features` FROM `fab_lableing_mc_feat_config_003` WHERE fab_labeling_mc_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				
				while(rs2.next())
				{
					FABLabellingMachineModel fablabeling2=new FABLabellingMachineModel();
					
					fablabeling2.setFeature(rs2.getString(1));
					list.add(fablabeling2);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<HotFABMoldingMachineModel> fetchhotfabmoldingmc(HotFABMoldingMachineModel hotfabmoldingmc1,
			String quotation_name) {
		// TODO Auto-generated method stub
		List<HotFABMoldingMachineModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `hotfabmoldingmc_id`, `name`, `iimage`, `machine_details`, `subheading1`, `techSpecifications1`, `subheading2`, `techSpecifications2`, `specificationsDetails` FROM `hotfabmold_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HotFABMoldingMachineModel hotFABMoldingMachineModel=new HotFABMoldingMachineModel();
				hotFABMoldingMachineModel.setHotfab_id(rs.getInt(1));
				hotFABMoldingMachineModel.setName(rs.getString(2));
				hotFABMoldingMachineModel.setImage(rs.getString(3));
				String mcDetails[]=rs.getString(4).split("@");
				
				String machineDetails=mcDetails[0]+"<br>"+mcDetails[1]+"<br>"+mcDetails[2]+"<br>"+mcDetails[3]+"<br>";
				
				hotFABMoldingMachineModel.setMachine_details(machineDetails);
				
				/*String subname[]=rs.getString(5).split("@");
				
				String subnme=subname[0]+"<br>"+subname[1];*/
				
				hotFABMoldingMachineModel.setSubname(rs.getString(5));
				
				/*String subname1[]=rs.getString(6).split("@");
				
				String subname11=subname1[0]+"<br>"+subname1[1];*/
				
				hotFABMoldingMachineModel.setSubname1(rs.getString(6));
				hotFABMoldingMachineModel.setSubheading1(rs.getString(7));
				hotFABMoldingMachineModel.setSubheading2(rs.getString(8));
				hotFABMoldingMachineModel.setSpecificationsDetails(rs.getString(9));
				list.add(hotFABMoldingMachineModel);
				
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `specifications` FROM `hotfabmold_config_001` WHERE fab_hotfab_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					HotFABMoldingMachineModel hotFABMoldingMachineModel1=new HotFABMoldingMachineModel();
					
					hotFABMoldingMachineModel1.setSpecification(rs1.getString(1));
					list.add(hotFABMoldingMachineModel1);
				}
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `srno`, `specifications` FROM `hotfabmold_config_002` WHERE fab_hotfab_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					HotFABMoldingMachineModel hotFABMoldingMachineModel2=new HotFABMoldingMachineModel();
					hotFABMoldingMachineModel2.setSrno1(rs2.getString(1));
					hotFABMoldingMachineModel2.setSpecification1(rs2.getString(2));
					list.add(hotFABMoldingMachineModel2);
				}
				
				PreparedStatement pst3=connection.prepareStatement("SELECT `specifications`, `quantity` FROM `hotfabmold_config_003` WHERE hotfab_id="+rs.getInt(1)+"");
				ResultSet rs3=pst3.executeQuery();
				while(rs3.next())
				{
					HotFABMoldingMachineModel hotFABMoldingMachineModel3=new HotFABMoldingMachineModel();
					hotFABMoldingMachineModel3.setSpecification2(rs3.getString(1));
					hotFABMoldingMachineModel3.setQuantity21(rs3.getString(2));
					list.add(hotFABMoldingMachineModel3);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
	}

	public List<HighPressureCompressorModel> fetchHPCDetails(HighPressureCompressorModel hpcmodel,
			String quotation_name) {
		// TODO Auto-generated method stub
		
		List<HighPressureCompressorModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `high_pressure_compressor_id`, `name_of_of_index`, `image`, `machine_details`, `subname1`, `subname2`, `techname`, `tech_details`, `heading2` FROM `hpc_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				HighPressureCompressorModel hpcmodal=new HighPressureCompressorModel();
				hpcmodal.setHighPressureComp_id(rs.getInt(1));
				hpcmodal.setName_of_index(rs.getString(2));
				hpcmodal.setImage(rs.getString(3));
				hpcmodal.setMachine_details(rs.getString(4));
				hpcmodal.setSubname1(rs.getString(5));
				hpcmodal.setSubname2(rs.getString(6));
				hpcmodal.setTechname(rs.getString(7));
				hpcmodal.setTechDetails(rs.getString(8));
				hpcmodal.setHeading1(rs.getString(9));
				list.add(hpcmodal);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `specifications`, `quantity` FROM `hpc_config_001` WHERE hpc_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					HighPressureCompressorModel hpcmodal1=new HighPressureCompressorModel();
					
					hpcmodal1.setSpecifi(rs1.getString(1));
					hpcmodal1.setQty(rs1.getString(2));
					list.add(hpcmodal1);
				}
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `specifications`, `quantity`  FROM `hpc_config_002` WHERE hpc_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					HighPressureCompressorModel hpcmodal2=new HighPressureCompressorModel();
					
					hpcmodal2.setSpecifi2(rs2.getString(1));
					hpcmodal2.setQty2(rs2.getString(2));
					list.add(hpcmodal2);
				}
				
				PreparedStatement pst3=connection.prepareStatement("SELECT `specifications4`, `quantity4` FROM `hpc_config_003` WHERE hpc_id="+rs.getInt(1)+"");
				ResultSet rs3=pst3.executeQuery();
				while(rs3.next())
				{
					HighPressureCompressorModel hpcmodal3=new HighPressureCompressorModel();
					
					hpcmodal3.setSpecifi3(rs3.getString(1));
					hpcmodal3.setQty3(rs3.getString(2));
					list.add(hpcmodal3);
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LowPressureCompressorModel> fetchlpcDetails(LowPressureCompressorModel lpcmodel,
			String quotation_name) {
		// TODO Auto-generated method stub
		List<LowPressureCompressorModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `lpc_id`, `name_of_index`, `image`, `machine_details1`, `machine_details2`, `technical_specifications`, `scope_of_supply` FROM `lpc_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LowPressureCompressorModel lpcmodal=new LowPressureCompressorModel();
				lpcmodal.setLpc_id(rs.getInt(1));
				lpcmodal.setName_of_index(rs.getString(2));
				lpcmodal.setImage(rs.getString(3));
				lpcmodal.setMachine_details1(rs.getString(4));
				lpcmodal.setMachine_details2(rs.getString(5));
				lpcmodal.setTech_specifications(rs.getString(6));
				lpcmodal.setScope_of_supply(rs.getString(7));
				list.add(lpcmodal);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `specifications`, `quantity` FROM `lpc_config_001` WHERE lpc_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					LowPressureCompressorModel lpcmodal1=new LowPressureCompressorModel();
					lpcmodal1.setSpecifi(rs1.getString(1));
					lpcmodal1.setQty(rs1.getString(2));
					list.add(lpcmodal1);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LowPressureCompressorModel> fetchLpcSpDetails(LowPressureCompressorModel lpcmodel,
			String quotation_name) {
		// TODO Auto-generated method stub
		List<LowPressureCompressorModel> list=new ArrayList<>();
		int lpc_sp_id = 0;
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `lpc_id` FROM `lpc_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				lpc_sp_id=rs.getInt(1);
			}
			
			PreparedStatement pst2=connection.prepareStatement("SELECT `lpc_sp_id`,`specifications` FROM `lpc_config_002` WHERE lpc_id="+lpc_sp_id+"");
			ResultSet rs2=pst2.executeQuery();
			while(rs2.next())
			{
				LowPressureCompressorModel lpcmodal2=new LowPressureCompressorModel();
				lpcmodal2.setLpc_sp_id(rs2.getInt(1));
				lpcmodal2.setSpecifi2(rs2.getString(2));
				list.add(lpcmodal2);
				
				PreparedStatement pst3=connection.prepareStatement("SELECT `quantity` FROM `lpc_config_003` WHERE lpc_sp_id="+rs2.getInt(1)+"");
				ResultSet rs3=pst3.executeQuery();
				while(rs3.next())
				{
					LowPressureCompressorModel lpcmodal3=new LowPressureCompressorModel();
					lpcmodal3.setSpecifi3(rs3.getString(1));
					list.add(lpcmodal3);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ShrinkMachineModel> fetchShrinkMCDetails(ShrinkMachineModel shrinkmodal, String quotation_name) {
		// TODO Auto-generated method stub
		List<ShrinkMachineModel> list=new ArrayList<>();
		
		try {
			
			PreparedStatement pst = connection.prepareStatement("SELECT `shrink_machine_id`, `name_of_index`, `image`, `name`, `parameterValue`, `features` FROM `shrink_machine_config_master` WHERE quotation_name='"+quotation_name+"'");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ShrinkMachineModel shrinkmd=new ShrinkMachineModel();
				
				shrinkmd.setShrink_id(rs.getInt(1));
				shrinkmd.setShrink(rs.getString(2));
				shrinkmd.setImage(rs.getString(3));
				shrinkmd.setName(rs.getString(4));
				shrinkmd.setParameterValue(rs.getString(5));
				shrinkmd.setSpecifi(rs.getString(6));
				
				list.add(shrinkmd);
				
				PreparedStatement pst1 = connection.prepareStatement("SELECT `specifications` FROM `shrink_machine_config_001` WHERE shrink_machine_id="+rs.getInt(1)+"");
				
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					ShrinkMachineModel shrinkmd1=new ShrinkMachineModel();
					shrinkmd1.setSpecifi1(rs1.getString(1));
					list.add(shrinkmd1);
				}
				
				PreparedStatement pst2 = connection.prepareStatement("SELECT `features` FROM `shrink_machine_config_002` WHERE shrink_master_id="+rs.getInt(1)+"");
				
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					ShrinkMachineModel shrinkmd2=new ShrinkMachineModel();
					shrinkmd2.setFeatures(rs2.getString(1));
					list.add(shrinkmd2);
				}
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<AutocasePackerModel> fetchAutocasePAcker(AutocasePackerModel autocasepacker1, String quotation_name) {
		// TODO Auto-generated method stub
		List<AutocasePackerModel> list=new ArrayList<>();
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `autocase_packer_id`, `name_of_index`, `sub_name`, `note` FROM `autocase_packer_config_master` WHERE quotation_name='"+quotation_name+"'");
		
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				AutocasePackerModel aotocasepacker=new AutocasePackerModel();
				
				aotocasepacker.setAutocase_packer_id(rs.getInt(1));
				aotocasepacker.setName_of_index(rs.getString(2));
				aotocasepacker.setSubanme(rs.getString(3));
				aotocasepacker.setNote(rs.getString(4));
				list.add(aotocasepacker);
				
				PreparedStatement pst1 = connection.prepareStatement("SELECT `specifications`, `quantity` FROM `autocase_packer_config_001` WHERE autocase_packer_id="+rs.getInt(1)+"");
				
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					AutocasePackerModel aotocasepacker1=new AutocasePackerModel();
					aotocasepacker1.setSpecifi(rs1.getString(1));
					aotocasepacker1.setQty(rs1.getString(2));
					list.add(aotocasepacker1);
				}
				
			}
			
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
		return list;
	}

	public List<LabChemMicroBioModel> fetchlabchembioDetails(LabChemMicroBioModel labchemnio, String quotation_name) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `lab_id`, `name_of_index`, `subname1`, `subname2`, `subname3`, `subname4`, `subname5` FROM `lab_chem_micro_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel labchembio=new LabChemMicroBioModel();
				labchembio.setLab_id(rs.getInt(1));
				labchembio.setName_of_index(rs.getString(2));
				labchembio.setSubname1(rs.getString(3));
				labchembio.setSubname2(rs.getString(4));
				labchembio.setSubname3(rs.getString(5));
				labchembio.setSubname4(rs.getString(6));
				labchembio.setSubname5(rs.getString(7));
				list.add(labchembio);
				
				
				PreparedStatement pst1 = connection.prepareStatement("SELECT `particulars`, `qty` FROM `lab_che_microbio_config_001` WHERE lab_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					LabChemMicroBioModel labchembio1=new LabChemMicroBioModel();
					labchembio1.setParti(rs1.getString(1));
					labchembio1.setQuantity(rs1.getString(2));
					list.add(labchembio1);
				}
				
				/*PreparedStatement pst12 = connection.prepareStatement("SELECT `particulars3`, `quantity3` FROM `lab_che_microbio_config_003` WHERE lab_id="+rs.getInt(1)+"");
				ResultSet rs12=pst12.executeQuery();
				while(rs12.next())
				{
					LabChemMicroBioModel labchembio12=new LabChemMicroBioModel();
					labchembio12.setParti2(rs12.getString(1));
					labchembio12.setQuantity2(rs12.getString(2));
					list.add(labchembio12);
				}*/
				
				/*PreparedStatement pst13 = connection.prepareStatement("SELECT `particulars4`, `quantity4` FROM `lab_che_microbio_config_004` WHERE lab_id="+rs.getInt(1)+"");
				ResultSet rs13=pst13.executeQuery();
				while(rs13.next())
				{
					LabChemMicroBioModel labchembio13=new LabChemMicroBioModel();
					labchembio13.setParti3(rs13.getString(1));
					labchembio13.setQuantity3(rs13.getString(2));
					list.add(labchembio13);
				}
				
				PreparedStatement pst14 = connection.prepareStatement("SELECT `particulars5`, `quantity5` FROM `lab_che_microbio_config_005` WHERE lab_id="+rs.getInt(1)+"");
				ResultSet rs14=pst14.executeQuery();
				while(rs14.next())
				{
					LabChemMicroBioModel labchembio14=new LabChemMicroBioModel();
					labchembio14.setParti4(rs14.getString(1));
					labchembio14.setQuantity4(rs14.getString(2));
					list.add(labchembio14);
				}*/
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<LabChemMicroBioModel> fetchlabchembioDetails1(LabChemMicroBioModel labchemnio, String quotation_name) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<>();
		int lab_id=0;
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `lab_id`  FROM `lab_chem_micro_config_master` WHERE quotation_name='"+quotation_name+"'");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				lab_id=rs.getInt(1);
			}
			
			PreparedStatement pst12 = connection.prepareStatement("SELECT `particulars3`, `quantity3` FROM `lab_che_microbio_config_003` WHERE lab_id="+lab_id+"");
			ResultSet rs12=pst12.executeQuery();
			while(rs12.next())
			{
				LabChemMicroBioModel labchembio12=new LabChemMicroBioModel();
				labchembio12.setParti1(rs12.getString(1));
				labchembio12.setQuantity1(rs12.getString(2));
				list.add(labchembio12);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<LabChemMicroBioModel> fetchlabchembioDetails2(LabChemMicroBioModel labchemnio, String quotation_name) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<>();
		
		System.out.println("quotation name in lab:"+quotation_name);
		int lab_id=0;
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `lab_id`  FROM `lab_chem_micro_config_master` WHERE quotation_name='"+quotation_name+"'");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				lab_id=rs.getInt(1);
			}
			
			PreparedStatement pst2 = connection.prepareStatement("SELECT `particulars2`, `quantity2` FROM `lab_che_microbio_config_002` WHERE lab_id="+lab_id+"");
			ResultSet rs2=pst2.executeQuery();
			while(rs2.next())
			{
				LabChemMicroBioModel labchembio2=new LabChemMicroBioModel();
				labchembio2.setParti2(rs2.getString(1));
				labchembio2.setQuantity2(rs2.getString(2));
				System.out.println(rs2.getString(1)+","+rs2.getString(2));
				list.add(labchembio2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List<LabChemMicroBioModel> fetchlabchembioDetails3(LabChemMicroBioModel labchemnio, String quotation_name) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<>();
		int lab_id=0;
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `lab_id`  FROM `lab_chem_micro_config_master` WHERE quotation_name='"+quotation_name+"'");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				lab_id=rs.getInt(1);
			}
			
			PreparedStatement pst13 = connection.prepareStatement("SELECT `particulars4`, `quantity4` FROM `lab_che_microbio_config_004` WHERE lab_id="+lab_id+"");
			ResultSet rs13=pst13.executeQuery();
			while(rs13.next())
			{
				LabChemMicroBioModel labchembio13=new LabChemMicroBioModel();
				labchembio13.setParti3(rs13.getString(1));
				labchembio13.setQuantity3(rs13.getString(2));
				list.add(labchembio13);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public List<LabChemMicroBioModel> fetchlabchembioDetails4(LabChemMicroBioModel labchemnio, String quotation_name) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<>();
		int lab_id=0;
		try {
			PreparedStatement pst = connection.prepareStatement("SELECT `lab_id`  FROM `lab_chem_micro_config_master` WHERE quotation_name='"+quotation_name+"'");
			
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				lab_id=rs.getInt(1);
			}
			
			PreparedStatement pst14 = connection.prepareStatement("SELECT `particulars5`, `quantity5` FROM `lab_che_microbio_config_005` WHERE lab_id="+lab_id+"");
			ResultSet rs14=pst14.executeQuery();
			while(rs14.next())
			{
				LabChemMicroBioModel labchembio14=new LabChemMicroBioModel();
				labchembio14.setParti4(rs14.getString(1));
				labchembio14.setQuantity4(rs14.getString(2));
				list.add(labchembio14);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<InvestmentAndExpencesModel> fetchInvestmentAndExp(InvestmentAndExpencesModel investandexp,int max_invest_exp_id) {
		
		System.out.println("max_invest_exp_id:"+max_invest_exp_id);
		int invest_exp_id=0;
		List<InvestmentAndExpencesModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `invest_exp_id`, `name_of_index`, `sub_name_of_index`, `heading3`, `heading4`, `total1`, `total2`, `total3` FROM `investmt_exp_config_master` WHERE `invest_exp_id`="+max_invest_exp_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				InvestmentAndExpencesModel investexp=new InvestmentAndExpencesModel();
				invest_exp_id=rs.getInt(1);
				investandexp.setInvest_exp_id(rs.getInt(1));
				investandexp.setName(rs.getString(2));
				investandexp.setSubname(rs.getString(3));
				investandexp.setHeading3(rs.getString(4));
				investandexp.setHeading4(rs.getString(5));
				investandexp.setTot1(rs.getString(6));
				investandexp.setTot2(rs.getString(7));
				investandexp.setTot3(rs.getString(8));
				list.add(investandexp);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `invest_exp_sp_id`, `particulars`, `expences`, `gst%`, `gst_amount`, `total` FROM `invest_exp_details_config_001` WHERE invest_exp_id="+invest_exp_id+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					InvestmentAndExpencesModel investexpmodal=new InvestmentAndExpencesModel();
					
					investexpmodal.setInvest_exp_id(rs1.getInt(1));
					investexpmodal.setParti(rs1.getString(2));
					investexpmodal.setExp(rs1.getString(3));
					investexpmodal.setGstP(rs1.getString(4));
					investexpmodal.setGstAmt(rs1.getString(5));
					investexpmodal.setTot(rs1.getString(6));
					System.out.println(investexpmodal.getInvest_exp_id());
					list.add(investexpmodal);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<TermsAndConditionsModel> fetchTermsConditionsDetails(TermsAndConditionsModel termsConditions1,
			String quotation_name) {
		// TODO Auto-generated method stub
		
		List<TermsAndConditionsModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `terms_cond_id`, `name_of_index`, `sub_name_of_index` FROM `terms_conditions_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				TermsAndConditionsModel termscond=new TermsAndConditionsModel();
				termscond.setTerms_condition_id(rs.getInt(1));
				termscond.setName_of_index(rs.getString(2));
				termscond.setSub_name_of_index(rs.getString(3));
				list.add(termscond);
				
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `particulars`, `details` FROM `terms_conditions_001` WHERE terms_conditions_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					TermsAndConditionsModel termscondDetails=new TermsAndConditionsModel();
					
					termscondDetails.setSpecifi(rs1.getString(1));
					termscondDetails.setQty(rs1.getString(2));
					list.add(termscondDetails);
				}
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `specifications` FROM `terms_conditions_002` WHERE terms_conditions_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					TermsAndConditionsModel termscondDetails=new TermsAndConditionsModel();
					
					termscondDetails.setSpecifi1(rs2.getString(1));
					list.add(termscondDetails);
				}
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<ProductWiseProductionCostModel> fetchPWPC(ProductWiseProductionCostModel pwpc1, String quotation_name) {
		// TODO Auto-generated method stub
		List<ProductWiseProductionCostModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `pwpc_id`, `name_of_index`, `heading1`, `heading2` FROM `product_wise_prod_cost_config_master` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				ProductWiseProductionCostModel pwpc=new ProductWiseProductionCostModel();
				pwpc.setPwproduction_id(rs.getInt(1));
				pwpc.setName_of_index(rs.getString(2));
				pwpc.setHeading1(rs.getString(3));
				pwpc.setHeading2(rs.getString(4));
				list.add(pwpc);
				
				PreparedStatement pst1=connection.prepareStatement("SELECT `requirement`, `quantity` FROM `pwpc_config_001` WHERE pwpc_id="+rs.getInt(1)+"");
				ResultSet rs1=pst1.executeQuery();
				while(rs1.next())
				{
					ProductWiseProductionCostModel pwpc2=new ProductWiseProductionCostModel();
					
					pwpc2.setParti(rs1.getString(1));
					pwpc2.setLtr(rs1.getString(2));
					list.add(pwpc2);
					
				}
				
				
				PreparedStatement pst2=connection.prepareStatement("SELECT `particulars`, `1ltr(R)` FROM `pwpc_config_002` WHERE pwpc_id="+rs.getInt(1)+"");
				ResultSet rs2=pst2.executeQuery();
				while(rs2.next())
				{
					ProductWiseProductionCostModel pwpc3=new ProductWiseProductionCostModel();
					pwpc3.setReq(rs2.getString(1));
					pwpc3.setQty(rs2.getString(2));
					list.add(pwpc3);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<FlowChartModel> fetchFlowChartsDetails(FlowChartModel flowchartmodal, String quotation_name) {
		// TODO Auto-generated method stub
		List<FlowChartModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `name_of_index`, `image`  FROM `flow_chart_config` WHERE quotation_name='"+quotation_name+"'");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				FlowChartModel flowchart=new FlowChartModel();
				flowchart.setName_of_index(rs.getString(1));
				flowchart.setImage(rs.getString(2));
				list.add(flowchart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
}

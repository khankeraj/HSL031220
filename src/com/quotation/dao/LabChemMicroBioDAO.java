package com.quotation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DB.DBConnection;
import com.quotation.model.LabChemMicroBioModel;

public class LabChemMicroBioDAO {

	DBConnection connection=new DBConnection();
	
	public int insert_lab_chemical_microbiology(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		int i=0;
		int max_count=0;
	
	try {
		Connection conn=connection.getConnection();
		
		PreparedStatement pst=conn.prepareStatement("INSERT INTO `lab_chem_micro_config_master`(`name_of_index`, `subname1`, `subname2`, `subname3`, `subname4`, `subname5`, `quotation_name`) VALUES (?,?,?,?,?,?,?)");
		pst.setString(1, labChemicalMicro.getName_of_index());
		pst.setString(2, labChemicalMicro.getSubname1());
		pst.setString(3, labChemicalMicro.getSubname2());
		pst.setString(4, labChemicalMicro.getSubname3());
		pst.setString(5, labChemicalMicro.getSubname4());
		pst.setString(6, labChemicalMicro.getSubname5());
		pst.setString(7, labChemicalMicro.getQuotation_name());
		
		i=pst.executeUpdate();
		if(i>0)
		{
			System.out.println("inserted...!!!");
			
			PreparedStatement pst1=conn.prepareStatement("SELECT MAX(lab_chem_micro_config_master.lab_id)AS maxCount FROM lab_chem_micro_config_master");
			ResultSet rs=pst1.executeQuery();
			if(rs.next())
			{
				max_count=Integer.parseInt(rs.getString(1));
			}
			
			for(int j=0;j<labChemicalMicro.getParticulars().length;j++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_001`(`particulars`, `qty`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars()[j]);
				pst11.setString(2, labChemicalMicro.getQty()[j]);
				pst11.setInt(3, max_count);
				i=pst11.executeUpdate();
			}
			
			for(int k=0;k<labChemicalMicro.getParticulars1().length;k++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_002`(`particulars2`, `quantity2`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars1()[k]);
				pst11.setString(2, labChemicalMicro.getQty1()[k]);
				pst11.setInt(3, max_count);
				i=pst11.executeUpdate();
			}
			
			for(int l=0;l<labChemicalMicro.getParticulars2().length;l++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_003`(`particulars3`, `quantity3`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars2()[l]);
				pst11.setString(2, labChemicalMicro.getQty2()[l]);
				pst11.setInt(3, max_count);
				i=pst11.executeUpdate();
			}
			
			for(int m=0;m<labChemicalMicro.getParticulars3().length;m++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_004`(`particulars4`, `quantity4`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars3()[m]);
				pst11.setString(2, labChemicalMicro.getQty3()[m]);
				pst11.setInt(3, max_count);
				i=pst11.executeUpdate();
			}
			
			for(int n=0;n<labChemicalMicro.getParticulars4().length;n++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_005`(`particulars5`, `quantity5`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars4()[n]);
				pst11.setString(2, labChemicalMicro.getQty4()[n]);
				pst11.setInt(3, max_count);
				i=pst11.executeUpdate();
			}
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return i;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `name_of_index`, `subname1`, `subname2`, `subname3`, `subname4`, `subname5` FROM `laboratories_chemical_microbiology`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel labchembio=new LabChemMicroBioModel();
				labchembio.setName_of_index(rs.getString(1));
				labchembio.setSubname1(rs.getString(2));
				labchembio.setSubname2(rs.getString(3));
				labchembio.setSubname3(rs.getString(4));
				labchembio.setSubname4(rs.getString(5));
				labchembio.setSubname5(rs.getString(6));
				list.add(labchembio);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology1(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `qty` FROM `lab_che_microbio_sp_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti(rs.getString(1));
				lab.setQuantity(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology2(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
	
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars2`, `quantity2` FROM `lab_che_microbio_sp2_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti1(rs.getString(1));
				lab.setQuantity1(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology3(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars3`, `quantity3` FROM `lab_che_microbio_sp3_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti2(rs.getString(1));
				lab.setQuantity2(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology4(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars4`, `quantity4` FROM `lab_che_microbio_sp4_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti3(rs.getString(1));
				lab.setQuantity3(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology5(LabChemMicroBioModel labChemicalMicro) {
		// TODO Auto-generated method stub
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars5`, `quantity5` FROM `lab_che_microbio_sp5_details`");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti4(rs.getString(1));
				lab.setQuantity4(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology6(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `lab_id`, `name_of_index`, `subname1`, `subname2`, `subname3`, `subname4`, `subname5`, `quotation_name` FROM `lab_chem_micro_config_master` WHERE lab_id=?");
			pst.setInt(1, lcmId);
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
				labchembio.setQuotation_name(rs.getString(8));
				list.add(labchembio);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology71(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars`, `qty` FROM `lab_che_microbio_config_001` WHERE lab_id=?");
			pst.setInt(1, lcmId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti(rs.getString(1));
				lab.setQuantity(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology8(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
	
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars2`, `quantity2` FROM `lab_che_microbio_config_002` WHERE lab_id=?");
			pst.setInt(1, lcmId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti1(rs.getString(1));
				lab.setQuantity1(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology9(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars3`, `quantity3` FROM `lab_che_microbio_config_003` WHERE lab_id=?");
			pst.setInt(1, lcmId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti2(rs.getString(1));
				lab.setQuantity2(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology10(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars4`, `quantity4` FROM `lab_che_microbio_config_004` WHERE lab_id=?");
			pst.setInt(1, lcmId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti3(rs.getString(1));
				lab.setQuantity3(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<LabChemMicroBioModel> fetchLab_chemical_microbiology11(LabChemMicroBioModel labChemicalMicro,String lcmid) {
		// TODO Auto-generated method stub
		int lcmId=Integer.parseInt(lcmid);
		
		List<LabChemMicroBioModel> list=new ArrayList<LabChemMicroBioModel>();
		
		Connection conn=connection.getConnection();
		
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT `particulars5`, `quantity5` FROM `lab_che_microbio_config_005` WHERE lab_id=?");
			pst.setInt(1, lcmId);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				LabChemMicroBioModel lab=new LabChemMicroBioModel();
				lab.setParti4(rs.getString(1));
				lab.setQuantity4(rs.getString(2));
				list.add(lab);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int updateLCMDetails(LabChemMicroBioModel labChemicalMicro, String lcmid) {
		// TODO Auto-generated method stub
		int lcm_Id=Integer.parseInt(lcmid);
		
		int i=0;
		int max_count=0;
		Connection conn=connection.getConnection();
	try {
		PreparedStatement pst=conn.prepareStatement("UPDATE `lab_chem_micro_config_master` SET `name_of_index`=?,`subname1`=?,`subname2`=?,`subname3`=?,`subname4`=?,`subname5`=?,`quotation_name`=? WHERE `lab_id`=?");
		pst.setString(1, labChemicalMicro.getName_of_index());
		pst.setString(2, labChemicalMicro.getSubname1());
		pst.setString(3, labChemicalMicro.getSubname2());
		pst.setString(4, labChemicalMicro.getSubname3());
		pst.setString(5, labChemicalMicro.getSubname4());
		pst.setString(6, labChemicalMicro.getSubname5());
		pst.setString(7, labChemicalMicro.getQuotation_name());
		pst.setInt(8,lcm_Id);
		i=pst.executeUpdate();
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
	try {
			
			PreparedStatement pstmt=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_001` WHERE lab_id=?");
			pstmt.setInt(1, lcm_Id);
			i=pstmt.executeUpdate();
			
			for(int j=0;j<labChemicalMicro.getParticulars().length;j++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_001`(`particulars`, `qty`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars()[j]);
				pst11.setString(2, labChemicalMicro.getQty()[j]);
				pst11.setInt(3, lcm_Id);
				i=pst11.executeUpdate();
			}
			
			PreparedStatement pstmt1=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_002` WHERE lab_id=?");
			pstmt1.setInt(1, lcm_Id);
			i=pstmt1.executeUpdate();
			
			for(int k=0;k<labChemicalMicro.getParticulars1().length;k++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_002`(`particulars2`, `quantity2`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars1()[k]);
				pst11.setString(2, labChemicalMicro.getQty1()[k]);
				pst11.setInt(3, lcm_Id);
				i=pst11.executeUpdate();
			}
			
			PreparedStatement pstmt11=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_003` WHERE lab_id=?");
			pstmt11.setInt(1, lcm_Id);
			i=pstmt11.executeUpdate();
			
			for(int l=0;l<labChemicalMicro.getParticulars2().length;l++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_003`(`particulars3`, `quantity3`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars2()[l]);
				pst11.setString(2, labChemicalMicro.getQty2()[l]);
				pst11.setInt(3, lcm_Id);
				i=pst11.executeUpdate();
			}
			
			PreparedStatement pstmt111=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_004` WHERE lab_id=?");
			pstmt111.setInt(1, lcm_Id);
			i=pstmt111.executeUpdate();
			
			for(int m=0;m<labChemicalMicro.getParticulars3().length;m++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_004`(`particulars4`, `quantity4`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars3()[m]);
				pst11.setString(2, labChemicalMicro.getQty3()[m]);
				pst11.setInt(3, lcm_Id);
				i=pst11.executeUpdate();
			}
			
			PreparedStatement pstmt1111=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_005` WHERE lab_id=?");
			pstmt1111.setInt(1, lcm_Id);
			i=pstmt1111.executeUpdate();
			
			for(int n=0;n<labChemicalMicro.getParticulars4().length;n++) 
			{
				PreparedStatement pst11=conn.prepareStatement("INSERT INTO `lab_che_microbio_config_005`(`particulars5`, `quantity5`, `lab_id`) VALUES (?,?,?)");
				pst11.setString(1, labChemicalMicro.getParticulars4()[n]);
				pst11.setString(2, labChemicalMicro.getQty4()[n]);
				pst11.setInt(3, lcm_Id);
				i=pst11.executeUpdate();
			}
			
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return i;
	}

	public int deleteLCMDetails(LabChemMicroBioModel labChemicalMicro, String lcmid) {
		// TODO Auto-generated method stub
		int lcm_Id=Integer.parseInt(lcmid);
		int i=0;
		Connection conn=connection.getConnection();
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_chem_micro_config_master` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_001` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_002` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_003` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_004` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		try
		{
			PreparedStatement pst=conn.prepareStatement("DELETE FROM `lab_che_microbio_config_005` WHERE lab_id=?");
			pst.setInt(1, lcm_Id);
			i=pst.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	
}

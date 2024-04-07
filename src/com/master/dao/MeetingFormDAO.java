package com.master.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.master.model.LeadFormModel;
import com.master.model.MeetingFormModel;

public class MeetingFormDAO {
	public int insert_meeting_details(MeetingFormModel meetingForm)
	{
		int i=0;
		try {
			int status=1;
			DBConnection conn=new DBConnection();
			Connection connection=conn.getConnection();
			
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `meeting_details`(`customer_name`, `contact_no`,`requiredDate`, `meeting_status`, `next_meeting_date`, `descriptioin`, `remark`, `amount`, `status`) VALUES (?,?,?,?,?,?,?,?,?)");
			pst.setString(1, meetingForm.getCustomer_name());
			pst.setString(2, meetingForm.getContact_no());
			pst.setString(3,meetingForm.getRequiredDate() );
			pst.setString(4, meetingForm.getMeeting_status());
			pst.setString(5, meetingForm.getNext_meeting_date());
			pst.setString(6, meetingForm.getDescription());
			pst.setString(7, meetingForm.getRemark());
			pst.setString(8, meetingForm.getAmount());
			pst.setInt(9, status);
			i=pst.executeUpdate();
			
			if(i>0)
			{
				int lead_id = 0;
				PreparedStatement pst1=connection.prepareStatement("SELECT MAX(lead_id) FROM lead_deatils WHERE lead_deatils.customer_name='"+meetingForm.getCustomer_name()+"' ");
				ResultSet rs=pst1.executeQuery();
				while(rs.next())
				{
					lead_id=rs.getInt(1);
				}
				
				PreparedStatement pst11=connection.prepareStatement("UPDATE `status_master` SET `meeting`='YES' WHERE lead_no="+lead_id+"");
				int j=pst11.executeUpdate();
				if(j>0)
				{
					System.out.println("status Updated Successfully");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return i;
		
	}
	
	public int saveMeeting(MeetingFormModel meetingForm,String lead_no) {
		// TODO Auto-generated method stub
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		int i=0;
		try {
			int status=1;
			System.out.println("in meeting form");
			
			PreparedStatement pst=connection.prepareStatement("INSERT INTO `meeting_details`(`lead_no`,`customer_name`, `contact_no`,`requiredDate`, `meeting_status`, `next_meeting_date`, `descriptioin`, `remark`, `amount`, `status`) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, lead_no);
			pst.setString(2, meetingForm.getCustomer_name());
			pst.setString(3, meetingForm.getContact_no());
			pst.setString(4, meetingForm.getRequiredDate());
			pst.setString(5, meetingForm.getMeeting_status());
			pst.setString(6, meetingForm.getNext_meeting_date());
			pst.setString(7, meetingForm.getDescription());
			pst.setString(8, meetingForm.getRemark());
			pst.setString(9, meetingForm.getAmount());
			pst.setInt(10, status);
			i=pst.executeUpdate();
			
			
				String lead_no1 = null;
				
				PreparedStatement pst12=connection.prepareStatement("UPDATE `lead_deatils` SET `status`=2 WHERE `lead_no`='"+lead_no+"'");
				i=pst12.executeUpdate();
				if(i>0)
				{
					System.out.println("status Updated Successfully");
				}
				
				/*PreparedStatement pst1=connection.prepareStatement("SELECT MAX(lead_no) FROM lead_deatils WHERE lead_deatils.customer_name='"+meetingForm.getCustomer_name()+"' ");
				ResultSet rs=pst1.executeQuery();
				while(rs.next())
				{
					lead_no1=rs.getString(1);
				}*/
				
				PreparedStatement pst11=connection.prepareStatement("UPDATE `status_master` SET `meeting`='YES' WHERE lead_no='"+lead_no+"'");
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
	
	public List<MeetingFormModel> fetchMeetingFormDetails(MeetingFormModel meetingForm)
	{
		List<MeetingFormModel> list=new ArrayList<>();
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `customer_name`, `contact_no`, `requiredDate`, `meeting_status`, `next_meeting_date`, `descriptioin`, `remark`, `amount`,`lead_no` FROM `meeting_details` WHERE STATUS=1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				MeetingFormModel meetingForm1=new MeetingFormModel();
				meetingForm1.setCustomer_name(rs.getString(1));
				meetingForm1.setContact_no(rs.getString(2));
				meetingForm1.setRequiredDate(rs.getString(3));
				meetingForm1.setMeeting_status(rs.getString(4));
				meetingForm1.setNext_meeting_date(rs.getString(5));
				meetingForm1.setDescription(rs.getString(6));
				meetingForm1.setRemark(rs.getString(7));
				meetingForm1.setAmount(rs.getString(8));
				meetingForm1.setLead_no(rs.getString(9));
				list.add(meetingForm1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return list;
		
	}
	
	public int delete_meetingForm_details(MeetingFormModel meetingForm, String meeting_id) {
		// TODO Auto-generated method stub
		int i=0;
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		try {
			PreparedStatement pst11=connection.prepareStatement("DELETE FROM `meeting_details` WHERE meeting_id="+meeting_id+"");
			i=pst11.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	public List<MeetingFormModel> fetchForUpdateMeetingDetails(MeetingFormModel meetingForm, String fetch_meeting_id) {
		// TODO Auto-generated method stub
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		List<MeetingFormModel> list=new ArrayList<>();
		
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `customer_name`, `contact_no`, `requiredDate`, `meeting_status`, `next_meeting_date`, `descriptioin`, `remark`, `amount`,`meeting_id` FROM `meeting_details` WHERE meeting_details.meeting_id="+fetch_meeting_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				MeetingFormModel meetingForm1=new MeetingFormModel();
				meetingForm1.setCustomer_name(rs.getString(1));
				meetingForm1.setContact_no(rs.getString(2));
				meetingForm1.setRequiredDate(rs.getString(3));
				meetingForm1.setMeeting_status(rs.getString(4));
				meetingForm1.setNext_meeting_date(rs.getString(5));
				meetingForm1.setDescription(rs.getString(6));
				meetingForm1.setRemark(rs.getString(7));
				meetingForm1.setAmount(rs.getString(8));
				meetingForm1.setMeeting_id(rs.getInt(9));	
				list.add(meetingForm1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public int update_Meeting_From_Details(MeetingFormModel meetingForm, String meeting_id) {
		// TODO Auto-generated method stub
		int i=0;
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		try {
			PreparedStatement pst=connection.prepareStatement("UPDATE `meeting_details` SET `customer_name`=?,`contact_no`=?,`requiredDate`=?,`meeting_status`=?,`next_meeting_date`=?,`descriptioin`=?,`remark`=?,`amount`=? WHERE `meeting_id`="+meeting_id+"");
			pst.setString(1,meetingForm.getCustomer_name());
			pst.setString(2, meetingForm.getContact_no());
			pst.setString(3, meetingForm.getRequiredDate());
			pst.setString(4, meetingForm.getMeeting_status());
			pst.setString(5, meetingForm.getNext_meeting_date());
			pst.setString(6, meetingForm.getDescription());
			pst.setString(7, meetingForm.getRemark());
			pst.setString(8, meetingForm.getAmount());
			i=pst.executeUpdate();
					
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

}
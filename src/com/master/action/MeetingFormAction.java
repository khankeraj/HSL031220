package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.LeadFormDAO;
import com.master.dao.MeetingFormDAO;
import com.master.model.MeetingFormModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MeetingFormAction extends ActionSupport implements ModelDriven {
	
	private MeetingFormModel meetingForm=new MeetingFormModel();
	private List<MeetingFormModel> meetingForm1;
	private List<MeetingFormModel> editMeetingForm;
	private List<MeetingFormModel> meetingForm2;
	
	public List<MeetingFormModel> getMeetingForm2() {
		return meetingForm2;
	}

	public void setMeetingForm2(List<MeetingFormModel> meetingForm2) {
		this.meetingForm2 = meetingForm2;
	}

	public List<MeetingFormModel> getEditMeetingForm() {
		return editMeetingForm;
	}

	public void setEditMeetingForm(List<MeetingFormModel> editMeetingForm) {
		this.editMeetingForm = editMeetingForm;
	}

	public MeetingFormModel getMeetingForm() {
		return meetingForm;
	}

	public void setMeetingForm(MeetingFormModel meetingForm) {
		this.meetingForm = meetingForm;
	}

	public List<MeetingFormModel> getMeetingForm1() {
		return meetingForm1;
	}

	public void setMeetingForm1(List<MeetingFormModel> meetingForm1) {
		this.meetingForm1 = meetingForm1;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_meetingForm_details()
	{
		 String response;
		 System.out.println("in action");
		 
		int status=new MeetingFormDAO().insert_meeting_details(meetingForm);
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
	}
	
	public String fetchMeetingDetails()
	{
			String response="";
			 System.out.println("in action");
			 
			HttpServletRequest request = ServletActionContext.getRequest();
			meetingForm1=new MeetingFormDAO().fetchMeetingFormDetails(meetingForm);
			if(meetingForm1!=null)
			{
				response="success";
			}
			else
			{
				response="fail";

			}
			return response;
	}
	
	public String fetchForUpdateMeetingDetails()
	{
			String response;
			 System.out.println("in action");
			 
			HttpServletRequest request = ServletActionContext.getRequest();
			String fetch_meeting_id=request.getParameter("meeting_id");
			meetingForm2=new MeetingFormDAO().fetchForUpdateMeetingDetails(meetingForm,fetch_meeting_id);
			if(meetingForm2!=null)
			{
				response="success";
			}
			else
			{
				response="fail";

			}
			return response;
	}
	
	public String saveMeeting()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String lead_no=request.getParameter("lead_serial_no");
		System.out.println("lead_no:"+lead_no);
		int i=new MeetingFormDAO().saveMeeting(meetingForm,lead_no);
		if(i>0)
		{
			System.out.println("in action ");
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
		
	}
	
	public String delete_meetingForm_details()
	{
		 String response;
		 System.out.println("in action");
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		String meeting_id=request.getParameter("meeting_id");
		int status=new MeetingFormDAO().delete_meetingForm_details(meetingForm,meeting_id);
		
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
	}
	
	public String update_Meeting_From_Details()
	{
		String response;
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		String meeting_id=request.getParameter("update_meeting_id");
		
		int status=new MeetingFormDAO().update_Meeting_From_Details(meetingForm,meeting_id);
		if(status>0)
		{
			response="success";
		}
		else
		{
			response="fail";

		}
		return response;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return meetingForm;
	}

}

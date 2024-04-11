package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.CustomerMasterDAO;
import com.master.dao.StudentMasterDao;

import com.master.model.StudentModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StudentMasterAction extends ActionSupport implements ModelDriven {

	StudentModel student_model = new StudentModel();

	private List <StudentModel> studentMasterDetails;
	
	private List <StudentModel> fetchStudentDetails;
	
	
	
	
	public StudentModel getStudent_model() {
		return student_model;
	}

	public void setStudent_model(StudentModel student_model) {
		this.student_model = student_model;
	}

	public List<StudentModel> getStudentMasterDetails() {
		return studentMasterDetails;
	}

	public void setStudentMasterDetails(List<StudentModel> studentMasterDetails) {
		this.studentMasterDetails = studentMasterDetails;
	}

	public List<StudentModel> getFetchStudentDetails() {
		return fetchStudentDetails;
	}

	public void setFetchStudentDetails(List<StudentModel> fetchStudentDetails) {
		this.fetchStudentDetails = fetchStudentDetails;
	}

	public String studentMaster() {
		return "success";
	}
	
	public String insert_student_master_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		int i = new StudentMasterDao().insert_student_master_details(student_model);
		if (i > 0) {
			response = "success";
		} else if (i == -1) {
			response = "already";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	
	public String fetchStudentMasterDetails() {
		String response;
		studentMasterDetails = new StudentMasterDao().fetchStudentMasterDetails(student_model);
		if (studentMasterDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}

	
	public String deleteStudentMasterDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String delete_student_id = request.getParameter("student_id");

		int i = new StudentMasterDao().delete_student_master(student_model, delete_student_id);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	public String fetchForUpdateStudentDetails() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String student_id = request.getParameter("student_id");

		fetchStudentDetails = new StudentMasterDao().fetchForUpdateStudentDetails(student_model, student_id);

		if (fetchStudentDetails.size() > 0) {
			response = "success";
		} else {
			response = "fail";
		}

		return response;
	}
	
	
	
	public String update_student_details() {
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String update_student = request.getParameter("student_id");
		System.out.println("update:" + update_student);
		int i = new StudentMasterDao().update_student_details(student_model, update_student);
		if (i > 0) {
			response = "success";
		} else {
			response = "fail";
		}
		return response;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return student_model;
	}

}

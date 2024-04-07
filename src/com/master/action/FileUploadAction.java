package com.master.action;

import com.master.dao.FileUploadDAO;
import com.master.model.FileUploadModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FileUploadAction extends ActionSupport implements ModelDriven {

	private FileUploadModel fileupload=new FileUploadModel();
	
	public String execute()
	{
		return "success";
	}
	
	public String insert_image()
	{
		String response = null;
		int i=new FileUploadDAO().insert_image(fileupload);
		return response;
		
	}
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return fileupload;
	}

	public FileUploadModel getFileupload() {
		return fileupload;
	}

	public void setFileupload(FileUploadModel fileupload) {
		this.fileupload = fileupload;
	}
	
	

}

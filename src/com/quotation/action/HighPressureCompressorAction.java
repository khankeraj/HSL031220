package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.HighPressureCompressorDAO;
import com.quotation.model.HighPressureCompressorModel;

public class HighPressureCompressorAction extends ActionSupport implements ModelDriven{
	
	private HighPressureCompressorModel highpressurecompressor=new HighPressureCompressorModel();
	
	private List<HighPressureCompressorModel> hpc;
	private List<HighPressureCompressorModel> hpc1;
	private List<HighPressureCompressorModel> hpc2;
	private List<HighPressureCompressorModel> hpc3;
	
	private List<HighPressureCompressorModel> hpc4;
	private List<HighPressureCompressorModel> hpc5;
	private List<HighPressureCompressorModel> hpc6;
	private List<HighPressureCompressorModel> hpc7;
	
	public List<HighPressureCompressorModel> getHpc4() {
		return hpc4;
	}

	public void setHpc4(List<HighPressureCompressorModel> hpc4) {
		this.hpc4 = hpc4;
	}

	public List<HighPressureCompressorModel> getHpc5() {
		return hpc5;
	}

	public void setHpc5(List<HighPressureCompressorModel> hpc5) {
		this.hpc5 = hpc5;
	}

	public List<HighPressureCompressorModel> getHpc6() {
		return hpc6;
	}

	public void setHpc6(List<HighPressureCompressorModel> hpc6) {
		this.hpc6 = hpc6;
	}

	public List<HighPressureCompressorModel> getHpc7() {
		return hpc7;
	}

	public void setHpc7(List<HighPressureCompressorModel> hpc7) {
		this.hpc7 = hpc7;
	}

	public List<HighPressureCompressorModel> getHpc() {
		return hpc;
	}

	public void setHpc(List<HighPressureCompressorModel> hpc) {
		this.hpc = hpc;
	}

	public List<HighPressureCompressorModel> getHpc1() {
		return hpc1;
	}

	public void setHpc1(List<HighPressureCompressorModel> hpc1) {
		this.hpc1 = hpc1;
	}

	public List<HighPressureCompressorModel> getHpc2() {
		return hpc2;
	}

	public void setHpc2(List<HighPressureCompressorModel> hpc2) {
		this.hpc2 = hpc2;
	}

	public List<HighPressureCompressorModel> getHpc3() {
		return hpc3;
	}

	public void setHpc3(List<HighPressureCompressorModel> hpc3) {
		this.hpc3 = hpc3;
	}

	public HighPressureCompressorModel getHighpressurecompressor() {
		return highpressurecompressor;
	}

	public void setHighpressurecompressor(HighPressureCompressorModel highpressurecompressor) {
		this.highpressurecompressor = highpressurecompressor;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_high_pressure_compressormaster()
	{
		String response;
		int i=new HighPressureCompressorDAO().insert_high_pressure_compressor(highpressurecompressor);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchHPCDetails()
	{
		String response;
		hpc=new HighPressureCompressorDAO().fetchHPCDetails(highpressurecompressor);
		hpc1=new HighPressureCompressorDAO().fetchHPCDetails1(highpressurecompressor);
		hpc2=new HighPressureCompressorDAO().fetchHPCDetails2(highpressurecompressor);
		hpc3=new HighPressureCompressorDAO().fetchHPCDetails3(highpressurecompressor);
		System.out.println("max size of hpc:"+hpc.size());
		if(hpc.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdate()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String hpcId=request.getParameter("hpc_id");
		
		hpc4=new HighPressureCompressorDAO().fetchHPCDetails4(highpressurecompressor,hpcId);
		hpc5=new HighPressureCompressorDAO().fetchHPCDetails5(highpressurecompressor,hpcId);
		hpc6=new HighPressureCompressorDAO().fetchHPCDetails6(highpressurecompressor,hpcId);
		hpc7=new HighPressureCompressorDAO().fetchHPCDetails7(highpressurecompressor,hpcId);
		
		if(hpc4.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}

	
	public String updateHPCDetails()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String hpc_Id=request.getParameter("update_id");
		
		int i=new HighPressureCompressorDAO().updateHPCDetails(highpressurecompressor,hpc_Id);
		
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	public String deleteHPCDetails()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String hpc_Id=request.getParameter("hpc_id");
		
		int i=new HighPressureCompressorDAO().deleteHPCDetails(highpressurecompressor,hpc_Id);
		
		if(i>0)
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
		return highpressurecompressor;
	}

}

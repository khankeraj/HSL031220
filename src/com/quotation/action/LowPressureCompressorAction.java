package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.LowPressureCompressorDAO;
import com.quotation.model.LowPressureCompressorModel;

public class LowPressureCompressorAction extends ActionSupport implements ModelDriven{

	private LowPressureCompressorModel lowPressureCompressor=new LowPressureCompressorModel();
	
	private List<LowPressureCompressorModel> lowPressureCompressure;
	private List<LowPressureCompressorModel> lowPressureCompressure1;
	private List<LowPressureCompressorModel> lowPressureCompressure2;
	
	
	private List<LowPressureCompressorModel> lowPressureCompressure3;
	private List<LowPressureCompressorModel> lowPressureCompressure4;
	private List<LowPressureCompressorModel> lowPressureCompressure5;
	
	public List<LowPressureCompressorModel> getLowPressureCompressure3() {
		return lowPressureCompressure3;
	}

	public void setLowPressureCompressure3(List<LowPressureCompressorModel> lowPressureCompressure3) {
		this.lowPressureCompressure3 = lowPressureCompressure3;
	}

	public List<LowPressureCompressorModel> getLowPressureCompressure4() {
		return lowPressureCompressure4;
	}

	public void setLowPressureCompressure4(List<LowPressureCompressorModel> lowPressureCompressure4) {
		this.lowPressureCompressure4 = lowPressureCompressure4;
	}

	public List<LowPressureCompressorModel> getLowPressureCompressure5() {
		return lowPressureCompressure5;
	}

	public void setLowPressureCompressure5(List<LowPressureCompressorModel> lowPressureCompressure5) {
		this.lowPressureCompressure5 = lowPressureCompressure5;
	}

	public List<LowPressureCompressorModel> getLowPressureCompressure() {
		return lowPressureCompressure;
	}

	public void setLowPressureCompressure(List<LowPressureCompressorModel> lowPressureCompressure) {
		this.lowPressureCompressure = lowPressureCompressure;
	}

	public List<LowPressureCompressorModel> getLowPressureCompressure1() {
		return lowPressureCompressure1;
	}

	public void setLowPressureCompressure1(List<LowPressureCompressorModel> lowPressureCompressure1) {
		this.lowPressureCompressure1 = lowPressureCompressure1;
	}

	public List<LowPressureCompressorModel> getLowPressureCompressure2() {
		return lowPressureCompressure2;
	}

	public void setLowPressureCompressure2(List<LowPressureCompressorModel> lowPressureCompressure2) {
		this.lowPressureCompressure2 = lowPressureCompressure2;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_lowPressureCompressorMaster()
	{
		String response;
		
		int i=new LowPressureCompressorDAO().insert_lowPressureCompressorMaster(lowPressureCompressor);
		
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchLowPressureCompressure()
	{
		String response;
		lowPressureCompressure2=new LowPressureCompressorDAO().fetchLowPressureCompressure2(lowPressureCompressor);
		lowPressureCompressure1=new LowPressureCompressorDAO().fetchLowPressureCompressure1(lowPressureCompressor);
		lowPressureCompressure=new LowPressureCompressorDAO().fetchLowPressureCompressure(lowPressureCompressor);
		
		if(lowPressureCompressure.size()>0)
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
		String lpc_id=request.getParameter("lpc_id");
		
		lowPressureCompressure3=new LowPressureCompressorDAO().fetchLowPressureCompressure3(lowPressureCompressor,lpc_id);
		lowPressureCompressure4=new LowPressureCompressorDAO().fetchLowPressureCompressure4(lowPressureCompressor,lpc_id);
		lowPressureCompressure5=new LowPressureCompressorDAO().fetchLowPressureCompressure5(lowPressureCompressor,lpc_id);
		
		if(lowPressureCompressure3.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateLPCDetails()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String lpc_id=request.getParameter("update_id");
		
		String response;
		
		int i=new LowPressureCompressorDAO().updateLPCDetails(lowPressureCompressor,lpc_id);
		
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String deleteLPCDetails()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lpc_id=request.getParameter("lpc_id");
		int i=new LowPressureCompressorDAO().deleteLPCDetails(lowPressureCompressor,lpc_id);
		
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return lowPressureCompressor;
	}


	public LowPressureCompressorModel getLowPressureCompressor() {
		return lowPressureCompressor;
	}


	public void setLowPressureCompressor(LowPressureCompressorModel lowPressureCompressor) {
		this.lowPressureCompressor = lowPressureCompressor;
	}

}

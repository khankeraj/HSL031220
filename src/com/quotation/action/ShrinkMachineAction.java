package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.ShrinkMachineDAO;
import com.quotation.model.ShrinkMachineModel;

public class ShrinkMachineAction extends ActionSupport implements ModelDriven{

	private ShrinkMachineModel shrinkmachine=new ShrinkMachineModel();
	private List<ShrinkMachineModel> shrinkmachine1;
	private List<ShrinkMachineModel> shrinkmachine2;
	private List<ShrinkMachineModel> shrinkmachine3;
	
	private List<ShrinkMachineModel> shrinkmachine4;
	private List<ShrinkMachineModel> shrinkmachine5;
	private List<ShrinkMachineModel> shrinkmachine6;
	
	public List<ShrinkMachineModel> getShrinkmachine4() {
		return shrinkmachine4;
	}

	public void setShrinkmachine4(List<ShrinkMachineModel> shrinkmachine4) {
		this.shrinkmachine4 = shrinkmachine4;
	}

	public List<ShrinkMachineModel> getShrinkmachine5() {
		return shrinkmachine5;
	}

	public void setShrinkmachine5(List<ShrinkMachineModel> shrinkmachine5) {
		this.shrinkmachine5 = shrinkmachine5;
	}

	public List<ShrinkMachineModel> getShrinkmachine6() {
		return shrinkmachine6;
	}

	public void setShrinkmachine6(List<ShrinkMachineModel> shrinkmachine6) {
		this.shrinkmachine6 = shrinkmachine6;
	}

	public String execute()
	{
		return "success";
	}
	
	public List<ShrinkMachineModel> getShrinkmachine1() {
		return shrinkmachine1;
	}

	public void setShrinkmachine1(List<ShrinkMachineModel> shrinkmachine1) {
		this.shrinkmachine1 = shrinkmachine1;
	}

	public List<ShrinkMachineModel> getShrinkmachine2() {
		return shrinkmachine2;
	}

	public void setShrinkmachine2(List<ShrinkMachineModel> shrinkmachine2) {
		this.shrinkmachine2 = shrinkmachine2;
	}

	public List<ShrinkMachineModel> getShrinkmachine3() {
		return shrinkmachine3;
	}

	public void setShrinkmachine3(List<ShrinkMachineModel> shrinkmachine3) {
		this.shrinkmachine3 = shrinkmachine3;
	}

	public String insert_shrinkMachineMaster()	
	{
		String response;
		int i=new ShrinkMachineDAO().insert_shrink_machine(shrinkmachine);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="success";
		}
		return response;
	}
	
	public String fetchShrinkMachineMaster()
	{
		String response;
		shrinkmachine3=new ShrinkMachineDAO().fetchShrinkMachineMaster2(shrinkmachine);
		shrinkmachine2=new ShrinkMachineDAO().fetchShrinkMachineMaster1(shrinkmachine);
		shrinkmachine1=new ShrinkMachineDAO().fetchShrinkMachineMaster(shrinkmachine);
		if(shrinkmachine1.size()>0)
		{
			response="success";
		}
		else
		{
			response="success";
		}
		return response;
	}
	
	public String fetchForUpdate()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrinkId=request.getParameter("shrink_id");
		
		shrinkmachine4=new ShrinkMachineDAO().fetchShrinkMachineMaster4(shrinkmachine,shrinkId);
		shrinkmachine5=new ShrinkMachineDAO().fetchShrinkMachineMaster5(shrinkmachine,shrinkId);
		shrinkmachine6=new ShrinkMachineDAO().fetchShrinkMachineMaster6(shrinkmachine,shrinkId);
		
		if(shrinkmachine4.size()>0)
		{
			response="success";
		}
		else
		{
			response="success";
		}
		return response;
	}
	
	public String updateShrinkMC()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrinkId=request.getParameter("update_shrink_id");
		
		int i=new ShrinkMachineDAO().updateShrinkMC(shrinkmachine,shrinkId);
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="success";
		}
		return response;
	}
	
	public String deleteShrinkMachine()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String shrinkId=request.getParameter("shrink_id");
		
		int i=new ShrinkMachineDAO().deleteShrinkMachine(shrinkmachine,shrinkId);
		
		if(i>0)
		{
			response="success";
		}
		else
		{
			response="success";
		}
		return response;
	}
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return shrinkmachine;
	}

	public ShrinkMachineModel getShrinkmachine() {
		return shrinkmachine;
	}

	public void setShrinkmachine(ShrinkMachineModel shrinkmachine) {
		this.shrinkmachine = shrinkmachine;
	}

}

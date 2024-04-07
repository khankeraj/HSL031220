package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.HotFABMoldingMachineDAO;
import com.quotation.model.HotFABMoldingMachineModel;

public class HotFABMoldingMachine extends ActionSupport implements ModelDriven{

	private HotFABMoldingMachineModel hotfabmoldingmc=new HotFABMoldingMachineModel();
	private List<HotFABMoldingMachineModel> hotfabmolding;
	private List<HotFABMoldingMachineModel> hotfabmolding1;
	private List<HotFABMoldingMachineModel> hotfabmolding2;
	private List<HotFABMoldingMachineModel> hotfabmolding3;
	
	private List<HotFABMoldingMachineModel> hotfabmolding4;
	private List<HotFABMoldingMachineModel> hotfabmolding5;
	private List<HotFABMoldingMachineModel> hotfabmolding6;
	private List<HotFABMoldingMachineModel> hotfabmolding7;
	
	public List<HotFABMoldingMachineModel> getHotfabmolding4() {
		return hotfabmolding4;
	}

	public void setHotfabmolding4(List<HotFABMoldingMachineModel> hotfabmolding4) {
		this.hotfabmolding4 = hotfabmolding4;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding5() {
		return hotfabmolding5;
	}

	public void setHotfabmolding5(List<HotFABMoldingMachineModel> hotfabmolding5) {
		this.hotfabmolding5 = hotfabmolding5;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding6() {
		return hotfabmolding6;
	}

	public void setHotfabmolding6(List<HotFABMoldingMachineModel> hotfabmolding6) {
		this.hotfabmolding6 = hotfabmolding6;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding7() {
		return hotfabmolding7;
	}

	public void setHotfabmolding7(List<HotFABMoldingMachineModel> hotfabmolding7) {
		this.hotfabmolding7 = hotfabmolding7;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding1() {
		return hotfabmolding1;
	}

	public void setHotfabmolding1(List<HotFABMoldingMachineModel> hotfabmolding1) {
		this.hotfabmolding1 = hotfabmolding1;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding2() {
		return hotfabmolding2;
	}

	public void setHotfabmolding2(List<HotFABMoldingMachineModel> hotfabmolding2) {
		this.hotfabmolding2 = hotfabmolding2;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding3() {
		return hotfabmolding3;
	}

	public void setHotfabmolding3(List<HotFABMoldingMachineModel> hotfabmolding3) {
		this.hotfabmolding3 = hotfabmolding3;
	}

	public List<HotFABMoldingMachineModel> getHotfabmolding() {
		return hotfabmolding;
	}

	public void setHotfabmolding(List<HotFABMoldingMachineModel> hotfabmolding) {
		this.hotfabmolding = hotfabmolding;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_hot_fabmoldingmc()
	{
		String response;
		int i=new HotFABMoldingMachineDAO().insert_hot_fab_moldingmc(hotfabmoldingmc);
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
	
	public String fetchHotFABModlingMC()
	{
		String response;
		
		hotfabmolding3=new HotFABMoldingMachineDAO().fetchHotFABModlingMC3(hotfabmoldingmc);
		hotfabmolding2=new HotFABMoldingMachineDAO().fetchHotFABModlingMC2(hotfabmoldingmc);
		hotfabmolding1=new HotFABMoldingMachineDAO().fetchHotFABModlingMC1(hotfabmoldingmc);
		hotfabmolding=new HotFABMoldingMachineDAO().fetchHotFABModlingMC(hotfabmoldingmc);
		
		if(hotfabmolding.size()>0)
		{
			response="success";
		}
		else {
			response="fail";
		}
		return response;
		
	}
	
	public String fetchForUpdateHOTFAVMolding()
	{ 
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String hotfabmolding_id=request.getParameter("hotfabmolding_id");
		
		hotfabmolding4=new HotFABMoldingMachineDAO().fetchHotFABModlingMC4(hotfabmoldingmc,hotfabmolding_id);
		hotfabmolding5=new HotFABMoldingMachineDAO().fetchHotFABModlingMC5(hotfabmoldingmc,hotfabmolding_id);
		hotfabmolding6=new HotFABMoldingMachineDAO().fetchHotFABModlingMC6(hotfabmoldingmc,hotfabmolding_id);
		hotfabmolding7=new HotFABMoldingMachineDAO().fetchHotFABModlingMC7(hotfabmoldingmc,hotfabmolding_id);
		
		if(hotfabmolding4.size()>0)
		{
			response="success";
		}
		else {
			response="fail";
		}
		return response;
		
		
	}
	
	public String updateHOTFABMoldingMc()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String hotfabmolding_id=request.getParameter("update_hotfabmolding_id");
		int i=new HotFABMoldingMachineDAO().updateHOTFABMoldingMc(hotfabmoldingmc,hotfabmolding_id);
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
	
	public String deleteHOTFABMoldingmc()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String hotfabmolding_id=request.getParameter("hotfabmolding_id");
		
		int i=new HotFABMoldingMachineDAO().deleteHOTFABMoldingmc(hotfabmoldingmc,hotfabmolding_id);
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
		return hotfabmoldingmc;
	}

	public HotFABMoldingMachineModel getHotfabmoldingmc() {
		return hotfabmoldingmc;
	}

	public void setHotfabmoldingmc(HotFABMoldingMachineModel hotfabmoldingmc) {
		this.hotfabmoldingmc = hotfabmoldingmc;
	}

}

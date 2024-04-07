package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FABLabellingMachineDAO;
import com.quotation.model.FABLabellingMachineModel;

public class FABLabellingMachineAction extends ActionSupport implements ModelDriven {
	
	private FABLabellingMachineModel FABLabellingMachine=new FABLabellingMachineModel();
	
	private List<FABLabellingMachineModel> fablabelingmc1;
	private List<FABLabellingMachineModel> fablabelingmc2;
	private List<FABLabellingMachineModel> fablabelingmc3;
	
	private List<FABLabellingMachineModel> fablabelingmc4;
	private List<FABLabellingMachineModel> fablabelingmc5;
	private List<FABLabellingMachineModel> fablabelingmc6;
	
	public List<FABLabellingMachineModel> getFablabelingmc4() {
		return fablabelingmc4;
	}

	public void setFablabelingmc4(List<FABLabellingMachineModel> fablabelingmc4) {
		this.fablabelingmc4 = fablabelingmc4;
	}

	public List<FABLabellingMachineModel> getFablabelingmc5() {
		return fablabelingmc5;
	}

	public void setFablabelingmc5(List<FABLabellingMachineModel> fablabelingmc5) {
		this.fablabelingmc5 = fablabelingmc5;
	}

	public List<FABLabellingMachineModel> getFablabelingmc6() {
		return fablabelingmc6;
	}

	public void setFablabelingmc6(List<FABLabellingMachineModel> fablabelingmc6) {
		this.fablabelingmc6 = fablabelingmc6;
	}

	public List<FABLabellingMachineModel> getFablabelingmc1() {
		return fablabelingmc1;
	}

	public void setFablabelingmc1(List<FABLabellingMachineModel> fablabelingmc1) {
		this.fablabelingmc1 = fablabelingmc1;
	}

	public List<FABLabellingMachineModel> getFablabelingmc2() {
		return fablabelingmc2;
	}

	public void setFablabelingmc2(List<FABLabellingMachineModel> fablabelingmc2) {
		this.fablabelingmc2 = fablabelingmc2;
	}

	public List<FABLabellingMachineModel> getFablabelingmc3() {
		return fablabelingmc3;
	}

	public void setFablabelingmc3(List<FABLabellingMachineModel> fablabelingmc3) {
		this.fablabelingmc3 = fablabelingmc3;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_FABLabellingMachine()
	{
		String response;
		int i=new FABLabellingMachineDAO().insert_FABLabellingMachine(FABLabellingMachine);
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
	
	public String fetchFabLabelingMC()
	{
		String response;
		fablabelingmc3=new FABLabellingMachineDAO().fetchFabLabelingMC2(FABLabellingMachine);
		fablabelingmc2=new FABLabellingMachineDAO().fetchFabLabelingMC1(FABLabellingMachine);
		fablabelingmc1=new FABLabellingMachineDAO().fetchFabLabelingMC(FABLabellingMachine);
		
		System.out.println("max Size:"+fablabelingmc1.size());
		
		if(fablabelingmc1.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return response;
	}
	
	public String fetchFABLabelingForUpdate()
	{
		String response;
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String fablabeling=request.getParameter("labeling_id");
	
		fablabelingmc4=new FABLabellingMachineDAO().fetchFabLabelingMC4(FABLabellingMachine,fablabeling);
		fablabelingmc5=new FABLabellingMachineDAO().fetchFabLabelingMC5(FABLabellingMachine,fablabeling);
		fablabelingmc6=new FABLabellingMachineDAO().fetchFabLabelingMC6(FABLabellingMachine,fablabeling);
		
		if(fablabelingmc4.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
			
		
	}
	
	public String updateFABLabelingMC()
	{
		String response;
	
		HttpServletRequest request = ServletActionContext.getRequest();
		String fablabeling=request.getParameter("update_fablabelingId");
		
		int i=new FABLabellingMachineDAO().updateFABLabelingMC(FABLabellingMachine,fablabeling);
		
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
	
	public String deleteFABLabelingmc()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String delete_id=request.getParameter("labeling_id");
		
		int i=new FABLabellingMachineDAO().deleteFABLabelingmc(FABLabellingMachine,delete_id);
		
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
		return FABLabellingMachine;
	}



	public FABLabellingMachineModel getFABLabellingMachine() {
		return FABLabellingMachine;
	}



	public void setFABLabellingMachine(FABLabellingMachineModel fABLabellingMachine) {
		FABLabellingMachine = fABLabellingMachine;
	}

}

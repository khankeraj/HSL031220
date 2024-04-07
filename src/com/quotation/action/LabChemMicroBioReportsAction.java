package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.LabChemMicroBioREportsDAO;
import com.quotation.model.LabChemMicroBioReportsModel;

public class LabChemMicroBioReportsAction extends ActionSupport implements ModelDriven{

	private LabChemMicroBioReportsModel lab=new LabChemMicroBioReportsModel();
	private List<LabChemMicroBioReportsModel> labList;
	
	public LabChemMicroBioReportsModel getLab() {
		return lab;
	}


	public void setLab(LabChemMicroBioReportsModel lab) {
		this.lab = lab;
	}


	public List<LabChemMicroBioReportsModel> getLabList() {
		return labList;
	}


	public void setLabList(List<LabChemMicroBioReportsModel> labList) {
		this.labList = labList;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchLabChemicalMicrobiology()
	{
		String response;
		labList=new LabChemMicroBioREportsDAO().fetchLabChemicalMicrobiology(lab);
		if(labList.size()>0)
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
		return null;
	}

}

package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.LabChemMicroBioDAO;
import com.quotation.model.LabChemMicroBioModel;

public class LabChemMicroBioAction extends ActionSupport implements ModelDriven{

	private LabChemMicroBioModel labChemicalMicro=new LabChemMicroBioModel();
	
	private List<LabChemMicroBioModel> labchemicalbiology;
	private List<LabChemMicroBioModel> labchemicalbiology1;
	private List<LabChemMicroBioModel> labchemicalbiology2;
	private List<LabChemMicroBioModel> labchemicalbiology3;
	private List<LabChemMicroBioModel> labchemicalbiology4;
	private List<LabChemMicroBioModel> labchemicalbiology5;
	
	private List<LabChemMicroBioModel> labchemicalbiology6;
	private List<LabChemMicroBioModel> labchemicalbiology7;
	private List<LabChemMicroBioModel> labchemicalbiology8;
	private List<LabChemMicroBioModel> labchemicalbiology9;
	private List<LabChemMicroBioModel> labchemicalbiology10;
	private List<LabChemMicroBioModel> labchemicalbiology11;
	
	public List<LabChemMicroBioModel> getLabchemicalbiology6() {
		return labchemicalbiology6;
	}

	public void setLabchemicalbiology6(List<LabChemMicroBioModel> labchemicalbiology6) {
		this.labchemicalbiology6 = labchemicalbiology6;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology7() {
		return labchemicalbiology7;
	}

	public void setLabchemicalbiology7(List<LabChemMicroBioModel> labchemicalbiology7) {
		this.labchemicalbiology7 = labchemicalbiology7;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology8() {
		return labchemicalbiology8;
	}

	public void setLabchemicalbiology8(List<LabChemMicroBioModel> labchemicalbiology8) {
		this.labchemicalbiology8 = labchemicalbiology8;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology9() {
		return labchemicalbiology9;
	}

	public void setLabchemicalbiology9(List<LabChemMicroBioModel> labchemicalbiology9) {
		this.labchemicalbiology9 = labchemicalbiology9;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology10() {
		return labchemicalbiology10;
	}

	public void setLabchemicalbiology10(List<LabChemMicroBioModel> labchemicalbiology10) {
		this.labchemicalbiology10 = labchemicalbiology10;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology11() {
		return labchemicalbiology11;
	}

	public void setLabchemicalbiology11(List<LabChemMicroBioModel> labchemicalbiology11) {
		this.labchemicalbiology11 = labchemicalbiology11;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology() {
		return labchemicalbiology;
	}

	public void setLabchemicalbiology(List<LabChemMicroBioModel> labchemicalbiology) {
		this.labchemicalbiology = labchemicalbiology;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology1() {
		return labchemicalbiology1;
	}

	public void setLabchemicalbiology1(List<LabChemMicroBioModel> labchemicalbiology1) {
		this.labchemicalbiology1 = labchemicalbiology1;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology2() {
		return labchemicalbiology2;
	}

	public void setLabchemicalbiology2(List<LabChemMicroBioModel> labchemicalbiology2) {
		this.labchemicalbiology2 = labchemicalbiology2;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology3() {
		return labchemicalbiology3;
	}

	public void setLabchemicalbiology3(List<LabChemMicroBioModel> labchemicalbiology3) {
		this.labchemicalbiology3 = labchemicalbiology3;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology4() {
		return labchemicalbiology4;
	}

	public void setLabchemicalbiology4(List<LabChemMicroBioModel> labchemicalbiology4) {
		this.labchemicalbiology4 = labchemicalbiology4;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_lab_chemical_microbiology()
	{
		String response;
		int i=new LabChemMicroBioDAO().insert_lab_chemical_microbiology(labChemicalMicro);
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
	
	public String fetchLab_chemical_microbiology()
	{
		String response;
		labchemicalbiology5=new LabChemMicroBioDAO().fetchLab_chemical_microbiology5(labChemicalMicro);
		labchemicalbiology4=new LabChemMicroBioDAO().fetchLab_chemical_microbiology4(labChemicalMicro);
		labchemicalbiology3=new LabChemMicroBioDAO().fetchLab_chemical_microbiology3(labChemicalMicro);
		labchemicalbiology2=new LabChemMicroBioDAO().fetchLab_chemical_microbiology2(labChemicalMicro);
		labchemicalbiology1=new LabChemMicroBioDAO().fetchLab_chemical_microbiology1(labChemicalMicro);
		labchemicalbiology=new LabChemMicroBioDAO().fetchLab_chemical_microbiology(labChemicalMicro);
		if(labchemicalbiology.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateLCMDetails()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lcmid=request.getParameter("update_lcm_id");
		
		int i=new LabChemMicroBioDAO().updateLCMDetails(labChemicalMicro,lcmid);
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
	
	public String fetchForUpdate()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lcmid=request.getParameter("updatelcm_id");
		
		labchemicalbiology6=new LabChemMicroBioDAO().fetchLab_chemical_microbiology6(labChemicalMicro,lcmid);
		labchemicalbiology7=new LabChemMicroBioDAO().fetchLab_chemical_microbiology71(labChemicalMicro,lcmid);
		labchemicalbiology8=new LabChemMicroBioDAO().fetchLab_chemical_microbiology8(labChemicalMicro,lcmid);
		labchemicalbiology9=new LabChemMicroBioDAO().fetchLab_chemical_microbiology9(labChemicalMicro,lcmid);
		labchemicalbiology10=new LabChemMicroBioDAO().fetchLab_chemical_microbiology10(labChemicalMicro,lcmid);
		labchemicalbiology11=new LabChemMicroBioDAO().fetchLab_chemical_microbiology11(labChemicalMicro,lcmid);
		
		if(labchemicalbiology6.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String deleteLCMDetails()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String lcmid=request.getParameter("updatelcm_id");
		int i=new LabChemMicroBioDAO().deleteLCMDetails(labChemicalMicro,lcmid);
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
		return labChemicalMicro;
	}


	public LabChemMicroBioModel getLabChemicalMicro() {
		return labChemicalMicro;
	}


	public void setLabChemicalMicro(LabChemMicroBioModel labChemicalMicro) {
		this.labChemicalMicro = labChemicalMicro;
	}

	public List<LabChemMicroBioModel> getLabchemicalbiology5() {
		return labchemicalbiology5;
	}

	public void setLabchemicalbiology5(List<LabChemMicroBioModel> labchemicalbiology5) {
		this.labchemicalbiology5 = labchemicalbiology5;
	}

}

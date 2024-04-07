package com.master.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

//import com.aqua.Constants.Constants;
//import com.aqua.dao.LR.LR_Dao;
//import com.aqua.model.LoginBean;
//import com.aqua.model.Purchase_Order_bean1;
//import com.aqua.model.Purchase_Order_bean1;
import com.master.dao.MAterialReceivedDAO;
import com.master.model.MaterialReceivedModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class MaterialReceivedAction extends ActionSupport implements ModelDriven {

	private MaterialReceivedModel materialReceived=new MaterialReceivedModel();
	private MaterialReceivedModel mrm;
	public MaterialReceivedModel getMrm() {
		return mrm;
	}
	public void setMrm(MaterialReceivedModel mrm) {
		this.mrm = mrm;
	}
	List<MaterialReceivedModel> material_Received_model123=new ArrayList<MaterialReceivedModel>();
	
	public List<MaterialReceivedModel> getMaterial_Received_model123() {
		return material_Received_model123;
	}
	public void setMaterial_Received_model123(List<MaterialReceivedModel> material_Received_model123) {
		this.material_Received_model123 = material_Received_model123;
	}
	private String po;
	
	public String getPo() {
		return po;
	}
	public void setPo(String po) {
		this.po = po;
	}
	
	
	public MaterialReceivedModel getMaterialReceived() {
		return materialReceived;
	}
	public void setMaterialReceived(MaterialReceivedModel materialReceived) {
		this.materialReceived = materialReceived;
	}
	public String execute()
	{
		return "success";
	}
	
	public String insert_material_received_details()
	{
		String response;
		
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		String pono = request.getParameter("purchase_po_no");
		
		
		material_Received_model123=new MAterialReceivedDAO().insert_material_details(pono,materialReceived);
		//System.out.println(material_Received_model123.get(0).getMaterial_code1());
//		if(i>0)
//		{
//			response="success";
//		}
//		else
//		{
//			response="fail";
//		}
//		return response;
		po=pono;
		return "success";
	}
	
	
	public String materialinsert() throws SQLException {
		
		
//		Map session = ActionContext.getContext().getSession();
//		LoginBean bean = new LoginBean();
//		bean = (LoginBean) session.get(Constants.USER_PROFILE);
//		HttpServletRequest request = (HttpServletRequest) ActionContext
//				.getContext().get(ServletActionContext.HTTP_REQUEST);
//		String pono = request.getParameter("pono");
		String status = new MAterialReceivedDAO().insertMaterialDetails(mrm);

		if (status.equals("success")) {
			return "success";
		} else if (status.equals("Already")) {
			return "Already";
		} else {
			return "error";
			
		}
	}

	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return materialReceived;
	}

}

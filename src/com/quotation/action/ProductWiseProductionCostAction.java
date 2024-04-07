package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.ProductWiseProductionCostDAO;
import com.quotation.model.ProductWiseProductionCostModel;

public class ProductWiseProductionCostAction extends ActionSupport implements ModelDriven {

	private ProductWiseProductionCostModel productWiseProduction=new ProductWiseProductionCostModel();
	private List<ProductWiseProductionCostModel> pwpc;
	private List<ProductWiseProductionCostModel> pwpc1;
	private List<ProductWiseProductionCostModel> pwpc2;
	
	private List<ProductWiseProductionCostModel> pwpc3;
	private List<ProductWiseProductionCostModel> pwpc4;
	private List<ProductWiseProductionCostModel> pwpc5;
	
	public List<ProductWiseProductionCostModel> getPwpc3() {
		return pwpc3;
	}

	public void setPwpc3(List<ProductWiseProductionCostModel> pwpc3) {
		this.pwpc3 = pwpc3;
	}

	public List<ProductWiseProductionCostModel> getPwpc4() {
		return pwpc4;
	}

	public void setPwpc4(List<ProductWiseProductionCostModel> pwpc4) {
		this.pwpc4 = pwpc4;
	}

	public List<ProductWiseProductionCostModel> getPwpc5() {
		return pwpc5;
	}

	public void setPwpc5(List<ProductWiseProductionCostModel> pwpc5) {
		this.pwpc5 = pwpc5;
	}

	public List<ProductWiseProductionCostModel> getPwpc() {
		return pwpc;
	}

	public void setPwpc(List<ProductWiseProductionCostModel> pwpc) {
		this.pwpc = pwpc;
	}

	public List<ProductWiseProductionCostModel> getPwpc1() {
		return pwpc1;
	}

	public void setPwpc1(List<ProductWiseProductionCostModel> pwpc1) {
		this.pwpc1 = pwpc1;
	}

	public List<ProductWiseProductionCostModel> getPwpc2() {
		return pwpc2;
	}

	public void setPwpc2(List<ProductWiseProductionCostModel> pwpc2) {
		this.pwpc2 = pwpc2;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_productWiseProductions()
	{
		String response;
		int i=new ProductWiseProductionCostDAO().insert_productWiseProductions(productWiseProduction);
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
	
	public String fetchProductWiseProductionCost()
	{
		String response;
		pwpc2=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost2(productWiseProduction);
		pwpc1=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost1(productWiseProduction);
		pwpc=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost(productWiseProduction);
		if(pwpc.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdatePWPC()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String pwpc_id=request.getParameter("pwpc_id");

		pwpc3=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost3(productWiseProduction,pwpc_id);
		pwpc4=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost4(productWiseProduction,pwpc_id);
		pwpc5=new ProductWiseProductionCostDAO().fetchProductWiseProductionCost5(productWiseProduction,pwpc_id);
		
		if(pwpc3.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updatePWPC()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String pwpc_id=request.getParameter("update_PWPC");
		
		int i=new ProductWiseProductionCostDAO().updatePWPC(productWiseProduction,pwpc_id);
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
	
	public String DeletePWPC()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String pwpc_id=request.getParameter("pwpc_id");
		
		int i=new ProductWiseProductionCostDAO().DeletePWPC(productWiseProduction,pwpc_id);
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
		return productWiseProduction;
	}


	public ProductWiseProductionCostModel getProductWiseProduction() {
		return productWiseProduction;
	}


	public void setProductWiseProduction(ProductWiseProductionCostModel productWiseProduction) {
		this.productWiseProduction = productWiseProduction;
	}

}

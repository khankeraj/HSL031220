package com.master.action;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.master.dao.ItemMasterDAO;
import com.master.dao.TaxMasterDAO;
import com.master.model.ItemMasterModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ItemMasterAction extends ActionSupport implements ModelDriven{
	
	private ItemMasterModel itemmaster=new ItemMasterModel();
	private String tax_percentages;
	private List<ItemMasterModel> fetchfetchitemReports;
	private String fetchItemDetails;
	
	public String getFetchItemDetails() {
		return fetchItemDetails;
	}

	public void setFetchItemDetails(String fetchItemDetails) {
		this.fetchItemDetails = fetchItemDetails;
	}

	public List<ItemMasterModel> getFetchfetchitemReports() {
		return fetchfetchitemReports;
	}

	public void setFetchfetchitemReports(List<ItemMasterModel> fetchfetchitemReports) {
		this.fetchfetchitemReports = fetchfetchitemReports;
	}

	public String getTax_percentages() {
		return tax_percentages;
	}

	public void setTax_percentages(String tax_percentages) {
		this.tax_percentages = tax_percentages;
	}

	public ItemMasterModel getItemmaster() {
		return itemmaster;
	}

	public void setItemmaster(ItemMasterModel itemmaster) {
		this.itemmaster = itemmaster;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_item_master()
	{
		String response;
		int i=new ItemMasterDAO().insert_item_master(itemmaster);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		
		return response;
	}
	
	public String fetchTaxPercentage()
	{
		System.out.println("hiiii");
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String hsncode=request.getParameter("hsncode");
		System.out.println("hsnCode:"+hsncode);
		
		tax_percentages=new ItemMasterDAO().fetchTaxPercentage(itemmaster,hsncode);
		
		System.out.println("tax in action:"+tax_percentages);
		
		return "success";
	}
	
	public String fetchItemReports()
	{
		String response;
		fetchfetchitemReports=new ItemMasterDAO().fetchReports(itemmaster);
		
		if(fetchfetchitemReports.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String fetchItemDetails()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String item_name=request.getParameter("item_name");
		fetchItemDetails=new ItemMasterDAO().fetchItemDetails(itemmaster,item_name);
		return "success";
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return itemmaster;
	}
	
}

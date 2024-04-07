package com.master.action;
import com.master.dao.StockDAO;
import com.master.model.StockModel;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StockAction extends ActionSupport implements ModelDriven{

	List<StockModel> stockReport = new ArrayList<StockModel>();
	List<StockModel> stockmodel = new ArrayList<StockModel>();
	
	
	public List<StockModel> getStockReport() {
		return stockReport;
	}


	public void setStockReport(List<StockModel> stockReport) {
		this.stockReport = stockReport;
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String stock_report()
	{
		String response = "";
		//stockReport = new StockDAO.stockreport(stockmodel);
		stockReport = new StockDAO().stock_report(stockmodel);
		if(stockReport.size()>0)
		{
			response = "success";
		}
		else
		{
			response = "fail";
		}
		return response;
	}
	
	
}
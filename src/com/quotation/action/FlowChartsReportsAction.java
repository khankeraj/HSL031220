package com.quotation.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FlowChartsReportsDAO;
import com.quotation.model.FlowChartsReportsModel;

public class FlowChartsReportsAction extends ActionSupport implements ModelDriven{

	private FlowChartsReportsModel flowchartrepo=new FlowChartsReportsModel();
	private List<FlowChartsReportsModel> flowcharts;
	
	
	
	public FlowChartsReportsModel getFlowchartrepo() {
		return flowchartrepo;
	}



	public void setFlowchartrepo(FlowChartsReportsModel flowchartrepo) {
		this.flowchartrepo = flowchartrepo;
	}



	public List<FlowChartsReportsModel> getFlowcharts() {
		return flowcharts;
	}



	public void setFlowcharts(List<FlowChartsReportsModel> flowcharts) {
		this.flowcharts = flowcharts;
	}

	public String execute()
	{
		return "success";
	}
	
	public String fetchFlowchartsReports()
	{
		String response;
		flowcharts=new FlowChartsReportsDAO().fetchFlowchartsReports(flowcharts);
		if(flowcharts.size()>0)
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
		return flowchartrepo;
	}

}

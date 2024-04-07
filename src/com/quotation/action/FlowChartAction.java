package com.quotation.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.FlowChartDAO;
import com.quotation.model.FlowChartModel;

public class FlowChartAction extends ActionSupport implements ModelDriven {

	private FlowChartModel flowChart=new FlowChartModel();
	private List<FlowChartModel> flowChart1;
	private List<FlowChartModel> flowChart2;
	
	public List<FlowChartModel> getFlowChart2() {
		return flowChart2;
	}

	public void setFlowChart2(List<FlowChartModel> flowChart2) {
		this.flowChart2 = flowChart2;
	}

	public String execute()
	{
		return "success";
	}
	
	public String insert_flowChart_details()
	{
		String response;
		int i=new FlowChartDAO().insert_flowChart_details(flowChart);
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
	
	public String fetchFlowChartDetails()
	{
		String response;
		flowChart1=new FlowChartModel().fetchFlowChartDetails(flowChart);
		System.out.println("flowchart:"+flowChart1.size());
		if(flowChart1.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdate()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String flowcharts_id=request.getParameter("flowCharts_id");
		
		flowChart2=new FlowChartModel().fetchForUpdate(flowChart,flowcharts_id);
		if(flowChart2.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateFlowCharts()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String flowcharts_id=request.getParameter("update_flowCharts");
		
		int i=new FlowChartModel().updateFlowCharts(flowChart,flowcharts_id);
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
	
	public String deleteFlowCharts()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String flowcharts_id=request.getParameter("flowCharts_id");
		
		int i=new FlowChartModel().deleteFlowCharts(flowChart,flowcharts_id);
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
		return flowChart;
	}

	public FlowChartModel getFlowChart() {
		return flowChart;
	}

	public void setFlowChart(FlowChartModel flowChart) {
		this.flowChart = flowChart;
	}

	public List<FlowChartModel> getFlowChart1() {
		return flowChart1;
	}

	public void setFlowChart1(List<FlowChartModel> flowChart1) {
		this.flowChart1 = flowChart1;
	}

}

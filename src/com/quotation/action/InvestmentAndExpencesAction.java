package com.quotation.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.master.model.ContractModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.InvestmentAndExpencesDAO;
import com.quotation.dao.QuotationViewDAO;
import com.quotation.dao.SubmitQuotationDAO;
import com.quotation.model.AutocasePackerModel;
import com.quotation.model.FABLabellingMachineModel;
import com.quotation.model.FABRFCModel;
import com.quotation.model.FlowChartModel;
import com.quotation.model.HighPressureCompressorModel;
import com.quotation.model.HotFABMoldingMachineModel;
import com.quotation.model.InvestmentAndExpencesModel;
import com.quotation.model.LabChemMicroBioModel;
import com.quotation.model.LowPressureCompressorModel;
import com.quotation.model.ProductWiseProductionCostModel;
import com.quotation.model.QuotationIndexModel;
import com.quotation.model.ROWaterTPModel;
import com.quotation.model.ShrinkMachineModel;
import com.quotation.model.SubmitQuotationModel;
import com.quotation.model.TermsAndConditionsModel;

public class InvestmentAndExpencesAction extends ActionSupport implements ModelDriven{
	
	
	//for fetching quotation Reports....at insert time
	
	private InvestmentAndExpencesModel investAndExpences1=new InvestmentAndExpencesModel();
	private SubmitQuotationModel submitQuotationName=new SubmitQuotationModel();
	
	private ROWaterTPModel rowater=new ROWaterTPModel();
	
	public ROWaterTPModel getRowater() {
		return rowater;
	}

	public void setRowater(ROWaterTPModel rowater) {
		this.rowater = rowater;
	}

	private ContractModel contractmodel=new ContractModel();
	
	private QuotationIndexModel quotationIndex1=new QuotationIndexModel();
	
	private FABRFCModel fabrfc=new FABRFCModel();
	
	private FABLabellingMachineModel fablabelingmc=new FABLabellingMachineModel();
	
	private HotFABMoldingMachineModel hotfabmoldingmc1=new HotFABMoldingMachineModel();
	
	private HighPressureCompressorModel hpcmodel=new HighPressureCompressorModel();
	
	private LowPressureCompressorModel lpcmodel=new LowPressureCompressorModel();
	
	private ShrinkMachineModel shrinkmodal=new ShrinkMachineModel();
	
	private AutocasePackerModel autocasepacker1=new AutocasePackerModel();
	
	private LabChemMicroBioModel labchemnio=new LabChemMicroBioModel();
	
	private InvestmentAndExpencesModel investexpenses=new InvestmentAndExpencesModel();
	
	private TermsAndConditionsModel termsConditions1=new TermsAndConditionsModel();
	
	private ProductWiseProductionCostModel pwpc1=new ProductWiseProductionCostModel();
	
	private FlowChartModel flowchartmodal=new FlowChartModel();

	private InvestmentAndExpencesModel investAndExpences=new InvestmentAndExpencesModel();
	private QuotationIndexModel quotationIndex=new QuotationIndexModel();
	
	public QuotationIndexModel getQuotationIndex() {
		return quotationIndex1;
	}

	public void setQuotationIndex(QuotationIndexModel quotationIndex) {
		this.quotationIndex1 = quotationIndex;
	}
	
	private List<InvestmentAndExpencesModel> investmentExp;
	private List<InvestmentAndExpencesModel> investmentExp1;
	private List<InvestmentAndExpencesModel> investmentExp2;
	private List<InvestmentAndExpencesModel> investmentExp3;
	
	
	//for quotation reports /......................
	
private List<ContractModel>  coverDetails;
	
	private List<ContractModel> contractDetails;
	
	private List<QuotationIndexModel> quotationIndexList;
	
	private List<QuotationIndexModel> quotationIndexSublist;
	
	private List<ROWaterTPModel> romaster;
	
	private List<ROWaterTPModel> roparts1;
	
	private List<ROWaterTPModel> rotechspecifications;
	
	private List<FABRFCModel> fabrfclist;
	
	private List<FABLabellingMachineModel> fablabelinglist;
	
	private List<HotFABMoldingMachineModel> hotfabmoldingmc;
	
	private List<HighPressureCompressorModel> hpc;
	private List<LowPressureCompressorModel> lpc;
	
	private List<LowPressureCompressorModel> lpcList;
	
	private List<ShrinkMachineModel> shrinkmodel;
	
	private List<AutocasePackerModel> autocasepacker;
	
	private List<LabChemMicroBioModel> labchembio;
	
	private List<LabChemMicroBioModel> labchemglass;
	
	private List<LabChemMicroBioModel> labchemchem;
	
	private List<LabChemMicroBioModel> labchemchem3;
	
	private List<LabChemMicroBioModel> labchemchem4;
	
	private List<InvestmentAndExpencesModel> investmentAndExp;
	
	private List<TermsAndConditionsModel> termsConditions11;
	
	private List<ProductWiseProductionCostModel> pwpc;
	
	private List<FlowChartModel> flowcharts;
	
	
	public InvestmentAndExpencesModel getInvestAndExpences1() {
		return investAndExpences1;
	}

	public void setInvestAndExpences1(InvestmentAndExpencesModel investAndExpences1) {
		this.investAndExpences1 = investAndExpences1;
	}

	public SubmitQuotationModel getSubmitQuotationName() {
		return submitQuotationName;
	}

	public void setSubmitQuotationName(SubmitQuotationModel submitQuotationName) {
		this.submitQuotationName = submitQuotationName;
	}

	public ContractModel getContractmodel() {
		return contractmodel;
	}

	public void setContractmodel(ContractModel contractmodel) {
		this.contractmodel = contractmodel;
	}

	public QuotationIndexModel getQuotationIndex1() {
		return quotationIndex1;
	}

	public void setQuotationIndex1(QuotationIndexModel quotationIndex1) {
		this.quotationIndex1 = quotationIndex1;
	}

	public FABRFCModel getFabrfc() {
		return fabrfc;
	}

	public void setFabrfc(FABRFCModel fabrfc) {
		this.fabrfc = fabrfc;
	}

	public FABLabellingMachineModel getFablabelingmc() {
		return fablabelingmc;
	}

	public void setFablabelingmc(FABLabellingMachineModel fablabelingmc) {
		this.fablabelingmc = fablabelingmc;
	}

	public HotFABMoldingMachineModel getHotfabmoldingmc1() {
		return hotfabmoldingmc1;
	}

	public void setHotfabmoldingmc1(HotFABMoldingMachineModel hotfabmoldingmc1) {
		this.hotfabmoldingmc1 = hotfabmoldingmc1;
	}

	public HighPressureCompressorModel getHpcmodel() {
		return hpcmodel;
	}

	public void setHpcmodel(HighPressureCompressorModel hpcmodel) {
		this.hpcmodel = hpcmodel;
	}

	public LowPressureCompressorModel getLpcmodel() {
		return lpcmodel;
	}

	public void setLpcmodel(LowPressureCompressorModel lpcmodel) {
		this.lpcmodel = lpcmodel;
	}

	public ShrinkMachineModel getShrinkmodal() {
		return shrinkmodal;
	}

	public void setShrinkmodal(ShrinkMachineModel shrinkmodal) {
		this.shrinkmodal = shrinkmodal;
	}

	public AutocasePackerModel getAutocasepacker1() {
		return autocasepacker1;
	}

	public void setAutocasepacker1(AutocasePackerModel autocasepacker1) {
		this.autocasepacker1 = autocasepacker1;
	}

	public LabChemMicroBioModel getLabchemnio() {
		return labchemnio;
	}

	public void setLabchemnio(LabChemMicroBioModel labchemnio) {
		this.labchemnio = labchemnio;
	}

	public InvestmentAndExpencesModel getInvestexpenses() {
		return investexpenses;
	}

	public void setInvestexpenses(InvestmentAndExpencesModel investexpenses) {
		this.investexpenses = investexpenses;
	}

	public TermsAndConditionsModel getTermsConditions1() {
		return termsConditions1;
	}

	public void setTermsConditions1(TermsAndConditionsModel termsConditions1) {
		this.termsConditions1 = termsConditions1;
	}

	public ProductWiseProductionCostModel getPwpc1() {
		return pwpc1;
	}

	public void setPwpc1(ProductWiseProductionCostModel pwpc1) {
		this.pwpc1 = pwpc1;
	}

	public FlowChartModel getFlowchartmodal() {
		return flowchartmodal;
	}

	public void setFlowchartmodal(FlowChartModel flowchartmodal) {
		this.flowchartmodal = flowchartmodal;
	}

	public List<ContractModel> getCoverDetails() {
		return coverDetails;
	}

	public void setCoverDetails(List<ContractModel> coverDetails) {
		this.coverDetails = coverDetails;
	}

	public List<ContractModel> getContractDetails() {
		return contractDetails;
	}

	public void setContractDetails(List<ContractModel> contractDetails) {
		this.contractDetails = contractDetails;
	}

	public List<QuotationIndexModel> getQuotationIndexList() {
		return quotationIndexList;
	}

	public void setQuotationIndexList(List<QuotationIndexModel> quotationIndexList) {
		this.quotationIndexList = quotationIndexList;
	}

	public List<QuotationIndexModel> getQuotationIndexSublist() {
		return quotationIndexSublist;
	}

	public void setQuotationIndexSublist(List<QuotationIndexModel> quotationIndexSublist) {
		this.quotationIndexSublist = quotationIndexSublist;
	}

	public List<ROWaterTPModel> getRomaster() {
		return romaster;
	}

	public void setRomaster(List<ROWaterTPModel> romaster) {
		this.romaster = romaster;
	}

	public List<ROWaterTPModel> getRoparts1() {
		return roparts1;
	}

	public void setRoparts1(List<ROWaterTPModel> roparts1) {
		this.roparts1 = roparts1;
	}

	public List<ROWaterTPModel> getRotechspecifications() {
		return rotechspecifications;
	}

	public void setRotechspecifications(List<ROWaterTPModel> rotechspecifications) {
		this.rotechspecifications = rotechspecifications;
	}

	public List<FABRFCModel> getFabrfclist() {
		return fabrfclist;
	}

	public void setFabrfclist(List<FABRFCModel> fabrfclist) {
		this.fabrfclist = fabrfclist;
	}

	public List<FABLabellingMachineModel> getFablabelinglist() {
		return fablabelinglist;
	}

	public void setFablabelinglist(List<FABLabellingMachineModel> fablabelinglist) {
		this.fablabelinglist = fablabelinglist;
	}

	public List<HotFABMoldingMachineModel> getHotfabmoldingmc() {
		return hotfabmoldingmc;
	}

	public void setHotfabmoldingmc(List<HotFABMoldingMachineModel> hotfabmoldingmc) {
		this.hotfabmoldingmc = hotfabmoldingmc;
	}

	public List<HighPressureCompressorModel> getHpc() {
		return hpc;
	}

	public void setHpc(List<HighPressureCompressorModel> hpc) {
		this.hpc = hpc;
	}

	public List<LowPressureCompressorModel> getLpc() {
		return lpc;
	}

	public void setLpc(List<LowPressureCompressorModel> lpc) {
		this.lpc = lpc;
	}

	public List<LowPressureCompressorModel> getLpcList() {
		return lpcList;
	}

	public void setLpcList(List<LowPressureCompressorModel> lpcList) {
		this.lpcList = lpcList;
	}

	public List<ShrinkMachineModel> getShrinkmodel() {
		return shrinkmodel;
	}

	public void setShrinkmodel(List<ShrinkMachineModel> shrinkmodel) {
		this.shrinkmodel = shrinkmodel;
	}

	public List<AutocasePackerModel> getAutocasepacker() {
		return autocasepacker;
	}

	public void setAutocasepacker(List<AutocasePackerModel> autocasepacker) {
		this.autocasepacker = autocasepacker;
	}

	public List<LabChemMicroBioModel> getLabchembio() {
		return labchembio;
	}

	public void setLabchembio(List<LabChemMicroBioModel> labchembio) {
		this.labchembio = labchembio;
	}

	public List<LabChemMicroBioModel> getLabchemglass() {
		return labchemglass;
	}

	public void setLabchemglass(List<LabChemMicroBioModel> labchemglass) {
		this.labchemglass = labchemglass;
	}

	public List<LabChemMicroBioModel> getLabchemchem() {
		return labchemchem;
	}

	public void setLabchemchem(List<LabChemMicroBioModel> labchemchem) {
		this.labchemchem = labchemchem;
	}

	public List<LabChemMicroBioModel> getLabchemchem3() {
		return labchemchem3;
	}

	public void setLabchemchem3(List<LabChemMicroBioModel> labchemchem3) {
		this.labchemchem3 = labchemchem3;
	}

	public List<LabChemMicroBioModel> getLabchemchem4() {
		return labchemchem4;
	}

	public void setLabchemchem4(List<LabChemMicroBioModel> labchemchem4) {
		this.labchemchem4 = labchemchem4;
	}

	public List<InvestmentAndExpencesModel> getInvestmentAndExp() {
		return investmentAndExp;
	}

	public void setInvestmentAndExp(List<InvestmentAndExpencesModel> investmentAndExp) {
		this.investmentAndExp = investmentAndExp;
	}

	public List<TermsAndConditionsModel> getTermsConditions11() {
		return termsConditions11;
	}

	public void setTermsConditions11(List<TermsAndConditionsModel> termsConditions11) {
		this.termsConditions11 = termsConditions11;
	}

	public List<ProductWiseProductionCostModel> getPwpc() {
		return pwpc;
	}

	public void setPwpc(List<ProductWiseProductionCostModel> pwpc) {
		this.pwpc = pwpc;
	}

	public List<FlowChartModel> getFlowcharts() {
		return flowcharts;
	}

	public void setFlowcharts(List<FlowChartModel> flowcharts) {
		this.flowcharts = flowcharts;
	}

	public List<InvestmentAndExpencesModel> getInvestmentExp2() {
		return investmentExp2;
	}

	public void setInvestmentExp2(List<InvestmentAndExpencesModel> investmentExp2) {
		this.investmentExp2 = investmentExp2;
	}

	public List<InvestmentAndExpencesModel> getInvestmentExp3() {
		return investmentExp3;
	}

	public void setInvestmentExp3(List<InvestmentAndExpencesModel> investmentExp3) {
		this.investmentExp3 = investmentExp3;
	}

	public List<InvestmentAndExpencesModel> getInvestmentExp1() {
		return investmentExp1;
	}

	public void setInvestmentExp1(List<InvestmentAndExpencesModel> investmentExp1) {
		this.investmentExp1 = investmentExp1;
	}

	public List<InvestmentAndExpencesModel> getInvestmentExp() {
		return investmentExp;
	}

	public void setInvestmentExp(List<InvestmentAndExpencesModel> investmentExp) {
		this.investmentExp = investmentExp;
	}

	public InvestmentAndExpencesModel getInvestAndExpences() {
		return investAndExpences1;
	}

	public void setInvestAndExpences(InvestmentAndExpencesModel investAndExpences) {
		this.investAndExpences1 = investAndExpences;
	}
	
	public String execute()
	{
		return "success";
	}
	
	public String insert_investment_expences()
	{
		String response;
		int max_count=0;
		
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String quotation_name=request.getParameter("getQuotation_name");
		String lead_no=request.getParameter("lead_no");
		String customer_name=request.getParameter("customer_name");
		
		
		int quotation_id=0;
		
		PreparedStatement pst3;
		try {
			pst3 = conn.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet result=pst3.executeQuery();
			if(result.next())
			{
				int id=result.getInt(1);
				quotation_id=id;
				System.out.println("quottaion_id:"+quotation_id);
			}
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		int i=new InvestmentAndExpencesDAO().insertInvestmentAndExp(investAndExpences1,quotation_id,lead_no);
		
		int max_invest_exp_id=0;
		try {
			PreparedStatement pst2=conn.prepareStatement("SELECT MAX(invest_exp_id) FROM investmt_exp_config_master");
			ResultSet rs3=pst2.executeQuery();
			while(rs3.next())
			{
				max_invest_exp_id=rs3.getInt(1);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		PreparedStatement pst1;
		
		try {
			pst1 = conn.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				max_count=rs1.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		coverDetails=new SubmitQuotationDAO().fetchCoverDetails(contractmodel,max_count);
		
		contractDetails=new SubmitQuotationDAO().getContractDetails(contractmodel,max_count);
		
		quotationIndexList=new SubmitQuotationDAO().fetchQuotationIndexList(quotationIndex1,"6000LPH");
		
		
		PreparedStatement pst;
		try {
			
			pst = conn.prepareStatement("SELECT `name_of_index`, `select_quotation` FROM `edit_quotation_index` WHERE `quotation_id`="+max_count+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
		
				String name_of_index=rs.getString(1);
				String select_quotation_name=rs.getString(2);
				
			System.out.println("quottaion:"+name_of_index);
				
			if(name_of_index.equals("RO WATER TREATMENT PLANT")){
				
			romaster=new SubmitQuotationDAO().fetchROMaster(rowater,select_quotation_name);
				
			rotechspecifications=new SubmitQuotationDAO().fetchTechnicalSpecifications(romaster,select_quotation_name);
			}
			if(name_of_index.equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))	{
			
			fabrfclist=new SubmitQuotationDAO().fetchFABRFCDetails(fabrfc,select_quotation_name);
			}
			if(name_of_index.equals("Fully Auto Bottle Labelling Machine"))	{
			fablabelinglist=new SubmitQuotationDAO().fetchFABLabelingDetails(fablabelingmc,select_quotation_name);
			}
			if(name_of_index.equals("Hot Fill Fully Auto Blow Molding Machine"))	{
			hotfabmoldingmc=new SubmitQuotationDAO().fetchhotfabmoldingmc(hotfabmoldingmc1,select_quotation_name);
			}
			if(name_of_index.equals("High Pressure Compressor"))	{
			hpc=new SubmitQuotationDAO().fetchHPCDetails(hpcmodel,select_quotation_name);
			}
			if(name_of_index.equals("Low Pressure Compressor"))	{
			lpc=new SubmitQuotationDAO().fetchlpcDetails(lpcmodel,select_quotation_name);
			lpcList=new SubmitQuotationDAO().fetchLpcSpDetails(lpcmodel,select_quotation_name);
			}
			
			if(name_of_index.equals("SHRINK MACHINE"))	{
			shrinkmodel=new SubmitQuotationDAO().fetchShrinkMCDetails(shrinkmodal,select_quotation_name);
			}
			if(name_of_index.equals("Autocase Packer"))	{
			autocasepacker=new SubmitQuotationDAO().fetchAutocasePAcker(autocasepacker1,select_quotation_name);
			}
			if(name_of_index.equals("Laboratories : Chemical & Microbiology"))	{
			labchembio=new SubmitQuotationDAO().fetchlabchembioDetails(labchemnio,select_quotation_name);
			
			labchemglass=new SubmitQuotationDAO().fetchlabchembioDetails1(labchemnio,select_quotation_name);
			
			labchemchem=new SubmitQuotationDAO().fetchlabchembioDetails2(labchemnio,select_quotation_name);
			
			labchemchem3=new SubmitQuotationDAO().fetchlabchembioDetails3(labchemnio,select_quotation_name);
			
			labchemchem4=new SubmitQuotationDAO().fetchlabchembioDetails4(labchemnio,select_quotation_name);
			}
			/*if(name_of_index.equals("Investment And Expences For Project As Per Bis"))	{
			investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quotationIndex1.getSelectQuotationName()[j]);
			}*/
			
			if(name_of_index.equals("Commercial Terms And Conditions"))	{
			termsConditions11=new SubmitQuotationDAO().fetchTermsConditionsDetails(termsConditions1,select_quotation_name);
			}
			if(name_of_index.equals("Product Wise Production Cost"))	{
			pwpc=new SubmitQuotationDAO().fetchPWPC(pwpc1,select_quotation_name);
			}
			if(name_of_index.equals("Manufacturing Process Flow Chart"))	{
			flowcharts=new SubmitQuotationDAO().fetchFlowChartsDetails(flowchartmodal,select_quotation_name);
			}
		  }
			
			String name=request.getParameter("name");
			System.out.println("invest and exp1:"+name);
			if(name.equalsIgnoreCase("INVESTMENT AND EXPENCES FOR PROJECT AS PER BIS")) {
				System.out.println("invest and exp2:"+name);
				investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investexpenses,max_invest_exp_id);
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
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
	
	public String fetchInvestmentAndExp()
	{
		String response;
		
		DBConnection conn=new DBConnection();
		Connection connection=conn.getConnection();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = 0;
		PreparedStatement pst1;
		try {
			pst1 = connection.prepareStatement("SELECT MAX(quotation_id) FROM customer_master");
			ResultSet rs1=pst1.executeQuery();
			if(rs1.next())
			{
				id=rs1.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("quottaion_id 1:"+id);
		String counter=request.getParameter("counter");
		String lead_no=request.getParameter("lead_no");
		String customer_name=request.getParameter("customer_name");
		String quotation_name=request.getParameter("quotation_name");
		int i;
		i=new QuotationViewDAO().insert_quotation_view(quotationIndex1,customer_name,id,lead_no,counter);//insert quotation Index
		
		investmentExp1=new InvestmentAndExpencesDAO().fetchInvestmenexp(investAndExpences1);
		investmentExp=new InvestmentAndExpencesDAO().fetchInvestmentAndExp(investAndExpences1);
		
		if(investmentExp.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdateInvestmentAndExp()
	{
		String response;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String investmentAndExpId=request.getParameter("investmentAndExpId");
		
		investmentExp2=new InvestmentAndExpencesDAO().fetchInvestmentAndExp2(investAndExpences1,investmentAndExpId);
		investmentExp3=new InvestmentAndExpencesDAO().fetchInvestmenexp3(investAndExpences1,investmentAndExpId);
		
		if(investmentExp2.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	public String updateInvestmentAndExpenses()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String investmentAndExpId=request.getParameter("invest_exp_id");
		
		int i=new InvestmentAndExpencesDAO().updateInvestmentAndExpenses(investAndExpences1,investmentAndExpId);
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
	
	public String deleteInvestAndExp()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String investmentAndExpId=request.getParameter("investmentAndExpId");
		
		int i=new InvestmentAndExpencesDAO().deleteInvestAndExp(investAndExpences1,investmentAndExpId);
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
		return investAndExpences1;
	}

}

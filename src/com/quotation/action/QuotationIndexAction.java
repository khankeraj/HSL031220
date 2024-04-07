package com.quotation.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.DB.DBConnection;
import com.master.dao.ContractDAO;
import com.master.model.ContractModel;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.quotation.dao.QuotationIndexDAO;
import com.quotation.dao.QuotationViewDAO;
import com.quotation.dao.ROWaterTPDAO;
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
import com.quotation.model.QuotationViewModel;
import com.quotation.model.ROWaterTPModel;
import com.quotation.model.ShrinkMachineModel;
import com.quotation.model.SubmitQuotationModel;
import com.quotation.model.TermsAndConditionsModel;

public class QuotationIndexAction extends ActionSupport implements ModelDriven {
	
	DBConnection conn=new DBConnection();
	
	Connection connection=conn.getConnection();
	
	private String cust_name;
	
	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	private ContractModel customer=new ContractModel();
	public ContractModel getCustomer() {
		return customer;
	}

	public void setCustomer(ContractModel customer) {
		this.customer = customer;
	}

	private QuotationViewModel quotationViewModal=new QuotationViewModel();
	private QuotationIndexModel quotationIndex=new QuotationIndexModel();
	
	private List<QuotationIndexModel> index;
	private List<QuotationIndexModel> index1;
	private List<QuotationIndexModel> indexReports;
	private List<QuotationIndexModel> quoIndex;
	private List<QuotationIndexModel> quoIndex1;
	private List<QuotationIndexModel> quotationIndexList;
	private List<QuotationViewModel> quotationList;
	private List<QuotationIndexModel> viewQuotation;
	
	///view quotation Reports
	
	private SubmitQuotationModel submitQuotationName=new SubmitQuotationModel();
	
	private ContractModel contractmodel=new ContractModel();
	
	private QuotationIndexModel quotationIndex11=new QuotationIndexModel();
	
	private FABRFCModel fabrfc=new FABRFCModel();
	
	private FABLabellingMachineModel fablabelingmc=new FABLabellingMachineModel();
	
	private HotFABMoldingMachineModel hotfabmoldingmc1=new HotFABMoldingMachineModel();
	
	private HighPressureCompressorModel hpcmodel=new HighPressureCompressorModel();
	
	private LowPressureCompressorModel lpcmodel=new LowPressureCompressorModel();
	
	private ShrinkMachineModel shrinkmodal=new ShrinkMachineModel();
	
	private AutocasePackerModel autocasepacker1=new AutocasePackerModel();
	
	private LabChemMicroBioModel labchemnio=new LabChemMicroBioModel();
	
	private InvestmentAndExpencesModel investandexp=new InvestmentAndExpencesModel();
	
	private TermsAndConditionsModel termsConditions1=new TermsAndConditionsModel();
	
	private ProductWiseProductionCostModel pwpc1=new ProductWiseProductionCostModel();
	
	private FlowChartModel flowchartmodal=new FlowChartModel();
	
	
	//Finalization Reports
	
	private List<QuotationIndexModel> finalizationList;

	public List<QuotationIndexModel> getFinalizationList() {
		return finalizationList;
	}

	public void setFinalizationList(List<QuotationIndexModel> finalizationList) {
		this.finalizationList = finalizationList;
	}

	public FlowChartModel getFlowchartmodal() {
		return flowchartmodal;
	}

	public void setFlowchartmodal(FlowChartModel flowchartmodal) {
		this.flowchartmodal = flowchartmodal;
	}

	public ProductWiseProductionCostModel getPwpc1() {
		return pwpc1;
	}

	public void setPwpc1(ProductWiseProductionCostModel pwpc1) {
		this.pwpc1 = pwpc1;
	}

	public TermsAndConditionsModel getTermsConditions1() {
		return termsConditions1;
	}

	public void setTermsConditions1(TermsAndConditionsModel termsConditions1) {
		this.termsConditions1 = termsConditions1;
	}

	public LabChemMicroBioModel getLabchemnio() {
		return labchemnio;
	}

	public void setLabchemnio(LabChemMicroBioModel labchemnio) {
		this.labchemnio = labchemnio;
	}

	public AutocasePackerModel getAutocasepacker1() {
		return autocasepacker1;
	}

	public void setAutocasepacker1(AutocasePackerModel autocasepacker1) {
		this.autocasepacker1 = autocasepacker1;
	}

	public ShrinkMachineModel getShrinkmodal() {
		return shrinkmodal;
	}

	public void setShrinkmodal(ShrinkMachineModel shrinkmodal) {
		this.shrinkmodal = shrinkmodal;
	}

	public List<ShrinkMachineModel> getShrinkmodel() {
		return shrinkmodel;
	}

	public void setShrinkmodel(List<ShrinkMachineModel> shrinkmodel) {
		this.shrinkmodel = shrinkmodel;
	}

	public HighPressureCompressorModel getHpcmodel() {
		return hpcmodel;
	}

	public void setHpcmodel(HighPressureCompressorModel hpcmodel) {
		this.hpcmodel = hpcmodel;
	}

	public HotFABMoldingMachineModel getHotfabmoldingmc1() {
		return hotfabmoldingmc1;
	}

	public void setHotfabmoldingmc1(HotFABMoldingMachineModel hotfabmoldingmc1) {
		this.hotfabmoldingmc1 = hotfabmoldingmc1;
	}

	public FABLabellingMachineModel getFablabelingmc() {
		return fablabelingmc;
	}

	public void setFablabelingmc(FABLabellingMachineModel fablabelingmc) {
		this.fablabelingmc = fablabelingmc;
	}

	public FABRFCModel getFabrfc() {
		return fabrfc;
	}

	public void setFabrfc(FABRFCModel fabrfc) {
		this.fabrfc = fabrfc;
	}

	private ROWaterTPModel rowater=new ROWaterTPModel();
	
	public ROWaterTPModel getRowater() {
		return rowater;
	}

	public void setRowater(ROWaterTPModel rowater) {
		this.rowater = rowater;
	}

	public QuotationIndexModel getQuotationIndex11() {
		return quotationIndex;
	}

	public void setQuotationIndex1(QuotationIndexModel quotationIndex) {
		this.quotationIndex = quotationIndex;
	}

	private List<ContractModel>  coverDetails;
	
	private List<ContractModel> contractDetails;
	
	private List<QuotationIndexModel> quotationIndexList1;
	
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
	
	public List<FlowChartModel> getFlowcharts() {
		return flowcharts;
	}

	public void setFlowcharts(List<FlowChartModel> flowcharts) {
		this.flowcharts = flowcharts;
	}

	public List<ProductWiseProductionCostModel> getPwpc() {
		return pwpc;
	}

	public void setPwpc(List<ProductWiseProductionCostModel> pwpc) {
		this.pwpc = pwpc;
	}

	public List<TermsAndConditionsModel> getTermsConditions11() {
		return termsConditions11;
	}

	public void setTermsConditions11(List<TermsAndConditionsModel> termsConditions11) {
		this.termsConditions11 = termsConditions11;
	}

	public InvestmentAndExpencesModel getInvestandexp() {
		return investandexp;
	}

	public void setInvestandexp(InvestmentAndExpencesModel investandexp) {
		this.investandexp = investandexp;
	}

	public List<FABRFCModel> getFabrfclist() {
		return fabrfclist;
	}

	public void setFabrfclist(List<FABRFCModel> fabrfclist) {
		this.fabrfclist = fabrfclist;
	}

	public List<LowPressureCompressorModel> getLpcList() {
		return lpcList;
	}

	public void setLpcList(List<LowPressureCompressorModel> lpcList) {
		this.lpcList = lpcList;
	}

	public List<InvestmentAndExpencesModel> getInvestmentAndExp() {
		return investmentAndExp;
	}

	public void setInvestmentAndExp(List<InvestmentAndExpencesModel> investmentAndExp) {
		this.investmentAndExp = investmentAndExp;
	}

	public List<LabChemMicroBioModel> getLabchemchem4() {
		return labchemchem4;
	}

	public void setLabchemchem4(List<LabChemMicroBioModel> labchemchem4) {
		this.labchemchem4 = labchemchem4;
	}

	public List<LabChemMicroBioModel> getLabchemchem3() {
		return labchemchem3;
	}

	public void setLabchemchem3(List<LabChemMicroBioModel> labchemchem3) {
		this.labchemchem3 = labchemchem3;
	}

	public List<LabChemMicroBioModel> getLabchemchem() {
		return labchemchem;
	}

	public void setLabchemchem(List<LabChemMicroBioModel> labchemchem) {
		this.labchemchem = labchemchem;
	}

	public List<LabChemMicroBioModel> getLabchemglass() {
		return labchemglass;
	}

	public void setLabchemglass(List<LabChemMicroBioModel> labchemglass) {
		this.labchemglass = labchemglass;
	}

	public List<LabChemMicroBioModel> getLabchembio() {
		return labchembio;
	}

	public void setLabchembio(List<LabChemMicroBioModel> labchembio) {
		this.labchembio = labchembio;
	}

	public List<AutocasePackerModel> getAutocasepacker() {
		return autocasepacker;
	}

	public void setAutocasepacker(List<AutocasePackerModel> autocasepacker) {
		this.autocasepacker = autocasepacker;
	}

	public LowPressureCompressorModel getLpcmodel() {
		return lpcmodel;
	}

	public void setLpcmodel(LowPressureCompressorModel lpcmodel) {
		this.lpcmodel = lpcmodel;
	}

	public List<LowPressureCompressorModel> getLpc() {
		return lpc;
	}

	public void setLpc(List<LowPressureCompressorModel> lpc) {
		this.lpc = lpc;
	}

	public List<HighPressureCompressorModel> getHpc() {
		return hpc;
	}

	public void setHpc(List<HighPressureCompressorModel> hpc) {
		this.hpc = hpc;
	}

	public List<HotFABMoldingMachineModel> getHotfabmoldingmc() {
		return hotfabmoldingmc;
	}

	public void setHotfabmoldingmc(List<HotFABMoldingMachineModel> hotfabmoldingmc) {
		this.hotfabmoldingmc = hotfabmoldingmc;
	}

	public List<FABLabellingMachineModel> getFablabelinglist() {
		return fablabelinglist;
	}

	public void setFablabelinglist(List<FABLabellingMachineModel> fablabelinglist) {
		this.fablabelinglist = fablabelinglist;
	}

	public List<ROWaterTPModel> getRotechspecifications() {
		return rotechspecifications;
	}

	public void setRotechspecifications(List<ROWaterTPModel> rotechspecifications) {
		this.rotechspecifications = rotechspecifications;
	}

	public List<ROWaterTPModel> getRoparts1() {
		return roparts1;
	}

	public void setRoparts1(List<ROWaterTPModel> roparts1) {
		this.roparts1 = roparts1;
	}

	public List<ROWaterTPModel> getRomaster() {
		return romaster;
	}

	public void setRomaster(List<ROWaterTPModel> romaster) {
		this.romaster = romaster;
	}

	public List<QuotationIndexModel> getQuotationIndexSublist() {
		return quotationIndexSublist;
	}

	public void setQuotationIndexSublist(List<QuotationIndexModel> quotationIndexSublist) {
		this.quotationIndexSublist = quotationIndexSublist;
	}

	public List<QuotationIndexModel> getQuotationIndexList11() {
		return quotationIndexList;
	}

	public void setQuotationIndexList11(List<QuotationIndexModel> quotationIndexList) {
		this.quotationIndexList = quotationIndexList;
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

	
	public List<QuotationIndexModel> getViewQuotation() {
		return viewQuotation;
	}

	public void setViewQuotation(List<QuotationIndexModel> viewQuotation) {
		this.viewQuotation = viewQuotation;
	}

	public QuotationViewModel getQuotationViewModal() {
		return quotationViewModal;
	}

	public void setQuotationViewModal(QuotationViewModel quotationViewModal) {
		this.quotationViewModal = quotationViewModal;
	}

	public List<QuotationViewModel> getQuotationList() {
		return quotationList;
	}

	public void setQuotationList(List<QuotationViewModel> quotationList) {
		this.quotationList = quotationList;
	}

	private List<QuotationIndexModel> q1;
	private List<QuotationIndexModel> q2;
	private List<QuotationIndexModel> fetchQuotationIndex;
	
	public List<QuotationIndexModel> getFetchQuotationIndex() {
		return fetchQuotationIndex;
	}

	public void setFetchQuotationIndex(List<QuotationIndexModel> fetchQuotationIndex) {
		this.fetchQuotationIndex = fetchQuotationIndex;
	}

	public List<QuotationIndexModel> getQ1() {
		return q1;
	}

	public void setQ1(List<QuotationIndexModel> q1) {
		this.q1 = q1;
	}

	public List<QuotationIndexModel> getQ2() {
		return q2;
	}

	public void setQ2(List<QuotationIndexModel> q2) {
		this.q2 = q2;
	}

	public void setQuotationIndexList(List<QuotationIndexModel> quotationIndexList) {
		this.quotationIndexList = quotationIndexList;
	}

	public List<QuotationIndexModel> getQuoIndex1() {
		return quoIndex1;
	}

	public void setQuoIndex1(List<QuotationIndexModel> quoIndex1) {
		this.quoIndex1 = quoIndex1;
	}

	public List<QuotationIndexModel> getQuoIndex() {
		return quoIndex;
	}

	public void setQuoIndex(List<QuotationIndexModel> quoIndex) {
		this.quoIndex = quoIndex;
	}

	public List<QuotationIndexModel> getIndexReports() {
		return indexReports;
	}

	public void setIndexReports(List<QuotationIndexModel> indexReports) {
		this.indexReports = indexReports;
	}

	public List<QuotationIndexModel> getIndex1() {
		return index1;
	}

	public void setIndex1(List<QuotationIndexModel> index1) {
		this.index1 = index1;
	}

	public List<QuotationIndexModel> getIndex() {
		return index;
	}

	public void setIndex(List<QuotationIndexModel> index) {
		this.index = index;
	}

	public QuotationIndexModel getQuotationIndex() {
		return quotationIndex;
	}

	public void setQuotationIndex(QuotationIndexModel quotationIndex) {
		this.quotationIndex = quotationIndex;
	}
	
	private List<QuotationIndexModel> quotationIndex1;
	
	
	public List<QuotationIndexModel> getQuotationIndex1() {
		return quotationIndex1;
	}

	public void setQuotationIndex1(List<QuotationIndexModel> quotationIndex1) {
		this.quotationIndex1 = quotationIndex1;
	}

	public void setQuotationIndex11(QuotationIndexModel quotationIndex11) {
		this.quotationIndex11 = quotationIndex11;
	}
	
	public String finalizationReportsDetails()
	{
		String response;
		
		try {
			finalizationList=new QuotationIndexDAO().fetchFinalizationReports(quotationIndex);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("finalizationList size::"+finalizationList);
		
		if(finalizationList!=null)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}

	public String viewQuotationReports()
	{
		String response = null;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String quotation_id=request.getParameter("quotation_id");
		int quo_id=Integer.parseInt(quotation_id);
		
		int max_count=0;
		int i=1;
		try {
			PreparedStatement pst=connection.prepareStatement("SELECT `id`, `name_of_index`, `select_quotation`, `quotation_id` FROM `edit_quotation_index` WHERE `quotation_id`="+quotation_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				if(!rs.getString(2).equals("")) {

				int id=rs.getInt(1);
				String name_of_index=rs.getString(2);
				String select_quotation=rs.getString(3);
				int quot_id=rs.getInt(4);
				
				System.out.println("select_quotation"+i+":"+select_quotation);
				i++;
				
				coverDetails=new SubmitQuotationDAO().fetchCoverDetails(contractmodel,quot_id);
				
				contractDetails=new SubmitQuotationDAO().getContractDetails(contractmodel,quot_id);
				
				quotationIndexList=new SubmitQuotationDAO().fetchQuotationIndexList(quotationIndex,"6000LPH");
					
				if(name_of_index.equals("RO WATER TREATMENT PLANT")){
					
				romaster=new SubmitQuotationDAO().fetchROMaster(rowater,select_quotation);
				
				rotechspecifications=new SubmitQuotationDAO().fetchTechnicalSpecifications(romaster,select_quotation);
				}
				if(name_of_index.equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))	{
				
				fabrfclist=new SubmitQuotationDAO().fetchFABRFCDetails(fabrfc,select_quotation);
				}
				if(name_of_index.equals("Fully Auto Bottle Labelling Machine"))	{
				fablabelinglist=new SubmitQuotationDAO().fetchFABLabelingDetails(fablabelingmc,select_quotation);
				}
				if(name_of_index.equals("Hot Fill Fully Auto Blow Molding Machine"))	{
				hotfabmoldingmc=new SubmitQuotationDAO().fetchhotfabmoldingmc(hotfabmoldingmc1,select_quotation);
				}
				if(name_of_index.equals("High Pressure Compressor"))	{
				hpc=new SubmitQuotationDAO().fetchHPCDetails(hpcmodel,select_quotation);
				}
				if(name_of_index.equals("Low Pressure Compressor"))	{
				lpc=new SubmitQuotationDAO().fetchlpcDetails(lpcmodel,select_quotation);
				lpcList=new SubmitQuotationDAO().fetchLpcSpDetails(lpcmodel,select_quotation);
				}
				
				if(name_of_index.equals("SHRINK MACHINE"))	{
				shrinkmodel=new SubmitQuotationDAO().fetchShrinkMCDetails(shrinkmodal,select_quotation);
				}
				if(name_of_index.equals("Autocase Packer"))	{
				autocasepacker=new SubmitQuotationDAO().fetchAutocasePAcker(autocasepacker1,select_quotation);
				}
				if(name_of_index.equals("Laboratories : Chemical & Microbiology"))	{
				labchembio=new SubmitQuotationDAO().fetchlabchembioDetails(labchemnio,select_quotation);
				
				labchemglass=new SubmitQuotationDAO().fetchlabchembioDetails1(labchemnio,select_quotation);
				
				labchemchem=new SubmitQuotationDAO().fetchlabchembioDetails2(labchemnio,select_quotation);
				
				labchemchem3=new SubmitQuotationDAO().fetchlabchembioDetails3(labchemnio,select_quotation);
				
				labchemchem4=new SubmitQuotationDAO().fetchlabchembioDetails4(labchemnio,select_quotation);
				}
				
				investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quo_id);
				
				if(name_of_index.equals("Commercial Terms And Conditions"))	{
				termsConditions11=new SubmitQuotationDAO().fetchTermsConditionsDetails(termsConditions1,select_quotation);
				}
				if(name_of_index.equals("Product Wise Production Cost"))	{
				pwpc=new SubmitQuotationDAO().fetchPWPC(pwpc1, select_quotation);
				}
				if(name_of_index.equals("Manufacturing Process Flow Chart"))	{
				flowcharts=new SubmitQuotationDAO().fetchFlowChartsDetails(flowchartmodal,select_quotation);
				}
				
				if(coverDetails.size()>0)
				{
					response="success";
				}
				else
				{
					response="fail";
				}
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		
	}
	
	public String fetchCustomerDetails()
	{
		String response;
		System.out.println("quotationViewModal:"+quotationViewModal.getLead_no());
		try {
			quotationList=new QuotationViewDAO().fetchCustomerDetails(quotationViewModal);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("quotationList.size():"+quotationList.size());
		if(quotationList!=null)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	
	
	public String execute()
	{
		return "success";
	}
	
	public String insert_Quotation_Index()
	{
		String response;
		int i=new QuotationIndexDAO().insert_Quotation_Index(quotationIndex);
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
	
	public String fetchQuotationIndexDetails()
	{
		String response;
		index=new QuotationIndexDAO().fetchQuotationIndex(quotationIndex);
		index1=new QuotationIndexDAO().fetchQuotationIndex1(quotationIndex);
		if(index1.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String fetchQuotationIndexReportsDetails()
	{
		String response;
		indexReports=new QuotationIndexDAO().fetchQuotationIndexReportsDetails(quotationIndex);
		if(indexReports.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchForUpdateQuoIndex()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String updateQuotationIndexId=request.getParameter("quotation_index_id");
		
		quoIndex=new QuotationIndexDAO().fetchForUpdateQuoIndex(quotationIndex,updateQuotationIndexId);
		quoIndex1=new QuotationIndexDAO().fetchForUpdateQuoIndex1(quotationIndex,updateQuotationIndexId);
		if(quoIndex.size()>0)
		{
			response="success";
		}else
			
		{
			response="success";
		}
		return response;
		
	}
	
	public String updateQuotationIndex()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String updateQuotationIndexId=request.getParameter("update_quo_index");
		int i=new QuotationIndexDAO().updateQuotationIndex(quotationIndex,updateQuotationIndexId);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String deleteQuotationIndex()
	{
		String response;
		HttpServletRequest request = ServletActionContext.getRequest();
		String updateQuotationIndexId=request.getParameter("quotation_index_id");
		
		int i=new QuotationIndexDAO().deleteQuotationIndex(quotationIndex,updateQuotationIndexId);
		if(i>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
		
	}
	
	public String getQuotationIndexList()
	{
		String response;
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String quotation_name=request.getParameter("quotation_name");
		
		//System.out.println("Quotation Name is:"+quotation_name);
		
		quotationIndexList=new QuotationIndexDAO().fetchQuotationIndexList(quotationIndex,quotation_name);
		//System.out.println("Quotation index:"+quotationIndexList.size());
		if(quotationIndexList.size()>0)
		{
			response="success";
		}else
		{
			response="fail";
		}
		return response;
	}
	
	public String fetchQuotationIndexDetails1()
	{
		String response = null;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		String quotation_id=request.getParameter("quotation_edit_id");
		
		String quotation_edit_id=request.getParameter("quotation_edit_id");
		String ref_no=request.getParameter("ref_no");
		String requiredDate=request.getParameter("requiredDate");
		String to=request.getParameter("to");
		String name1=request.getParameter("name1");
		String name2=request.getParameter("name2");
		
		String address=request.getParameter("address");
		
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String contact=request.getParameter("contact");
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String pincode=request.getParameter("pincode");
		String proCoOrdiName=request.getParameter("proCoOrdiName");
		String proCoOrdiContactNo=request.getParameter("proCoOrdiContactNo");
		
		int status=new ContractDAO().update_contractor(customer,quotation_edit_id,ref_no,requiredDate,to,name1,name2,address,state,city,contact,email,subject,pincode,proCoOrdiName,proCoOrdiContactNo);
		
		System.out.println("quotation_id:in quotation index action"+quotation_edit_id+"quo_edit_id:"+quotation_id);
		q1=new QuotationIndexDAO().fetchQ1(quotationIndex);
		q2=new QuotationIndexDAO().fetchQ2(quotationIndex,quotation_id);
		
		//fetchQuotationIndex=new QuotationIndexDAO().fetchQuotationIndex2(quotationIndex,fetquotationIndex);
		
		//System.out.println("sixe:"+q2.size());
		
		if(q1.size()>0)
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
		return quotationIndex;
	}

	public List<QuotationIndexModel> getQuotationIndexList1() {
		return quotationIndexList1;
	}

	public void setQuotationIndexList1(List<QuotationIndexModel> quotationIndexList1) {
		this.quotationIndexList1 = quotationIndexList1;
	}
	
}

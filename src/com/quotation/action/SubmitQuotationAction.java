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

public class SubmitQuotationAction extends ActionSupport implements ModelDriven{
	
	//private QuotationViewModel viewQuotation=new QuotationViewModel();
	
	private InvestmentAndExpencesModel investAndExpences=new InvestmentAndExpencesModel();
	private ContractModel customer=new ContractModel();
	
	public InvestmentAndExpencesModel getInvestAndExpences() {
		return investAndExpences;
	}

	public void setInvestAndExpences(InvestmentAndExpencesModel investAndExpences) {
		this.investAndExpences = investAndExpences;
	}

	private SubmitQuotationModel submitQuotationName=new SubmitQuotationModel();
	
	private ContractModel contractmodel=new ContractModel();
	
	private QuotationIndexModel quotationIndex=new QuotationIndexModel();
	
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

	public QuotationIndexModel getQuotationIndex() {
		return quotationIndex;
	}

	public void setQuotationIndex(QuotationIndexModel quotationIndex) {
		this.quotationIndex = quotationIndex;
	}

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

	public List<QuotationIndexModel> getQuotationIndexList() {
		return quotationIndexList;
	}

	public void setQuotationIndexList(List<QuotationIndexModel> quotationIndexList) {
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
	
	
	public String FinalizationQuotationDetails()
	{
		String response = null;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		int quotation_id=Integer.parseInt(request.getParameter("quotation_edit_id"));
		/*String quotation_name=request.getParameter("quotation_name");*/
		
		String finalized_amount=request.getParameter("finalized_amount");
		
		String token_amount=request.getParameter("token_amount");
		String lead_no=request.getParameter("lead_no");
		
		int i=new QuotationViewDAO().finalized_quoytation_Details(quotationIndex,quotation_id,finalized_amount,token_amount,lead_no);
		
		String quotation_name_from_contractor=request.getParameter("quotation_id");
		
		coverDetails=new SubmitQuotationDAO().fetchCoverDetails(contractmodel,quotation_id);
		
		contractDetails=new SubmitQuotationDAO().getContractDetails(contractmodel,quotation_id);
		
		quotationIndexList=new SubmitQuotationDAO().fetchQuotationIndexList(quotationIndex,"6000LPH");
		
		int len=quotationIndex.getSelectQuotationName().length;
		
		
		
		for(int j=0;j<len;j++) {
			
		//System.out.println("quottaion:"+quotationIndex.getMycheckbox()[j]);
			
		try {
			if(quotationIndex.getMycheckbox()[j].equals("RO WATER TREATMENT PLANT")){
				
				try {
					romaster=new SubmitQuotationDAO().fetchROMaster(rowater,quotationIndex.getSelectQuotationName()[j]);
				} catch (Exception e) {
					// TODO: handle exception
				}
				rotechspecifications=new SubmitQuotationDAO().fetchTechnicalSpecifications(romaster,quotationIndex.getSelectQuotationName()[j]);
				}
		
		if(quotationIndex.getMycheckbox()[j].equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))	{
		
		fabrfclist=new SubmitQuotationDAO().fetchFABRFCDetails(fabrfc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Fully Auto Bottle Labelling Machine"))	{
		fablabelinglist=new SubmitQuotationDAO().fetchFABLabelingDetails(fablabelingmc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Hot Fill Fully Auto Blow Molding Machine"))	{
		hotfabmoldingmc=new SubmitQuotationDAO().fetchhotfabmoldingmc(hotfabmoldingmc1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("High Pressure Compressor"))	{
		hpc=new SubmitQuotationDAO().fetchHPCDetails(hpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Low Pressure Compressor"))	{
		lpc=new SubmitQuotationDAO().fetchlpcDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		lpcList=new SubmitQuotationDAO().fetchLpcSpDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		
		if(quotationIndex.getMycheckbox()[j].equals("SHRINK MACHINE"))	{
		shrinkmodel=new SubmitQuotationDAO().fetchShrinkMCDetails(shrinkmodal,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Autocase Packer"))	{
		autocasepacker=new SubmitQuotationDAO().fetchAutocasePAcker(autocasepacker1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Laboratories : Chemical & Microbiology"))	{
		labchembio=new SubmitQuotationDAO().fetchlabchembioDetails(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemglass=new SubmitQuotationDAO().fetchlabchembioDetails1(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem=new SubmitQuotationDAO().fetchlabchembioDetails2(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem3=new SubmitQuotationDAO().fetchlabchembioDetails3(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem4=new SubmitQuotationDAO().fetchlabchembioDetails4(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		}
		
		investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quotation_id);
		
		if(quotationIndex.getMycheckbox()[j].equals("Commercial Terms And Conditions"))	{
		termsConditions11=new SubmitQuotationDAO().fetchTermsConditionsDetails(termsConditions1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Product Wise Production Cost"))	{
		pwpc=new SubmitQuotationDAO().fetchPWPC(pwpc1, quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Manufacturing Process Flow Chart"))	{
		flowcharts=new SubmitQuotationDAO().fetchFlowChartsDetails(flowchartmodal,quotationIndex.getSelectQuotationName()[j]);
		
		}
		
		System.out.println("cover Details :"+coverDetails.size());
		if(coverDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		}
		return response;
	}
	
	
	public String editQuotationDetails()
	{
		String response="";
		DBConnection connection=new DBConnection();
		Connection conn=connection.getConnection();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		int quotation_id=Integer.parseInt(request.getParameter("quotation_edit_id"));
		
		int i=new QuotationViewDAO().edit_quoytation_Details(quotationIndex,quotation_id);
		
		String quotation_name_from_contractor=request.getParameter("quotation_id");
		
		/*System.out.println("quotation_name_from_contractor:"+quotation_name_from_contractor);*/
		
		coverDetails=new SubmitQuotationDAO().fetchCoverDetails(contractmodel,quotation_id);
		
		contractDetails=new SubmitQuotationDAO().getContractDetails(contractmodel,quotation_id);
		
		quotationIndexList=new SubmitQuotationDAO().fetchQuotationIndexList(quotationIndex,"6000LPH");
		
		int len=quotationIndex.getSelectQuotationName().length;
		String count = null;
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT COUNT(quotation_id) FROM edit_quotation_index WHERE quotation_id="+quotation_id+"");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				count=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int counter=Integer.parseInt(count);
		
		for(int j=0;j<counter;j++) {
			
		System.out.println("quottaion:"+quotationIndex.getMycheckbox()[j]);
			
		if(quotationIndex.getMycheckbox()[j].equals("RO WATER TREATMENT PLANT")){
			
		romaster=new SubmitQuotationDAO().fetchROMaster(rowater,quotationIndex.getSelectQuotationName()[j]);
			
		rotechspecifications=new SubmitQuotationDAO().fetchTechnicalSpecifications(romaster,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))	{
		
		fabrfclist=new SubmitQuotationDAO().fetchFABRFCDetails(fabrfc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Fully Auto Bottle Labelling Machine"))	{
		fablabelinglist=new SubmitQuotationDAO().fetchFABLabelingDetails(fablabelingmc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Hot Fill Fully Auto Blow Molding Machine"))	{
		hotfabmoldingmc=new SubmitQuotationDAO().fetchhotfabmoldingmc(hotfabmoldingmc1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("High Pressure Compressor"))	{
		hpc=new SubmitQuotationDAO().fetchHPCDetails(hpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Low Pressure Compressor"))	{
		lpc=new SubmitQuotationDAO().fetchlpcDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		lpcList=new SubmitQuotationDAO().fetchLpcSpDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		
		if(quotationIndex.getMycheckbox()[j].equals("SHRINK MACHINE"))	{
		shrinkmodel=new SubmitQuotationDAO().fetchShrinkMCDetails(shrinkmodal,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Autocase Packer"))	{
		autocasepacker=new SubmitQuotationDAO().fetchAutocasePAcker(autocasepacker1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Laboratories : Chemical & Microbiology"))	{
		labchembio=new SubmitQuotationDAO().fetchlabchembioDetails(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemglass=new SubmitQuotationDAO().fetchlabchembioDetails1(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem=new SubmitQuotationDAO().fetchlabchembioDetails2(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem3=new SubmitQuotationDAO().fetchlabchembioDetails3(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem4=new SubmitQuotationDAO().fetchlabchembioDetails4(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		}
		
		investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quotation_id);
		
		if(quotationIndex.getMycheckbox()[j].equals("Commercial Terms And Conditions"))	{
		termsConditions11=new SubmitQuotationDAO().fetchTermsConditionsDetails(termsConditions1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Product Wise Production Cost"))	{
		pwpc=new SubmitQuotationDAO().fetchPWPC(pwpc1, quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Manufacturing Process Flow Chart"))	{
		flowcharts=new SubmitQuotationDAO().fetchFlowChartsDetails(flowchartmodal,quotationIndex.getSelectQuotationName()[j]);
		}
		}
		System.out.println("cover Details :"+coverDetails.size());
		if(coverDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		return response;
	}
	

	/*public String getCoverPageDetails()
	{
		String response;
		int i,K;
		
		HttpServletRequest request=ServletActionContext.getRequest();
		
		
		int quotation_id=Integer.parseInt(request.getParameter("quotation_id"));
		String customer_name=request.getParameter("customer_name");
		
		
		String quotation_name=request.getParameter("quotation_name");
		//System.out.println("customer_name:"+customer_name+"quotation_id:"+quotation_id+"quotation_name:"+quotation_name);
		
		K=new InvestmentAndExpencesDAO().insertInvestmentAndExp(investAndExpences);//insert investment and expences
		
		System.out.println("invest and exp:"+K);
		
		coverDetails=new SubmitQuotationDAO().fetchCoverDetails(contractmodel,quotation_id);
		
		contractDetails=new SubmitQuotationDAO().getContractDetails(contractmodel,quotation_id);
		
		quotationIndexList=new SubmitQuotationDAO().fetchQuotationIndexList(quotationIndex,"6000LPH");
		
		int len=quotationIndex.getSelectQuotationName().length;
		System.out.println("LENGH:"+len);
		
		for(int j=0;j<len;j++) {
			
		System.out.println("quottaion:"+quotationIndex.getMycheckbox()[j]);
			
		if(quotationIndex.getMycheckbox()[j].equals("RO WATER TREATMENT PLANT")){
			
		romaster=new SubmitQuotationDAO().fetchROMaster(rowater,quotationIndex.getSelectQuotationName()[j]);
			
		rotechspecifications=new SubmitQuotationDAO().fetchTechnicalSpecifications(romaster,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("FULLY AUTO RINSSING, FILLING AND CAPING MACHINE"))	{
		
		fabrfclist=new SubmitQuotationDAO().fetchFABRFCDetails(fabrfc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Fully Auto Bottle Labelling Machine"))	{
		fablabelinglist=new SubmitQuotationDAO().fetchFABLabelingDetails(fablabelingmc,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Hot Fill Fully Auto Blow Molding Machine"))	{
		hotfabmoldingmc=new SubmitQuotationDAO().fetchhotfabmoldingmc(hotfabmoldingmc1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("High Pressure Compressor"))	{
		hpc=new SubmitQuotationDAO().fetchHPCDetails(hpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Low Pressure Compressor"))	{
		lpc=new SubmitQuotationDAO().fetchlpcDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		lpcList=new SubmitQuotationDAO().fetchLpcSpDetails(lpcmodel,quotationIndex.getSelectQuotationName()[j]);
		}
		
		if(quotationIndex.getMycheckbox()[j].equals("SHRINK MACHINE"))	{
		shrinkmodel=new SubmitQuotationDAO().fetchShrinkMCDetails(shrinkmodal,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Autocase Packer"))	{
		autocasepacker=new SubmitQuotationDAO().fetchAutocasePAcker(autocasepacker1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Laboratories : Chemical & Microbiology"))	{
		labchembio=new SubmitQuotationDAO().fetchlabchembioDetails(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemglass=new SubmitQuotationDAO().fetchlabchembioDetails1(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem=new SubmitQuotationDAO().fetchlabchembioDetails2(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem3=new SubmitQuotationDAO().fetchlabchembioDetails3(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		
		labchemchem4=new SubmitQuotationDAO().fetchlabchembioDetails4(labchemnio,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Investment And Expences For Project As Per Bis"))	{
		investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quotationIndex.getSelectQuotationName()[j]);
		}
		investmentAndExp=new SubmitQuotationDAO().fetchInvestmentAndExp(investandexp,quotation_name);
		
		if(quotationIndex.getMycheckbox()[j].equals("Commercial Terms And Conditions"))	{
		termsConditions11=new SubmitQuotationDAO().fetchTermsConditionsDetails(termsConditions1,quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Product Wise Production Cost"))	{
		pwpc=new SubmitQuotationDAO().fetchPWPC(pwpc1, quotationIndex.getSelectQuotationName()[j]);
		}
		if(quotationIndex.getMycheckbox()[j].equals("Manufacturing Process Flow Chart"))	{
		flowcharts=new SubmitQuotationDAO().fetchFlowChartsDetails(flowchartmodal,quotationIndex.getSelectQuotationName()[j]);
		}
		}
		
		System.out.println("cover Details :"+coverDetails.size());
		if(coverDetails.size()>0)
		{
			response="success";
		}
		else
		{
			response="fail";
		}
		
		return "success";
	}*/
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return submitQuotationName;
	}
}

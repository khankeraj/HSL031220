package com.Factory;

import com.Service.LoginService;
import com.Service.NewUserService;
import com.Service.RoleService;
import com.Service.Impl.LoginServiceImpl;
import com.Service.Impl.NewUserServiceImpl;
import com.Service.Impl.RoleServiceImpl;

/*import com.pts.Service.AlertReportService;
import com.pts.Service.AllDeliveryNoteReportService;
import com.pts.Service.AllRentReportService;
import com.pts.Service.AllReplacementReportService;
import com.pts.Service.AllSaleReportService;
import com.pts.Service.AmcModuleService;
import com.pts.Service.AssignEngineer4ServiceService;
import com.pts.Service.BillingModuleService;
import com.pts.Service.DeliveryNoteModuleService;
import com.pts.Service.EmployeeModuleService;
import com.pts.Service.EnquiryFormService;
import com.pts.Service.GetSalarySheetService;
import com.pts.Service.GrnModuleService;
import com.pts.Service.InsertFsrModuleService;
import com.pts.Service.InsertMasterService;
import com.pts.Service.InstallationModuleService;*/
/*import com.pts.Service.ProductMasterService;
import com.pts.Service.RentReportService;
import com.pts.Service.ReplacementReportService;

import com.pts.Service.SaleReportService;
import com.pts.Service.ServicesStockModuleService;
import com.pts.Service.StockShiftingService;
import com.pts.Service.Impl.AlertReportServiceImpl;
import com.pts.Service.Impl.AllDeliveryNoteReportServiceImpl;
import com.pts.Service.Impl.AllRentReportServiceImpl;
import com.pts.Service.Impl.AllReplacementReportServiceImpl;
import com.pts.Service.Impl.AllSaleReportServiceImpl;
import com.pts.Service.Impl.AmcModuleServiceImpl;
import com.pts.Service.Impl.AssignEngineer4ServiceServiceImpl;
import com.pts.Service.Impl.BillingModuleServiceImpl;
import com.pts.Service.Impl.DeliveryNoteModuleServiceImpl;
import com.pts.Service.Impl.EmployeeModuleServiceImpl;
import com.pts.Service.Impl.EnquiryFormServiceImpl;
import com.pts.Service.Impl.GetSalarySheetServiceImpl;
import com.pts.Service.Impl.GrnModuleServiceImpl;
import com.pts.Service.Impl.InsertFsrModuleServiceImpl;
import com.pts.Service.Impl.InsertMasterServiceImpl;
import com.pts.Service.Impl.InstallationModuleServiceImpl;

import com.pts.Service.Impl.ProductMasterServiceImpl;
import com.pts.Service.Impl.RentReportServiceImpl;
import com.pts.Service.Impl.ReplacementReportServiceImpl;

import com.pts.Service.Impl.SaleReportServiceImpl;
import com.pts.Service.Impl.ServicesStockModuleServiceImpl;
import com.pts.Service.Impl.StockShiftingServiceImpl;*/

public class ServiceFactory {

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return new ServiceFactory();
	}

	public LoginService getLoginService() {

		return new LoginServiceImpl();

	}

	public RoleService getRoleService() {

		return new RoleServiceImpl();

	}

	public NewUserService getNewUserService() {

		return new NewUserServiceImpl();

	}

	/*public ProductMasterService getProductMasterServiceImpl() {

		return new ProductMasterServiceImpl();

	}

	public InsertMasterService getInsertMasterServiceImpl() {

		return new InsertMasterServiceImpl();

	}

	public ServicesStockModuleService getServicesStockModuleServiceImpl() {

		return new ServicesStockModuleServiceImpl();

	}

	public DeliveryNoteModuleService getDeliveryNoteModuleServiceImpl() {

		return new DeliveryNoteModuleServiceImpl();

	}

	public StockShiftingService getStockShiftingServiceImpl() {

		return new StockShiftingServiceImpl();

	}

	public AllDeliveryNoteReportService getAllDeliveryNoteReportServiceImpl() {

		return new AllDeliveryNoteReportServiceImpl();

	}

	public AllRentReportService getAllRentReportServiceImpl() {

		return new AllRentReportServiceImpl();

	}

	public AllReplacementReportService getAllReplacementReportServiceImpl() {

		return new AllReplacementReportServiceImpl();

	}

	public AllSaleReportService getAllSaleReportServiceImpl() {

		return new AllSaleReportServiceImpl();

	}

	public SaleReportService getSaleReportServiceImpl() {

		return new SaleReportServiceImpl();

	}

	public RentReportService getRentReportServiceImpl() {

		return new RentReportServiceImpl();

	}

	public ReplacementReportService getReplacementReportServiceImpl() {

		return new ReplacementReportServiceImpl();

	}

	public GrnModuleService getGrnModuleServiceImpl() {

		return new GrnModuleServiceImpl();

	}

	public InstallationModuleService getInstallationModuleServiceImpl() {

		return new InstallationModuleServiceImpl();

	}

	public AlertReportService getAlertReportServiceImpl() {

		return new AlertReportServiceImpl();

	}

	public EmployeeModuleService getEmployeeModuleServiceImpl() {

		return new EmployeeModuleServiceImpl();

	}

	public GetSalarySheetService getGetSalarySheetServiceImpl() {
		return new GetSalarySheetServiceImpl();
	}

	public AmcModuleService getAmcModuleServiceImpl() {
		return new AmcModuleServiceImpl();
	}

	public InsertFsrModuleService getInsertFsrModuleServiceImpl() {

		return new InsertFsrModuleServiceImpl();

	}

	public AssignEngineer4ServiceService getAssignEngineer4ServiceServiceImpl() {

		return new AssignEngineer4ServiceServiceImpl();

	}

	public BillingModuleService getBillingModuleServiceImpl() {

		return new BillingModuleServiceImpl();

	}

	public EnquiryFormService getEnquiryFormServiceImpl() {
		return new EnquiryFormServiceImpl();
	}
*/
}

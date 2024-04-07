package com.Factory;


import com.dao.LoginDao;
import com.dao.RoleDao;
import com.dao.Impl.LoginDaoImpl;
import com.dao.Impl.NewUserDaoImpl;
import com.dao.Impl.RoleDaoImpl;


public class DAOFactory {

	public DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return new DAOFactory();
	}

	public LoginDao getLoginDao() {

		return new LoginDaoImpl();

	}

	public RoleDao getRoleDao() {

		return new RoleDaoImpl();

	}

	public NewUserDaoImpl getNewUserDao() {

		return new NewUserDaoImpl();

	}

	/*public ProductMasterDao getProductMasterDaoImpl() {

		return new ProductMasterDaoImpl();

	}

	public InsertMasterDao getInsertMasterDaoImpl() {

		return new InsertMasterDaoImpl();

	}

	public ServicesStockModuleDao getServicesStockModuleDaoImpl() {

		return new ServicesStockModuleDaoImpl();

	}

	public DeliveryNoteModuleDao getDeliveryNoteModuleDaoImpl() {

		return new DeliveryNoteModuleDaoImpl();

	}

	public StockShiftingDao getStockShiftingDaoImpl() {

		return new StockShiftingDaoImpl();

	}

	public AllDeliveryNoteReportDao getAllDeliveryNoteReportDaoImpl() {

		return new AllDeliveryNoteReportDaoImpl();

	}

	public AllRentReportDao getAllRentReportDaoImpl() {

		return new AllRentReportDaoImpl();

	}

	public AllReplacementReportDao getAllReplacementReportDaoImpl() {

		return new AllReplacementReportDaoImpl();

	}

	public AllSaleReportDao getAllSaleReportDaoImpl() {

		return new AllSaleReportDaoImpl();

	}

	public SaleReportDao getSaleReportDaoImpl() {

		return new SaleReportDaoImpl();

	}

	public RentReportDao getRentReportDaoImpl() {

		return new RentReportDaoImpl();

	}

	public ReplacementReportDao getReplacementReportDaoImpl() {

		return new ReplacementReportDaoImpl();

	}

	public GrnModuleDao getGrnModuleDaoImpl() {

		return new GrnModuleDaoImpl();

	}

	public InstallationModuleDao getInstallationModuleDaoImpl() {

		return new InstallationModuleDaoImpl();

	}

	public AlertReportDao getAlertReportDaoImpl() {

		return new AlertReportDaoImpl();

	}

	public EmployeeModuleDao getEmployeeModuleDaoImpl() {

		return new EmployeeModuleDaoImpl();

	}

	public GetSalarySheetDao getGetSalarySheet() {

		return new GetSalarySheet();
	}

	public AmcModuleDao getAmcModuleDaoImpl() {

		return new AmcModuleDaoImpl();
	}

	public InsertFsrModuleDao getInsertFsrModuleDaoImpl() {

		return new InsertFsrModuleDaoImpl();

	}

	public AssignEngineer4ServiceDao getAssignEngineer4ServiceDaoImpl() {

		return new AssignEngineer4ServiceDaoImpl();

	}

	public BillingModuleDao getBillingModuleDaoImpl() {

		return new BillingModuleDaoImpl();

	}

	public EnquiryFormDoa getEnquiryFormDaoImpl() {
		return new EnquiryFormDaoImpl();
	}
*/}

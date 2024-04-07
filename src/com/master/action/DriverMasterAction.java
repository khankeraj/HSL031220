package com.master.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.VehicleMasterDao;
import com.master.model.DriverModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;





public class DriverMasterAction extends ActionSupport implements ModelDriven{

	private DriverModel drivermodel = new DriverModel();
	
	 private File[] photo;
	 private String[] photoFileName;
	 private String[] photoContentType;
	
	 private String tdays;
	 private String tnet;
	 private String gtded;
	 private String gtgross="";
	 private String gtbonus="";
	 private String gtbbasic="";
	 private String gtptax="";
	 private String gtuniform="";
	 private String gtroom="";
	 private  String gtadv="";
	 private  String gfine="";
	 private  String gother="";
	
	
	/*private File driver_photo;
	private File aadhar_photo;
	private File license_photo;
	private String fileUploadContentType;
	private String fileUploadFileName;

	
	
	
	
	
	
	public String getFileUploadContentType() {
		return fileUploadContentType;
	}









	public void setFileUploadContentType(String fileUploadContentType) {
		this.fileUploadContentType = fileUploadContentType;
	}









	public String getFileUploadFileName() {
		return fileUploadFileName;
	}









	public void setFileUploadFileName(String fileUploadFileName) {
		this.fileUploadFileName = fileUploadFileName;
	}









	public File getDriver_photo() {
		return driver_photo;
	}









	public void setDriver_photo(File driver_photo) {
		this.driver_photo = driver_photo;
	}









	public File getAadhar_photo() {
		return aadhar_photo;
	}









	public void setAadhar_photo(File aadhar_photo) {
		this.aadhar_photo = aadhar_photo;
	}









	public File getLicense_photo() {
		return license_photo;
	}









	public void setLicense_photo(File license_photo) {
		this.license_photo = license_photo;
	}
*/








	








	






	public String getTdays() {
		return tdays;
	}









	public void setTdays(String tdays) {
		this.tdays = tdays;
	}









	public String getTnet() {
		return tnet;
	}









	public void setTnet(String tnet) {
		this.tnet = tnet;
	}









	public String getGtded() {
		return gtded;
	}









	public void setGtded(String gtded) {
		this.gtded = gtded;
	}









	public String getGtgross() {
		return gtgross;
	}









	public void setGtgross(String gtgross) {
		this.gtgross = gtgross;
	}









	public String getGtbonus() {
		return gtbonus;
	}









	public void setGtbonus(String gtbonus) {
		this.gtbonus = gtbonus;
	}









	public String getGtbbasic() {
		return gtbbasic;
	}









	public void setGtbbasic(String gtbbasic) {
		this.gtbbasic = gtbbasic;
	}









	public String getGtptax() {
		return gtptax;
	}









	public void setGtptax(String gtptax) {
		this.gtptax = gtptax;
	}









	public String getGtuniform() {
		return gtuniform;
	}









	public void setGtuniform(String gtuniform) {
		this.gtuniform = gtuniform;
	}









	public String getGtroom() {
		return gtroom;
	}









	public void setGtroom(String gtroom) {
		this.gtroom = gtroom;
	}









	public String getGtadv() {
		return gtadv;
	}









	public void setGtadv(String gtadv) {
		this.gtadv = gtadv;
	}









	public String getGfine() {
		return gfine;
	}









	public void setGfine(String gfine) {
		this.gfine = gfine;
	}









	public String getGother() {
		return gother;
	}









	public void setGother(String gother) {
		this.gother = gother;
	}

	List<DriverModel> drivermodeldetails = new ArrayList<>();

	public List<DriverModel> getDrivermodeldetails() {
		return drivermodeldetails;
	}









	public void setDrivermodeldetails(List<DriverModel> drivermodeldetails) {
		this.drivermodeldetails = drivermodeldetails;
	}









	public DriverModel getDrivermodel() {
		return drivermodel;
	}









	public String[] getPhotoFileName() {
		return photoFileName;
	}









	public void setPhotoFileName(String[] photoFileName) {
		this.photoFileName = photoFileName;
	}









	public String[] getPhotoContentType() {
		return photoContentType;
	}









	public void setPhotoContentType(String[] photoContentType) {
		this.photoContentType = photoContentType;
	}









	public void setDrivermodel(DriverModel drivermodel) {
		this.drivermodel = drivermodel;
	}


	public String insert_driver_details()
	{
		
		//HttpServletRequest request=ServletActionContext.getRequest();
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(drivermodel.getDriver_name());
		
		String response;
		int i = 0;
		try {
			i=new DriverMasterDao().insert_driver_Details(drivermodel, photo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		if(i==-1)
		{
			return "already";
		}
		
		try {
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
					ServletContext context = ServletActionContext.getServletContext();
					
					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");  
			        	
			        System.out.println("Image Location:" + filePath);//see the server console for actual location  
			        String ss="";
			        for (int i1 = 0; i1 < photo.length; i1++) {
			            File uploadedFile = photo[i1];
			            String fileName = photoFileName[i1];
			            System.out.println("file name: "+fileName);
			            //File destFile = new File(saveDirectory + File.separator + fileName);
			            try {
			            	
			            	if(i1==0)
			            		ss=drivermodel.getDriver_id()+"Driver-Photo(1).png";
			            	else if(i1==1)
			            		ss=drivermodel.getDriver_id()+"Aadhar-Photo(1).png";
			            	else
			            		ss=drivermodel.getDriver_id()+"License-Photo(1).png";
			            	
			            	//File fileToCreate = new File(filePath,ss);  
			            	File fileToCreate = new File(filePath, ss);  
			                FileUtils.copyFile(uploadedFile, fileToCreate);
			            } catch (IOException ex) {
			                System.out.println("Could not copy file "+fileName);
			                ex.printStackTrace();
			            }
			        }
			      
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		System.out.println("i in action :"+i);
		
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
	

	
	
	public File[] getPhoto() {
		return photo;
	}









	public void setPhoto(File[] photo) {
		this.photo = photo;
	}









	public String update_driver_details()
	{
		String response;
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
				ServletContext context = ServletActionContext.getServletContext();
		
		
		/*HttpServletRequest request=ServletActionContext.getRequest();*/
		String update_driver=request.getParameter("driver_id");
		System.out.println("update:"+ update_driver);
		
		System.out.println("driver name is : "+drivermodel.getDriver_name());
		int i=new DriverMasterDao().update_driver_details(drivermodel,update_driver);
		
		
		try {
			
					
					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");  
					//String filePath = "C:\\Folder1\\temp2";
					
					System.out.println("Image Location:" + filePath);//see the server console for actual location  
			        String ss="";
			        for (int i1 = 0; i1 < photo.length; i1++) {
			            File uploadedFile = photo[i1];
			            String fileName = photoFileName[i1];
			            System.out.println("file name: "+fileName);
			            //File destFile = new File(saveDirectory + File.separator + fileName);
			            try {
			            	
			            	if(i1==0)
			            		ss=drivermodel.getDriver_id()+"Driver-Photo(1).png";
			            	else if(i1==1)
			            		ss=drivermodel.getDriver_id()+"Aadhar-Photo(1).png";
			            	else
			            		ss=drivermodel.getDriver_id()+"License-Photo(1).png";
			            	
			            	//File fileToCreate = new File(filePath,ss);  
			            	File fileToCreate = new File(filePath, ss);  
			                FileUtils.copyFile(uploadedFile, fileToCreate);
			            } catch (IOException ex) {
			                System.out.println("Could not copy file "+fileName);
			                ex.printStackTrace();
			            }
			        }
					
					
					
					
					
					
					
					/*File srcFile = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+drivermodel.getDriver_photo());
					File srcFile1 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+drivermodel.getAadhar_photo());
					File srcFile2 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+drivermodel.getLicense_photo());
					
			        System.out.println("Image Location:" + filePath);//see the server console for actual location  
			        
			        String ss=drivermodel.getDriver_id()+"Driver-Photo(1).png";
			        String ss1=drivermodel.getDriver_id()+"Aadhar-Photo(1).png";
			        String ss2=drivermodel.getDriver_id()+"License-Photo(1).png";
			        String ss3="PUC-Photo(1).png";
			        String ss4="Servicing-Photo(1).png";
			        String ss5="Insurance-Photo(1).png";
			        
			        File fileToCreate = new File(filePath,ss);  
			        FileUtils.copyFile(srcFile, fileToCreate);
			        
			        File fileToCreate1 = new File(filePath,ss1);  
			        FileUtils.copyFile(srcFile1, fileToCreate1);
			        
			        File fileToCreate2 = new File(filePath,ss2);  
			        FileUtils.copyFile(srcFile2, fileToCreate2);
			        
			        File fileToCreate1 = new File(filePath,ss1);  
			        FileUtils.copyFile(aadhar_photo, fileToCreate1);
			        
			        File fileToCreate2 = new File(filePath,ss2);  
			        FileUtils.copyFile(license_photo, fileToCreate2);
			        
			        File fileToCreate3 = new File(filePath,ss3);  
			        FileUtils.copyFile(puc_photo, fileToCreate3);
			        
			        File fileToCreate4 = new File(filePath,ss4);  
			        FileUtils.copyFile(servicing_photo, fileToCreate4);
			        
			        File fileToCreate5 = new File(filePath,ss5);  
			        FileUtils.copyFile(insurance_photo, fileToCreate5);
			        */
			        
			        
			        
			        
		} catch (Exception e) {
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
	
	public String salaryForm()
	{
		return "success";
	}

	
	
	public String driverSalaryInsert()
	{
		String response = "";
		int i = 0;
		try {
			i=new DriverMasterDao().insert_salary_Details(drivermodel);
			if(i>0)
			{
				response = "success";
			}
			else
			{
				response = "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	public String salary_edit_delete_report()
	{
		drivermodeldetails = new DriverMasterDao().getSalaryReport();
		System.out.println("size: "+drivermodeldetails.size());
		return "success";
	}
	
	
	public String salary_report()
	{
		return "success";
	}
	
	public String salary_report1()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
				ServletContext context = ServletActionContext.getServletContext();
		
		String month = request.getParameter("mnth");
		String year = request.getParameter("yr");
		
		System.out.println("month: "+month);
		System.out.println("year: "+year);
				
		drivermodeldetails = new DriverMasterDao().getSalaryDetails(month, year);
		
		System.out.println("size: "+drivermodeldetails.size());
		
		
		return "success";
	}

	
	public String submit_salary_report1()
	{
		String response = "";
		int i = 0;
		try {
			response=new DriverMasterDao().submit_salary_Details(drivermodel);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return response;
	}
	
	
	public String fetchForSalaryUpdate()
	{
		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String sal_id=request.getParameter("sal_id");
		
		drivermodeldetails=new DriverMasterDao().fetchForUpdateSalary(sal_id);
		
		System.out.println(drivermodeldetails.size());
		
		return "success";
	}
	
	
	public String updateSalaryDetails()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
		//String update_vehicle=request.getParameter("vehicle_id");
		//System.out.println("update:"+update_vehicle);
		
		System.out.println("vehicle no is : "+drivermodel.getSal_id());
		int i=new DriverMasterDao().update_salary_details(drivermodel);
		
		if(i>0)
			return "success";
		else
			return "fail";
	}
	
	public String DeleteSalary()
	{

		String response;
		HttpServletRequest request=ServletActionContext.getRequest();
		String sal_id=request.getParameter("sal_id");
		
		int i=new DriverMasterDao().delete_salary_details(sal_id);
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
	
	public String edit_salary_generation()
	{
		//String response;
		
		drivermodeldetails=new DriverMasterDao().fetchSalaryGenerationEditDetails();
		
		System.out.println(drivermodeldetails.size());
		
		return "success";
	}
	
	public String edit_salary_generation1()
	{

		HttpServletRequest request=ServletActionContext.getRequest();
		Map session = ActionContext.getContext().getSession();
		//LoginBean bean = new LoginBean();
		//bean = (LoginBean) session.get(Constants.USER_PROFILE);
		
		String month=request.getParameter("mnth");
		String year=request.getParameter("yr");
		drivermodel.setMonth(month);
		drivermodel.setYear(year);
			
			drivermodeldetails=new DriverMasterDao().EditSalaryGenerate(drivermodel); 
			System.out.println("Attendance Action........."+drivermodeldetails.size());
		//	System.out.println("Area_bean"+Area_bean.size());
			try {
			if(drivermodeldetails.size()>0)
			{
				tdays=drivermodeldetails.get(drivermodeldetails.size()-1).getDate11x();				
				tnet=drivermodeldetails.get(drivermodeldetails.size()-1).getArea();	
				gtded=drivermodeldetails.get(drivermodeldetails.size()-1).getAge();
				gtgross=drivermodeldetails.get(drivermodeldetails.size()-1).getDate12x();
				gtbonus=drivermodeldetails.get(drivermodeldetails.size()-1).getDate13x();
				gtbbasic=drivermodeldetails.get(drivermodeldetails.size()-1).getDate14x();
				gtptax=drivermodeldetails.get(drivermodeldetails.size()-1).getDate15x();
				gtuniform=drivermodeldetails.get(drivermodeldetails.size()-1).getDate16x();
				gtroom=drivermodeldetails.get(drivermodeldetails.size()-1).getDate17x();
				gtadv=drivermodeldetails.get(drivermodeldetails.size()-1).getDate18x();
				gfine=drivermodeldetails.get(drivermodeldetails.size()-1).getDate19x();
				gother=drivermodeldetails.get(drivermodeldetails.size()-1).getDate20x();
			}
			}catch(Exception e){}
			
			
			
			request.setAttribute("month",month);
			
			
			request.setAttribute("year",year);
			
			return "success";
			


		
	}
	
	
	
	public String submit_salary_report2()
	{
		System.out.println("Attendance Submit..........");
		System.out.println(">>>."+drivermodel.getDriver_id());
		String response = new DriverMasterDao().Salary_submit1(drivermodel);
		 
		 return response;
	}
	
	public String driverpayment()
	{
		return "success";
	}
	
	
	
	public String driverpayment1()
	{
		HttpServletRequest request=ServletActionContext.getRequest();
 		Map session = ActionContext.getContext().getSession();
 		
 		String month=request.getParameter("mnth");
		String year=request.getParameter("yr");
		drivermodel.setMonth(month);
		drivermodel.setYear(year);
 		
 		/*String month=drivermodel.getMonth();
 		String year=drivermodel.getYear();*/
 			
 		System.out.println("month: "+month);
 		System.out.println("year: "+year);
 		
 		drivermodeldetails=new DriverMasterDao().salary_payment_search(drivermodel); 
 			System.out.println("Attendance Action.........");
 		System.out.println("SRSS_Bean: "+drivermodeldetails.size());
 			
 			
 			request.setAttribute("month",month);
 			
 			
 			request.setAttribute("year",year);
 			
 			return "success";
 			


 	}
	
	
	
	public String payment_submit()
	{
		// TODO Auto-generated method stubbin.get
		Map session = ActionContext.getContext().getSession();
		/*LoginBean bean = new LoginBean();
		bean = (LoginBean) session.get(Constants.USER_PROFILE);*/
			
		/*System.out.println("Attendance Submit..........");
		System.out.println(">>>."+bin.getUnit());*/
		System.out.println(">>>."+drivermodel.getDriver_id());
		String response = new DriverMasterDao().payment_submit(drivermodel);
		 
		 
		 System.out.println("response"+response);
		/*if(response.equals("Already")) 
		 {
		 	response="Already";
		 }  
		  else
		
		 if(response.equals("success"))
		  {
		 	 response="success"; 
		  } 
		  else
		  {
		 	 response="fail";
		  }*/

		return response;

	}
	
	
	
	
	
	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return drivermodel;
	}
	
	
	
	
}

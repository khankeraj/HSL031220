package com.master.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.master.dao.DriverMasterDao;
import com.master.dao.EmployeeMasterDAO;
import com.master.dao.ProductMasterDao;
import com.master.dao.VehicleMasterDao;
import com.master.model.DriverModel;
import com.master.model.VehicleModel;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VehicleMasterAction extends ActionSupport implements ModelDriven{

	private VehicleModel vehiclemodel = new VehicleModel();
	private List<VehicleModel> vehicleDetails = new ArrayList<>();
	
	private File road_tax_photo;
	private File fitness_tax_photo;
	private File permit_tax_photo;
	private File puc_photo;
	private File servicing_photo;
	private File insurance_photo;
	
	private File[] photo;
	 public File[] getPhoto() {
		return photo;
	}









	public void setPhoto(File[] photo) {
		this.photo = photo;
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


	private String[] photoFileName;
	 private String[] photoContentType;
	
	
	
	public File getRoad_tax_photo() {
		return road_tax_photo;
	}









	public void setRoad_tax_photo(File road_tax_photo) {
		this.road_tax_photo = road_tax_photo;
	}









	public File getFitness_tax_photo() {
		return fitness_tax_photo;
	}









	public void setFitness_tax_photo(File fitness_tax_photo) {
		this.fitness_tax_photo = fitness_tax_photo;
	}









	public File getPermit_tax_photo() {
		return permit_tax_photo;
	}









	public void setPermit_tax_photo(File permit_tax_photo) {
		this.permit_tax_photo = permit_tax_photo;
	}









	public File getPuc_photo() {
		return puc_photo;
	}









	public void setPuc_photo(File puc_photo) {
		this.puc_photo = puc_photo;
	}









	public File getServicing_photo() {
		return servicing_photo;
	}









	public void setServicing_photo(File servicing_photo) {
		this.servicing_photo = servicing_photo;
	}









	public File getInsurance_photo() {
		return insurance_photo;
	}









	public void setInsurance_photo(File insurance_photo) {
		this.insurance_photo = insurance_photo;
	}









	public List<VehicleModel> getVehicleDetails() {
		return vehicleDetails;
	}









	public void setVehicleDetails(List<VehicleModel> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}









	public void setVehiclemodel(VehicleModel vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}









	public VehicleModel getVehiclemodel() {
		return vehiclemodel;
	}









	public void setVehiclemodel(DriverModel drivermodel) {
		this.vehiclemodel = vehiclemodel;
	}


	public String insert_vehicle_details()
	{
		String response;
		//HttpServletRequest request=ServletActionContext.getRequest();
		int i = 0;
		try {
			i=new VehicleMasterDao().insert_vehicle_Details(vehiclemodel);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("i in action :"+i);
		
		if(i==-1)
		{
			return "already";
		}
		
		
		
		
		try {
			HttpServletRequest request = (HttpServletRequest) ActionContext
					.getContext().get(ServletActionContext.HTTP_REQUEST);
					ServletContext context = ServletActionContext.getServletContext();
					
					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");  
			          
					
					String ss="";
			        for (int i1 = 0; i1 < photo.length; i1++) {
			            File uploadedFile = photo[i1];
			            String fileName = photoFileName[i1];
			            System.out.println("file name: "+fileName);
			            //File destFile = new File(saveDirectory + File.separator + fileName);
			            try {
			            	
			            	if(i1==0)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Road-Tax-Photo(1).png";
			            	else if(i1==1)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Fitness-Tax-Photo(1).png";
			            	else if(i1==2)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Permit-Tax-Photo(1).png";
			            	else if(i1==3)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"PUC-Photo(1).png";
			            	else if(i1==4)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Servicing-Photo(1).png";
			            	else if(i1==5)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Insurance-Photo(1).png";
			            	//File fileToCreate = new File(filePath,ss);  
			            	File fileToCreate = new File(filePath, ss);  
			                FileUtils.copyFile(uploadedFile, fileToCreate);
			            } catch (IOException ex) {
			                System.out.println("Could not copy file "+fileName);
			                ex.printStackTrace();
			            }
			        }
			        
					
					
					
					
					
					
					
					
					
					//String filePath = "C:\\Folder1\\temp2";
					/*File srcFile = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getRoad_tax_photo());
					File srcFile1 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getFitness_tax_photo());
					File srcFile2 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getPermit_tax_photo());
					File srcFile3 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getPuc_photo());
					File srcFile4 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getServicing_photo());
					File srcFile5 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getInsurance_photo());
					
					
					
			        System.out.println("Image Location:" + filePath);//see the server console for actual location  
			        
			        System.out.println("road tax: "+vehiclemodel.getRoad_tax_photo());
			        System.out.println("fitness tax: "+vehiclemodel.getFitness_tax_photo());
			        System.out.println("permit tax: "+vehiclemodel.getPermit_tax_photo());
			        System.out.println("puc photo: "+vehiclemodel.getPuc_photo());
			        System.out.println("road tax photo: "+road_tax_photo);
			        
			        String ss=vehiclemodel.getVehicle_no()+"-"+"Road-Tax-Photo(1).png";
			        String ss1=vehiclemodel.getVehicle_no()+"-"+"Fitness-Tax-Photo(1).png";
			        String ss2=vehiclemodel.getVehicle_no()+"-"+"Permit-Tax-Photo(1).png";
			        String ss3=vehiclemodel.getVehicle_no()+"-"+"PUC-Photo(1).png";
			        String ss4=vehiclemodel.getVehicle_no()+"-"+"Servicing-Photo(1).png";
			        String ss5=vehiclemodel.getVehicle_no()+"-"+"Insurance-Photo(1).png";
			        
			        File fileToCreate = new File(filePath,ss);  
			        FileUtils.copyFile(srcFile, fileToCreate);
			        
			        File fileToCreate1 = new File(filePath,ss1);  
			        FileUtils.copyFile(srcFile1, fileToCreate1);
			        
			        File fileToCreate2 = new File(filePath,ss2);  
			        FileUtils.copyFile(srcFile2, fileToCreate2);
			        
			        File fileToCreate3 = new File(filePath,ss3);  
			        FileUtils.copyFile(srcFile3, fileToCreate3);
			        
			        File fileToCreate4 = new File(filePath,ss4);  
			        FileUtils.copyFile(srcFile4, fileToCreate4);
			        
			        File fileToCreate5 = new File(filePath,ss5);  
			        FileUtils.copyFile(srcFile5, fileToCreate5);
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
	

	
	
	
	public String update_vehicle_details()
	{
		String response;
		HttpServletRequest request1 = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
				ServletContext context = ServletActionContext.getServletContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String update_vehicle=request.getParameter("vehicle_id");
		System.out.println("update:"+update_vehicle);
		
		System.out.println("vehicle no is : "+vehiclemodel.getVehicle_no());
		int i=new VehicleMasterDao().update_vehicle_details(vehiclemodel,update_vehicle);
		
		
		
		try {
			
					
					String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");  
			          
					String ss="";
			        for (int i1 = 0; i1 < photo.length; i1++) {
			            File uploadedFile = photo[i1];
			            String fileName = photoFileName[i1];
			            System.out.println("file name: "+fileName);
			            //File destFile = new File(saveDirectory + File.separator + fileName);
			            try {
			            	
			            	if(i1==0)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Road-Tax-Photo(1).png";
			            	else if(i1==1)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Fitness-Tax-Photo(1).png";
			            	else if(i1==2)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Permit-Tax-Photo(1).png";
			            	else if(i1==3)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"PUC-Photo(1).png";
			            	else if(i1==4)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Servicing-Photo(1).png";
			            	else if(i1==5)
			            		ss=vehiclemodel.getVehicle_no()+"-"+"Insurance-Photo(1).png";
			            	//File fileToCreate = new File(filePath,ss);  
			            	File fileToCreate = new File(filePath, ss);  
			                FileUtils.copyFile(uploadedFile, fileToCreate);
			            } catch (IOException ex) {
			                System.out.println("Could not copy file "+fileName);
			                ex.printStackTrace();
			            }
			        }
					
					
					
					
					/*File srcFile = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getRoad_tax_photo());
					File srcFile1 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getFitness_tax_photo());
					File srcFile2 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getPermit_tax_photo());
					File srcFile3 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getPuc_photo());
					File srcFile4 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getServicing_photo());
					File srcFile5 = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\"+vehiclemodel.getInsurance_photo());
					
					
					System.out.println("road tax photo: "+vehiclemodel.getRoad_tax_photo());
			        System.out.println("Image Location:" + filePath);//see the server console for actual location  
			        
			        String ss=vehiclemodel.getVehicle_no()+"-"+"Road-Tax-Photo(1).png";
			        String ss1=vehiclemodel.getVehicle_no()+"-"+"Fitness-Tax-Photo(1).png";
			        String ss2=vehiclemodel.getVehicle_no()+"-"+"Permit-Tax-Photo(1).png";
			        String ss3=vehiclemodel.getVehicle_no()+"-"+"PUC-Photo(1).png";
			        String ss4=vehiclemodel.getVehicle_no()+"-"+"Servicing-Photo(1).png";
			        String ss5=vehiclemodel.getVehicle_no()+"-"+"Insurance-Photo(1).png";
			        
			        File fileToCreate = new File(filePath,ss);  
			        FileUtils.copyFile(srcFile, fileToCreate);
			        
			        File fileToCreate1 = new File(filePath,ss1);  
			        FileUtils.copyFile(srcFile1, fileToCreate1);
			        
			        File fileToCreate2 = new File(filePath,ss2);  
			        FileUtils.copyFile(srcFile2, fileToCreate2);
			        
			        File fileToCreate3 = new File(filePath,ss3);  
			        FileUtils.copyFile(srcFile3, fileToCreate3);
			        
			        File fileToCreate4 = new File(filePath,ss4);  
			        FileUtils.copyFile(srcFile4, fileToCreate4);
			        
			        File fileToCreate5 = new File(filePath,ss5);  
			        FileUtils.copyFile(srcFile5, fileToCreate5);*/
			        
			        
			        
			        
			        
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



	public String fetchVehicleAlertDetails()
	{
		vehicleDetails = new VehicleMasterDao().fetchVehicleAlertDetails();
		
		System.out.println("size: "+vehicleDetails.size());
		
		if(vehicleDetails.size()>0)
		{
			return "success";
		}
		
		else
		{
			return "fail";
		}
	}


	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return vehiclemodel;
	}
	
	
	
	
}

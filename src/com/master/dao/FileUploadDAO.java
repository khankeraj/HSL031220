package com.master.dao;

import java.sql.Connection;

import com.DB.DBConnection;
import com.master.model.FileUploadModel;

public class FileUploadDAO {
	DBConnection connection=new DBConnection();
	
	public int insert_image(FileUploadModel fileUpload)
	{
		Connection conn=connection.getConnection();
		
		
		return 0;
		
	}

}

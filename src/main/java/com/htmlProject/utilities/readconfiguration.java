package com.htmlProject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

		public class readconfiguration {
	
		Properties pro;
	
		public  readconfiguration() {
		File src = new File("C:\\Users\\Lalit\\eclipse-workspace\\Framework\\configuration\\cong.properties");
		
		try {
		FileInputStream file = new FileInputStream(src);
		
		pro = new Properties();
		pro.load(file);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
		public String getAppURL()
		{
			String url = pro.getProperty("baseURL");
			return url;
		}
		public String getUsername()
		{
			String username = pro.getProperty("username");
			return username;
		}
		public String getPassword()
		{
			String password = pro.getProperty("Password");
			return password;
		}
}








		
		
		
		
		


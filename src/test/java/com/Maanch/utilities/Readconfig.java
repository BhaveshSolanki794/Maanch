package com.Maanch.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Readconfig {
	
    Properties pro;
	
	public Readconfig() {
		
		File src = new File("./Configuration Files/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error message is" + e.getMessage());
		}
		
	}
	
	public String getBaseUrl() {
		String url = pro.getProperty("baseurl");
		return url;
	}
	
	
	public String getUsername() {
		String user = pro.getProperty("username");
		return user;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath() {
		String chrome = pro.getProperty("browser");
		return chrome;
	}


}

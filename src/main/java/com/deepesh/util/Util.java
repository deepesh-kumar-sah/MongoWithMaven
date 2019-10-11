package com.deepesh.util;

import java.util.ArrayList;
import java.util.Collections;

public class Util {
	
	public static String MONGO_USER="Deepeshh",
			
						 MONGO_PASS=Helper.encodeURIComponent("mtap@381"),
						 
						 DB_NAME="studentdb",
						 
						 COLL_NAME="student",
						 
						 HOST_NAME="localhost",
						 
						 Host_IP="127.0.0.1",
						 
						 PORT_NO="27017",
						 
						 HOST_NAME_COMPASS="@cluster0-loga8.mongodb.net",
						 
						 URI="mongodb+srv://"
								+ MONGO_USER+":"+ MONGO_PASS
								+ HOST_NAME_COMPASS
								+ "/test" ;
	
	public static ArrayList<String> EMP_KEY=new ArrayList<String>();
	
	public static ArrayList<String> ADDRESS_KEYS=new ArrayList<String>();
	
	static {
		Collections.addAll(EMP_KEY, new String[] {"empid","name","age","mobile","address"});
		Collections.addAll(ADDRESS_KEYS, new String[] {"street","city","state","country","pin"});
		
		
	}
	
	
	
}

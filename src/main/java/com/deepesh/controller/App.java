package com.deepesh.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.BSON;
import org.bson.json.JsonParseException;

import com.deepesh.database.MongoDbMethod;
import com.deepesh.pojo.Address;
import com.deepesh.pojo.Employee;
import com.deepesh.util.Util;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "--------Main method--------" );


//------------To Insert Document in MongoDB------------------"
		
//		 Address address=new Address("Tin Factory","Bangalore","Karnataka","India",980045); 
//		 Employee employee=new Employee(102,"Rohit","7909872455",5,address);
//		 
//		 BasicDBObject obj=(BasicDBObject) JSON.parse(employee.toString());
//		 MongoDbMethod.insertData(obj);
		 
        
//------------To Retrieve MongoDB Document------------------"
        //MongoDbMethod.retrieveData();
        //MongoDbMethod.retrieveData_By_Name("Deepesh","Ayush","mohit","gopal"); 
        
        //MongoDbMethod.retrieve_key_values("street","Marathali","RT Nagar","Tin Factory","Btm");
        //MongoDbMethod.retrieve_key_values("empid", 101,102,103);
        MongoDbMethod.retrieve_key_values("age", 20,21,22);
        
        
//------------To Update Document MongoDB------------------"
		/*
		 * BasicDBObject query=new BasicDBObject() .append("name", "Deepesh");
		 * BasicDBObject update=new BasicDBObject() .append("$set", new BasicDBObject()
		 * .append("empid", 101)); MongoDbMethod.updateData(query, update);
		 */
        
//------------To Delete Document From MongoDB------------------"
        //MongoDbMethod.deleteUsing_Key_StringArray_$eq("name", "Deepesh");
        //MongoDbMethod.deleteUsing_Key_StringArray_$in("name", "Sahil","Ankush","Ismil");
        /*List names=new ArrayList();
        names.add("Deepesh");
        names.add("Rupak");
        MongoDbMethod.deleteUsing_Key_ArrayList_$in("name", names);*/
        

    }
}

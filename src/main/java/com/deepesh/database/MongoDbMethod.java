package com.deepesh.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.bson.BasicBSONObject;

import com.deepesh.pojo.Address;
import com.deepesh.pojo.Employee;
import com.deepesh.util.Helper;
import com.deepesh.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDbMethod {
	
	public static MongoClientURI clienturi;
	public static MongoClient client;
	public static DB db;
	public static DBCollection dbcol;
	public static DBCursor cursor;
	public static DBObject dbobject;
	public static BasicBSONObject dbobject_addr;
	
	static {
		try {
			clienturi=new MongoClientURI(Util.URI);
			client=new  MongoClient(clienturi);
			
			//client= new MongoClient(Util.Host_IP,Integer.parseInt(Util.PORT_NO));
			//MongoDatabase mdb=client.getDatabase(Util.DB_NAME);
			db=client.getDB(Util.DB_NAME);
			
			//MongoCollection mdbcol=mdb.getCollection(Util.COLL_NAME);
			dbcol=db.getCollection(Util.COLL_NAME);
			
			System.out.println("-----------Database Connected-------------");
			
		} catch (Exception e) {
			System.out.println("-------------Could not connected to Database-------------");
			e.printStackTrace();
		}
	}
	
	public static void insertData(BasicDBObject obj) {
		try {
			dbcol.insert(obj);
			System.out.println("Record_Inserted Successful whose Name is "+obj.getString("name"));
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Inserte----------- ");
			e.printStackTrace();
		}
	}
	
	public static void retrieveData() {
		try {
			cursor=dbcol.find();
			System.out.println(cursor.count());
			while (cursor.hasNext()) {
				dbobject=cursor.next();
				System.out.println(dbobject);
				System.out.println(dbobject.get("name")+" ,  "+dbobject.get("mobile"));
			}
			System.out.println("Record_Retrieved Successful");
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Retrieve----------- ");
			e.printStackTrace();
		}
		
	}
	public static void retrieveData_By_Name(String name) {
		try {
			cursor=dbcol.find();
			System.out.println(cursor.count());
			while (cursor.hasNext()) {
				dbobject=cursor.next();
				if (name.equalsIgnoreCase((String)dbobject.get("name"))) {
					System.out.println(dbobject.get("name")+" ,  "+dbobject.get("mobile"));
				}
				//System.out.println(dbobject.get("name"));
			}
			System.out.println("Record_Retrieved Successful");
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Retrieve----------- ");
			e.printStackTrace();
		}
		
	}

	public static void retrieveData_By_Name(String...names) {
		try {
			cursor=dbcol.find();
			System.out.println(cursor.count());
			int count=0;
			while (cursor.hasNext()) {
				dbobject=cursor.next();
				if (Helper.isStringExist((String)dbobject.get("name"), names)) {
					System.out.println(dbobject.get("name")+" ,  "+dbobject.get("mobile"));
				}
				//System.out.println(dbobject.get("name"));
			}
			System.out.println("Record_Retrieved Successful");
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Retrieve----------- ");
			e.printStackTrace();
		}
		
	}
	
	
	public static void retrieve_key_values(String key,Object...values) {
		
		try {
			cursor=dbcol.find();
	
			ArrayList al=new ArrayList();
			Collections.addAll(al, values);
			System.out.println("Input "+al);
			
			while (cursor.hasNext()) {
				dbobject=cursor.next();
				dbobject_addr=(BasicBSONObject)dbobject.get("address");
				ObjectMapper mapper=new ObjectMapper();
				
				if (Util.EMP_KEY.contains(key)) {
					if (al.contains(dbobject.get(key))) {
						
						Employee emp=mapper.readValue(dbobject.toString(), Employee.class);
						Address addr=emp.getAddress();
						
						System.out.println("------------Employee----------");
						System.out.println(emp.getEmpid()+"\n"+emp.getName()+"\n"+emp.getAge()+"\n"+emp.getMobile()+"\n"+"\t--------Address--------\n\t"+addr.getStreet()+"\n\t"+addr.getCity()+"\n\t"+addr.getState()+"\n\t"+addr.getCountry()+"\n\t"+addr.getPin());
					}
				}else {
					if (al.contains(dbobject_addr.get(key))) {
						
						Employee emp=mapper.readValue(dbobject.toString(), Employee.class);
						Address addr=emp.getAddress();
						
						System.out.println("------------Employee Addr----------");
						System.out.println(emp.getEmpid()+"\n"+emp.getName()+"\n"+emp.getAge()+"\n"+emp.getMobile()+"\n"+"\t--------Address--------\n\t"+addr.getStreet()+"\n\t"+addr.getCity()+"\n\t"+addr.getState()+"\n\t"+addr.getCountry()+"\n\t"+addr.getPin());
					}
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateData(BasicDBObject query,BasicDBObject update) {
		try {
			
			dbcol.update(query, update);
			//dbcol.updateMulti(query, update);
			System.out.println("Record_Updated Successful");
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Update----------- ");
			e.printStackTrace();
		}
	} 

	public static void deleteUsing_Key_Val(String key,String val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, val));
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_StringArray_$eq(String key,Object val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$eq", val)));

			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
			
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_StringArray_$neq(String key,Object val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$ne", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_StringArray_$in(String key,String...val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$in", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_ArrayList_$in(String key,List val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$in", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_ArrayList_$nin(String key,List val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$in", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}

	public static void deleteUsing_Key_ArrayList_$lt(String key,long val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$lt", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}
	
	public static void deleteUsing_Key_ArrayList_$gt(String key,long val) {
		try {
			dbcol.remove(new BasicDBObject().append(key, new BasicDBObject().append("$gt", val)));
			System.out.println("Record_Deleted Successful whose "+key+" was "+val);
		} catch (Exception e) {
			System.out.println("-----------Exception occurs during Delete----------- ");
			e.printStackTrace();
		}
	}

		
}

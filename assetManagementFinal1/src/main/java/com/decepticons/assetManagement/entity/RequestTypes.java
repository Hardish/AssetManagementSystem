package com.decepticons.assetManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Document(collection = "RequestTypes")
public class RequestTypes
{
	  @Id
	  private ObjectId id = new ObjectId();
//	  private String id;
	  
	  
	  @Field("requesttype")
	  public String requesttype;
	  
	  
	  
	  @Field("role")
	  public String role;
	 
	  
	  public RequestTypes(ObjectId id  ,String requesttype ,String role)
	  {
		  this.id = id;
		  this.requesttype = requesttype;
		
		  this.role = role;
		
	  }
//	  public RequestTypes(String requesttype,String role)
//	  {
//		  super();
//		
//		  this.requesttype = requesttype;
//		  this.role = role;
//	  }
	 public RequestTypes() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	 {
		 return "Request Type "+ requesttype+" role "+ role;
	 }
	
}

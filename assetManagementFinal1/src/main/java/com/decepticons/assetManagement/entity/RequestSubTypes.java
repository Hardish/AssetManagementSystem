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
@Document(collection = "RequestSubTypes")
public class RequestSubTypes {
	  @Id
	  private ObjectId id = new ObjectId();
//	  private String id;
	  
	  
	  @Field("requestsubtype")
	  public String requestsubtype;
	  @Field("requesttype")
	  public String requesttype;
	
	  
	  public RequestSubTypes(ObjectId id,String requesttype,String requestsubtype)
	  {
		  this.id = id;
		  this.requesttype = requesttype;
		  this.requestsubtype = requestsubtype;
	  }
//	  public RequestTypes(String requesttype,String role)
//	  {
//		  super();
//		
//		  this.requesttype = requesttype;
//		  this.role = role;
//	  }
	 public RequestSubTypes() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	 {
		 return "Request Type "+ requesttype+"SubRequest"+requestsubtype ;
	 }
	
}


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

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Document(collection = "RequestTypes")
public class RequestTypes
{
	  @Id private String id;
	  @Field("Request_type")
	  public String requesttype;
	  @Field("Access")
	  public boolean access;
	  
	  
	  public RequestTypes(String requesttype,boolean access)
	  {
		  super();
		  this.requesttype = requesttype;
		  this.access = access;
	  }
	
	 public RequestTypes() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	 {
		 return "Request Type "+ requesttype+" access "+ access;
	 }
	
}

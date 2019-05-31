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
@Document(collection = "RequestStatus")
public class RequestStatus
{
	  @Id
	  private ObjectId id = new ObjectId();

	  @Field("requeststatus")
	  public String requeststatus;
	 

	  public RequestStatus(ObjectId id  ,String requeststatus)
	  {
		  this.id = id;
		  this.requeststatus = requeststatus;
	  }

	 public RequestStatus() {
		// TODO Auto-generated constructor stub
	}

	public String toString()
	 {
		 return " requeststatus "+ requeststatus;
	 }
	
}

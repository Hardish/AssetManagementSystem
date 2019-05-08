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

@Data
@Entity
@Table(name="requesttypeemp")
public class RequestTypeEmp {


	@Getter
	@Setter
	//define fields
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "REQTYPEEMP_ID_SEQ", allocationSize = 1)
	@Column(name="request_type_id")
	private int id;

	@Column(name="request_type")
	private String requesttype;
	
	
	
	//define constructors
	
	public RequestTypeEmp(int ID,String request_type)
	{
		super();
		this.requesttype = request_type;
		this.id = ID;
	}
	

	
	public RequestTypeEmp(String request_type)
	{
		super();
		this.requesttype = request_type;
		
	}
	

	
	
	//define getter/setters
	
	public RequestTypeEmp() {
		// TODO Auto-generated constructor stub
	}

	//define toString
	@Override
	public String toString() {
		return "Request Type [getId()=" + getId() + ", getRequest_type()=" + getRequesttype() + "]";
	}
	
	
}

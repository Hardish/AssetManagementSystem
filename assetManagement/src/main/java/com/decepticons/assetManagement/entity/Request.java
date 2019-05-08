package com.decepticons.assetManagement.entity;

import java.sql.Date;

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
@Table(name="request")
public class Request {


	@Getter
	@Setter
	//define fields
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator = "id_Sequence")
    @SequenceGenerator(name = "id_Sequence", sequenceName = "REQ_ID_SEQ", allocationSize = 1)
	@Column(name="request_id")
	private int id;

	@Column(name="request_type")
	private String requesttype;
	
	@Column(name="request_subtype")
	private String requestsubtype;
	
	@Column(name="request_description")
	private String requestdescription;
	
	
	@Column(name="employee_id")
	private Integer requestemployee_id;
	
	
	@Column(name="first_name")
	private String requestfirstname;
	
	@Column(name="last_name")
	private String requestlastname;
	
	@Column(name="request_date")
	private Date requestdate;
	
	
	@Column(name="priority")
	private Integer requestpriority;
	
	@Column(name="department_name")
	private String requestdepartmentname;
	
	@Column(name="asset_name")
	private String requestassetname;
	
	@Column(name="units")
	private Integer requestunits;
	
	
	@Column(name="request_status")
	private String requeststatus;
	
	@Column(name="new_owner_empid")
	private Integer requestassigtoowner;
	
//	@Column(name="new_owner_emp_first_name")
//	private String requestnewownerempfirstname;
	
	@Column(name="assigned_to")
	private String requestassignedto;

	@Column(name="assigned_date")
	private Date requestassigneddate;
	
	@Column(name="closed_before")
	private Date requestclosebefore;
	
	@Column(name="assigned_to_emp_id")
	private Integer requestassignedempid;
	
	
	//define constructors
	
	public Request(int ID,String request_type, String request_subtype,
			String request_description, Integer employee_id,String first_name,String last_name,
			Date request_date, Integer priority,String department_name,String asset_name,
			Integer units, String request_status,Integer new_owner_empid		//, String new_owner_emp_first_name
			,Integer assigned_to_emp_id,String assigned_to ,Date assigned_date,Date closed_before)
	{
		super();
		this.requesttype = request_type;
		this.requestsubtype = request_subtype;
		this.id = ID;
		this.requestdescription = request_description;
		this.requestemployee_id = employee_id;
		this.requestfirstname = first_name;
		this.requestlastname = last_name;
		this.requestdate = request_date;
		this.requestpriority = priority;
		this.requestdepartmentname = department_name;
		this.requestassetname = asset_name;
		this.requestunits = units;
		this.requeststatus = request_status;
		this.requestassigtoowner = new_owner_empid;
//		this.requestnewownerempfirstname = new_owner_emp_first_name;
//		this.requestassignedempid = assigned_to_emp_id;
		this.requestassignedto = assigned_to;
		this.requestassigneddate = assigned_date;
		this.requestclosebefore = closed_before;
	}
	

	
	public Request(String request_type, String request_subtype,
			String request_description, Integer employee_id,String first_name, String last_name,
			Date request_date,Integer priority,String department_name,String asset_name,
			Integer units,String request_status,int new_owner_empid 		//, String new_owner_emp_first_name
			,Integer assigned_to_emp_id,String assigned_to,Date assigned_date,Date closed_before)
	{
		super();
		this.requesttype = request_type;
		this.requestsubtype = request_subtype;
		this.requestdescription = request_description;
		this.requestemployee_id = employee_id;
		this.requestfirstname = first_name;
		this.requestlastname = last_name;
		this.requestdate = request_date;
		this.requestpriority = priority;
		this.requestdepartmentname = department_name;
		this.requestassetname = asset_name;
		this.requestunits = units;
		this.requeststatus = request_status;
		this.requestassigtoowner = new_owner_empid;
//		this.requestnewownerempfirstname = new_owner_emp_first_name;
//		this.requestassignedempid = assigned_to_emp_id;
		this.requestassignedto = assigned_to;
		this.requestassigneddate = assigned_date;
		this.requestclosebefore = closed_before;
	}
	

	
	
	//define getter/setters
	
	public Request() {
		// TODO Auto-generated constructor stub
	}

	//define toString
	@Override
	public String toString() {
		return "Request [getId()=" + getId() + ", getRequest_type()=" + getRequesttype() + ", getRequestsubtype()="
				+ getRequestsubtype() + "]";
	}
	
	
}

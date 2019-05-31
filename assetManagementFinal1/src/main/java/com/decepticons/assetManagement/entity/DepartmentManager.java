package com.decepticons.assetManagement.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "department_manager")
public class DepartmentManager implements Serializable{
	
	@Getter
	@Setter
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_DeptManSequence")
	@SequenceGenerator(name = "id_DeptManSequence", sequenceName = "DEPTMAN_ID_SEQ", allocationSize = 1)
	@Column(name = "deptmanager_id")
	private int deptmanagerid;
	
//	@Column(name = "department_id")
//	private int deptManId;
		
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department deptId;
	
//	@Column(name = "employee_id")
//	private int deptEmpId;
	

	@OneToOne
	@JoinColumn(name = "employee_id")
//	@Column(name = "employee_id")
	private Employee deptEmpId;
	
	@Override
	public String toString()
	{
		return deptmanagerid+" - " + deptEmpId +  "-" + deptId ;
	}
	
}

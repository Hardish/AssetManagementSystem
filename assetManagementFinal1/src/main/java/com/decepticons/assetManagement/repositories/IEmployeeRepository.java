package com.decepticons.assetManagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;

@RepositoryRestResource
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	public List<Employee> findByDepartment(Department dept);
	
	public Employee findByUserName(String userName);
}

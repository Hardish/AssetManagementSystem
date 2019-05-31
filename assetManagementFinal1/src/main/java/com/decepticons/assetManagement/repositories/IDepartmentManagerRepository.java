package com.decepticons.assetManagement.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Employee;

@RepositoryRestResource
public interface IDepartmentManagerRepository extends JpaRepository<DepartmentManager, Integer> {
	
	
//	@Query( value = "SELECT e.first_name, e.last_name, e.email, e.phone_number "
//			+ "FROM department_manager d "
//			+ "LEFT JOIN employees e ON d.employee_id = e.employee_id "
//			+ "WHERE d.department_id = :id", nativeQuery = true)		
//	public List<Object[]> findByDeptman(@Param("id") int id); 

	public List<DepartmentManager> findByDeptId(Department d);

	public DepartmentManager findByDeptIdAndDeptEmpId(Department d, Employee e);
}

package com.decepticons.assetManagement.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.DepartmentManager;
import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.repositories.IDepartmentManagerRepository;
import com.decepticons.assetManagement.repositories.IDepartmentRepository;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.services.protocols.IDepartmentManagerService;

@Service
public class DepartmentManagerService implements IDepartmentManagerService{
	
	@Autowired
	private IDepartmentManagerRepository deptManRepo;
	
	public DepartmentManagerService() {
	}
	
//	@Override
//	public List<Object[]> findByDeptman(int id) {
//		// TODO Auto-generated method stub
//		return deptManRepo.findByDeptman(id);
//	}
	
	@Override
	public List<DepartmentManager> findAll(){
		return deptManRepo.findAll();
	}
	
	@Override
	public List<DepartmentManager> findByDeptId(Department d) {
		System.out.println("calling custom method");
		return deptManRepo.findByDeptId(d);
	}
	
	@Override
	public void deleteManagerById(int id) {
		System.out.println("======== delete manager=======");
		deptManRepo.deleteById(id);
	}

//	@Override
//	public List<Object[]> findByDeptman(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public void saveManager(DepartmentManager deptMan) {
		deptManRepo.save(deptMan);
	}
	
	@Override
	public DepartmentManager findByDeptIdAndDeptEmpId(Department d, Employee e) {
		return deptManRepo.findByDeptIdAndDeptEmpId(d,e);
	}
	
	@Override
	public int countManagerByDepartment(Department d) {
		List<DepartmentManager> manList = deptManRepo.findByDeptId(d);
		return manList.size();
	}
}

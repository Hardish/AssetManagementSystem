package com.decepticons.assetManagement.services;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import javax.persistence.PrePersist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.stereotype.Service;

import com.decepticons.assetManagement.entity.Department;
import com.decepticons.assetManagement.entity.Employee;
import com.decepticons.assetManagement.entity.Role;
import com.decepticons.assetManagement.entity.UserAuth;
import com.decepticons.assetManagement.repositories.IEmployeeRepository;
import com.decepticons.assetManagement.repositories.IUserAuthRepository;
import com.decepticons.assetManagement.services.protocols.IEmployeeService;
import com.decepticons.assetManagement.services.protocols.IUserAuthService;
import com.decepticons.assetManagement.util.AssetManagementUtil;

@Service
public class EmployeeService implements IEmployeeService {

	private static AssetManagementUtil util = AssetManagementUtil.getFormatter();

	private static Department dept = new Department();
	private static Role role = new Role();

	@Autowired
	private IEmployeeRepository empRepo;

	@Autowired
	private IUserAuthRepository userAuthRepo;

	@Autowired
	private IUserAuthService userAuthService;

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

	@Override
	public Employee findById(int Id) {
		Optional<Employee> result = empRepo.findById(Id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Employee not found witn ID=" + Id);
		}
	}

	@Override
	public void save(Employee employee) {

		String userName;
		if (util.isNewUser(employee)) {

			userName = util.generateUserName(employee);
			System.out.println("username " + userName);
			employee.setUserName(userName);
//			employee.setPassword(userName);
			//employee.setDepartment(dept);
			//employee.setRole(role);
		}
		userName = employee.getUserName();

		UserAuth userAuth = userAuthRepo.findByUserNameEquals(userName);
		System.out.println("userName :: " + userName + " userAuth " + userAuth);
		if (userAuth == null) {
			userAuth = new UserAuth();
			userAuth.setUserName(userName);
			userAuth.setPassword(userName);

			userAuthService.save(userAuth);
		}

		empRepo.save(employee);

	}

	@Override
	public void deleteById(int id) {

		Employee emp = findById(id);
		if (emp != null) {
			UserAuth userAuth = userAuthRepo.findByUserNameEquals(emp.getUserName());
			userAuthService.delete(userAuth);

			empRepo.deleteById(id);
		}

	}

	/**
	 * updates only selcted fields
	 */
	@Override
	public void updateEmployee(Employee emp) {

		System.out.println("from updateEmployee" + emp);
		if (util.isNewUser(emp)) {
			System.out.println("calling save");
			save(emp);
		}

		System.out.println("Continue Update");
		Employee employee = findById(emp.getId());

		// System.out.println("Employess before change "+employee);

		try {

			Method[] method = Class.forName(Employee.class.getName()).getMethods();
			for (Method m : method) {

				if (m.getName().startsWith("get") && !m.getName().equals("getId") && !m.getName().equals("getClass")) {
					// m.setAccessible(true);
					Object data = m.invoke(emp, null);

					// System.out.println(m.getName() + " Data " + data + " return type " +
					// m.getReturnType());

					if (data != null) {
						String methodName = m.getName().replace("get", "set");
						Method setter = Class.forName(Employee.class.getName()).getMethod(methodName,
								m.getReturnType());
//						System.out.println("invoke "+setter.getName());
						setter.invoke(employee, data);
					}

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		save(employee);

		// System.out.println("Employess after change "+employee);

	}

	@Override
	public List<Employee> findByDepartment(Department dept) {
		// TODO Auto-generated method stub
		return empRepo.findByDepartment(dept);
	}

	@Override
	public Employee findByUserName(String userName) {
		return empRepo.findByUserName(userName);
	}
}

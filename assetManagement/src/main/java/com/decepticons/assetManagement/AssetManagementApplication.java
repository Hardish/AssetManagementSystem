package com.decepticons.assetManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.decepticons.assetManagement.entity.Employee;

@SpringBootApplication
public class AssetManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssetManagementApplication.class, args);
		
		//Employee emp = new Employee("Ravi", "Sharma", "a@a.c");
		//System.out.println(emp.getEmail());
	}

}

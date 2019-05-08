
Alter Table Employees 
 ADD FOREIGN KEY (role_id) REFERENCES Roles(role_id);

Alter Table Employees 
 ADD FOREIGN KEY (dept_id) REFERENCES Departments(department_id);
 
 Alter Table Employees 
 ADD FOREIGN KEY (REPORTING_MANAGER) REFERENCES Employees(EMPLOYEE_ID);
 
-- Alter Table Departments
--ADD FOREIGN KEY (DEPARTMENT_MANAGER) REFERENCES Employees(EMPLOYEE_ID);



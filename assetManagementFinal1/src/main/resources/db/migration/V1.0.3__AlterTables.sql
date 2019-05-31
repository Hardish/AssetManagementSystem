
Alter Table Employees 
 ADD FOREIGN KEY (role_id) REFERENCES Roles(role_id);

Alter Table Employees 
 ADD FOREIGN KEY (dept_id) REFERENCES Departments(department_id);
 
 Alter Table Employees 
 ADD FOREIGN KEY (REPORTING_MANAGER) REFERENCES Employees(EMPLOYEE_ID);
 
-- Alter Table Departments
--ADD FOREIGN KEY (DEPARTMENT_MANAGER) REFERENCES Employees(EMPLOYEE_ID);


Alter table Request 
ADD CONSTRAINT FK_RequestEMP FOREIGN KEY (employee_id) REFERENCES Employees(employee_id);

Alter table Request 
ADD CONSTRAINT FK_RequestDeptID FOREIGN KEY (department_id) REFERENCES departments(department_id);

Alter table department_manager 
ADD CONSTRAINT FK_EmpID FOREIGN KEY (employee_id) REFERENCES Employees(employee_id);

Alter table department_manager
ADD CONSTRAINT FK_deptID FOREIGN KEY (department_id) REFERENCES departments(department_id);
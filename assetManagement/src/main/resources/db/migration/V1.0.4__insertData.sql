insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'Employee');
insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'Manager');
insert into Roles(role_id, role_name) values(ROLES_ID_SEQ.NEXTVAL,'HR');
-- inert into Dept table
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'HR');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'IT');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Network');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Law');
insert into Departments(department_id, department_name) values(DEPTS_ID_SEQ.NEXTVAL,'Immigration');
INSERT INTO departments (department_id, department_name) VALUES (DEPTS_ID_SEQ.NEXTVAL, 'Boss'); 


--commit;


--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob) values(EMP_ID_SEQ.NEXTVAL,300,200,'Ravi','Sharma','sharma.ravi70@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),3125329099,'rsha123');
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,301,200,'Disha','Patel','disha.patel@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),4125328099,'pa123');
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,300,200,'ryan','D','ryan.d@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),455329099,'ryn123');
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,303,200,'Juan','P','Juan.p@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725329099,'jua123');
--insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name) values(EMP_ID_SEQ.NEXTVAL,304,200,'Abhi','T','abhi.t@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),0985329099,'t123');

insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no) values(EMP_ID_SEQ.NEXTVAL,300,200,'Ravi','Sharma','sharma.ravi70@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),3125329099,'sha123',to_date('04/12/1986', 'dd/mm/YYYY'),500000,'123-frd-34567');
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,301,200,'Disha','Patel','disha.patel@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),4125328099,'pa123',to_date('04/12/1986', 'dd/mm/YYYY'),90000,'123-frd-3487',100);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,300,200,'ryan','D','ryan.d@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),455329099,'ryn123',to_date('04/12/1986', 'dd/mm/YYYY'),80000,'123-frd-3467',100);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,303,200,'Juan','P','Juan.p@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),6725329099,'jua123',to_date('04/12/1986', 'dd/mm/YYYY'),100000,'123-frd-34097',101);
insert into Employees (employee_id,dept_id,role_id,first_name,last_name,email,hire_date,end_date,phone_number,user_name,dob,salary,ssn_no,reporting_manager) values(EMP_ID_SEQ.NEXTVAL,304,200,'Abhi','T','abhi.t@gmail.com',to_date('04/12/1986', 'dd/mm/YYYY'),to_date('04/12/2100', 'dd/mm/YYYY'),0985329099,'t123',to_date('04/12/1986', 'dd/mm/YYYY'),120000,'123-frd-34167',102);
--commit;

INSERT INTO departments (department_id, department_name) VALUES (DEPTS_ID_SEQ.NEXTVAL, 'Human Resource'); 
INSERT INTO departments (department_id, department_name, department_manager) VALUES (2, 'Information Technology', 102); 
INSERT INTO departments (department_id, department_name, department_manager) VALUES (3, 'Accounting', 103);  



--CHANGE # 3 STARTED

INSERT INTO request(REQUEST_ID, REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,DEPARTMENT_NAME) VALUES	(REQ_ID_SEQ.NEXTVAL,'Software','Windows 10','Lets stay with world,and have a fun',1,'DISHA','PATEL','FI');
INSERT INTO request(REQUEST_ID, REQUEST_TYPE,REQUEST_SUBTYPE,REQUEST_DESCRIPTION,EMPLOYEE_ID,FIRST_NAME,LAST_NAME,REQUEST_DATE,DEPARTMENT_NAME,ASSET_NAME,UNITS,PRIORITY,REQUEST_STATUS,ASSIGNED_TO_EMP_ID,ASSIGNED_TO,ASSIGNED_DATE) VALUES (REQ_ID_SEQ.NEXTVAL,'Software','Oracle 12c','RDBMS',1,'DISHA','PATEL',TO_DATE('17/12/2015', 'DD/MM/YYYY'),'HR','Laptop',1,3,'In-Progress','34021','ARUN SHAH',TO_DATE('19/12/2015', 'DD/MM/YYYY'));

--commit;

INSERT INTO requesttypeemp(REQUEST_TYPE_ID,REQUEST_TYPE) values (REQTYPEEMP_ID_SEQ.nextval,'HARDWARE');
INSERT INTO requesttypeemp(REQUEST_TYPE_ID,REQUEST_TYPE) values (REQTYPEEMP_ID_SEQ.nextval,'SOFTWARE');


--commit;

INSERT INTO requesttypesystemanalyst(REQUEST_TYPE_ID,REQUEST_TYPE) values (REQTYPESA_ID_SEQ.nextval,'Create New Asset');
INSERT INTO requesttypesystemanalyst(REQUEST_TYPE_ID,REQUEST_TYPE) values (REQTYPESA_ID_SEQ.nextval,'Allocate Asset');

---CHANGE # 3 ENDED

DROP SEQUENCE  EMP_ID_SEQ;
DROP SEQUENCE  ROLES_ID_SEQ;
DROP SEQUENCE  DEPTS_ID_SEQ;

DROP SEQUENCE REQ_ID_SEQ;
DROP SEQUENCE DEPTMAN_ID_SEQ;

DROP TABLE  Employees CASCADE CONSTRAINTS;
DROP TABLE  Roles;
DROP TABLE  Departments CASCADE CONSTRAINTS;

DROP TABLE DEPARTMENT_MANAGER;
DROP TABLE REQUEST;

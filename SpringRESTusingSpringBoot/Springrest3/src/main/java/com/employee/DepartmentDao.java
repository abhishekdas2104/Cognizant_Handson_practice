package com.employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DepartmentDao {
private static List<Department> DEPARTMENT_LIST;
public DepartmentDao() {
ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
DEPARTMENT_LIST = (List<Department>) context.getBean("departmentList");
}
public List<Department> getAllDepartments() {
return DEPARTMENT_LIST;
}
}

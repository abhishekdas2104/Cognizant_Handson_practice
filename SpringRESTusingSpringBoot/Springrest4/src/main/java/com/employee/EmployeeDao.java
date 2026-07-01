package com.employee;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDao {
private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();
public EmployeeDao() {
Department deptIT = new Department(1, "IT");
Department deptHR = new Department(2, "HR");
Skill java = new Skill(1, "Java");
Skill spring = new Skill(2, "Spring");
Skill angular = new Skill(3, "Angular");
Employee emp1 = new Employee();
emp1.setId(1);
emp1.setName("Rahul Sharma");
emp1.setEmail("rahul@company.com");
emp1.setSalary(50000.0);
emp1.setPermanent(true);
emp1.setDateOfBirth(new Date());
emp1.setDepartment(deptIT);
emp1.setSkills(Arrays.asList(java, spring));
Employee emp2 = new Employee();
emp2.setId(2);
emp2.setName("Shubham Patel");
emp2.setEmail("shubham@company.com");
emp2.setSalary(45000.0);
emp2.setPermanent(true);
emp2.setDateOfBirth(new Date());
emp2.setDepartment(deptHR);
emp2.setSkills(Arrays.asList(angular));
EMPLOYEE_LIST.add(emp1);
EMPLOYEE_LIST.add(emp2);
}
public List<Employee> getAllEmployees() {
return EMPLOYEE_LIST;
}
public Employee getEmployeeById(Integer id) throws EmployeeNotFoundException {
for (Employee emp : EMPLOYEE_LIST) {
if (emp.getId().equals(id)) {
return emp;
}
}
throw new EmployeeNotFoundException();
}
public void addEmployee(Employee employee) {
EMPLOYEE_LIST.add(employee);
}
public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
EMPLOYEE_LIST.set(i, employee);
return;
}
}
throw new EmployeeNotFoundException();
}
public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
if (EMPLOYEE_LIST.get(i).getId().equals(id)) {
EMPLOYEE_LIST.remove(i);
return;
}
}
throw new EmployeeNotFoundException();
}
}

package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
@Autowired
private EmployeeDao employeeDao;
public List<Employee> getAllEmployees() {
return employeeDao.getAllEmployees();
}
public Employee getEmployeeById(Integer id) throws EmployeeNotFoundException {
return employeeDao.getEmployeeById(id);
}
public void addEmployee(Employee employee) {
employeeDao.addEmployee(employee);
}
public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
employeeDao.updateEmployee(employee);
}
public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
employeeDao.deleteEmployee(id);
}
}

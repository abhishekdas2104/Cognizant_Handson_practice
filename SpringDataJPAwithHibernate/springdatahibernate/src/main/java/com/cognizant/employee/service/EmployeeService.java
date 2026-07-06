package com.cognizant.employee.service;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class EmployeeService {
@Autowired
private EmployeeRepository employeeRepository;
public List<Employee> getAllEmployees() {
return employeeRepository.findAll();
}
public Optional<Employee> getEmployeeById(Long id) {
return employeeRepository.findById(id);
}
public Employee createEmployee(Employee employee) {
return employeeRepository.save(employee);
}
public Employee updateEmployee(Long id, Employee employeeDetails) {
Employee employee = employeeRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Employee not found"));
employee.setName(employeeDetails.getName());
employee.setEmail(employeeDetails.getEmail());
employee.setDepartment(employeeDetails.getDepartment());
return employeeRepository.save(employee);
}
public void deleteEmployee(Long id) {
employeeRepository.deleteById(id);
}
public List<Employee> searchEmployees(String name) {
return employeeRepository.findByNameContaining(name);
}
public Page<Employee> getEmployeesPaged(Pageable pageable) {
return employeeRepository.findAll(pageable);
}
public List<Employee> getEmployeesByDepartment(Long departmentId) {
return employeeRepository.findByDepartmentId(departmentId);
}
}

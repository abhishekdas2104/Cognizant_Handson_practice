package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
@Autowired
private EmployeeService employeeService;
@GetMapping
public List<Employee> getAllEmployees() {
return employeeService.getAllEmployees();
}
@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Integer id) throws EmployeeNotFoundException {
return employeeService.getEmployeeById(id);
}
@PostMapping
public Employee addEmployee(@RequestBody @Valid Employee employee) {
employeeService.addEmployee(employee);
return employee;
}
@PutMapping
public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
employeeService.updateEmployee(employee);
}
@DeleteMapping("/{id}")
public void deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
employeeService.deleteEmployee(id);
}
}

package com.cognizant.employee.controller;
import com.cognizant.employee.model.Employee;
import com.cognizant.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
@Autowired
private EmployeeService employeeService;
@GetMapping
public List<Employee> getAllEmployees() {
return employeeService.getAllEmployees();
}
@GetMapping("/{id}")
public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
return employeeService.getEmployeeById(id)
.map(ResponseEntity::ok)
.orElse(ResponseEntity.notFound().build());
}
@PostMapping
public Employee createEmployee(@RequestBody Employee employee) {
return employeeService.createEmployee(employee);
}
@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
employeeService.deleteEmployee(id);
return ResponseEntity.noContent().build();
}
@GetMapping("/search")
public List<Employee> searchEmployees(@RequestParam String name) {
return employeeService.searchEmployees(name);
}
@GetMapping("/paged")
public Page<Employee> getEmployeesPaged(@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size) {
Pageable pageable = PageRequest.of(page, size);
return employeeService.getEmployeesPaged(pageable);
}
@GetMapping("/sorted")
public Page<Employee> getEmployeesSorted(@RequestParam(defaultValue = "0") int page,
@RequestParam(defaultValue = "10") int size,
@RequestParam(defaultValue = "name") String sortBy,
@RequestParam(defaultValue = "asc") String direction) {
Sort sort = direction.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
Pageable pageable = PageRequest.of(page, size, sort);
return employeeService.getEmployeesPaged(pageable);
}
@GetMapping("/department/{departmentId}")
public List<Employee> getEmployeesByDepartment(@PathVariable Long departmentId) {
return employeeService.getEmployeesByDepartment(departmentId);
}
}

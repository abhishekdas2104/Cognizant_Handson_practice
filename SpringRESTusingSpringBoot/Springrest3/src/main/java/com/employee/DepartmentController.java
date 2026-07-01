package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DepartmentController {
@Autowired
private DepartmentService departmentService;
@GetMapping("/departments")
public List<Department> getAllDepartments() {
return departmentService.getAllDepartments();
}
}

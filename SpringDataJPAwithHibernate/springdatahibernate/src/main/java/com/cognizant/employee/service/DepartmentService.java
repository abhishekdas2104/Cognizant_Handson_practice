package com.cognizant.employee.service;
import com.cognizant.employee.model.Department;
import com.cognizant.employee.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class DepartmentService {
@Autowired
private DepartmentRepository departmentRepository;
public List<Department> getAllDepartments() {
return departmentRepository.findAll();
}
public Optional<Department> getDepartmentById(Long id) {
return departmentRepository.findById(id);
}
public Department createDepartment(Department department) {
return departmentRepository.save(department);
}
public Department updateDepartment(Long id, Department departmentDetails) {
Department department = departmentRepository.findById(id)
.orElseThrow(() -> new RuntimeException("Department not found"));
department.setName(departmentDetails.getName());
return departmentRepository.save(department);
}
public void deleteDepartment(Long id) {
departmentRepository.deleteById(id);
}
public List<Department> searchDepartments(String name) {
return departmentRepository.findByNameContaining(name);
}
}

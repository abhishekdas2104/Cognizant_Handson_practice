package com.cognizant.employee.repository;
import com.cognizant.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
List<Department> findByNameContaining(String name);
}

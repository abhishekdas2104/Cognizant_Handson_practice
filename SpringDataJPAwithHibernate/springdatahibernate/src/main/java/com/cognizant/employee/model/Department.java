package com.cognizant.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
import java.util.Set;
@Entity
@Table(name="department")
@EntityListeners(AuditingEntityListener.class)
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String name;
@OneToMany(mappedBy = "department")
private Set<Employee> employees;
@CreatedDate
@Column(nullable = false, updatable = false)
private Date createdDate;
@LastModifiedDate
@Column(nullable = false)
private Date lastModifiedDate;
public Long getId() {
return id;
}
public void setId(Long id) {
this.id = id;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public Set<Employee> getEmployees() {
return employees;
}
public void setEmployees(Set<Employee> employees) {
this.employees = employees;
}
public Date getCreatedDate() {
return createdDate;
}
public void setCreatedDate(Date createdDate) {
this.createdDate = createdDate;
}
public Date getLastModifiedDate() {
return lastModifiedDate;
}
public void setLastModifiedDate(Date lastModifiedDate) {
this.lastModifiedDate = lastModifiedDate;
}
}

package com.cognizant.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;
@Entity
@Table(name="employee")
@EntityListeners(AuditingEntityListener.class)
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String name;
@Column(nullable = false, unique = true)
private String email;
@ManyToOne
@JoinColumn(name = "department_id")
private Department department;
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
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public Department getDepartment() {
return department;
}
public void setDepartment(Department department) {
this.department = department;
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

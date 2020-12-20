package com.mn.spring.boot.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mn.spring.boot.hibernate.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

package com.mn.spring.boot.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="EMPLOYEE")
@Data
public class Employee {

	@Id
	@Column(name="ID",nullable = false,length = 20)
	private Long id;
	@Column(name="FIRST_NAME",length = 50)
	private String firstName;
	@Column(name="LAST_NAME",length = 50)
	private String lastName;
	@Column(name="EMAIL_ID",nullable = false,length = 200)
	private String emailId;
}

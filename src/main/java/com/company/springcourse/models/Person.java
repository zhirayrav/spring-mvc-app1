package com.company.springcourse.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name = "Person")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	  	@NotEmpty(message = "Name should not be empty")
	    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
	    @Column(name = "name")
	    private String name;

	    @Min(value = 0, message = "Age should be greater than 0")
	    @Column(name = "age")
	    private int age;
	    
	    @NotEmpty(message = "Email shoud not be empty")
	    @Email
	    @Column(name = "email")
	    private String email;
	    @OneToMany(mappedBy = "owner")
	    private List<Item> items;
//	    @Temporal(TemporalType.DATE)          if use type date ,with this ann for mapping JDBC type
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;
	    @Column(name = "created_at")
//	    @Temporal(TemporalType.TIMESTAMP)      if use type Date , with this ann for mapping JDBC type
	    private LocalDateTime createdAt;
	    @Enumerated(EnumType.ORDINAL) //or STRING, as default ORDINAL
	    private Mood mood;
	    
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Person() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	public Mood getMood() {
		return mood;
	}
	public void setMood(Mood mood) {
		this.mood = mood;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}

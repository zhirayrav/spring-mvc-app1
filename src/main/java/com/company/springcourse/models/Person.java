package com.company.springcourse.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

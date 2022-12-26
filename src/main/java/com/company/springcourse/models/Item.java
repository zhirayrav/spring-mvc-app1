package com.company.springcourse.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotEmpty(message = "itemName shoud not be empty")
	@Column(name = "item_name")
	private String itemName;
	@ManyToOne
	@JoinColumn(name = "person_id",referencedColumnName = "id")
	private Person owner;
	public Item(@NotEmpty(message = "itemName shoud not be empty") String itemName, Person owner) {
		super();
		this.itemName = itemName;
		this.owner = owner;
	}
	public Item() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemName=" + itemName + "]";
	}
	
	
	
}

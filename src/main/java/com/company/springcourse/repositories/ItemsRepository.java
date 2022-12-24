package com.company.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.springcourse.models.Item;
import com.company.springcourse.models.Person;

@Repository
public interface ItemsRepository extends JpaRepository<Item,Integer> {
	List<Item> findByOwner(Person person); // or person.getItems()
	List<Item> findByItemName(String itemName);

}

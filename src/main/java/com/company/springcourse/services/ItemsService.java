package com.company.springcourse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.models.Item;
import com.company.springcourse.models.Person;
import com.company.springcourse.repositories.ItemsRepository;

@Service
@Transactional
public class ItemsService {
	private final ItemsRepository itemsRepository;

	@Autowired
	public ItemsService(ItemsRepository itemsRepository) {
		super();
		this.itemsRepository = itemsRepository;
	}
	public List<Item> findByItemName(String itemName){
		return itemsRepository.findByItemName(itemName);   //  breakpoint
	}
	
	public List<Item> findByOwner(Person person){
		return itemsRepository.findByOwner(person);   //  breakpoint
	}
	
	
}

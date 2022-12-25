package com.company.springcourse.services;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.models.Mood;
import com.company.springcourse.models.Person;
import com.company.springcourse.repositories.PeopleRepository;

@Service
@Transactional(readOnly = true)
public class PeopleService {
	private final PeopleRepository peopleRepository;
	
	@Autowired
	public PeopleService(PeopleRepository peopleRepository) {
		super();
		this.peopleRepository = peopleRepository;
	}
	
	public List<Person> findAll(){
		return peopleRepository.findAll();
	}
	
	public Person findOne(int id) {
		Optional<Person> foundPerson = peopleRepository.findById(id);
		return foundPerson.orElse(null);
	}
	@Transactional
	public void save(Person person) {
		person.setCreatedAt(LocalDateTime.now()); // if use type Date, person.setCreatedAt(new Date());
		person.setMood(Mood.CALM);
		peopleRepository.save(person);
	}
	@Transactional
	public void update(int id,Person updatedPerson) {
		updatedPerson.setId(id);
		peopleRepository.save(updatedPerson);
	}
	@Transactional 
	public void delete(int id) {
		peopleRepository.deleteById(id);
	}
	
	
}

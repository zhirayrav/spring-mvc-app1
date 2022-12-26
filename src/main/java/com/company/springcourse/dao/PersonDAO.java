package com.company.springcourse.dao;

import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.springcourse.models.Person;
@Component
public class PersonDAO {
	private final EntityManager entityManager;

	public PersonDAO(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	@Transactional(readOnly = true)
	public void testNPlus1() {
		Session session = entityManager.unwrap(Session.class);
		
//		Problem N + 1
//		
//		List<Person> people = session.createQuery("select p from Person p",Person.class)
//				.getResultList();
//		for(Person person : people) {
//			System.out.println("Person: " + person.getName() + "has: " + person.getItems());
//		}
		
//		Solution (only 1 query)
		
		HashSet<Person> people = new HashSet<>(session.createQuery("select p from Person p left join fetch p.items",Person.class)
				.getResultList()); // necessarily override methods hashcode() and equals() for Person
		for(Person person : people) {
			System.out.println("Person: " + person.getName() + "has: " + person.getItems());
		}
		
	}
}

package com.company.springcourse.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.springcourse.models.Person;
import com.company.springcourse.repositories.PeopleRepository;
import com.company.springcourse.services.ItemsService;
import com.company.springcourse.services.PeopleService;

@Controller
@RequestMapping("/people")
public class PeopleController {
	private final PeopleService peopleService;
	private final ItemsService itemsService;
	
	@Autowired
	public PeopleController(PeopleService peopleService,ItemsService itemsService) {
		super();
		this.peopleService = peopleService;
		this.itemsService = itemsService;
	}
	@GetMapping()
	public String index(Model model) {
		model.addAttribute("people", peopleService.findAll());
		
		return "people/index";
	}
	@GetMapping("/{id}")
	public String show(@PathVariable("id")int id,Model model) {
		model.addAttribute("person",peopleService.findOne(id));
		return "people/show";
	}
	@GetMapping("/new")
	public String newPerson(@ModelAttribute("person") Person person) {
		return "people/new";
	}
	@PostMapping()
	public String create(@ModelAttribute("person") @Valid Person person, BindingResult br) {
		if(br.hasErrors())
			return "people/new";
		peopleService.save(person);
		return "redirect:/people";
	}
	@GetMapping("/{id}/edit")
	public String edit (@PathVariable("id") int id,Model model) {
		model.addAttribute("person",peopleService.findOne(id));
		return "people/edit";
	}
	@PatchMapping("/{id}")
	public String update(@PathVariable("id") int id,@ModelAttribute("person") @Valid Person person, BindingResult br) {
		if(br.hasErrors())
			return "people/edit";
		peopleService.update(id,person);
		return "redirect:/people";
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") int id) {
		peopleService.delete(id);
		return "redirect:/people";
	}
	
	
		
}

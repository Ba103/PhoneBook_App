package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Entity.Contact;
import com.example.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	// Show all contacts
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listContacts", contactService.getAllContacts());
		return "index";
	}

	// Show form to add a new contact
	@GetMapping("/showNewContactForm")
	public String showNewContactForm(Model model) {
		Contact contact = new Contact();
		model.addAttribute("contact", contact);
		return "new_contact";
	}

	// Save contact to database
	@PostMapping("/saveContact")
	public String saveContact(@ModelAttribute("contact") Contact contact) {
		contactService.saveContact(contact);
		return "redirect:/";
	}

	// Show form to update contact
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		Optional<Contact> contact = contactService.getContactById(id);
		if (contact.isPresent()) {
			model.addAttribute("contact", contact.get());
			return "update_contact";
		} else {
			return "redirect:/";
		}
	}

	// Delete contact
	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable(value = "id") long id) {
		contactService.deleteContact(id);
		return "redirect:/";
	}
}

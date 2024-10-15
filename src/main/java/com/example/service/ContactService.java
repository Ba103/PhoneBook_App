package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Contact;
import com.example.Repo.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	// Get all contacts
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	// Get a contact by ID
	public Optional<Contact> getContactById(Long id) {
		return contactRepository.findById(id);
	}

	// Save a new contact
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	// Delete a contact by ID
	public void deleteContact(Long id) {
		contactRepository.deleteById(id);
	}
}

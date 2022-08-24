package com.BikkadIT.PhoneBookApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.PhoneBookApp.Entity.Contact;
import com.BikkadIT.PhoneBookApp.Service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {

	@Autowired
	 private ContactService contactService;
	
	@PostMapping(value = "/saveContact", consumes= "application/json",produces = "application/json")
	public ResponseEntity<String> saveContact(@RequestBody Contact contact)
	{
		boolean flag = this.contactService.saveContact(contact);
		
		if(flag == true)
		{
			return new ResponseEntity<String>("Contact Saved Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Contact not Saved",HttpStatus.BAD_REQUEST);

		}
		
		
	}
	
	@GetMapping(value = "/getAllContact",produces = "application/json")
	public ResponseEntity<List<Contact>> getAllContact()
	{
		List<Contact> allContact = this.contactService.getAllContact();
		return new ResponseEntity<List<Contact>>(allContact,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getContact/{contactId}",produces = "application/json")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId)
	{
		Contact contactById = this.contactService.getContactById(contactId);
		return new ResponseEntity<Contact>(contactById,HttpStatus.OK);
	}
	
	@PutMapping(value = "/updateContact", consumes= "application/json",produces = "application/json")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact)
	{
		boolean flag = this.contactService.updateContact(contact);
		
		if(flag == true)
		{
			return new ResponseEntity<String>("Contact Updated Successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Contact not Updated",HttpStatus.BAD_REQUEST);

		}
		
		
	}
}

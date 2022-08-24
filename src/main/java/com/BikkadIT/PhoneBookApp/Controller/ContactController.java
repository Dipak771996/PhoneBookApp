package com.BikkadIT.PhoneBookApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}

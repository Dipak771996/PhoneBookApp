package com.BikkadIT.PhoneBookApp.Service;

import java.util.List;

import com.BikkadIT.PhoneBookApp.Entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);

	List<Contact> getAllContact();

	Contact getContactById(Integer contactId);
	
	boolean updateContact(Contact contact);

	boolean deleteContactById(Integer contactId);
	
	boolean softDeleteById(Integer contactId);

}

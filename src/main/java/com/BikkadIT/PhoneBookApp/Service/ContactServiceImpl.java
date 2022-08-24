package com.BikkadIT.PhoneBookApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.PhoneBookApp.Entity.Contact;
import com.BikkadIT.PhoneBookApp.Repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact savedContact = this.contactRepository.save(contact);
		
		boolean flag=savedContact!=null?true:false;
		return flag;
	}

	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}

}

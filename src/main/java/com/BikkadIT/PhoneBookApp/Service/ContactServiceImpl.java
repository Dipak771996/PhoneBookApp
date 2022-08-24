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
		List<Contact> findAll = this.contactRepository.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = this.contactRepository.findById(contactId).get();
		
		return contact;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateContact(Contact contact) {
		Contact contact1 = this.contactRepository.save(contact);
		
		if(contact1!=null)
		{
			return true;
		}
		return false;
	}

}

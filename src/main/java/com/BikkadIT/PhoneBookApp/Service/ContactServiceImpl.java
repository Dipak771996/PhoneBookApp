package com.BikkadIT.PhoneBookApp.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
		List<Contact> collect = findAll.stream().filter(contact->contact.getActiveSwitch() == 'Y').collect(Collectors.toList());
		return collect;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact = this.contactRepository.findById(contactId).get();
		
		return contact;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		boolean existsById = this.contactRepository.existsById(contactId);
		
		if(existsById)
		{
			this.contactRepository.deleteById(contactId);
			return true;
		}
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

	@Override
	public boolean softDeleteById(Integer contactId) {
		Optional<Contact> findById = this.contactRepository.findById(contactId);
		
		if(findById.isPresent())
		{
			Contact contact = findById.get();
			contact.setActiveSwitch('N');
			Contact contact2 = this.contactRepository.save(contact);
			return true;
		}
		return false;
	}

}

package com.BikkadIT.PhoneBookApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.PhoneBookApp.Entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}

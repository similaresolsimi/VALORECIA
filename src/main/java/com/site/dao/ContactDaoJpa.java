/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.Contact;

/**
 * @author carole
 *
 */
public class ContactDaoJpa extends DaoJpa<Long, Contact> implements ContactDaoInterface {

	@Override
	public ArrayList<Long> getAllContact() {
		ArrayList<Long> listContacts = new ArrayList<>();
		for (Contact contact : findAll()) {
			listContacts.add(contact.getContactId());
		}
		return listContacts;
	}



}

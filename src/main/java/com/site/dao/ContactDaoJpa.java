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

		try{
			for (Contact contact : findAll()) {
				listContacts.add((long) contact.getContactid());
			}
		}	catch(Exception e)
		{
			System.out.println("ContactDaoJpa getAllContact");
		}
		return listContacts;
	}



}

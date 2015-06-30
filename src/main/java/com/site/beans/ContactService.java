/**
 *
 */
package com.site.beans;

import java.sql.Date;
import java.util.ArrayList;

import javax.ejb.Stateless;

/**
 * @author carole
 *
 */
@Stateless
public class ContactService implements ContactServiceInterface {

	@Override
	public Contact createContact(String name,
			String surname,String mail,String telephone,String message,
			Boolean sendMessage,Date dateMessage,ContactOrigine contactOrigine) {

		Contact contact = new Contact( name, surname, mail, telephone, message,
				sendMessage, dateMessage, contactOrigine);

		return null;
	}

	@Override
	public ArrayList<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContact(long ContactId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 */


}

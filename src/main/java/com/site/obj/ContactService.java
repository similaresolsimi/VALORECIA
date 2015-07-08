/**
 *
 */
package com.site.obj;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.site.dao.ContactDaoInterface;

/**
 * @author carole
 *
 */
@Stateless
public class ContactService implements ContactServiceInterface {

	@Inject
	private ContactDaoInterface contactDao;

	@Override
	public Contact createContact(String name,String surname,String mail,String telephone,
			String message,Boolean sendMessage,LocalDateTime dateMessage,ContactOrigine contactOrigine) {

		Contact contact = new Contact( name, surname, mail, telephone, message,	sendMessage, dateMessage, contactOrigine);
		contactDao.persist(contact);
		return contact;
	}

	//	@Override
	//	public Contact createContact(String name,String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,ContactOrigine contactOrigine) {
	//
	//		Contact contact = new Contact( name, surname, mail, telephone, message,	sendMessage, contactOrigine);
	//		contactDao.persist(contact);
	//		return contact;
	//	}
	//
	//	@Override
	//	public Contact createContact(String name,String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,Long contactOrigineId) {
	//
	//		Contact contact = new Contact( name, surname, mail, telephone, message,	sendMessage, contactOrigineId);
	//		contactDao.persist(contact);
	//		return contact;
	//	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<Contact> getAllContact() {
		ArrayList<Contact> result = new ArrayList<>();
		for (Contact contact : contactDao.findAll()) {
			result.add(contact);
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Contact getContact(long contactId) {
		return contactDao.findById(contactId);
	}


	/**
	 * This method is used for Junit testing only.
	 * @param contactDao the contactDao to set
	 */
	void setContactDao(ContactDaoInterface contactDao) {
		this.contactDao = contactDao;
	}

}

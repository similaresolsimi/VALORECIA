/**
 *
 */
package com.site.obj;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Stateless;
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


	//	@TransactionAttribute
	@Override
	public Contact createContact(String nom, String prenom, String mail,
			String telephone, String message, Boolean copymessage,
			Date dateMessage, Contactorigine contactorigine) {
		Contact contact = new Contact(  nom,  prenom,  mail, telephone,
				message,  copymessage, dateMessage,  contactorigine);
		contactDao.persist(contact);
		return contact;

	}

	//	@Override
	//	public Contact1 createContact(String name,String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,ContactOrigine1 contactOrigine) {
	//
	//		Contact1 contact = new Contact1( name, surname, mail, telephone, message,	sendMessage, contactOrigine);
	//		contactDao.persist(contact);
	//		return contact;
	//	}
	//
	//	@Override
	//	public Contact1 createContact(String name,String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,Long contactOrigineId) {
	//
	//		Contact1 contact = new Contact1( name, surname, mail, telephone, message,	sendMessage, contactOrigineId);
	//		contactDao.persist(contact);
	//		return contact;
	//	}

	@Override
	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ArrayList<Contact> getAllContact() {
		ArrayList<Contact> result = new ArrayList<>();
		for (Contact contact : contactDao.findAll()) {
			result.add(contact);
		}
		return result;
	}

	@Override
	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Contact getContact(Long contactId) {
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

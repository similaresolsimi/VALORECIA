/**
 *
 */
package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.site.beans.Contact;

/**
 * @author carole
 *
 */
@Stateless
@Alternative
public class ContactDaoFixed extends DaoFixed <Long, Contact> implements ContactDaoInterface {

	private static HashMap<Long, Contact> listContacts;

	/**
	 *
	 */
	public ContactDaoFixed() {
		if (ContactDaoFixed.listContacts == null) {
			ContactDaoFixed.listContacts = new HashMap<Long, Contact>();
		}
	}

	@Override
	public void persist(Contact entity) {
		ContactDaoFixed.listContacts.put(entity.getContactId(), entity);

	}

	@Override
	public void remove(Contact entity) {
		ContactDaoFixed.listContacts.remove(entity);

	}

	@Override
	public Contact findById(Long id) {
		return ContactDaoFixed.listContacts.get(id);
	}

	@Override
	public  Collection<Contact> findAll() {
		return ContactDaoFixed.listContacts.values();
	}

	@Override
	public ArrayList<Long> getAllContact() {
		ArrayList<Long> listContacts = new ArrayList<>();
		for (Contact contact : findAll()) {
			listContacts.add(contact.getContactId());
		}
		return listContacts;
	}

}

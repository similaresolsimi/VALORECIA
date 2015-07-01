/**
 *
 */
package com.site.obj;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.site.dao.ContactOrigineDaoInterface;

/**
 * @author carole
 *
 */
@Stateless
public class ContactOrigineService implements ContactOrigineServiceInterface {

	/**
	 *
	 */
	@Inject
	private ContactOrigineDaoInterface contactOrigineDao;

	@Override
	public ContactOrigine createContactOrigine(Long contactOrigineId,
			String _contactOrigine) {
		ContactOrigine contactOrigine = new ContactOrigine(contactOrigineId, _contactOrigine);
		contactOrigineDao.persist(contactOrigine);
		return contactOrigine;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ArrayList<ContactOrigine> getAllContactOrigine() {
		ArrayList<ContactOrigine> result = new ArrayList<>();
		for (ContactOrigine contactOrigine : contactOrigineDao.findAll()) {
			result.add(contactOrigine);
		}
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ContactOrigine getContactOrigine(long contactOrigineId) {
		return contactOrigineDao.findById(contactOrigineId);
	}

}

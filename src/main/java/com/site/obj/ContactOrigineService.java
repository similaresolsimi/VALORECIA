/**
 *
 */
package com.site.obj;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
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

	@TransactionAttribute
	@Override
	public Contactorigine createContactOrigine(Long contactOrigineId,String _contactOrigine) {
		Contactorigine ContactOrigine = new Contactorigine(contactOrigineId, _contactOrigine);
		contactOrigineDao.persist(ContactOrigine);
		return ContactOrigine;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	@TransactionAttribute
	public ArrayList<Contactorigine> getAllContactOrigine() {
		ArrayList<Contactorigine> result = new ArrayList<>();
		for (Contactorigine ContactOrigine : contactOrigineDao.findAll()) {
			result.add(ContactOrigine);
		}
		return result;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	@TransactionAttribute
	public Contactorigine getContactOrigine(Long contactOrigineId) {
		return contactOrigineDao.findById(contactOrigineId);
	}

}

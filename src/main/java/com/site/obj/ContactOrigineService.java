/**
 *
 */
package com.site.obj;

import java.util.ArrayList;

import javax.ejb.Stateless;
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

	//	@TransactionAttribute
	@Override
	public ContactOrigine createContactOrigine(Long contactOrigineId,String _contactOrigine) {
		ContactOrigine contactOrigine = new ContactOrigine(contactOrigineId, _contactOrigine);
		contactOrigineDao.persist(contactOrigine);
		return contactOrigine;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ArrayList<ContactOrigine> getAllContactOrigine() {
		ArrayList<ContactOrigine> result = new ArrayList<>();
		for (ContactOrigine contactOrigine : contactOrigineDao.findAll()) {
			result.add(contactOrigine);
		}
		return result;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public ContactOrigine getContactOrigine(Long contactOrigineId) {
		return contactOrigineDao.findById(contactOrigineId);
	}

}

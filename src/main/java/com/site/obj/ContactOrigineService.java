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
	private ContactOrigineDaoInterface contactOrigineDaoI;

	@TransactionAttribute
	@Override
	public Contactorigine createContactOrigine(int contactOrigineId,String contactoriginelabel) {
		Contactorigine ContactOrigine = new Contactorigine(contactOrigineId, contactoriginelabel);
		contactOrigineDaoI.persist(ContactOrigine);
		return ContactOrigine;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	@TransactionAttribute
	public ArrayList<Contactorigine> getAllContactOrigine() {
		ArrayList<Contactorigine> result = new ArrayList<>();
		try{
			for (Contactorigine ContactOrigine : contactOrigineDaoI.findAll()) {
				result.add(ContactOrigine);
			}
		}	catch(Exception e)
		{
			System.out.println("ContactDaoJpa getAllContact");
		}
		return result;
	}

	//	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	@TransactionAttribute
	public Contactorigine getContactOrigine(Long contactOrigineId) {
		return contactOrigineDaoI.findById(contactOrigineId);
	}

}

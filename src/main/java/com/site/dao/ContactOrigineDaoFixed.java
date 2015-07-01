/**
 *
 */
package com.site.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.site.obj.ContactOrigine;

/**
 * @author carole
 *
 */
@Stateless
@Alternative
public class ContactOrigineDaoFixed extends DaoFixed <Long, ContactOrigine> implements ContactOrigineDaoInterface{

	private static HashMap<Long, ContactOrigine> listContactOrigine;

	/**
	 *
	 */
	public ContactOrigineDaoFixed() {
		if (ContactOrigineDaoFixed.listContactOrigine == null) {
			ContactOrigineDaoFixed.listContactOrigine = new HashMap<Long, ContactOrigine>();
		}
	}

	@Override
	public void persist(ContactOrigine entity) {
		ContactOrigineDaoFixed.listContactOrigine.put(entity.getContactOrigineId(), entity);

	}

	@Override
	public void remove(ContactOrigine entity) {
		ContactOrigineDaoFixed.listContactOrigine.remove(entity);

	}

	@Override
	public ContactOrigine findById(Long id) {
		return ContactOrigineDaoFixed.listContactOrigine.get(id);
	}

	@Override
	public  Collection<ContactOrigine> findAll() {
		return ContactOrigineDaoFixed.listContactOrigine.values();
	}

	@Override
	public ArrayList<Long> getAllContactOrigine() {
		ArrayList<Long> listContactOrigine = new ArrayList<>();
		for (ContactOrigine contactOrigine : findAll()) {
			listContactOrigine.add(contactOrigine.getContactOrigineId());
		}
		return listContactOrigine;
	}

}

/**
 *
 */
package com.site.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import com.site.obj.Contactorigine;


/**
 * @author carole
 *
 */

@Stateless
@Alternative
public class ContactOrigineDaoFixed extends DaoFixed <Long, Contactorigine> implements ContactOrigineDaoInterface{

	private static HashMap<Long, Contactorigine> listContactOrigine;

	/**
	 *
	 */
	public ContactOrigineDaoFixed() {
		if (ContactOrigineDaoFixed.listContactOrigine == null) {
			ContactOrigineDaoFixed.listContactOrigine = new HashMap<Long, Contactorigine>();
		}
	}

	@Override
	public void persist(Contactorigine entity) {
		ContactOrigineDaoFixed.listContactOrigine.put((long) entity.getContactorigineid(), entity);

	}

	@Override
	public void remove(Contactorigine entity) {
		ContactOrigineDaoFixed.listContactOrigine.remove(entity);

	}

	@Override
	public Contactorigine findById(Long id) {
		return ContactOrigineDaoFixed.listContactOrigine.get(id);
	}

	@Override
	public  Collection<Contactorigine> findAll() {
		return ContactOrigineDaoFixed.listContactOrigine.values();
	}

	@Override
	public ArrayList<Long> getAllContactOrigine() {
		ArrayList<Long> listContactOrigine = new ArrayList<>();
		for (Contactorigine contactOrigine : findAll()) {
			listContactOrigine.add((long) contactOrigine.getContactorigineid());
		}
		return listContactOrigine;
	}

}

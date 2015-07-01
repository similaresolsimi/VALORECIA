/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.ContactOrigine;

/**
 * @author carole
 *
 */
public class ContactOrigineDaoJpa extends DaoJpa<Long, ContactOrigine> implements ContactOrigineDaoInterface{

	/**
	 *
	 */
	@Override
	public ArrayList<Long> getAllContactOrigine() {
		ArrayList<Long> listContactOrigine = new ArrayList<>();
		for (ContactOrigine contactOrigine : findAll()) {
			listContactOrigine.add(contactOrigine.getContactOrigineId());
		}
		return listContactOrigine;
	}


}

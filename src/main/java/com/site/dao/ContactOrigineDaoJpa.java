/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.Contactorigine;

/**
 * @author carole
 *
 */
public class ContactOrigineDaoJpa extends DaoJpa<Long, Contactorigine> implements ContactOrigineDaoInterface{

	/**
	 *
	 */
	@Override
	public ArrayList<Long> getAllContactOrigine() {

		ArrayList<Long> listContactOrigine = new ArrayList<>();
		try{
			for (Contactorigine contactorigine : findAll()) {
				listContactOrigine.add((long) contactorigine.getContactorigineid());
			}

		}	catch(Exception e)
		{
			System.out.println("ContactOrigineDaoJpa getAllContactOrigine");
		}
		return listContactOrigine;

	}


}

/**
 *
 */
package com.site.obj;

import java.util.ArrayList;

/**
 * @author carole
 *
 */
public interface ContactOrigineServiceInterface {

	/**
	 *
	 */
	public ContactOrigine createContactOrigine(Long contactOrigineId, String contactOrigine) ;
	/**
	 * @return list of all ContactOrigine request.
	 *
	 */
	public ArrayList<ContactOrigine> getAllContactOrigine();

	/**
	 * @param idContactOrigine a long the ContactOrigine id.
	 * @return the ContactOrigineId
	 */
	public ContactOrigine getContactOrigine(long ContactOrigineId);

}

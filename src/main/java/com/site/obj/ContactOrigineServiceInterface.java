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
	public Contactorigine createContactOrigine(int contactOrigineId, String contactOrigine) ;
	/**
	 * @return list of all ContactOrigine1 request.
	 *
	 */
	public ArrayList<Contactorigine> getAllContactOrigine();

	/**
	 * @param idContactOrigine a long the ContactOrigine1 id.
	 * @return the ContactOrigineId
	 */
	public Contactorigine getContactOrigine(int contactOrigineId);

}

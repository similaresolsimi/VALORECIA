/**
 *
 */
package com.site.beans;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author carole
 *
 */
public interface ContactServiceInterface {

	public Contact createContact(String name,
			String surname,String mail,String telephone,String message,
			Boolean sendMessage,Date dateMessage,ContactOrigine contactOrigine);

	/**
	 * @return list of all Contact request.
	 *
	 */
	public ArrayList<Contact> getAllContact();

	/**
	 * @param idAnimal a long the animal's id.
	 * @return teh Animal
	 */
	public Contact getContact(long ContactId);

}

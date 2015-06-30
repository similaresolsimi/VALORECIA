/**
 *
 */
package com.site.beans;
import java.util.ArrayList;

/**
 * @author carole
 *
 */
public interface ContactServiceInterface {

	public Contact createContact();

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

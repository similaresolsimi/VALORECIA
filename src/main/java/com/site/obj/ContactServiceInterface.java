/**
 *
 */
package com.site.obj;
import java.util.ArrayList;

/**
 * @author carole
 *
 */
public interface ContactServiceInterface {

	//	public Contact createContact(String name,
	//			String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,LocalDateTime dateMessage,ContactOrigine contactOrigine);

	public Contact createContact(String name,
			String surname,String mail,String telephone,String message,
			Boolean sendMessage,ContactOrigine contactOrigine);

	/**
	 * @return list of all Contact request.
	 *
	 */
	public ArrayList<Contact> getAllContact();

	/**
	 * @param ContactId a long the ContactId.
	 * @return the ContactId
	 */
	public Contact getContact(long ContactId);

}

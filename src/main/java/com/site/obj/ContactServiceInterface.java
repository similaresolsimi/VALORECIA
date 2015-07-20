/**
 *
 */
package com.site.obj;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author carole
 *
 */
public interface ContactServiceInterface {

	public Contact createContact(String nom, String prenom, String mail,
			String telephone, String message, Boolean copymessage,
			Date dateMessage, Contactorigine contactorigine);

	//	public Contact1 createContact(String name,
	//			String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,ContactOrigine1 contactOrigine);

	//	public Contact1 createContact(String name,
	//			String surname,String mail,String telephone,String message,
	//			Boolean sendMessage,Long contactOrigineId );

	/**
	 * @return list of all Contact1 request.
	 *
	 */
	public ArrayList<Contact> getAllContact();

	/**
	 * @param ContactId a long the ContactId.
	 * @return the ContactId
	 */
	public Contact getContact(Long ContactId);




}

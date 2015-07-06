package com.site.web;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.site.obj.Contact;
import com.site.obj.ContactOrigineServiceInterface;
import com.site.obj.ContactServiceInterface;



@Model
public class ContactJsf {

	@Inject
	private ContactServiceInterface contactService;
	@Inject
	private ContactOrigineServiceInterface contactOrigineService;

	//private Long ContactId;
	private String Nom;
	private String Prenom;
	private String mail;
	private String telephone;
	private String message;
	private Boolean copymessage;
	//	private LocalDateTime dateMessage;
	//	private ContactOrigine contactOrigine;
	private Long contactOrigineId;
	/**
	 * @return the contactService
	 */
	public ContactServiceInterface getContactService() {
		return contactService;
	}

	/**
	 * @param contactService the contactService to set
	 */
	public void setContactService(ContactServiceInterface contactService) {
		this.contactService = contactService;
	}

	/**
	 * @return the Nom
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * @param Nom the Nom to set
	 */
	public void setNom(String nom) {
		this.Nom = nom;
	}

	/**
	 * @return the Prenom
	 */
	public String getPrenom() {
		return Prenom;
	}

	/**
	 * @param Prenom the Prenom to set
	 */
	public void setPrenom(String Prenom) {
		this.Prenom = Prenom;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the copymessage
	 */
	public Boolean getcopymessage() {
		return copymessage;
	}

	/**
	 * @param copymessage the copymessage to set
	 */
	public void setcopymessage(Boolean copymessage) {
		this.copymessage = copymessage;
	}

	//	/**
	//	 * @return the dateMessage
	//	 */
	//	public LocalDateTime getDateMessage() {
	//		dateMessage = LocalDateTime.now();
	//		return dateMessage;
	//	}
	//
	//	/**
	//	 * @param dateMessage the dateMessage to set
	//	 */
	//	public void setDateMessage(LocalDateTime dateMessage) {
	//		this.dateMessage = dateMessage;
	//	}

	/**
	 * @return the contactOrigine
	 */
	//	public ContactOrigine getContactOrigine() {
	//		return contactOrigine;
	//	}

	/**
	 * @param contactOrigine the contactOrigine to set
	 */
	//	public void setContactOrigine(ContactOrigine contactOrigine) {
	//		this.contactOrigine = contactOrigine;
	//	}

	/**
	 * @return the contactOrigineId
	 */
	public Long getContactOrigineId() {
		return contactOrigineId;
	}

	/**
	 * @param contactOrigineId the contactOrigineId to set
	 */
	public void setContactOrigineId(Long contactOrigineId) {
		this.contactOrigineId = contactOrigineId;
	}

	// Managed Backing Bean
	private HtmlDataTable dataTable;

	/**
	 * @return "contact" (navigation). Set the contact and the hidden input field.
	 */
	public String editContact() {
		// Get selected animal to be displayed.
		Contact contactFromList = (Contact) dataTable.getRowData();
		if (contactFromList != null) {
			// Set properties to be displayed.
			setNom(contactFromList.getNom());
			setPrenom(contactFromList.getPrenom());
			setMail(contactFromList.getMail());
			setTelephone(contactFromList.getTelephone());
			setMessage(contactFromList.getMessage());
			setcopymessage(contactFromList.getcopymessage());
			//			setDateMessage(contactFromList.getDateMessage());
			//			setContactOrigineId(contactFromList.getContactOrigine().getContactOrigineId());
			setContactOrigineId(contactFromList.getContactOrigineId());
		}
		// Navigation case.
		return "contact";
	}

	/**
	 * @return a list of all animals.
	 */
	public ArrayList<Contact> getAllContacts() {
		return contactService.getAllContact();
	}

	/**
	 * @param context a FacesContext.
	 * @param component a UIComponent.
	 * @param value an Object the birthPlace to validate.
	 * @throws ValidatorException
	 */
	public void validateContactRequest(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String birthPlace = (String) value;
		String errorMessage = null;
		if (birthPlace.length() < 4) {
			errorMessage = "The birth place must be at least 4 characters long.";
		}
		if (errorMessage == null && !birthPlace.startsWith("ZOO_") && !birthPlace.matches("WILD")) {
			errorMessage = "The birth place must be on format 'WILD' or 'ZOO_something'.";
		}
		if (errorMessage != null) {
			FacesMessage facesMessage = new FacesMessage(errorMessage);
			facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(facesMessage);
		}
	}

	public String create() {
		//		ContactOrigine ContactOrigineFromDao = contactOrigineService.getContactOrigine(contactOrigineId);
		//		contactService.createContact( Nom, Prenom, mail, telephone, message, copymessage,  ContactOrigineFromDao);
		contactService.createContact( Nom, Prenom, mail, telephone, message, copymessage,  contactOrigineId);
		return "create";
	}

	/**
	 * @return the dataTable
	 */
	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

}

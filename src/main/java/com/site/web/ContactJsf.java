package com.site.web;

import java.sql.Date;
import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.site.obj.Contact;
import com.site.obj.ContactOrigine;
import com.site.obj.ContactServiceInterface;



@Model
public class ContactJsf {

	@Inject
	private ContactServiceInterface contactService;
	@Inject
	private ContactOrigine speciesService;

	//private Long ContactId;
	private String name;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
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
	 * @return the sendMessage
	 */
	public Boolean getSendMessage() {
		return sendMessage;
	}

	/**
	 * @param sendMessage the sendMessage to set
	 */
	public void setSendMessage(Boolean sendMessage) {
		this.sendMessage = sendMessage;
	}

	/**
	 * @return the dateMessage
	 */
	public Date getDateMessage() {
		return dateMessage;
	}

	/**
	 * @param dateMessage the dateMessage to set
	 */
	public void setDateMessage(Date dateMessage) {
		this.dateMessage = dateMessage;
	}

	/**
	 * @return the contactOrigine
	 */
	public ContactOrigine getContactOrigine() {
		return contactOrigine;
	}

	/**
	 * @param contactOrigine the contactOrigine to set
	 */
	public void setContactOrigine(ContactOrigine contactOrigine) {
		this.contactOrigine = contactOrigine;
	}

	private String surname;
	private String mail;
	private String telephone;
	private String message;
	private Boolean sendMessage;
	private Date dateMessage;
	private ContactOrigine contactOrigine;
	private Long contactOrigineId;
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
			// Set animal's properties to be displayed.
			setName(contactFromList.getName());
			setSurname(contactFromList.getSurname());
			setMail(contactFromList.getMail());
			setTelephone(contactFromList.getTelephone());
			setMessage(contactFromList.getMessage());
			setSendMessage(contactFromList.getSendMessage());
			setDateMessage(contactFromList.getDateMessage());
			setContactOrigineId(contactFromList.getContactOrigine().getContactOrigineId());
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
		ContactOrigine speciesFromDao = speciesService.getFromId(speciesId);
		contactService.createContact(matricule, age, birthPlace, speciesFromDao, enclosure);
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

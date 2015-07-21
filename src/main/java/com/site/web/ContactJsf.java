package com.site.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.site.obj.Contact;
import com.site.obj.ContactOrigineServiceInterface;
import com.site.obj.ContactServiceInterface;
import com.site.obj.Contactorigine;


//@ApplicationScoped
//@Named
@Model
@ManagedBean
@SessionScoped
public class ContactJsf implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ContactServiceInterface contactSI;
	@Inject
	private ContactOrigineServiceInterface contactOrigineSI;

	private Long ContactId;
	private String Nom;
	private String Prenom;
	private String mail;
	private String telephone;
	private String message;
	private Boolean copymessage;
	private Date dateMessage;
	private Contactorigine contactorigine;
	private int contactOrigineId;

	/**
	 * @return the contactSI
	 */
	public ContactServiceInterface getContactService() {
		return contactSI;
	}

	/**
	 * @param contactSI the contactSI to set
	 */
	public void setContactService(ContactServiceInterface contactService) {
		this.contactSI = contactService;
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

	/**
	 * @return the dateMessage
	 */
	public Date getDateMessage() {
		dateMessage =Date.from(null) ;
		return dateMessage;
	}

	/**
	 * @param date the dateMessage to set
	 */
	public void setDateMessage(Date date) {
		this.dateMessage = date;
	}

	/**
	 * @return the contactorigine
	 */
	public Contactorigine getContactOrigine() {
		return contactorigine;
	}

	/**
	 * @param contactorigine the contactorigine to set
	 */
	public void setContactOrigine(Contactorigine contactorigine) {
		this.contactorigine = contactorigine;
	}

	/**
	 * @return the contactOrigineId
	 */
	public int getContactOrigineId() {
		return contactOrigineId;
	}

	/**
	 * @param i the contactOrigineId to set
	 */
	public void setContactOrigineId(int contactOrigineid) {
		this.contactOrigineId =  contactOrigineid;
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
			setcopymessage(contactFromList.getCopymessage());
			setDateMessage(contactFromList.getDatemessage());
			setContactOrigineId(contactFromList.getContactorigine().getContactorigineid());
			//			setContactOrigineId(contactFromList.getContactOrigineId());
			setContactOrigine(contactorigine);
		}
		// Navigation case.
		return "contact";
	}

	/**
	 * @return a list of all animals.
	 */
	public ArrayList<Contact> getAllContacts() {
		return contactSI.getAllContact();
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
		Contactorigine ContactOrigineFromDao = contactOrigineSI.getContactOrigine(contactOrigineId);
		contactSI.createContact( Nom, Prenom, mail, telephone, message, copymessage,  dateMessage, ContactOrigineFromDao);
		//		contactSI.createContact( Nom, Prenom, mail, telephone, message, copymessage,  contactOrigineId);
		contactSI.createContact( Nom, Prenom, mail, telephone, message, copymessage,  dateMessage, contactorigine);
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

	/**
	 * @return the contactId
	 */
	public Long getContactId() {
		return ContactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(Long contactId) {
		ContactId = contactId;
	}

}

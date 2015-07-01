/**
 *
 */
package com.site.obj;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author carole
 *
 */
@Entity(name="Contact")
@NamedQuery(name="Contact.findAll", query="SELECT a FROM Contact a")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Contact {

	@Id
	@GeneratedValue
	@XmlAttribute(required = true)
	@Column(unique=true)
	private Long ContactId;
	@XmlAttribute(required = true)
	private String nom;
	@XmlAttribute
	private String prenom;
	@XmlAttribute
	private String mail;
	@XmlAttribute
	private String telephone;
	@XmlAttribute
	private String message;
	@XmlAttribute
	private Boolean copymessage;
	@XmlAttribute
	private Date dateMessage;

	@ManyToOne
	@XmlElement(required = true)
	private ContactOrigine contactOrigine;


	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String nom,
			String prenom,String mail,String telephone,String message,
			Boolean copymessage,Date dateMessage,ContactOrigine contactOrigine)
	{
		this.nom = nom;
		this.prenom=prenom;
		this.mail=mail;
		this.telephone=telephone;
		this.message=message;
		this.copymessage=copymessage;
		this.dateMessage=dateMessage;
		this.contactOrigine=contactOrigine;

	}

	public Long getContactId() {
		return ContactId;
	}

	public void setContactId(Long ContactId) {
		this.ContactId = ContactId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMessage() {
		return message;
	}

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
	public void setSendMessage(Boolean copymessage) {
		this.copymessage = copymessage;
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

}

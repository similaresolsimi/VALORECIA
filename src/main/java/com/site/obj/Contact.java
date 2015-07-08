/**
 *
 */
package com.site.obj;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
//import javax.persistence.TableGenerator;
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

	@Id //Clé primaire
	@GeneratedValue
	//	@XmlAttribute(required = true)
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
	private LocalDateTime dateMessage;
	@ManyToOne
	@XmlElement(required = true)
	private ContactOrigine contactOrigine;
	//	@XmlAttribute
	//	private Long ContactOrigineId;


	/**
	 * @return the copymessage
	 */
	public Boolean getCopymessage() {
		return copymessage;
	}

	/**
	 * @param copymessage the copymessage to set
	 */
	public void setCopymessage(Boolean copymessage) {
		this.copymessage = copymessage;
	}

	//	/**
	//	 * @return the contactOrigineId
	//	 */
	//	public Long getContactOrigineId() {
	//		return ContactOrigineId;
	//	}
	//
	//	/**
	//	 * @param contactOrigineId the contactOrigineId to set
	//	 */
	//	public void setContactOrigineId(Long contactOrigineId) {
	//		ContactOrigineId = contactOrigineId;
	//	}

	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String nom,
			String prenom,String mail,String telephone,String message,
			Boolean copymessage,LocalDateTime dateMessage,ContactOrigine contactOrigine)
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

	//	public Contact(String nom,
	//			String prenom,String mail,String telephone,String message,
	//			Boolean copymessage,ContactOrigine contactOrigine)
	//	{
	//		this.nom = nom;
	//		this.prenom=prenom;
	//		this.mail=mail;
	//		this.telephone=telephone;
	//		this.message=message;
	//		this.copymessage=copymessage;
	//		this.contactOrigine=contactOrigine;
	//
	//	}

	//	public Contact(String nom,
	//			String prenom,String mail,String telephone,String message,
	//			Boolean copymessage,Long contactOrigineId)
	//	{
	//		this.nom = nom;
	//		this.prenom=prenom;
	//		this.mail=mail;
	//		this.telephone=telephone;
	//		this.message=message;
	//		this.copymessage=copymessage;
	//		this.ContactOrigineId=contactOrigineId;
	//
	//	}

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
	public LocalDateTime getDateMessage() {
		//		Date date =  new Date(1000);
		//		return date;
		return dateMessage;

	}

	/**
	 * @param dateMessage the dateMessage to set
	 */

	public void setDateMessage(LocalDateTime dateMessage) {
		//		Date date =  new Date(1000);
		//		dateMessage=date;
		this.dateMessage =dateMessage;
	}

}

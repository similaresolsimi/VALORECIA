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
	private String name;
	@XmlAttribute
	private String surname;
	@XmlAttribute
	private String mail;
	@XmlAttribute
	private String telephone;
	@XmlAttribute
	private String message;
	@XmlAttribute
	private Boolean sendMessage;
	@XmlAttribute
	private Date dateMessage;
	@ManyToOne
	@XmlElement(required = true)
	private ContactOrigine contactOrigine;


	public Contact() {
		// TODO Auto-generated constructor stub
	}

	public Contact(String name,
			String surname,String mail,String telephone,String message,
			Boolean sendMessage,Date dateMessage,ContactOrigine contactOrigine)
	{
		this.name = name;
		this.surname=surname;
		this.mail=mail;
		this.telephone=telephone;
		this.message=message;
		this.sendMessage=sendMessage;
		this.dateMessage=dateMessage;
		this.contactOrigine=contactOrigine;

	}

	public Long getContactId() {
		return ContactId;
	}

	public void setContactId(Long ContactId) {
		this.ContactId = ContactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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



}

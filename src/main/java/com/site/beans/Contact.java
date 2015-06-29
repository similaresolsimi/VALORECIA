/**
 *
 */
package com.site.beans;

/**
 * @author carole
 *
 */
public class Contact {

	/**
	 *
	 */
	private String name;
	private String surname;
	private String mail;
	private String telephone;
	private String message;
	private Boolean SendMessage;

	public Contact() {
		// TODO Auto-generated constructor stub
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
		return SendMessage;
	}

	/**
	 * @param sendMessage the sendMessage to set
	 */
	public void setSendMessage(Boolean sendMessage) {
		SendMessage = sendMessage;
	}



}

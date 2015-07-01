package com.site.web;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.site.obj.ContactOrigine;
import com.site.obj.ContactOrigineServiceInterface;

@Model
public class ContactOrigineJsf {

	@Inject
	private ContactOrigineServiceInterface ContactOrigineSI;
	private String contactOrigine;


	/**
	 * @return the contactOrigineSI
	 */
	public ContactOrigineServiceInterface getContactOrigineSI() {
		return ContactOrigineSI;
	}


	/**
	 * @param contactOrigineSI the contactOrigineSI to set
	 */
	public void setContactOrigineSI(ContactOrigineServiceInterface contactOrigineSI) {
		ContactOrigineSI = contactOrigineSI;
	}


	/**
	 * @return the contactOrigine
	 */
	public String getContactOrigine() {
		return contactOrigine;
	}


	/**
	 * @param contactOrigine the contactOrigine to set
	 */
	public void setContactOrigine(String contactOrigine) {
		this.contactOrigine = contactOrigine;
	}


	/**
	 * @return a list of all Species
	 */
	public ArrayList<ContactOrigine> getAllContactOrigine() {
		return ContactOrigineSI.getAllContactOrigine();
	}



}

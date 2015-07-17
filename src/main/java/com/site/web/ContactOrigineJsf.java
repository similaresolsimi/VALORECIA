package com.site.web;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;

import com.site.obj.ContactOrigine;
import com.site.obj.ContactOrigineServiceInterface;

//@ApplicationScoped
//@Named
@Model
public class ContactOrigineJsf implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ContactOrigineServiceInterface ContactOrigineSI;

	private String contactOrigineLabel;


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
	 * @return the contactOrigineLabel
	 */
	public String getContactOrigineLabel() {
		return contactOrigineLabel;
	}


	/**
	 * @param contactOrigineLabel the contactOrigineLabel to set
	 */
	public void setContactOrigineLabel(String contactOrigine) {
		this.contactOrigineLabel = contactOrigine;
	}


	/**
	 * @return a list of all Species
	 */
	public ArrayList<ContactOrigine> getAllContactOrigine() {
		return ContactOrigineSI.getAllContactOrigine();
	}


	// Managed Backing Bean
	private HtmlDataTable dataTable;
	/**
	 * @return "contactOrigine" (navigation). Set the contactOrigine and the hidden input field.
	 */
	public String editContactOrigine() {
		// Get selected animal to be displayed.
		ContactOrigine contactOrigineFromList = (ContactOrigine) dataTable.getRowData();
		if (contactOrigineFromList != null) {
			// Set properties to be displayed.
			setContactOrigineLabel(contactOrigineFromList.getContactOrigineLabel());

		}
		// Navigation case.
		return "contactOrigine";
	}
}

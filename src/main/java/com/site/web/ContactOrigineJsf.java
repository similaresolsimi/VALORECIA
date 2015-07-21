package com.site.web;

import java.io.Serializable;
import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;

import com.site.obj.ContactOrigineServiceInterface;
import com.site.obj.Contactorigine;

//@ApplicationScoped
//@Named
@Model
@ManagedBean
@SessionScoped
public class ContactOrigineJsf implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ContactOrigineServiceInterface ContactOrigineSI;

	private int contactorigineid;
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
	public ArrayList<Contactorigine> getAllContactOrigine() {
		return ContactOrigineSI.getAllContactOrigine();
	}


	// Managed Backing Bean
	private HtmlDataTable dataTable;
	/**
	 * @return "contactOrigine" (navigation). Set the contactOrigine and the hidden input field.
	 */
	public String editContactOrigine() {
		// Get selected animal to be displayed.
		Contactorigine contactOrigineFromList = (Contactorigine) dataTable.getRowData();
		if (contactOrigineFromList != null) {
			// Set properties to be displayed.
			setContactOrigineLabel(contactOrigineFromList.getContactoriginelabel());

		}
		// Navigation case.
		return "contactOrigine";
	}


	/**
	 * @return the contactorigineid
	 */
	public int getContactorigineid() {
		return contactorigineid;
	}


	/**
	 * @param contactorigineid the contactorigineid to set
	 */
	public void setContactorigineid(int contactorigineid) {
		this.contactorigineid = contactorigineid;
	}
}

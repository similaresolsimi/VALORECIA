package com.site.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.site.obj.Contact;
import com.site.obj.ContactServiceInterface;

@Path("/animal")
public class ContactRestRessource {

	@Inject
	private ContactServiceInterface contactService;

	// This method is called if XML or JSON is requested MediaType.APPLICATION_JSON,
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public List<Contact> getListContacts() {
		return contactService.getAllContact();
	}
}

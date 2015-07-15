/**
 *
 */
package com.site.obj;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author carole
 *
 */
@Entity
@NamedQuery(name="ContactOrigine.findAll", query="SELECT c FROM ContactOrigine c")
public class ContactOrigine {


	/**
	 *
	 */
	@Id
	@GeneratedValue
	@Column(unique=true)
	//	@XmlAttribute(required = true)
	private Long contactOrigineId;
	@XmlAttribute
	private String contactOrigine;

	public ContactOrigine() {
		// TODO Auto-generated constructor stub
	}

	public ContactOrigine(Long contactOrigineId,String ContactOrigine) {
		this.contactOrigineId=contactOrigineId;
		this.contactOrigine =ContactOrigine;
	}
	/**
	 * @return the contactOrigineId
	 */
	public Long getContactOrigineId() {
		return contactOrigineId;
	}
	//
	//	/**
	//	 * @param contactOrigineId the contactOrigineId to set
	//	 */
	//	public void setContactOrigineId(Long contactOrigineId) {
	//		this.contactOrigineId = contactOrigineId;
	//	}

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




}

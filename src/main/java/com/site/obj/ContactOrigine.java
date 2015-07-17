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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author carole
 *
 */
//@Table
//@Model
@Entity
@NamedQuery(name="ContactOrigine.findAll", query="SELECT c FROM ContactOrigine c")
@XmlRootElement
public class ContactOrigine {


	/**
	 *
	 */
	//	@XmlAttribute(required = true)
	//	@GeneratedValue(strategy = "increment")
	//	@GenericGenerator(parameters = @Parameter(name = "contactOrigineId"))
	@Id
	@GeneratedValue
	@Column(unique=true)
	@XmlAttribute
	private Long contactOrigineId;
	@XmlAttribute
	private String contactOrigineLabel;

	public ContactOrigine() {
		// TODO Auto-generated constructor stub
	}

	public ContactOrigine(Long contactOrigineId,String ContactOrigineLabel) {
		this.contactOrigineId=contactOrigineId;
		this.contactOrigineLabel =ContactOrigineLabel;
	}
	/**
	 * @return the contactOrigineId
	 */
	public Long getContactOrigineId() {
		return contactOrigineId;
	}



	/**
	 * @param contactOrigineId the contactOrigineId to set
	 */
	public void setContactOrigineId(Long contactOrigineId) {
		this.contactOrigineId = contactOrigineId;
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
	public void setContactOrigineLabel(String contactOrigineLabel) {
		this.contactOrigineLabel = contactOrigineLabel;
	}




}

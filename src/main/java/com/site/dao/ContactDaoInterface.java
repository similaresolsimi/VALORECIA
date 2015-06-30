/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.Contact;

/**
 * @author carole
 *
 */
public interface ContactDaoInterface extends Dao<Long, Contact>{

	/**
	 *
	 */
	public ArrayList<Long> getAllContact();

}

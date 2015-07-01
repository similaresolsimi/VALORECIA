/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.ContactOrigine;

/**
 * @author carole
 *
 */
public interface ContactOrigineDaoInterface extends Dao<Long, ContactOrigine> {
	/**
	 *
	 */
	public ArrayList<Long> getAllContactOrigine();

}

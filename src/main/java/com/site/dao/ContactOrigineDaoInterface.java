/**
 *
 */
package com.site.dao;

import java.util.ArrayList;

import com.site.obj.Contactorigine;

/**
 * @author carole
 *
 */
public interface ContactOrigineDaoInterface extends Dao<Long, Contactorigine> {
	/**
	 *
	 */
	public ArrayList<Long> getAllContactOrigine();

}

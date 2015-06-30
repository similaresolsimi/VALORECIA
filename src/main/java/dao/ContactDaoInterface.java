/**
 *
 */
package dao;

import java.util.ArrayList;

import com.site.beans.Contact;

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

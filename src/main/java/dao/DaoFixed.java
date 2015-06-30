/**
 * 
 */
package dao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author humanbooster
 *
 */
public abstract class DaoFixed<K, E> implements Dao<K, E> {

	protected Map<K, E> daoFixedMap;

	public DaoFixed() {
		if (daoFixedMap == null) {
			daoFixedMap = new HashMap<K, E>();
		}
	}
}

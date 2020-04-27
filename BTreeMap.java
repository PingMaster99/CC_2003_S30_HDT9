/**
 * <h1>BTreeMap</h1>
 * Implements a BTree map according to the MapInterface interface
 * allows its use in a factory
 *
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class BTreeMap<K extends Comparable<K>,V> implements MapInterface<K, V> {

    BTree<K, V> btree = new BTree<K, V>();

    /**
     * Inserts a value with a given key
     *
     * @param  key the key
     * @param value value to be inserted
     */
    public void put(K key, V value) {
        btree.put(key, value);
    }

    /**
     * Gets a value associated with a key
     *
     * @param  key the key
     * @return value associated
     */
    public String get(K key) {
        String english = key.toString();
        if(btree.get(key) != null) {
            return btree.get(key).toString();   // Returns word in Spanish
        } else {
            return null;    // Returns null if not found
        }
    }
}

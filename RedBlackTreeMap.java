/**
 * <h1>RedBlackTreeMap</h1>
 * Implements a Red Black Tree map according to the MapImplementation interface
 * allows its use in a factory
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class RedBlackTreeMap<K extends Comparable<K>,V> implements MapInterface<K, V> {

    RedBlackBST<K, V> rbt = new RedBlackBST<>();

    /**
     * Inserts a value with a given key
     *
     * @param  key the key
     * @param value value to be inserted
     */
    public void put(K key, V value) {
        rbt.put(key, value);
    }

    /**
     * Gets a value associated with a key
     *
     * @param  key the key
     * @return value associated
     */
    public String get(K key) {
        String english = key.toString();
        if(rbt.get(key) != null) {
            return rbt.get(key).toString(); // Returns word in Spanish
        } else {
            return null;    // Returns null if not found
        }
    }
}

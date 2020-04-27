public class BTreeMap<K extends Comparable<K>,V> implements MapInterface<K, V> {

    BTree<K, V> btree = new BTree<K, V>();

    public void put(K key, V value) {
        btree.put(key, value);
    }

    public String get(K key) {
        String english = key.toString();
        if(btree.get(key) != null) {
            return btree.get(key).toString();
        } else {
            return null;
        }

    }
}

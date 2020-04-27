public class BTreeMap<K extends Comparable<K>,V> implements Map<K, V>{

    public BTreeMap(BTree<K, V> btree) {
        this.btree = btree;
    }

    BTree<K, V> btree;

    public void put(K key, V value) {
        btree.put(key,value);
    }

    public V get(K key) {
        return btree.get(key);
    }
}

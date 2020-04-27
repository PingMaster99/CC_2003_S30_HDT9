public class BTreeMap<K,V> implements Map<K, V>{

    BTree<String, V> btree = new BTree<>();

    public void put(K key, V value) {
        String english = key.toString();
        btree.put(english, value);
    }

    public String get(K key) {
        String english = key.toString();
        return btree.get(english).toString();
    }
}

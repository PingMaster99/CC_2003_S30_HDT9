public class RedBlackTreeMap<K extends Comparable<K>,V> implements MapInterface<K, V> {

    RedBlackBST<K, V> rbt = new RedBlackBST<>();

    public void put(K key, V value) {
        rbt.put(key, value);
    }

    public String get(K key) {
        String english = key.toString();
        return rbt.get(key).toString();
    }
}

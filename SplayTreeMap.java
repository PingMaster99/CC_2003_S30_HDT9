public class SplayTreeMap<K, V> implements Map<K, V> {
    SplayTree<String> splayTree;

    @Override
    public void put(K key, V value) {
        SplayNode<K> splayNode = new SplayNode<key, value>();
        splayTree.insert();
    }

    @Override
    public V get(K key) {

        return null;
    }
}

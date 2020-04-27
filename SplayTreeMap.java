public class SplayTreeMap<K, V> implements Map<K, V> {
    SplayTree<String> splayTree;

    @Override
    public void put(K key, V value) {
        SplayNode<String> splayNode = new SplayNode<String>(key.toString(), value.toString());
        splayTree.insert(splayNode);
    }

    @Override
    public String get(K key) {
        return splayTree.search(key.toString());
    }
}

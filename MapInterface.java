public interface MapInterface<K, V> {
    void put(K key, V value);
    String get(K key);
}

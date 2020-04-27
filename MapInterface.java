/**
 * <h1>MapInterface</h1>
 * Interface for map implementation in mapping structures
 *
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public interface MapInterface<K, V> {
    void put(K key, V value);
    String get(K key);
}

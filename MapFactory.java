/**
 * <h1>MapFactory</h1>
 * Factory used to generate the mapping structure of the dictionary
 *
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class MapFactory<K extends Comparable<K>, V> {

    /**
     * Inserts a value with a given key
     *
     * @param  entry of map to be used (uses B-Tree by default)
     * @return mapping structure (RBT or B-Tree)
     */
    public MapInterface<K, V> getMap(String entry) {

        // Mapping structure generation according to input
        if(entry.equals("1")) {
            System.out.println("Usando Red Black Tree");
            return new RedBlackTreeMap<>();
        } else if (entry.equals("2")) {
            System.out.println("Usando BTree (2-3)");
            return new BTreeMap<>();
        } else {
            System.out.println("Usando BTree (2-3)");
            return new BTreeMap<>();
        }
    }
}

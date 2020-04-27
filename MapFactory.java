public class MapFactory<K extends Comparable<K>, V> {
    public MapInterface<K, V> getMap(String entry) {

        entry = entry.toLowerCase();

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

import java.util.LinkedHashMap;
import java.util.Map;

public class MapFactory<K, V> {
    public Map<K, V> getMap(String entry) {
        entry = entry.toLowerCase();
        if(entry.equals("1")) {
            System.out.println("Usando Splay Tree");
            return new LinkedHashMap<>();
        } else if (entry.equals("2")) {
            System.out.println("Usando BTree (2-3)");
            return (Map<K, V>) new BTree<String, String>();
        } else {
            System.out.println("Usando BTree (2-3)");
            return new LinkedHashMap<>();
        }
    }
}

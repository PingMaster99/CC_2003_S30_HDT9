import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapFactory<K, V> {
    public Map<K, V> getMap(String entry) {
        entry = entry.toLowerCase();
        if(entry.equals("1")) {
            System.out.println("Using Splay Tree");
            return new HashMap<>();
        } else if (entry.equals("2")) {
            System.out.println("Using BTree");
            return new LinkedHashMap<>();
        } else {
            System.out.println("Using BTree");
            return new TreeMap<>();
        }
    }


}

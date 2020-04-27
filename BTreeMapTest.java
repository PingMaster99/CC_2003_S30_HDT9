import org.junit.Test;

import static org.junit.Assert.*;
/**
 * <h1>BTreeMapTest</h1>
 * Tests for the B-Tree
 *
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class BTreeMapTest {
    BTreeMap<String, String> BTreeTest = new BTreeMap<>();
    @Test
    public void put() {
        // Checks if value has been inserted
        BTreeTest.put("This","Is_A_Test");
        assertEquals(BTreeTest.get("This"),"Is_A_Test");
    }

    @Test
    public void get() {
        // Verifies if something is on the tree
        assertEquals(BTreeTest.get("ThisIsNotOnTheTree"),null);

    }
}
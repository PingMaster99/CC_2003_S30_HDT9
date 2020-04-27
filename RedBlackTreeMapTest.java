import org.junit.Test;

import static org.junit.Assert.*;
/**
 * <h1>RedBlackTreeMapTest</h1>
 * Red black Tree tests
 * <p>
 *
 * @author Sebastian Gonzales (tabufellin) Pablo Ruiz (PingMaster99)
 * @version 1.0
 * @since 2020-04-27
 **/
public class RedBlackTreeMapTest {

    BTreeMap<String, String> RBT = new BTreeMap<>();
    @Test
    public void put() {
        // Checks if elements are inserted
        RBT.put("This","TestRBT");
        assertEquals(RBT.get("This"),"TestRBT");
    }

    @Test
    public void get() {
        // Verifies correct search method
        assertNull(RBT.get("ThisIsNotOnTheTree"));
    }
}
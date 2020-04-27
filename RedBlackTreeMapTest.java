import org.junit.Test;

import static org.junit.Assert.*;

public class RedBlackTreeMapTest {

    BTreeMap<String, String> RBT = new BTreeMap<>();
    @Test
    public void put() {
        RBT.put("This","TestRBT");
        assertEquals(RBT.get("This"),"TestRBT");
    }

    @Test
    public void get() {
        assertNull(RBT.get("ThisIsNotOnTheTree"));
    }
}
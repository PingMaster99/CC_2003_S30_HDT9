import org.junit.Test;

import static org.junit.Assert.*;

public class BTreeMapTest {
    BTreeMap<String, String> BTreeTest = new BTreeMap<>();
    @Test
    public void put() {
        BTreeTest.put("This","Is_A_Test");
        assertEquals(BTreeTest.get("This"),"Is_A_Test");
    }

    @Test
    public void get() {
        assertEquals(BTreeTest.get("ThisIsNotOnTheTree"),null);

    }
}
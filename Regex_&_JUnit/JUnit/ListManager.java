import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class ListManager {
    public void addElement(List<Integer> list, int element) {
        if (list != null) {
            list.add(element);
        }
    }

    public void removeElement(List<Integer> list, int element) {
        if (list != null) {
            list.remove(Integer.valueOf(element));
        }
    }

    public int getSize(List<Integer> list) {
        return (list != null) ? list.size() : 0;
    }
}

class ListManagerTest {
    private final ListManager listManager = new ListManager();

    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        listManager.addElement(list, 5);
        listManager.addElement(list, 10);
        assertEquals(2, list.size());
        assertTrue(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        listManager.removeElement(list, 5);
        assertEquals(1, list.size());
        assertFalse(list.contains(5));
        assertTrue(list.contains(10));
    }

    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, listManager.getSize(list));
        listManager.addElement(list, 5);
        assertEquals(1, listManager.getSize(list));
        listManager.addElement(list, 10);
        assertEquals(2, listManager.getSize(list));
        listManager.removeElement(list, 5);
        assertEquals(1, listManager.getSize(list));
    }

    @Test
    void testNullListOperations() {
        List<Integer> list = null;
        listManager.addElement(list, 5);  // Should not throw exception
        listManager.removeElement(list, 5);  // Should not throw exception
        assertEquals(0, listManager.getSize(list));  // Should return 0 for null lists
    }
}

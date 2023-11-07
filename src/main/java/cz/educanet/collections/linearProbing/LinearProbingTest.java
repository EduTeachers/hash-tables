package cz.educanet.collections.linearProbing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearProbingTest {

    @Test
    public void testPutAndGet() {
        LinearProbing hashTable = new LinearProbing(10);

        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(12, 120);

        assertEquals(10, hashTable.get(1));
        assertEquals(20, hashTable.get(2));
        assertEquals(120, hashTable.get(12));
    }

    @Test
    public void testContains() {
        LinearProbing hashTable = new LinearProbing(10);

        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(12, 120);

        assertTrue(hashTable.contains(1));
        assertTrue(hashTable.contains(2));
        assertTrue(hashTable.contains(12));
        assertFalse(hashTable.contains(3));
    }

    @Test
    public void testSize() {
        LinearProbing hashTable = new LinearProbing(10);

        assertEquals(0, hashTable.getSize());

        hashTable.put(1, 10);
        assertEquals(1, hashTable.getSize());

        hashTable.put(2, 20);
        assertEquals(2, hashTable.getSize());

        hashTable.put(12, 120);
        assertEquals(3, hashTable.getSize());
    }
}

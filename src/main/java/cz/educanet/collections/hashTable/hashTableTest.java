package cz.educanet.collections.hashTable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

    public class hashTableTest {
        private hashTable table;

        @Test
        public void testAddAndContains() {
            assertTrue(table.add("apple"));
            assertTrue(table.contains("apple"));
            assertFalse(table.contains("banana"));
        }

        @Test
        public void testRemove() {
            table.add("apple");
            assertTrue(table.remove("apple"));
            assertFalse(table.contains("apple"));
        }

        @Test
        public void testRemoveNonExistent() {
            assertFalse(table.remove("banana"));
        }

        @Test
        public void testToList() {
            table.add("apple");
            table.add("banana");
            table.add("cherry");

            assertTrue(table.toList().contains("apple"));
            assertTrue(table.toList().contains("banana"));
            assertTrue(table.toList().contains("cherry"));
        }
    }
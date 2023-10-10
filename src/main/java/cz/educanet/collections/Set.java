package cz.educanet.collections;

import java.util.List;

public interface Set<String> {

    /**
     * Adds an item to the collection
     *
     * @param item Item to add
     * @return True if item was added successfully, false if item already exists
     */
    boolean add(String item);

    /**
     * Removes an item from the collection
     *
     * @param item Item to remove
     * @return True if item was removed successfully, false if item wasn't found
     */
    boolean remove(String item);

    /**
     * Searches for the given item, and returns true if found.
     *
     * @param item To search for
     * @return Found element
     */
    boolean contains(String item);

    /**
     * Converts the collection to a List and returns it
     *
     * @return List
     */
    List<String> toList();

}

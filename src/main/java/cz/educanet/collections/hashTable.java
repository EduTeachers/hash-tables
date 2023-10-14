package cz.educanet.collections;

import java.util.LinkedList;
import java.util.List;

public class hashTable implements Set<String>{
    List<LinkedList<String>> list = new LinkedList<>();
    @Override
    public boolean add(String item) {
        return list.get(getHashIndex(item)).add(item);
    }

    public int getHashIndex(String item) {
        return item.hashCode() % 1000;
    }

    @Override
    public boolean remove(String item) {
        return list.get(getHashIndex(item)).removeFirstOccurrence(item);
    }

    @Override
    public boolean contains(String item) {
        return list.get(getHashIndex(item)).contains(item);
    }

    @Override
    public List toList() {
        return list.stream().toList();
    }
}

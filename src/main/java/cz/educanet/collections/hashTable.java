package cz.educanet.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class hashTable implements Set<String>{
    int size = 1000;
    private LinkedList<String>[] list = new LinkedList[size];

    @Override
    public boolean add(String item) {
        return list[getHashIndex(item)].add(item);
    }

    public int getHashIndex(String item) {
        return item.hashCode() % 1000;
    }

    @Override
    public boolean remove(String item) {
        return list[getHashIndex(item)].removeFirstOccurrence(item);
    }

    @Override
    public boolean contains(String item) {
        return list[getHashIndex(item)].contains(item);
    }

    @Override
    public List toList() {
        return Arrays.stream(list).toList();
    }
}

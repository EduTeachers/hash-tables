package cz.educanet.collections;

import java.util.Arrays;
import java.util.List;

public class LinearProbing<T> implements Set<T> {
    private Object[] table; // Úložiště pro prvky
    private int size;

    public LinearProbing(int capacity) {
        table = new Object[capacity];
        size = 0;
    }

    // Implementace hašovací funkce pro určení indexu pro prvek
    private int hash(T item) {
        return item.hashCode() % table.length;
    }

    @Override
    public boolean add(T item) {
        int index = hash(item);
        while (table[index] != null) {
            if (table[index].equals(item)) {
                return false; // Prvek již existuje, nelze ho přidat
            }
            index = (index + 1) ; // posun o 1
        }
        table[index] = item;
        size++;
        return true;
    }
    @Override
    public boolean remove(T item) {
        int index = hash(item);

        while (table[index] != null) {
            if (table[index].equals(item)) {
                table[index] = null;
                size--;
                return true;
            }
            index = (index + 1);
        }
        return false; // Prvek nebyl nalezen
    }

    @Override
    public boolean contains(T item) {
        int index = hash(item);

        while (table[index] != null) {
            if (table[index].equals(item)) {
                return true;
            }
            index = (index + 1) % table.length;
        }

        return false; // Prvek nebyl nalezen
    }

    @Override
    public List<T> toList() {
    return Arrays.stream(table).filter(item -> item != null).map(item -> (T) item).toList();
    }
}

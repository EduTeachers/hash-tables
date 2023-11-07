package cz.educanet;

public class LinearProbing {
    private int[] keys;
    private int[] values;
    private int capacity;
    private int size;

    public LinearProbing(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.keys = new int[capacity];
        this.values = new int[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {
        int index = hash(key);

        while (keys[index] != 0 && keys[index] != key) {
            index = (index + 1) % capacity;
        }

        keys[index] = key;
        values[index] = value;
        size++;
    }

    public int get(int key) {
        int index = hash(key);

        while (keys[index] != 0) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % capacity;
        }

        return -1;
    }

    public boolean contains(int key) {
        return get(key) != -1;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinearProbing hashTable = new LinearProbing(10);

        hashTable.put(1, 10);
        hashTable.put(2, 20);
        hashTable.put(12, 120);

        System.out.println("Value for key 1: " + hashTable.get(1));
        System.out.println("Value for key 2: " + hashTable.get(2));
        System.out.println("Value for key 12: " + hashTable.get(12));
        System.out.println("Size of hash table: " + hashTable.getSize());
    }
}


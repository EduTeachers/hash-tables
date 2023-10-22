package cz.educanet.linearProbing;

public class LinearProbing {


    private final int maxSize;
    private int currentSize;
    private final String[] keys;
    private final String[] values;


    public LinearProbing(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.keys = new String[maxSize];
        this.values = new String[maxSize];
    }

    private int hash(String key) {
        return key.hashCode() % this.maxSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public boolean put(String key, String value) {

        int hash = hash(key);

        int i = hash;
        do {
            if (this.keys[i] == null) {
                this.keys[i] = key;
                this.values[i] = value;
                this.currentSize++;
                return true;
            }
            if (this.keys[i].equals(key)) {
                this.values[i] = value;
                return true;
            }

            i = (i + 1) % this.maxSize;

        } while (i != hash);

        return false;
    }

    private String getValue(String key) {

        int i = hash(key);
        while (this.keys[i] != null) {
            if (this.keys[i].equals(key)) return this.values[i];
            i = (i + 1) % this.maxSize;
        }
        return null;
    }

    public boolean contains(String key) {
        return getValue(key) == null;
    }

    public String get(String key) {
        return getValue(key);
    }

    public boolean remove(String key) {

        if (getValue(key) == null) return false;

        int i = hash(key);
        while (!key.equals(keys[i])) i = (i + 1) % this.maxSize;

        this.keys[i] = null;
        this.values[i] = null;

        for (i = (i + 1) % this.maxSize; this.keys[i] != null; i = (i + 1) % this.maxSize) {

            String tmpKey = this.keys[i];
            String tmpValue = this.values[i];
            this.keys[i] = null;
            this.values[i] = null;

            currentSize--;

            put(tmpKey, tmpValue);
        }
        currentSize--;
        return true;
    }
}

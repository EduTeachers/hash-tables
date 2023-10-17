package cz.educanet.collections;

import java.util.Arrays;
import java.util.List;

public class SetClass implements Set<String> {

    String[] rawArray;

    public SetClass(String[] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public boolean add(String item) {
        for (String s : this.rawArray) {
            if (s.equals(item)) return false;
        }

        String[] newRawArray = Arrays.copyOf(this.rawArray, this.rawArray.length + 1);
        newRawArray[newRawArray.length - 1] = item;
        this.rawArray = newRawArray;

        return true;
    }

    @Override
    public boolean remove(String item) {
        for (int i = 0; i < this.rawArray.length; i++) {
            if (this.rawArray[i].equals(item)) {
                //put last value into the removed item's place
                //changing the order doesn't matter, because it is a set
                this.rawArray[i] = this.rawArray[this.rawArray.length - 1];
                //remove the now empty last slot
                this.rawArray = Arrays.copyOf(this.rawArray, this.rawArray.length - 1);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean contains(String item) {
        for (String s : this.rawArray) {
            if (s.equals(item)) return true;
        }

        return false;
    }

    @Override
    public List<String> toList() {
        return Arrays.asList(rawArray);
    }
}

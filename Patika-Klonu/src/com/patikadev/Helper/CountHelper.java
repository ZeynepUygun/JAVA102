package com.patikadev.Helper;

public class CountHelper {
    private int count;
    private int id;

    public CountHelper(int id,int count) {
        this.count = count;
        this.id=id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

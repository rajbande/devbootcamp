package com.thoughtworks.devbootcamp.chemicalfactory;

public abstract class Machine {

    protected int count;
    protected int users;

    public Machine(int count) {
        this.count = count;
    }

    public abstract void process(Chemical chemical);

    public boolean isAvailable() {
        return users < count;
    }

    public void reset() {
        users = 0;
    }
}

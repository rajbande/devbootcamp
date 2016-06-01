package com.thoughtworks.devbootcamp.factory;

public class Packager extends Machine {

    public Packager(int count) {
        super(count);
    }

    @Override
    public void process(Chemical chemical) {
        if (chemical.shouldPack() && isAvailable()) {
            chemical.pack();
            users++;
        }
    }
}

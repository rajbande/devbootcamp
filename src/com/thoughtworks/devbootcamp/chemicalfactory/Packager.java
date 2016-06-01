package com.thoughtworks.devbootcamp.chemicalfactory;

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

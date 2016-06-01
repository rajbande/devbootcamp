package com.thoughtworks.devbootcamp.factory;

public class Mixer extends Machine {

    public Mixer(int count) {
        super(count);
    }

    @Override
    public void process(Chemical chemical) {
        if (chemical.shouldMix() && isAvailable()) {
            chemical.mix();
            users++;
        }
    }
}

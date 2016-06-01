package com.thoughtworks.devbootcamp.chemicalfactory;

public class Grinder extends Machine {

    public Grinder(int count) {
        super(count);
    }

    @Override
    public void process(Chemical chemical) {
        if(chemical.shouldGrind() && isAvailable()) {
            chemical.grind();
            users++;
        }
    }
}

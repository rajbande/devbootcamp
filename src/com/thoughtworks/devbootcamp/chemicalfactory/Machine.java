package com.thoughtworks.devbootcamp.chemicalfactory;

public enum Machine {
    GRINDER(2),
    MIXER(2),
    REACTOR(1),
    COOLER(1),
    PACKAGER(1);

    protected int count;
    private int jobs;

    Machine(int count) {
        this.count = count;
    }

    public void process(Chemical chemical, Machine machine) {
        boolean available = getAvailability(machine);

        if (chemical.shouldProcess(machine) && available) {
            chemical.process(machine);
            jobs++;
        }
    }

    private boolean getAvailability(Machine machine) {
        boolean available = isAvailable();
        if(machine == COOLER) {
            available = true;
        }
        return available;
    }

    public boolean isAvailable() {
        return jobs < count;
    }

    public void clearJobs() {
        jobs = 0;
    }
}

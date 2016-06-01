package com.thoughtworks.devbootcamp.factory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;

public class ChemicalFactory {

    private List<Chemical> chemicals;
    private List<Machine> machines = asList(new Packager(1), new Cooler(1),
            new Reactor(1), new Mixer(1), new Grinder(1));

    public int productionTime(Chemical... chemicals) {
        this.chemicals = new ArrayList<>(asList(chemicals));

        int productionTime = 1;
        while (this.chemicals.size() > 0) {

            resetMachines();
            processChemicals();

            if (this.chemicals.size() > 0) {
                productionTime++;
            }
        }
        return productionTime;
    }

    private void processChemicals() {
        Iterator<Chemical> chemicals = this.chemicals.iterator();
        while (chemicals.hasNext()) {
            Chemical chemical = chemicals.next();
            processChemical(chemical);
            if (chemical.isComplete()) {
                chemicals.remove();
            }
        }
    }

    private void processChemical(Chemical chemical) {
        for (Machine machine : machines) {
            machine.process(chemical);
        }
    }

    private void resetMachines() {
        for (Machine machine : machines) {
            machine.reset();
        }
    }
}

package com.thoughtworks.devbootcamp.chemicalfactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.thoughtworks.devbootcamp.chemicalfactory.Machine.*;
import static java.util.Arrays.asList;

public class ChemicalFactory {

    private static final int BASE_PRODUCTION_TIME = 1;
    private List<Chemical> chemicals;
    private List<Machine> machines = asList(PACKAGER, COOLER, REACTOR, MIXER, GRINDER);

    public int getProductionTime(Chemical... chemicalJobs) {
        this.chemicals = new ArrayList<>(asList(chemicalJobs));

        int productionTime = BASE_PRODUCTION_TIME;
        productionTime = calculateProductionTime(productionTime);
        return productionTime;
    }

    private int calculateProductionTime(int productionTime) {
        while (!chemicals.isEmpty()) {
            clearJobs();
            processChemicals();

            if (!chemicals.isEmpty()) {
                productionTime++;
            }
        }
        return productionTime;
    }

    private void processChemicals() {
        Iterator<Chemical> chemicals = this.chemicals.iterator();

        while (chemicals.hasNext()) {
            Chemical chemical = chemicals.next();
            processChemical(chemicals, chemical);
        }
    }

    private void processChemical(Iterator<Chemical> chemicals, Chemical chemical) {
        for (Machine machine : machines) {
            machine.process(chemical, machine);
        }

        purgeIfComplete(chemicals, chemical);
    }

    private void purgeIfComplete(Iterator<Chemical> chemicals, Chemical chemical) {
        if (chemical.isComplete()) {
            chemicals.remove();
        }
    }

    private void clearJobs() {
        for (Machine machine : machines) {
            machine.clearJobs();
        }
    }
}

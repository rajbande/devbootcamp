package com.thoughtworks.devbootcamp.chemicalfactory;

import static com.thoughtworks.devbootcamp.chemicalfactory.Machine.*;

public class Chemical {
    private int grinderTime;
    private int mixerTime;
    private int reactorTime;
    private int coolerTime;
    private int packagerTime;

    public Chemical(int grinder, int mixer, int reactor, int cooler, int packager) {
        this.grinderTime = grinder;
        this.mixerTime = mixer;
        this.reactorTime = reactor;
        this.coolerTime = cooler;
        this.packagerTime = packager;
    }

    public boolean isComplete() {
        return packagerTime <= 0;
    }

    @Override
    public String toString() {
        return "Chemical{" +
                "grinderTime=" + grinderTime +
                ", mixerTime=" + mixerTime +
                ", reactorTime=" + reactorTime +
                ", coolerTime=" + coolerTime +
                ", packagerTime=" + packagerTime +
                '}';
    }

    public boolean shouldProcess(Machine machine) {
        if(machine == GRINDER){
            return grinderTime > 0;
        } else if(machine == MIXER){
            return mixerTime > 0 && grinderTime <= 0;
        } else if(machine == REACTOR){
            return reactorTime > 0 && mixerTime <= 0;
        } else if(machine == COOLER){
            return coolerTime > 0 && reactorTime <= 0;
        } else if(machine == PACKAGER){
            return packagerTime > 0 && coolerTime <= 0;
        }
        return false;
    }

    public void process(Machine machine) {
        if(machine == GRINDER){
            grinderTime--;
        } else if(machine == MIXER){
            mixerTime--;
        } else if(machine == REACTOR){
            reactorTime--;
        } else if(machine == COOLER){
            coolerTime--;
        } else if(machine == PACKAGER){
            packagerTime--;
        }
    }
}

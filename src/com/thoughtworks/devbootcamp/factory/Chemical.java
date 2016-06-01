package com.thoughtworks.devbootcamp.factory;

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

    public void grind() {
        grinderTime -= 1;
    }

    public void mix() {
        mixerTime -= 1;
    }

    public void react() {
        reactorTime -= 1;
    }


    public void cool() {
        coolerTime -= 1;
    }

    public void pack() {
        packagerTime -= 1;
    }

    public boolean shouldGrind() {
        return grinderTime > 0;
    }

    public boolean shouldMix() {
        return mixerTime > 0 && grinderTime <= 0;
    }

    public boolean shouldReact() {
        return reactorTime > 0 && mixerTime <= 0;
    }


    public boolean shouldCool() {
        return coolerTime > 0 && reactorTime <= 0;
    }


    public boolean shouldPack() {
        return packagerTime > 0 && coolerTime <= 0;
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
}

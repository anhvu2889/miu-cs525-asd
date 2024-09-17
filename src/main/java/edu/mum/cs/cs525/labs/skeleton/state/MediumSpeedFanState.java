package edu.mum.cs.cs525.labs.skeleton.state;

public class MediumSpeedFanState implements FanState {
    private final CeilingFan fan;

    public MediumSpeedFanState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pullGreen() {
        fan.setFanState(fan.getHighSpeedFanState());
        System.out.println("high speed");
    }

    @Override
    public void pullRed() {
        fan.setFanState(fan.getMediumSpeedFanState());
        System.out.println("low speed");
    }
}

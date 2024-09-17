package edu.mum.cs.cs525.labs.skeleton.state;

public class OffFanState implements FanState {

    private final CeilingFan fan;

    public OffFanState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pullGreen() {
        fan.setFanState(fan.getLowSpeedFanState());
        System.out.println("low speed");
    }

    @Override
    public void pullRed() {
        fan.setFanState(fan.getHighSpeedFanState());
        System.out.println("high speed");
    }
}

package edu.mum.cs.cs525.labs.skeleton.state;

public class HighSpeedFanState implements FanState {
    private final CeilingFan fan;

    public HighSpeedFanState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pullGreen() {
        fan.setFanState(fan.getOffFanState());
        System.out.println("turning off");
    }

    @Override
    public void pullRed() {
        fan.setFanState(fan.getMediumSpeedFanState());
        System.out.println("medium speed");
    }
}

package edu.mum.cs.cs525.labs.skeleton.state;

public class LowSpeedFanState implements FanState {
    private final CeilingFan fan;

    public LowSpeedFanState(CeilingFan fan) {
        this.fan = fan;
    }

    @Override
    public void pullGreen() {
        fan.setFanState(fan.getMediumSpeedFanState());
        System.out.println("medium speed");
    }

    @Override
    public void pullRed() {
        fan.setFanState(fan.getOffFanState());
        System.out.println("turning off");
    }
}

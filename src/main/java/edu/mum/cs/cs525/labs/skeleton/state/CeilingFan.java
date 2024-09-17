package edu.mum.cs.cs525.labs.skeleton.state;

public class CeilingFan {
    private FanState fanState;
    private final OffFanState offFanState;
    private final LowSpeedFanState lowSpeedFanState;
    private final MediumSpeedFanState mediumSpeedFanState;
    private final HighSpeedFanState highSpeedFanState;


    public CeilingFan() {
        this.offFanState = new OffFanState(this);
        this.lowSpeedFanState = new LowSpeedFanState(this);
        this.mediumSpeedFanState = new MediumSpeedFanState(this);
        this.highSpeedFanState = new HighSpeedFanState(this);

        this.fanState = getOffFanState();
    }

    public OffFanState getOffFanState() {
        return offFanState;
    }

    public LowSpeedFanState getLowSpeedFanState() {
        return lowSpeedFanState;
    }

    public MediumSpeedFanState getMediumSpeedFanState() {
        return mediumSpeedFanState;
    }

    public HighSpeedFanState getHighSpeedFanState() {
        return highSpeedFanState;
    }

    public FanState getFanState() {
        return fanState;
    }

    public void setFanState(FanState fanState) {
        this.fanState = fanState;
    }

    public void pullGreen() {
        fanState.pullGreen();
    }

    public void pullRed() {
        fanState.pullRed();
    }
}

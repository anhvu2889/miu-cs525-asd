package edu.mum.cs.cs525.labs.skeleton.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Manager extends Hire {

    private final List<Hire> directReports;

    public Manager() {
        this.directReports = new ArrayList<>();
    }

    public void addHire(Hire hire) {
        directReports.add(hire);
    }

    public void removeHire(Hire hire) {
        directReports.remove(hire);
    }

    @Override
    public void process(Consumer<Hire> action) {
        action.accept(this);
        for (Hire hire : directReports) {
            hire.process(action);
        }
    }
}

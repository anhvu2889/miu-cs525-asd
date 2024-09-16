package edu.mum.cs.cs525.labs.skeleton.composite;

import java.util.function.Consumer;

public class Employee extends Hire {

    @Override
    public void process(Consumer<Hire> action) {
        action.accept(this);
    }


}

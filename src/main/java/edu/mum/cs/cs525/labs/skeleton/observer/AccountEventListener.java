package edu.mum.cs.cs525.labs.skeleton.observer;

public interface AccountEventListener {
    void onAccountUpdate(AccountEventType accountEventType);
}

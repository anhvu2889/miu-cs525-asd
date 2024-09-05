package edu.mum.cs.cs525.labs.skeleton.observer;

public class AccountLogger implements AccountEventListener {
    @Override
    public void onAccountUpdate(AccountEventType accountEventType) {
        System.out.println("Received event: " + accountEventType + " in AccountLogger");
    }
}

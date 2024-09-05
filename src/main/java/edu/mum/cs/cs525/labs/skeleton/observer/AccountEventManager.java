package edu.mum.cs.cs525.labs.skeleton.observer;

public interface AccountEventManager {
    void subscribe(AccountEventListener listener, AccountEventType accountEventType);

    void unsubscribe(AccountEventListener listener, AccountEventType accountEventType);

    void triggerEvent(AccountEventType accountEventType);

}

package edu.mum.cs.cs525.labs.skeleton.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountEventManagerImpl implements AccountEventManager {
    private Map<AccountEventType, List<AccountEventListener>> listenersMap;

    public AccountEventManagerImpl() {
        listenersMap = new HashMap<>();
    }

    public void subscribe(AccountEventListener listener, AccountEventType accountEventType) {
        listenersMap.computeIfAbsent(accountEventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(AccountEventListener listener, AccountEventType accountEventType) {
        List<AccountEventListener> listeners = listenersMap.get(accountEventType);
        if (listeners != null) {
            listeners.remove(listener);
            if (listeners.isEmpty()) {
                listenersMap.remove(accountEventType);
            }
        }
    }

    @Override
    public void triggerEvent(AccountEventType accountEventType) {
        notify(accountEventType);
        notify(AccountEventType.ALL);
    }

    private void notify(AccountEventType accountEventType) {
        List<AccountEventListener> listeners = listenersMap.get(accountEventType);
        if (listeners != null) {
            for (AccountEventListener listener : listeners) {
                listener.onAccountUpdate(accountEventType);
            }
        }
    }
    public List<AccountEventListener> getListeners(AccountEventType accountEventType) {
        return listenersMap.get(accountEventType);
    }


}

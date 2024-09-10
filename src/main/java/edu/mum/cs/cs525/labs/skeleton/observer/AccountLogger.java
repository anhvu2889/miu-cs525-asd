package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.adapter.AppLogger;
import edu.mum.cs.cs525.labs.skeleton.adapter.LogLevel;
import edu.mum.cs.cs525.labs.skeleton.adapter.Logger4jAdapter;

public class AccountLogger implements AccountEventListener {
    @Override
    public void onAccountUpdate(AccountEventType accountEventType) {
//        System.out.println("Received event: " + accountEventType + " in AccountLogger");
        AppLogger appLogger = new Logger4jAdapter(this.getClass());
        appLogger.log(LogLevel.ERROR, STR."Received event: \{accountEventType}");
    }
}

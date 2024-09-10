package edu.mum.cs.cs525.labs.skeleton.command;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class TransferFundCommand implements Command {
    private final Account fromAccount;
    private final Account toAccount;
    private final double amount;
    private final String description;

    public TransferFundCommand(Account fromAccount, Account toAccount, double amount, String description) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        fromAccount.transferFunds(toAccount, amount, description);
    }

    @Override
    public void undo() {
        toAccount.transferFunds(fromAccount, amount, "Revert: " + description);
    }
}

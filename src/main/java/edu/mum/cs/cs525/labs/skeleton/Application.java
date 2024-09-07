package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.decorator.LowIncomePromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.LoyaltyPromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.MilitaryVeteranPromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.factory.ProdServiceFactory;
import edu.mum.cs.cs525.labs.skeleton.factory.ServiceFactory;
import edu.mum.cs.cs525.labs.skeleton.observer.*;
import edu.mum.cs.cs525.labs.skeleton.strategy.CheckingInterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingInterestStrategy;

public class Application {
    public static void main(String[] args) {

        AccountLogger accountLogger = new AccountLogger();
        EmailSender emailSender = new EmailSender();
        SMSSender smsSender = new SMSSender();
        AccountEventManager accountEventManager = new AccountEventManagerImpl();
        accountEventManager.subscribe(accountLogger, AccountEventType.ALL);
        accountEventManager.subscribe(emailSender, AccountEventType.ACCOUNT_OPENED);
        accountEventManager.subscribe(smsSender, AccountEventType.ALL);

        ServiceFactory serviceFactory = new ProdServiceFactory();

        AccountService accountService = serviceFactory.getAccountService();
        accountService.setAccountEventManager(accountEventManager);

        // create 2 accounts;
        Account checkingAccount = accountService.createAccount("1263862", "Frank Brown");
        Account savingAccount = accountService.createAccount("4253892", "John Doe");

        // use account 1;
        accountService.deposit("1263862", 240);
        accountService.setInterestStrategy(new CheckingInterestStrategy());
        accountService.addInterest("1263862");
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        InterestStrategy specialCheckingInterest = new MilitaryVeteranPromotionInterestDecorator(new CheckingInterestStrategy());
        System.out.println(specialCheckingInterest.getDescription());
        accountService.setInterestStrategy(specialCheckingInterest);
        accountService.addInterest("1263862");

        // use account 2;


        accountService.deposit("4253892", 12450);
        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
        InterestStrategy superDealInterest = new LowIncomePromotionInterestDecorator(new LoyaltyPromotionInterestDecorator(new SavingInterestStrategy()));
        System.out.println(superDealInterest.getDescription());
        accountService.setInterestStrategy(superDealInterest);
        accountService.addInterest("4253892");


        // show balances
        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getEntries()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }

}

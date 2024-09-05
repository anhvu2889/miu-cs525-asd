package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.decorator.LowIncomePromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.LoyaltyPromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.decorator.MilitaryVeteranPromotionInterestDecorator;
import edu.mum.cs.cs525.labs.skeleton.observer.*;
import edu.mum.cs.cs525.labs.skeleton.strategy.CheckingInterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingInterestStrategy;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl();
		AccountEventManager accountEventManager = new AccountEventManagerImpl();

		accountService.setAccountEventManager(accountEventManager);
		AccountLogger accountLogger = new AccountLogger();
		EmailSender emailSender = new EmailSender();
		SMSSender smsSender = new SMSSender();

		accountEventManager.subscribe(accountLogger, AccountEventType.ALL);
		accountEventManager.subscribe(emailSender, AccountEventType.ACCOUNT_OPENED);
		accountEventManager.subscribe(smsSender, AccountEventType.ALL);

		// create 2 accounts;
		Account checkingAccount = accountService.createAccount("1263862", "Frank Brown");
		InterestStrategy specialCheckingInterest = new MilitaryVeteranPromotionInterestDecorator(new CheckingInterestStrategy());
		checkingAccount.setInterestStrategy(specialCheckingInterest);
		System.out.println(specialCheckingInterest.getDescription());
		System.out.println();

		InterestStrategy superDealInterest = new LowIncomePromotionInterestDecorator(new LoyaltyPromotionInterestDecorator(new SavingInterestStrategy()));
		System.out.println(superDealInterest.getDescription());
		System.out.println();
		Account savingAccount = accountService.createAccount("4253892", "John Doe");
		savingAccount.setInterestStrategy(superDealInterest);

		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");


		//Add interest to all account
		accountService.addInterest();


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

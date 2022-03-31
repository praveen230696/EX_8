package org.kiot.bank;

import org.kiot.bankaccount.BankAccount;

public interface IBankServiceProvider {
	
	BankAccount checkAccount(String accountNo);
	double getBalance( BankAccount account);
	boolean depositMoney(BankAccount account, double amount);
	boolean withdrawMoney(BankAccount account, double amount);
	boolean transferMoney(BankAccount fromAccount, BankAccount toAccount, 
			double amount);
}

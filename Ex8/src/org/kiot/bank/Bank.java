package org.kiot.bank;

import java.util.Arrays;
import java.util.Scanner;

import org.kiot.bankaccount.BankAccount;

public class Bank {
	private BankAccount[] bankAccountArray;
	Scanner scanner = new Scanner(System.in);
	BankAccount bankAccount =new BankAccount();
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(BankAccount[] bankAccount) {
		super();
		this.bankAccountArray = bankAccount;
	}

	public BankAccount[] getAccount() {
		return bankAccountArray;
	}
	
	public void setBankAccount(BankAccount[] bankAccount) {
		this.bankAccountArray = bankAccount;
	}
	
	@Override
	public String toString() {
		return "Bank [bankAccount=" + Arrays.toString(bankAccountArray) 
					+ ", scanner=" + scanner + ", bankAccount2="
					+ bankAccount + "]";
	}
		
	public BankAccount checkAccount(String accountNo) {
		for ( int i = 0 ; i < bankAccountArray.length; i++) {
			if (bankAccountArray[i].getAccountNo().equals(accountNo)) {
					//System.out.println("hi");
					return bankAccount;
			}
		}    
	    return null;
		
	}
	
	public double getBalance( BankAccount account) {
		System.out.println("Enter account no to check balance:");
		String accountNo = scanner.next();
		for ( int i = 0 ; i < bankAccountArray.length; i++) {
			if(bankAccountArray[i].getAccountNo().equals(accountNo)) {
			//System.out.println("hi" + i);
			return bankAccountArray[i].getminimumBalance();
			} else {
				System.out.println("Account not found");
			}
		}
		return 0.0;
	}
	
	public boolean depositMoney(BankAccount account, double amount) {
		System.out.println("Enter account no to deposit amount:");
		String accountNo = scanner.next();
		for ( int i = 0 ; i < bankAccountArray.length; i++) {			
			if(bankAccountArray[i].getAccountNo().equals(accountNo)) {
				bankAccountArray[i].setminimumBalance
						(bankAccountArray[i].getminimumBalance() + amount);
				return true;
			}
		}	
		return false;
	}
	
	public boolean withdrawMoney(BankAccount account, double amount) {
		System.out.println("Enter account no to withdraw amount:");
		String accountNo = scanner.next();
		for ( int i = 0 ; i < bankAccountArray.length; i++) {			
			if(bankAccountArray[i].getAccountNo().equals(accountNo)) {
				bankAccountArray[i].setminimumBalance
						(bankAccountArray[i].getminimumBalance() - amount);
				return true;
			}
		}
		return false;
	}
	
	public boolean transferMoney(BankAccount fromAccount, 
				BankAccount toAccount, double amount) {
		System.out.println("Enter account no from amount:");
		String fromaccountNo = scanner.next();
		System.out.println("Enter account no to amount:");
		String toaccountNo = scanner.next();
		int fromAccountNoFound = 0, toAccountNoFound = 0;
		//System.out.println("Enter account to deposit amount:");
		//double deposit = scanner.nextDouble();
		for ( int i = 0 ; i < bankAccountArray.length; i++) {			
			if (bankAccountArray[i].getAccountNo().equals(fromaccountNo)) {
				System.out.println(i);
				fromAccountNoFound = (bankAccountArray[i].getminimumBalance()
							>= amount) ? 1 : 0;
				if(1 != fromAccountNoFound) {
					System.out.println("From account balance is Insufficient");
				}
			}
			if (bankAccountArray[i].getAccountNo().equals(toaccountNo)) {
				System.out.println(i);
				toAccountNoFound = 1;
			}
		}
		if(fromAccountNoFound == 1 && toAccountNoFound == 1) {
			for ( int i = 0 ; i < bankAccountArray.length; i++) {			
				
				if (bankAccountArray[i].getAccountNo().equals(fromaccountNo)) {
					bankAccountArray[i].setminimumBalance
							(bankAccountArray[i].getminimumBalance() - amount);
				}
				if (bankAccountArray[i].getAccountNo().equals(toaccountNo)) {
					bankAccountArray[i].setminimumBalance
							(bankAccountArray[i].getminimumBalance() + amount);
				}				
			}
			return true;
		}
		return false;
	}
}

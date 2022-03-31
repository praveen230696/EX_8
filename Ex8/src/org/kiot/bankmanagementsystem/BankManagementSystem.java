package org.kiot.bankmanagementsystem;

import java.util.Scanner;
import org.kiot.bank.Bank;
import org.kiot.bankaccount.BankAccount;

public class BankManagementSystem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int choice;
		System.out.println("How many number of customers do you want to"
				+ " input");
		int n = scanner.nextInt();
		Bank bank = new Bank();
		BankAccount bankAccount = new BankAccount();
		BankAccount[] bankAccountArray = new BankAccount[n];
		for (int i = 0; i < bankAccountArray.length; i++) {
			bankAccountArray[i] = new BankAccount();
			System.out.println("Type Customer " + (i+1) + " details");
			bankAccountArray[i].createBankAccount();
			/*if(null != bankAccount[i]) {
				System.out.println("Bank account creted successfully");
			} else {
				System.out.println("Bank account creation failed");
			}*/
		} 
		bank.setBankAccount(bankAccountArray);
		do {
			System.out.println("1--> Check account exist or not\n"
					+ "2-->Check Balance\n3-->Deposit Amount"
					+ "\n4-->Withdraw Amount"
					+ "\n5-->Money transfer\n6-->Exit\n");
			System.out.println("Enter your choice:");
			choice = scanner.nextInt();
			switch(choice) {
				case 1: {
					System.out.println("Type accountNo to check");
					if(null != bank.checkAccount(scanner.next())) {
						System.out.println("exists");
					} else {
						System.out.println("not exits");
					}
					break;
				}
				
				case 2: {
					double balance = bank.getBalance(bankAccount);
					if (0.0 != balance) {
						System.out.println("Current Balance is: " + balance);
					} else {
						System.out.println("Please check your account no:");
					}
					break;
				}
		//bankAccount2 = bankAccount
				
				case 3: {
					System.out.println("Enter amount to deposit:");
					double amount = scanner.nextDouble();
					if(bank.depositMoney(bankAccount, amount)) {
						System.out.println("amount deposited successfully");
						System.out.println("Current Balance is " 
								+ bank.getBalance(bankAccount));
					} else {
						System.out.println("Account not found");
					}
					break;
				}
					
				case 4: {
					System.out.println("Enter amount to withdraw:");
					double withdraw = scanner.nextDouble();
					if(bank.withdrawMoney(bankAccount, withdraw)) {
						System.out.println("amount withdraw successfully");
						System.out.println("Current Balance is " 
								+ bank.getBalance(bankAccount));
					} else {
						System.out.println("Account not found");
					}
					break;
				}
		
				case 5: {
					System.out.println("Enter amount to transfer:");
					double transfer = scanner.nextDouble();
					if(bank.transferMoney( bankAccount,  bankAccount, 
							transfer)) {
						System.out.println("transferred successfully");
						System.out.println(bank.getBalance(bankAccount));
					} else {
						System.out.println("Money Transfer failed");
					}
					break;
				}
				
				case 6: {
					System.out.print("Thanks for using our service!");
					break;
				}		
			}
		} while (6 != choice);
	}
}

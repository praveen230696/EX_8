package org.kiot.bankaccount;

import java.util.Scanner;

public class BankAccount {
	private String accountNo;
	//private int lastAssignedNo;
	private int aadhaarNo;
	private String accountHolderName;
	private double minimumBalance;
	private String accountType;
	public static int lastAssigned = 0;
	Scanner scanner = new Scanner(System.in);
	//private BankAccount[] = new BankAccount[];
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAccount(String accountNo, int aadhaarNo, 
				String accountHolderName, double minimumBalance,
				String accountType) {
		super();
		this.accountNo = accountNo;
		this.aadhaarNo = aadhaarNo;
		this.accountHolderName = accountHolderName;
		this.minimumBalance = minimumBalance;
		this.accountType = accountType;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(int aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getminimumBalance() {
		return minimumBalance;
	}
	public void setminimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aadhaarNo;
		result = prime * result + ((accountNo == null) 
				? 0 : accountNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (aadhaarNo != other.aadhaarNo)
			return false;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", aadhaarNo=" +
				aadhaarNo + ", accountHolderName="
				+ accountHolderName + ", minimumBalance=" + minimumBalance
				+ ", accountType=" + accountType
				+ ", scanner=" + scanner + "]";
	}
	
	public void createBankAccount() {
		lastAssigned++;
		accountNo = accountNo.valueOf(lastAssigned);
		System.out.println("Type aadhaarNo:");
		aadhaarNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Type customer name:");
		accountHolderName = scanner.nextLine();
		System.out.println("Type Minimum minimumBalance:");
		minimumBalance = scanner.nextDouble();
		scanner.nextLine();
		System.out.println("Type customer account Type:");
		accountType = scanner.nextLine();
		System.out.println("Customer account no is " + lastAssigned);
		//BankAccount bankAccount = new BankAccount(accountNo, aadhaarNo, 
		//accountHolderName, minimumBalance, accountType);
		// TODO Auto-generated method stub
	}
}

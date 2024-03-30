package com;

public class Account {
	int accNo;
	int pin;
	int balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accNo, int pin, int balance) {
		super();
		this.accNo = accNo;
		this.pin = pin;
		this.balance = balance;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void withdraw(int amount) {
		if(amount > 0 && balance >= amount) {
			balance -=amount;

		} else {
			System.out.println("Insufficient balance");
		}
	}
	
	public void deposite(int amount) {
		if(amount > 0 ) {
			balance += amount;
			
		} else {
			System.out.println("Invalid amount");
		}
	}
	
	public void fundTransfer(Account account,int amount,int balance) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Money sent successfully!!!");

		}
		else {
			System.out.println("Invalid amount");
		}
	}
	
	
	
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", pin=" + pin + ", balance=" + balance + "]";
	}
	
	

}

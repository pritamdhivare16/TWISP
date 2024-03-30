package com;

public class ATM {
	private Account[] accounts;
	
	public ATM(Account[] accounts) {
		this.accounts=accounts;
	}
	
	public Account validateUser(int accno,int pin) {
		for(Account account : accounts) {
			if(account.getAccNo()== accno && account.getPin()== pin) {
				return account;
			}
		}
		return null;
		
	}
	
	public void withdrawAmt(Account account, int amount) {
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
        
    }
	
	public void depositeAmt(Account account, int amount) {
        if (account != null) {
            account.deposite(amount);
        } else {
            System.out.println("Authentication failed. Please try again.");
        }
	}
	
	public void viewBalance(Account account) {
        if(account != null) {
        	account.getBalance();
        	System.out.println("Current balance: "+account.getBalance());
        }else {
            System.out.println("Authentication failed. Please try again.");
        }
	}
	
	public void moneyTransfer(Account account, int amount,int balance) {
		if(account != null) {
			account.fundTransfer(account, amount,balance);
		}else {
			System.out.println("Authentication failed. Please try again.");
		}
	}
}

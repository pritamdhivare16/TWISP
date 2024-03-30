package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ATMMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Only 2 accounts are stored into the array for prototype.
		//More accounts could be added as per need
		Account[] accounts = {
				new Account(1111,1234,10000),
				new Account(2222,5678,20400)
		};
		ATM atm = new ATM(accounts);
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do {
		System.out.println("ATM Machine");
		System.out.println("Choose 1 for Withdraw");
		System.out.println("Choose 2 for Deposit");
		System.out.println("Choose 3 for Check Balance");
		System.out.println("Choose 4 for Money Transfer");
		System.out.println("Choose 5 for Exit");
		
		choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("Enter AC No: ");
				int accNo = sc.nextInt();
				System.out.println("Enter Pin: ");
				int pin = sc.nextInt();
				Account ac1 = atm.validateUser(accNo, pin);
				
				if(ac1 != null) {
					System.out.println("Authentication Successful");
					System.out.println("Enter amount to withdraw: ");
					int amt =sc.nextInt();
					atm.withdrawAmt(ac1, amt);
					System.out.println("Collect your cash!!!");
					System.out.println("Remaining Balance: "+ac1.balance);
					System.out.println(" ");
				} else {
					System.out.println("Incorrect Account No or Pin");
					System.out.println(" ");
				}
				break;
			
			case 2:
				System.out.println("Enter AC No: ");
				accNo = sc.nextInt();
				System.out.println("Enter Pin: ");
				pin = sc.nextInt();
				Account ac2 = atm.validateUser(accNo, pin);
				
				if(ac2 != null) {
					System.out.println("Authentication Successful");
					System.out.println("Enter amount to deposite: ");
					int amt =sc.nextInt();
					atm.depositeAmt(ac2, amt);
					System.out.println("Deposited");
					System.out.println("New Balance: "+ac2.balance);
					System.out.println(" ");
				}else {
					System.out.println("Incorrect Account No or Pin");
					System.out.println(" ");
				}
				break;
			
			case 3:
				System.out.println("Enter AC No: ");
				accNo = sc.nextInt();
				System.out.println("Enter Pin: ");
				pin = sc.nextInt();
				Account ac3 = atm.validateUser(accNo, pin);
				
				if(ac3 != null) {
					System.out.println("Authentication Successful");
				
					atm.viewBalance(ac3);
					System.out.println(" ");
				}else {
					System.out.println("Incorrect Account No or Pin");
					System.out.println(" ");
				}
				break;
				
			case 4:
				System.out.println("Enter Your AC No: ");
				accNo = sc.nextInt();
				System.out.println("Enter Pin: ");
				pin = sc.nextInt();
				Account ac4 = atm.validateUser(accNo, pin);
				
				if(ac4 != null) {
					System.out.println("Authentication Successful");
					System.out.println("Enter receiver's AC No: ");
					int accNo2 = sc.nextInt();
					System.out.println("Enter amount to transfer: ");
					int amt = sc.nextInt();
					if(amt > 0 && amt < ac4.balance) {
					atm.withdrawAmt(ac4,amt );
					atm.depositeAmt(ac4, amt);
					System.out.println("Amount deposited successfully!!!");
					System.out.println(" ");
					}else {
						System.out.println("Insufficient Balance");
						System.out.println(" ");
					}
				}else {
					System.out.println("Incorrect Account No or Pin");
					System.out.println(" ");
				}
				break;
				
			
				
			default:
				System.out.println("Thanks for visiting!!!");
		
		}//switch case end
		}while(choice != 5);
		sc.close();
	}
			
}

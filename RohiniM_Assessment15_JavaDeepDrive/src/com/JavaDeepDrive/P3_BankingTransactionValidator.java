/*
 * P3_BankingTransactionValidator class implements the java program to illustrate
 * the banking application must validate the fund transfer before processing it and 
 * handle the exception for Invalid account id, insufficient fund, Transaction limit.
 */

package com.JavaDeepDrive;

import java.util.Scanner;

abstract class BankTransactionException extends Exception{
	int errorCode;
	public BankTransactionException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
}

class InsufficientFundsException extends BankTransactionException{
	double shortfall;

	public InsufficientFundsException(String message, int errorCode, double shortfall) {
		super(message, errorCode);
		this.shortfall = shortfall;
	}

	public double getShortfall() {
		return shortfall;
	}
	
}

class InvalidAccountException extends BankTransactionException{
	String accountId;

	public InvalidAccountException(String message, int errorCode, String accountId) {
		super(message, errorCode);
		this.accountId = accountId;
	}

	public String getAccountId() {
		return accountId;
	}
	
}

class TransactionLimitException extends BankTransactionException{
	double limit;

	public TransactionLimitException(String message, int errorCode, double limit) {
		super(message, errorCode);
		this.limit = limit;
	}

	public double getLimit() {
		return limit;
	}
	
}

class TransactionValidator{
	public static void validateTransaction(String accountId, double balance, double amount, double dailyLimit) throws BankTransactionException{
		if(amount>balance) {
			throw new InsufficientFundsException("Shortfall: "+(amount-balance), 1002, amount-balance);
		}
		if(accountId == null )  {
			throw new InvalidAccountException("Account ID cannot empty", 1001, accountId);
		}
		if(amount>dailyLimit) {
			throw new TransactionLimitException("Limit: "+dailyLimit, 1003, dailyLimit);
		}
		System.out.println("Transaction is valid");
	}
}

public class P3_BankingTransactionValidator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Enter the Account Id: ");
			String accountId = sc.nextLine();
			System.out.print("Enter the balance: ");
			double balance = sc.nextDouble();
			System.out.print("Enter the amount: ");
			double amount = sc.nextDouble();
			System.out.print("Enter the limit: ");
			double limit = sc.nextDouble();
			TransactionValidator.validateTransaction(accountId, balance, amount, limit);
		}
		catch(BankTransactionException e) {
			System.out.println(e.getClass().getSimpleName()+" : "+e.getMessage()+" [Code: "+e.getErrorCode()+"]");
		}
		finally {
			System.out.println("Validation complete");
		}
	}

}

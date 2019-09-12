package atm;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	
	Scanner input = new Scanner(System.in);
	
	DecimalFormat moneyFormat = 
			new DecimalFormat("'$'###,##0.00");

	
	//Member declarations and initializations
		private int AcctNumber;
		private int PIN;
		private double checkingBalance = 0;
		private double savingBalance = 0;
		
		
	
	/* Getters and setters */
	public int getAcctNumber() {
		return AcctNumber;
	}
	public void setAcctNumber(int acctNumber) {
		AcctNumber = acctNumber;
	}
	public int getPIN() {
		return PIN;
	}
	public void setPIN(int pIN) {
		PIN = pIN;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}
	
	/*Class functions */
	
	//Withdraw functions
	public double calcCheckingWithdraw(double amount)
	{
		checkingBalance = checkingBalance - amount;
		return checkingBalance;
	}
	
	public double calcSavingWithdraw(double amount)
	{
		savingBalance = savingBalance - amount;
		return savingBalance;
	}
	
	//Deposit functions
	
	public double calcCheckingDeposit(double amount)
	{
		checkingBalance = checkingBalance + amount;
		return checkingBalance;
	}
	
	public double calcSavingDeposit(double amount)
	{
		savingBalance = savingBalance + amount;
		return savingBalance;
	}
	
	/*
	 * Input functions 
	 * */
	
	public void getCheckingWithdrawInput()
	{
		System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
		System.out.println("Enter the amount you "
				+ "want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		//check input
		if((checkingBalance - amount) >= 0) 
		{
			calcCheckingWithdraw(amount);
			System.out.println("New Checking " + "Account balance: " 
			+ moneyFormat.format(checkingBalance));
		}
		else {
			System.out.println("Balance cannot be negative");
		}
		
		
	}
	
	
	public void getSavingWithdrawInput()
	{
		System.out.println("Current Saving Account Balance: " + moneyFormat.format(savingBalance));
		System.out.println("Enter the amount you "
				+ "want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		//check input
		if((savingBalance - amount) >= 0) 
		{
			calcCheckingWithdraw(amount);
			System.out.println("New Saving " + "Account balance: " 
			+ moneyFormat.format(savingBalance));
		}
		
		else {
			System.out.println("Balance cannot be negative");
		}
		
	}
	
	
	
	public void getCheckingDepositInput()
	{
		System.out.println("Current Checking Account Balance: "+ moneyFormat.format(checkingBalance));
		System.out.println("Enter the amount you "
				+ "want to withdraw from Checking Account: ");
		double amount = input.nextDouble();
		
		//check input
		if((checkingBalance + amount) >= 0) 
		{
			calcCheckingWithdraw(amount);
			System.out.println("New Checking " + "Account balance: " 
			+ moneyFormat.format(checkingBalance));
		}
		else {
			System.out.println("Balance cannot be negative");
		}
	}
	
	
	public void getSavingDepositInput()
	 {
		
			System.out.println("Total Checking Account Balance: " + moneyFormat.format(checkingBalance));
			System.out.println("Enter the amount you "
					+ "want to withdraw from Checking Account: ");
			double amount = input.nextDouble();
			
			//check input
			if((checkingBalance + amount) >= 0) 
			{
				calcCheckingWithdraw(amount);
				System.out.println("New Checking " + "Account balance: " 
				+ moneyFormat.format(checkingBalance));
			}
			
			else {
				System.out.println("Balance cannot be negative");
			}	
	}
}

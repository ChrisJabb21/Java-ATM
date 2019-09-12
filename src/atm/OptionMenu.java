package atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account {
	
	// make a global scanner object for menu input.
	Scanner menuInput = new Scanner(System.in);
	
	DecimalFormat moneyFormat = 
			new DecimalFormat("'$'###,##0.00");
	
	HashMap<Integer, Integer> Acctdata =
			new HashMap<Integer, Integer>();
	
	public void getLogin() throws IOException {
	
		int x = 1; 
		
		//valid input
		do {
			try {
				Acctdata.put(7891011, 1994);
				Acctdata.put(0123456, 0222);
				
				System.out.println("Welcome to the ATM!");
				
				System.out.println("Enter "
						+ "Your Account(Card) number: ");
				setAcctNumber(menuInput.nextInt());
				
				System.out.println("Enter your PIN number: ");
				setPIN(menuInput.nextInt());
			} 
			
			catch (Exception e)
			{
				System.out.println("\n " + " Invalid character(s). Enter numbers only. " + "\n");
				x = 2;
				getLogin();
			}
			
			for(Entry<Integer, Integer> entry : Acctdata.entrySet()) 
			{
				if(entry.getKey() == getAcctNumber() && entry.getValue() == getPIN()) 
				{
					getAcctType();
				}
			}
			System.out.println("\n" + "Wrong Customer Number or PIN Number." + "\n");
	}  while (x == 1);

}
	
	public void getAcctType() 
	{
		System.out.println( "\n" + "Login successful!" + "\n");
		
		System.out.println("Select Account type (enter choice number): ");
		System.out.println("1) - Checking Account. ");
		System.out.println("2) - Saving Account. ");
		System.out.println("3) - Exit ");
		System.out.print( "Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection) {
		case 1:
			getChecking();
			break;
			
		case 2: 
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank you for using this ATM, goodbye!");
			break;
		
		default:
			System.out.println( "\n" + "Invalid choice."+ "\n");
			getAcctType();
		}		
	}
	
	public void getChecking()
	{
		System.out.println("Checking Account: ");
		System.out.println("Type a number to select a choice.");
		System.out.println("1) - View Balance");
		System.out.println("2) - Withdraw funds");
		System.out.println("3) - Deposit funds");
		System.out.println("4) - Exit ");
		System.out.print("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			//view CA balance
				//Call acct_menu prompt
			System.out.println("Current CA Balance: " + moneyFormat.format(getCheckingBalance()));
			getAcctType();
			break;
		case 2: 
			getCheckingWithdrawInput();
			getAcctType();
			break;
		case 3: 
			getCheckingDepositInput();
			getAcctType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye.");
			
		default:
			System.out.println("\n" + "Invalid choice." +"\n");
			getChecking();
		}
		
	}
	
	public void getSaving()
	{
		

		System.out.println("Saving Account: ");
		System.out.println("Type a number to select a choice.");
		System.out.println("1) - View Balance");
		System.out.println("2) - Withdraw funds");
		System.out.println("3) - Deposit funds");
		System.out.println("4) - Exit ");
		System.out.println("Choice: ");
		
		int selection = menuInput.nextInt();
		
		switch(selection)
		{
		case 1:
			//view CA balance
				//Call acct_menu prompt
			System.out.println("Current CA Balance: " + moneyFormat.format(getSavingBalance()));
			getAcctType();
			break;
		case 2: 
			getSavingWithdrawInput();
			getAcctType();
			break;
		case 3: 
			getSavingDepositInput();
			getAcctType();
			break;
		case 4:
			System.out.println("Thank you for using this ATM, bye.");
			
		default:
			System.out.println("\n" + "Invalid choice." +"\n");
			getSaving();
		}	
	}

	
	
}
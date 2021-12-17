import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Program Name: J_G_LotteryPrizes.java
 * Purpose: Lottery Prize Project: To create a lottery prize analyzer to analyze a .csv file for winning prizes.
 * Coder: Jarrod Grineau for Section 02
 * Date: Dec 1, 2021
 * 
 * 
 * 		*Step 1: Create a description or name for the lottery (to be included in the program’s output or report)
			*Step 2: Program needs to set-up a Scanner object for reading data from the file. 
			*				 This should include suitable exception handling code
			*Step 3 -5: Write methods to make code shorter and easier to read
			*Step 6-7: Set-up data structures to make a while loop in the main method to be able to output
			*Step8: Generate the report showing the results of the analysis in a nice looking format.
 * 
 */

public class J_G_LotteryPrizes
{

	public static void main(String[] args) throws FileNotFoundException
	{
			//create Scanner
			Scanner input = new Scanner(System.in);
			
			//Step 1:
			// A description or name for the lottery (to be included in the program’s output or report)
			System.out.println("Lottery Prizes Analyzer\n");
			System.out.print("Enter the name of the lottery: ");
			String lotteryName = input.nextLine();
			
			// The total amount of money in the prize pool. No decimal places are required, we want dollars only and no cents. It should be validated to ensure it’s at least $1,000.
			System.out.print("Enter the amount of money in the prize pool: $");
			float prizeMoney = input.nextFloat();
			//data validation to make sure prize money is over $1000
			while (prizeMoney < 1000)
			{
				System.out.println("Invalid input try again");
				System.out.print("Enter the amount of money in the prize pool: $");
				prizeMoney = input.nextFloat();
			}//end while
			
			
			// The path and name for the input file (e.g. “lottery.csv”)
			// The user inputs the name of the file
			System.out.print("Enter the path for the data file: ");
			String file = input.next();
			File myFile = new File(file);
			
			
			
			//set up a scanner object for reading data from the file and validate with a clean exit and if file is not found program a display error
			Scanner fileReader = null;
			try
			{
				fileReader = new Scanner(myFile);
			}//end try
			catch (FileNotFoundException e)
			{
				System.out.println("Provided file name not found. Please try again.");
				System.exit(1);
			}//end catch
			
			//buffer flush
			input.nextLine();
			
			
			//Step 6 setup two data structures to store the numbers for tickets that have won a prize
			int[] winningNumbers = J_G_ProjectMethods.getNextSeries(fileReader);
			int ticketLength = winningNumbers.length;
			//data structure arrays
			ArrayList<int[]>thirdPrizeTickets = new ArrayList<int[]>();
			ArrayList<int[]>secondPrizeTickets = new ArrayList<int[]>();
			int grandPrizeCount = 0;
			while(fileReader.hasNextLine())
			{
				 int[] ticketNumbers = J_G_ProjectMethods.getNextSeries(fileReader);
				 
				 
				 int matches = 0;
				 for (int i = 0; i < ticketLength; i++)
				 {
					 
					 for (int j= 0; j < ticketLength; j++ )
					 {
						 if(winningNumbers[i] == ticketNumbers[j])
						 {
							 matches++;
							 
						 }//end if
					 }//end for
					 
				 }//end for
				 
				 
				 if (matches == ticketLength - 2)
				 {
					 thirdPrizeTickets.add(ticketNumbers);
					  
				 }//end if
				 else if (matches == ticketLength - 1)
				 {
					 secondPrizeTickets.add(ticketNumbers);
				 }//end else if
				 else if (matches == ticketLength)
				 {
					grandPrizeCount++;
				 }//end else if
				 
			}//end while
			
			//Step 8 Analyzing all ticket numbers in the file
			
			float grandPrizePool = prizeMoney * 0.85f;
			float secondPrizePool = prizeMoney * 0.07f;
			float thirdPrizePool = prizeMoney * 0.08f;
			
			
		//Lottery Prize Report first paragraph
			System.out.println("\nLottery Prizes Report");
			System.out.println("---------------------\n");
			System.out.println("Lottery Name:        " + lotteryName);
			System.out.printf("Total prize pool:    $%.2f", prizeMoney);
			System.out.println("\nNumber of Tickets:   1,000");
			System.out.println("Winning Numbers:     " + J_G_ProjectMethods.formatTicketNumbers(winningNumbers));
			
			//Grand Prize winners
			System.out.println("\nGrand prize winners (all numbers match)...");
			System.out.printf("  Number of winners: %d%n", grandPrizeCount);
			System.out.println("  % of prize pool:   85.0");
			System.out.printf("  Total prize value: $%.2f%n", grandPrizePool);
			System.out.printf("  Prize per ticket:  $%.2f%n", grandPrizePool / grandPrizeCount);
			
			//Second Prize winners
			System.out.printf("\nSecond prize winners (%d numbers match)...%n", ticketLength -1);
			System.out.printf("  Number of winners: %d%n", secondPrizeTickets.size());
			System.out.println("  % of prize pool:   7.0");
			System.out.printf("  Total prize value: $%.2f%n", secondPrizePool);
			System.out.printf("  Prize per ticket:  $%.2f%n", secondPrizePool / secondPrizeTickets.size());
			System.out.print("  Ticket Numbers: ");
			
			for (int i = 0; i < secondPrizeTickets.size(); i++)
			{
				if(i % 2 == 0)
				{
					System.out.println();
				}
				System.out.printf("                     %-22s", J_G_ProjectMethods.formatTicketNumbers(secondPrizeTickets.get(i)));
			}
			
			//line spacing
			System.out.println();
			
			//Third Place winners
			System.out.printf("\nThird prize winners (%d numbers match)...%n", ticketLength -2);
			System.out.printf("  Number of winners: %d%n", thirdPrizeTickets.size());
			System.out.println("  % of prize pool:   8.0");
			System.out.printf("  Total prize value: $%.2f%n", thirdPrizePool);
			System.out.printf("  Prize per ticket:  $%.2f%n", thirdPrizePool / thirdPrizeTickets.size());
			System.out.print("  Ticket Numbers: ");
			
			for (int i = 0; i < thirdPrizeTickets.size(); i++)
			{
				
				//System.out.printf("          %s", J_G_ProjectMethods.formatTicketNumbers(thirdPrizeTickets.get(i)));
				if(i % 2 == 0)
				{
					System.out.println();
					//System.out.println("  Ticket Numbers: ");
				}
				
				System.out.printf("                     %-22s", J_G_ProjectMethods.formatTicketNumbers(thirdPrizeTickets.get(i)));
			}
			
		//housekeeping
			input.close();
		
	}//end main
}//end class


	

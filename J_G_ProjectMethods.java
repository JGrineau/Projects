/**
 * Program Name: J_G_ProjectMethods.java
 * Purpose: Project methods to help reduce code in main
 * Coder: Jarrod Grineau for Section 02
 * Date: Dec 1, 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class J_G_ProjectMethods
{

	/**
	 * Method Name: getNextSeries()
	 * Purpose: a public class method that will accept the initialized Scanner object that's associated with the file 
	 * 					and return an array of integers which is the series of numbers contained in the next line
	 * Accepts: an array of type int.
	 * Returns: an int that is the sum of all the values in the array NOTE: this first time this method is called it will return the winning numbers.
	 * 					Each time after that it will return the numbers from another customer's ticket.
	 * Date: Wed Dec 1, 2021
	 * Coder: JP
	 * @throws FileNotFoundException 
	 */
	public static int[] getNextSeries(Scanner fileReader) 
	{
		
		String numLine = fileReader.nextLine();
		String[] token = numLine.split(",");
		
		int[] nums = new int [token.length];
		for(int i = 0; i < token.length; i++)
		{
			
			nums[i] = Integer.parseInt(token[i]);
		}//end for
		return nums;
	}//end method
	
	/**
	 * Method Name: countMatchingNumbers()
	 * Purpose: a public class method which accepts two integer arrays as arguments 
	 * 					The first will contain the numbers for one ticket and the second will contain the winning numbers
	 * Accepts: an array of type int.
	 * Returns: number of matches of type int
	 * Date: Thur Dec 1, 2021
	 * Coder: JP
	 * @throws FileNotFoundException 
	 */
	public static int countMatchingNumbers(int[] ticketNumbers, int[] winningNumbers) 
	{
		
			 
			 int matches = 0;
			 
		
			for (int i = 0; i < winningNumbers.length; i++)
			 {
				 
				 
				for (int j= 0; j < ticketNumbers.length; j++ )
				 {
					 if(winningNumbers[i] == ticketNumbers[j])
					 {
						 matches++;
						 
					 }//end if
				 }//end for
				 
			 }//end for
			 return matches;
	}//end method
	
	/**
	 * Method Name: formatTicketNumbers()
	 * Purpose: a public class method will accept an integer array containing one set of ticket numbers and return a formatted string 
	 * Accepts: a string array to be formatted 
	 * Returns: formatted string
	 * Date: Thur Dec 1, 2021
	 * Coder: JP
	 * @throws FileNotFoundException 
	 */
	public static String formatTicketNumbers(int[] ticketNumbers)
	{
		String formattedString = "";
		for(int i = 0; i < ticketNumbers.length; i++)
		{
				formattedString = formattedString.concat(Integer.toString(ticketNumbers[i]));
			
			if (!(i + 1 == ticketNumbers.length)) 
			{
				formattedString = formattedString.concat(", ");
			}//end if
		}//end for
		return formattedString;
		
	}//end method
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		int prizeMoney = input.nextInt();
		
		// The path and name for the input file (e.g. “lottery.csv”)
		// Create the path
		File myFile = new File("lottacash.csv");
		System.out.print("Enter the path for the data file: " + myFile);
		//Scanner fileReader = new Scanner(myFile);
		

	}//end main 1
	
		//Step 3: create method called getNextSeries().
		public void getNextSeries(String[] args) throws FileNotFoundException
		{
			File myFile = new File("lottacash.csv");
			Scanner fileReader = new Scanner(myFile);
			
			// Split-up tokens contained in the line based on where the comma delimiters are.
			fileReader.useDelimiter(",");
			
			// Create useful Variables 
			int runningTotal = 0;
			int validScores = 0;
			int notValidScores = 0;
			//final int LOWEST_SCORE = 0;
			//final int HIGHEST_SCORE = 10;
			int tokenCount = 0;
			String[] textArray = null;
			
			String token;
			while(fileReader.hasNextInt() )
			{
				tokenCount++;
				token = fileReader.nextLine();
				textArray[tokenCount] = token;
				tokenCount++;
				System.out.println("Wining numbers: " + token);
			}//end while
			
		}//end main 2
			
}//end class
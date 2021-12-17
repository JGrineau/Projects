/**
 * Program Name: JG_RoadTrip.java
 * Purpose: Final exam Assignment. To create a Road Trip Time Estimator
 * Coder: Jarrod Grineau for Section 02
 * Date: Dec. 13, 2021
 * 
 * Pseudocode:
 * Step 1: Display a title and explanation (see the sample output provided)
 * Step 2: Ask the user to enter the number of legs that there are in the trip and store this to a variable.
 * Step 3: Create and define three arrays as follows:
 * 																										distancesArray	- double
 * 																										speedsArray			- int 
 * 																										timesArray			- double
 * Step 4: Create a loop that will iterate through all the legs of the trip and then prompt the user to enter distance and speed using the array in step 3
 * Step 5: Create a loop that will iterate through all the legs (again) to report distance and the speed of the legs
 * Step 6: Call the class method getArrayTotal() to get the total distance and total speed for each leg (Summarizing the distance and speed)
 * Step 7: Report the total trip distance and the total time by calling the formatTime() method to properly format hours and minutes
 */

import java.util.Scanner;


public class JG_RoadTrip
{

	public static void main(String[] args)
	{
		// Create a Scanner object
    Scanner input = new Scanner(System.in);
    
    // Step 1: Display a title and explanation of the program created
    System.out.println("Road Trip Time Estimator");
    System.out.println("\nThis program will estimate the time required to complete a road trip.");
    
    //Step 2: Prompt user for # of LEGS
    System.out.print("\nEnter the number of 'legs' for your road trip: ");
    int legs = input.nextInt();
    
    //Step 3: create and define the three arrays listed in pseudocode.
    double[] distancesArray = new double[legs];
    int[] speedsArray = new int[legs];
    double[] timesArray = new double[legs];
    
    //Step 4: create a loop that will iterate through all the legs of the trip prompted by the user in step 2
    for (int i = 0; i < legs; i++) 
    { 
            //Prompt user for DISTANCE
            System.out.print("\nEnter the distance in km for leg " + (i+1) + ": ");
            distancesArray[i] = input.nextDouble();
            
            //Prompt user for SPEED
            System.out.print("Enter the speed limit in km/h for leg " + (i+1) + ": ");
            speedsArray[i] = input.nextInt();
            
            //calculate times array distance/speed
            timesArray[i] = distancesArray[i]/speedsArray[i];         
    }//end for
    
    //Line Spacing for formatting the output
    System.out.println();
    
    //Step 5: create a loop that will iterate through all the legs of the trip for distance speed of each leg
    for (int i = 0; i < legs; i++) 
    {
    					System.out.println("Leg " + (i+1) + ": " + distancesArray[i] +" km at " + speedsArray[i] + " km/h will take " + formatTime(timesArray[i]) + ".");
    }//end for
    
    //Step 6: Call the class method getArrayTotal() to get the total distance and total speed for each leg (Summarizing the distance and speed)
    double totalDistance  = getArrayTotal(distancesArray);
    double totalTime = getArrayTotal(timesArray);
    
    //Step 7: Report the total trip distance and the total time by calling the formatTime() method to properly format hours and minutes
    System.out.println("\nThe entire journey of " + totalDistance + " km will take " + formatTime(totalTime) + ".");
    
    //Housekeeping 
    input.close();
    
}//end main


	/**
	 * Method Name: formatTime()
	 * Purpose: To format the time for each leg in hours and minutes
	 * Accepts: Accepts the raw time in hours
	 * Returns: Returns a String that is formatted for hours and minutes into a double
	 * Date: Dec 13, 2021
	 * Coder: Jarrod Grineau
	 */
		public static String formatTime(double hours) 
		{
			String time = null;
			//variables to store hour and minute
			int hour; 
			int minute;
    
			//Hours type cast to keep hour a integer
			hour = (int)hours;
    
			//get minute by type casting with calculation
			minute = (int)((double)(hours - hour)*60);
    
			//String to put hour and minutes together
			time = hour + " hours and " + minute + " minutes";
    
    
			return time;   //returning the formated time 
    
		}//end method



		/**
		 * Method Name: getArrayTotal()
		 * Purpose: To add all the numbers in the array and gather the total so it can be displayed for the trip
		 * Accepts: Type double (distanceArray, timesArray)
		 * Returns: Type double (Total arrays added together)
		 * Date: Dec 13, 2021
		 * Coder: Jarrod Grineau
		 */
		public static double getArrayTotal(double[] totalArray) 
		{
			//create double variable for total amount of array
			double total = 0;
    
			//create a loop array to total up the totalArray()
			for (int i = 0; i < totalArray.length; i++) 
			{
            	total += totalArray[i];
			}//end for loop
    
    
			return total;  //returning the total of the array
    
		}//end method

		
}//end class
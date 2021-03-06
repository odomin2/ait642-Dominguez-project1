/**
 * 
 */
package national.fire.danger.rating.indexes;

import java.util.Scanner;

/**
 * @author Obed Dominguez 
 * @version 1.1 (Initial code for project one) 
 * @since 2016-02-23 (This package was first added) 
 */
public class Ntl_Fire_Dng_R_Idx {

	/**
	 * Main method for re-engineer the Fortran77 code.		(1)
	 * <p>
	 * Re-engineer of Fortran77 code for national			(2)
	 * fire danger rating indexes.  
	 * <>p>
	 * @param args Beginning the main code. 				(3)
	 * @return 
	 */
	public static void main(String[] args) {
		// Beginning of the main code
		
		askforInput("snow");
		
		int storedValue = storeInput();
		
		int result = Calculate(storedValue);
		

	}//End of main method 
	
	/**
	 * Method for asking user input. 						(1)
	 * <p>
	 * This method will ask the user to enter
	 * an amount for the conditions the program 
	 * is testing.  This conditions are DRY, WET,
	 * ISNOW, PRECIP, WIND, BUO, IHERB, DF, FFM,
	 * ADFM, GRASS, TIMBER, and FLOAD. 
	 * <p>
	 * @param name This parameter accepts string input. 	(3)
	 * @return User input of the amount for the asked condition. 
	 */
	//This method will be reused to ask different conditions
	public static void askforInput(String name){ 
		  System.out.println("Enter the " + name + " amount");
		     		   
	}//End of user input method
	
	/**
	 * This method will store an input from the user.		(1)
	 * <p>
	 * The method will be reused to store the user's		(2)
	 * input.  
	 * <p>
	 * @return	This returns the user's input. 				(3) 
	 */
	public static int storeInput(){
		Scanner scan = new Scanner(System.in);
		int user_input_number = scan.nextInt();
		
		System.out.println("The entered value was " + user_input_number);
		
		return user_input_number;
				
	}//End of storeInput method 
	
	/**
	 * Calculation method 														(1)
	 * <p>
	 * The method will perform a if statement 									(2)
	 * to calculate the user's input.  It will then
	 * set the user input into a negative, zero, or 
	 * positive value.  
	 * <p>
	 * @param storedValue integer gets calculated and set to something. 	(3)
	 * @return 		A negative, zero, or positive value 
	 */
	public static int Calculate(int storedValue){
	 
			if (storedValue <= -1 ){
		    	storedValue = -1;
		    	System.out.println("The user's input is set to negative " + storedValue);
			 }
			  else if (storedValue == 0){
				  storedValue = 0;
				  System.out.println("The user's input is set to zero " + storedValue);
				}
			  else {
				  storedValue = 1; 
				  System.out.println("The user's input is set to positive " + storedValue);
			  }
			return (storedValue);
		    
		}//end of Calculate method.  

}

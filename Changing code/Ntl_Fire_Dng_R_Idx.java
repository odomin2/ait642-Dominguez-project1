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
		
		Scanner scan = new Scanner(System.in);
		int user_input_number = scan.nextInt();

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
	
	public static void askforInput(String name){ 
		  System.out.println("Enter the " + name + " amount");
		    		   
	}

}

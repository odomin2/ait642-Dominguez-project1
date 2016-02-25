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
		
		askforInput("snow");//asks for amount from the user. 
		
		int storedValue = storeInput(); //Stores the value entered by the user. 
		
		double result = Calculate(storedValue); //Calculates the stored Value entered by user.  
		
		double whereToGo = lineDecision(result);//makes decision line of code to execute.  
		

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
	 * @param storedValue integer gets calculated and set to something. 		(3)
	 * @return 		A negative, zero, or positive value 
	 */
	public static double Calculate(double storedValue){
	 
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
	
	/**
	 * Method deciding what line to go to.							(1)
	 * <p>
	 * This method makes the decision what							(2)
	 * code should be executed next. This is
	 * where the code goes to either line 
	 * one or line five of the Fortran77 code 
	 * <p>
	 * @param result takes a value that accepts decimal points. 	(3)
	 * @return The line that is executed.  
	 */
	public static double lineDecision(double result){
		//Line one of Fortran77
		if (result >= 1 ){
			System.out.println("There is snow on the ground.  Grass and timber set to zero.  Adjusting for precipitation.");
			//int grass = 0;
			//int timber = 0;
			
			double rainResult = rainCheck (result); //checks for rain 
		
			System.out.println("The system finished checking for rain ");
			
		}
		//Fortran line 5
		else if ((result == 0) || (result == -1))
			System.out.println("There is no snow on the ground. Computing spread indexes and fire load " + result);
			//int fuelResult = fireFuel();
			return result;
	 	
	}//end of lineDecision method
	
	/**
	 * Method to check rain and calculate precipitation		(1)
	 * <p>
	 * This code gets executed if the lineDecision code 	(2)
	 * yields a positive result.  Meaning that there was
	 * snow on the ground and additional calculations need
	 * to happen.  
	 * <p>
	 * @param rainResult
	 * @return
	 */	
	public static double rainCheck(double rainResult ){
		
		askforInput("Precipitation");//is there rain?
		
		int storedValue = storeInput();
		
		double x, y, answer;
		x = storedValue;
		y = (double) .1;
		answer = x - y;
		
		System.out.println("The precip is "+ answer);
		
		double result1 = Calculate(answer);
		
		if ((result1 == -1) || (result1 == 0)){
			
			return result1;
		}
		else {
		System.out.println("Yes there is rain. Ajusting the BUO " + result1);
		
		double buoCheck = buoCalculation();
		System.out.println("The buoCalculation yield " + buoCheck);
		
		double result2 = Calculate(buoCheck);
		
		if (result2 <= -1) {
		int buo = 0; 
		System.out.println("The BUO is set to zero");
		System.out.println("The rainCheck ends and returns to other calculations.");
		}
		else if (result2 == 0 || result2 >= 1){
		System.out.println("The rainCheck ends and returns to other calculations.");
		}
		return result2;
		}
				
	}//End of precipitation check method.

	/**Method to compute BUO random number generator 	(1)
	 * <p>
	 * This is where in Fortran77 does a complicated	(2)
	 * formula. Instead the code will create a random
	 * number to replicate the result of the formula.  
	 * <p> 
	 * @return Random number 
	 */
	public static double buoCalculation(){
		double rain= (double) ((Math.random()*201)-100);
		
		return rain;
		
	}//End of BUO method

}

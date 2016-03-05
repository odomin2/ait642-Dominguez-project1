/**
 * 
 */
package national.fire.danger.rating.indexes;

import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Ntl_Fire_Dng_R_Idx.
 *
 * @author Obed Dominguez
 * @version 1.1 (Initial code for project one)
 * @since 2016-02-23 (This package was first added)
 */
public class Ntl_Fire_Dng_R_Idx extends Ntl_Fire_SuperClass implements Main {

	/** The where to go. */
	private static double whereToGo;
	
	/** The rain result. */
	private static double rainResult;
	
	/** The herb. */
	private static double herb;
	
	/** The store adjusted. */
	private static double storeAdjusted;
	
	/** The buo. */
	private static int buo;
	
	/** The scan. */
	private static Scanner scan;

	/**
	 * Main method for re-engineer the Fortran77 code.		(1)
	 * <p>
	 * Re-engineer of Fortran77 code for national			(2)
	 * fire danger rating indexes.  
	 * <>p>
	 *
	 * @param args Beginning the main code. 				(3)
	 */
	public static void main(String[] args) {
		// Beginning of the main code
		
		askforInput(new AskforInputParameter("snow"));//asks for amount from the user. 
		
		int storedValue = storeInput(); //Stores the value entered by the user.
		
		System.out.println("--------------------------------------------------");
		
		double result = Calculate(storedValue); //Calculates the stored Value entered by user.
		
		System.out.println("--------------------------------------------------");
		
		setWhereToGo(lineDecision(result));
		
		System.out.println("--------------------------------------------------");
		
		double fineFuel = fuelMoisture();//Calls fuelMoisture for fine fuel calculation.
		
		System.out.println("--------------------------------------------------");
		
		double drying = dryingFactor(); //Calls dryingFactor for fine calculation.
		
		System.out.println("--------------------------------------------------");
		
		setHerb(fuelHerbStage ());
		
		System.out.println("--------------------------------------------------");
		
		double rainResult = rainCheck (result); //checks for rain
		double d, j, increaseBUI;
		d = drying;
		j = rainResult; 
		increaseBUI = d + j;
		
		System.out.println("This is the result for the increased BUI " + increaseBUI);
		System.out.println("--------------------------------------------------");
		
		double adjustFuel = fineFuel + fuelMoisture();//Calls fuelMoisture for fine fuel calculation.
		
		System.out.println("Adjusted fuel moisture result: " + adjustFuel);	
		
		System.out.println("--------------------------------------------------");
		
		setStoreAdjusted(fuelLevel (adjustFuel));
		
		System.out.println("--------------------------------------------------");
		
		double windStored = buoCalculation();//creates random number to calculate wind.
		System.out.println("The wind is: " + windStored);
		
		System.out.println("--------------------------------------------------");
		double windGust = windStrength (windStored);//calls windStrength 
		
		System.out.println("--------------------------------------------------");
		
		while (rainResult == 0 && windGust == 0){
			System.out.println("Calculate the fire load index");
		}
		System.out.println("--------------------------------------------------");
		System.out.println("BUI and timber spread are indexed at zero");
		System.out.println("This is the end of the code");
		


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
	 * @param parameterObject TODO
	 * @return User input of the amount for the asked condition. 
	 */
	//This method will be reused to ask different conditions
	public static void askforInput(AskforInputParameter parameterObject){ 
		  userInput(parameterObject.getName());
		     		   
	}//End of user input method

	/**
	 * User input.
	 *
	 * @param name the name
	 */
	private static void userInput(String name) {
		System.out.println("Enter the " + name + " amount");
	}
	
	/**
	 * This method will store an input from the user.		(1)
	 * <p>
	 * The method will be reused to store the user's		(2)
	 * input.  
	 * <p>
	 * @return	This returns the user's input. 				(3) 
	 */
	public static int storeInput(){
		scan = new Scanner(System.in);
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
			
			setRainResult(rainCheck (result));
		
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
	 *
	 * @param rainResult the rain result
	 * @return the double
	 */	
	public static double rainCheck(double rainResult ){
		
		askforInput(new AskforInputParameter("Precipitation"));//is there rain?
		
		double answer = answer();
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
		setBuo(0); 
		System.out.println("The BUO is set to zero");
		System.out.println("The rainCheck ends and returns to other calculations.");
		}
		else if (result2 == 0 || result2 >= 1){
		System.out.println("The rainCheck ends and returns to other calculations.");
		}
		return result2;
		}
				
	}//End of precipitation check method.

	/**
	 * Answer.
	 *
	 * @return the double
	 */
	private static double answer() {
		int storedValue = storeInput();
		double x, y, answer;
		x = storedValue;
		y = (double) .1;
		answer = x - y;
		return answer;
	}

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
	
	/**
	 * Calculate Fine fuel moisture.			(1)
	 * <p>
	 * Method will generate random number 		(2)
	 * to represent the calculation of
	 * the fine fuel moisture. 
	 * <p>
	 * @return A random number that represents fuel moisture 
	 */
	public static double fuelMoisture(){
		double moisture = buoCalculation();
		System.out.println("This is the fuel moisture calcualtion. " + moisture);
		return moisture; 
	}//End of fuel moisture method.
	
	/**
	 * Calculate Fine fuel moisture.			(1)
	 * <p>
	 * Method will generate random number 		(2)
	 * to represent the calculation of
	 * the fine fuel moisture. 
	 * <p>
	 * @return A random number that represents fuel moisture 
	 */
	public static double dryingFactor(){
		double factor = buoCalculation();
		System.out.println("This is the drying fuel calcualtion. " + factor);
		return factor; 
	}//End of drying factor method.  
	
	/**
	 * Calculate Fine fuel moisture.			(1)
	 * <p>
	 * Method will generate random number 		(2)
	 * to represent the calculation of
	 * the fine fuel and herb stage. 
	 * <p>
	 * @return A random number that represents the calculation 
	 */
	public static double fuelHerbStage (){
		double stage = buoCalculation();
		System.out.println("This is the fuel and herb stage calculation. " + stage);
		return stage; 
	}//End of fine fuel for herb stage method.  

	/**
	 * Method will evaluate fuel level 	(1).
	 *
	 * @param adjustFuel the adjust fuel
	 * @return the double
	 */
	public static double fuelLevel(double adjustFuel){
		double fuel = adjustFuel;
		if (adjustFuel >= 33){
			System.out.println("All indexes are set to one.");
			System.out.println("Move to check the wind.");
		}
		else {
			System.out.println("Go check the wind");
		}
		return fuel; 
			 
	}
	
	/**
	 * Method will evaluate the wind 	(1).
	 *
	 * @param randWind the rand wind
	 * @return the double
	 */
	public static double windStrength(double randWind){
		double wind = randWind;
		if (randWind >= 14){
			System.out.println("Calculate grass and timber spread indexes.");
			
		}
		else {
			System.out.println("Calculate grass and timber spread index");
		}
		return wind; 
			 
	}

	/**
	 * Gets the where to go.
	 *
	 * @return the where to go
	 */
	public static double getWhereToGo() {
		return whereToGo;
	}

	/**
	 * Sets the where to go.
	 *
	 * @param whereToGo the new where to go
	 */
	public static void setWhereToGo(double whereToGo) {
		Ntl_Fire_Dng_R_Idx.whereToGo = whereToGo;
	}

	/**
	 * Gets the rain result.
	 *
	 * @return the rain result
	 */
	public static double getRainResult() {
		return rainResult;
	}

	/**
	 * Sets the rain result.
	 *
	 * @param rainResult the new rain result
	 */
	public static void setRainResult(double rainResult) {
		Ntl_Fire_Dng_R_Idx.rainResult = rainResult;
	}

	/**
	 * Gets the herb.
	 *
	 * @return the herb
	 */
	public static double getHerb() {
		return herb;
	}

	/**
	 * Sets the herb.
	 *
	 * @param herb the new herb
	 */
	public static void setHerb(double herb) {
		Ntl_Fire_Dng_R_Idx.herb = herb;
	}

	/**
	 * Gets the store adjusted.
	 *
	 * @return the store adjusted
	 */
	public static double getStoreAdjusted() {
		return storeAdjusted;
	}

	/**
	 * Sets the store adjusted.
	 *
	 * @param storeAdjusted the new store adjusted
	 */
	public static void setStoreAdjusted(double storeAdjusted) {
		Ntl_Fire_Dng_R_Idx.storeAdjusted = storeAdjusted;
	}

	/**
	 * Gets the buo.
	 *
	 * @return the buo
	 */
	public static int getBuo() {
		return buo;
	}

	/**
	 * Sets the buo.
	 *
	 * @param buo the new buo
	 */
	public static void setBuo(int buo) {
		Ntl_Fire_Dng_R_Idx.buo = buo;
	}
}
		

	
	



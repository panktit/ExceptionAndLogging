//		Tasks:
//		1) write code that generates ArithmeticException, ArrayIndexOutOfBoundsException and FileNotFoundException
//		2) handle these exceptions using catch block and log appropriate error messages
//		3) produce log files at different locations of the machine

package com.accolite.au;

import java.io.*;
import java.util.*;
import java.util.logging.*;

public class ExceptionsAndLogging {
	static Logger logger;
	public static void main(String[] args) {
		
//		Logger Setup
	    logger = Logger.getLogger(ExceptionsAndLogging.class.getName());  
	    FileHandler fh;  
//	    to prevent from printing to console
    	logger.setUseParentHandlers(false);

        try {
//        	vary the path here to generate file at different locations
			fh = new FileHandler("C:\\Users\\Pankti\\Desktop\\log.txt");
			logger.addHandler(fh);
			
//			to store files as text files, because by default FileHandler uses XMLFormatter
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
		} catch (SecurityException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
        
        logger.info("Program starts executing...");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter dividend and divisor: ");
		int dividend = sc.nextInt();
		int divisor = sc.nextInt();
		logger.info("Successful user input for divide method");
		try {
			int result = divide(dividend, divisor);
			logger.info("divide method executed successfully");
			System.out.println("Result: "+result);
		}
		catch (ArithmeticException ae) {
			System.out.println("ERROR: Cannot divide by zero");
			logger.severe("Attempted divide by zero");
		}
		
		int [] array = {25, 41, 89, 62, 74, 53};
		System.out.println("\n\nArray: "+Arrays.toString(array));
		System.out.print("Enter index: ");
		int position = sc.nextInt();
		logger.info("Successful user input for accessArray method");
		try {
			int element = accessArray(array, position);
			logger.info("accessArray method executed successfully");
			System.out.println("The element at position "+position+" is: "+element);
		}
		catch(ArrayIndexOutOfBoundsException aie ) {
			System.out.println("ERROR: The specified index is out of range");
			logger.severe("Index accessed is out of range");
		}
		
		System.out.print("\n\nEnter file name to be read: ");
		String filename = sc.next();
		logger.info("Successful user input for readFile method");
		try {
			readFile(filename);
			logger.info("readFile method executed successfully");
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: The requested file is not found");
			logger.severe("Input file could not be found");
		}
		
		System.out.println("\nProgram terminated successfully!");
		sc.close();
		logger.info("Program terminated...");
	}
	
	static int divide(int dividend, int divisor) throws ArithmeticException {
		logger.info("Divide method called");
		return dividend/divisor;
	}
	
	static int accessArray (int [] array, int position) throws ArrayIndexOutOfBoundsException {
		logger.info("accessArray method called");
		return array[position];
	}
	
	static void readFile(String filename) throws FileNotFoundException {
		logger.info("readFile method called");
		 Scanner sc = new Scanner(new FileReader("C:\\Users\\Pankti\\Desktop\\"+filename));
		 while(sc.hasNextLine())
			 System.out.println(sc.nextLine());
		 sc.close();
	}
}

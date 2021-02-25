import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;



/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FormatNamesm {

	public static void main(String[] args) {
		try {	

			for(String arg:args)
			{
				if(args.equals("-")) //still acceptable
				       {      
						inputFile = new File(args[1]);
						outputFile = new File(args[2]);
					}

					else 
					{
						inputFile = new File(args[0]); //rearranging files to be in correct order
						outputFile = new File(args[1]);
					}
					//checking if file equals -u flag  	
					else if (args[0].equals("-u"))

					{
						inputFile = new File(args[1]);
						outputFile = new File(args[2]);
					}

					else 
					{
						inputFile = new File(args[0]); //rearranging files to be in correct order
						outputFile = new File(args[1]);
					}

					else if(inputFile==null) inputFile= arg;
					else of(outputFile==null) outputFile = arg; //checks if file is empty 
				        }
			
					
					File file = new File("OutputFile.txt"); 
				        FileWriter writer = new FileWriter(OutputFile); //Creating new OutputFile
				      

                                       
				        //Creating Scanner Input
					Scanner input  = new Scanner(inputFile);

					//Reading Scanner Input 
					While(input.hasNextLine()){ 

						String Firstname = input.next(); //Scans Firstname 
						String Surname = input.next();  //Scans Surname
						String MiddleName = "";         //Scans Middle name


						if(args[0].equals ("-u"))
						{
							Firstname.toUpperCase(); //Puts name in all caps 
							Surname.toUpperCase();// puts Last name in all caps
							MiddleName.toUpperCase();// Puts Middle name in all caps if there
						}
						else {
							Firstname.toLowerCase();  //reverts Firstname back to lower case
							Surname.toLowerCase();    //reverts Surname back to lower case
						}

						/* 
						*String pattern for date of birth
						*Using Simple Date Format
						*Day/Month/Year
                                                */  
						
						String datePattern = "MM-dd-yyyy"; //Configuring Date (//Month/Day/Year)
						SimpleDateFormat InputDate = new SimpleDateFormat(datePattern); //Input File
						SimpleDateFormat outputDate = new SimpleDateFormat(datePattern); //Output File

						//Configuring Date of Birth

						try {
							String Date_of_birth = InputDate.format(new Date());//Input Date
							String date = outputDate.format(new Date());//Output Date

							/* 
						       *Checks if person has a middle name by splitting the strings
						       *@returns Middle name along with results 
						       *If middle name is not found firstname and surname only returned
                                                       */  
							int firstSpace = Firstname.indexOf(" ");
							Firstname =Firstname.substring(0,firstSpace);

							int lastSpace = Surname.lastIndexOf(" ", firstSpace);
							String middleName = MiddleName.substring(firstSpace,lastSpace);

							if(lastSpace <0) {
								Surname =Surname.substring(lastSpace + 1);
								System.out.println(Firstname + ","+ Surname); //Middle name not found
							}

							else {
								MiddleName = MiddleName.substring(firstSpace, lastSpace);
								Surname = Surname.substring(lastSpace + 1);
								
								//displays results with middle name found
								System.out.println(Firstname + "," + MiddleName.charAt(1) + "," + Surname + date );
								
							}


							//Catching any errors 
						} catch (Exception e) {
							e.printStackTrace();
						}
						writer.close(); //close file



					} // main

					// FilesInOut

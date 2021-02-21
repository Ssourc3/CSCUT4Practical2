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
			File inputFile;
			File outputFile;

			//checking if file equals -u flag  	

			for(String arg:args)
			{
				if(args.equals("-")) 
				{
					if (args[0].equals("-u"))

					{
						inputFile = new File(args[1]);
						outputFile = new File(args[2]);
					}

					else 
					{
						inputFile = new File(args[0]); //rearranging files to be in correct order
						outputFile = new File(args[1]);
					}

					//Creating Scanner Input

					Scanner input  = new Scanner(inputFile);

					//creating Scanner output 
					outputFile.createNewFile();  
					FileWriter Writer new FileWriter(outputFile);


					//Reading Scanner Input 
					While(input.hasNextLine()){ 

						String Firstname = input.next();
						String Surname = input.next();
						String MiddleName = "";


						if(args[0].equals ("-u"))
						{
							Firstname.toUpperCase(); //Puts name in all caps 
							Surname.toUpperCase();// puts Last name in all caps
							MiddleName.toUpperCase();// Puts Middle name in all caps if there
						}
						else {
							Firstname.toLowerCase();  //reverts it back to lower case
							Surname.toLowerCase();
						}

						//Setting Pattern of Date of Birth
						String datePattern = "MM-dd-yyyy"; //Configuring Date (//Month/Day/Year)
						SimpleDateFormat InputDate = new SimpleDateFormat(datePattern); //Input File
						SimpleDateFormat outputDate = new SimpleDateFormat(datePattern); //Output File

						//Configuring Date of Birth

						try {
							String Date_of_birth = InputDate.format(new Date());//Output Data
							String date = outputDate.format(new Date());//Output Data

							//checking if person has a middle name 

							//checking if Middle name is there
							int firstSpace = Firstname.indexOf(" ");
							Firstname =Firstname.substring(0,firstSpace);

							int lastSpace = Surname.lastIndexOf(" ", firstSpace);
							String middleName = MiddleName.substring(firstSpace,lastSpace);

							if(lastSpace<0) {
								Surname =Surname.substring(lastSpace + 1);
								System.out.println(Firstname + ","+ Surname);
							}

							else {
								MiddleName = MiddleName.substring(firstSpace, lastSpace);
								Surname = Surname.substring(lastSpace + 1);
								System.out.println(Firstname + "," + MiddleName.charAt(1) + "," + Surname + date );
							}



							//Catching any errors 
						} catch (Exception e) {
							e.printStackTrace();
						}
						writer.close();



					} // main

					// FilesInOut

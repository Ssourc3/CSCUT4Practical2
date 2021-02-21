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
public class FilesInOut 


	public static void main(String[] args) {
		// Replace this with statements to set the file name (input) and file name (output).
		// Initially it will be easier to hardcode suitable file names.

		// Set up a new Scanner to read the input file.
		// Processing line by line would be sensible here.
		// Initially, echo the text to System.out to check you are reading correctly.
		// Then add code to modify the text to the output format.

		// Set up a new PrintWriter to write the output file.
		// Add suitable code into the above processing (because you need to do this line by line also.
		// That is, read a line, write a line, loop.

		// Finally, add code to read the filenames as arguments from the command line.

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
						String date = input.next();

						if(args[0].equals ("-u"))
						{
							Firstname.toUpperCase(); //Puts name in all caps 
							Surname.toUpperCase();// puts Last name in all caps

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
							System.out.println(Firstname + Surname + outputDate);

							//Catching any errors 
						} catch (Exception e) {
							e.printStackTrace();
						}
						writer.close();
						
			} // main

		   }// FilesInOut
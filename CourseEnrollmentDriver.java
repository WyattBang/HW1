// /////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseEnrollmentDriver
// Course:   CS 300 Fall 2023
//
// Author:   Bang Zhang
// Email:    bzhang457@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons:         none
// Online Sources:  none
//
///////////////////////////////////////////////////////////////////////////////
// Be sure to credit the outside help section in the file header
// Be sure to credit the outside help section in the file header

import CourseEnrollment;

import java.util.Scanner;


import static CourseEnrollment.*;

/**
 * This class implements the Driver Application for cs300 Fall 2023 p01 Course Enrollment System
 *
 */
public class CourseEnrollmentDriver {

  // welcome, good bye, and syntax error messages
  private static final String WELCOME_MSG = "--- Welcome to the Course Enrollment System! ----";
  private static final String GOOD_BYE_MSG = "---------- BYE! Thanks for using our App! ----------";
  private static final String SYNTAX_ERROR_MSG = "Syntax Error: Please enter a valid command!";
  private static final String NO_COURSE_ENROLLMENT_MSG =
      "Error: Create a new course enrollment first!";


  /**
   * Main method that launches this driver application
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    // run application
    System.out.println(WELCOME_MSG); // display welcome message
    // Create a scanner to read the user inputs
    Scanner scanner = new Scanner(System.in);
    // read and process user command lines
    processUserCommands(scanner);
    scanner.close();// close the scanner
    System.out.println(GOOD_BYE_MSG);// display good bye message
  }


  /**
   * Prints out the menu of this application
   */
  private static void displayMenu() {
    System.out.println("\n================================ MENU ===============================");
    System.out.println("Enter one of the following options:");
    System.out.println("[1 <roster_capacity> <waitlist_capacity>] Create a new course enrollment");
    System.out.println("[2 <name>:<wisc_email>:<campus_ID>:boolean(true/false)] Enroll student");
    System.out.println("[3 <name>:<wisc_email>:<campus_ID>:boolean] Add student to waitlist");
    System.out.println("[4 <campus_ID>] Drop the course");
    System.out.println("[5] Print roster");
    System.out.println("[6] Print waitlist");
    System.out.println("[7] Logout and EXIT");
    System.out.println("-----------------------------------------------------------------------");
  }


  /**
   * Reads and processes user command lines
   */
  private static void processUserCommands(Scanner scanner) {
    
    String promptCommandLine = "ENTER COMMAND: ";    
    String command = null; // variable to save the user command line

    // define a roster and a waitlist variables for the course enrollment, not yet initialized
    String[][] roster = null;
    int size = 0; // size of roster

    String[][] waitlist = null; // waitlist of the course

    // read and process user command lines until the user quits the application
    do{
      
      displayMenu(); // display the main menu
      // read user command line
      System.out.print(promptCommandLine);
      command = scanner.nextLine();
      // blank command
      if(command == null || command.isBlank()) {
        System.out.println(SYNTAX_ERROR_MSG); // syntax error message
        continue; // go to the next iteration
      }
      
      // Exit the loop if the user command is 7 for Quit
      if(command.charAt(0) == '7') {
        break; // exit the loop
      }
      
      // Create new course enrollment lists
      if (command.charAt(0) == '1') {
        // [1 <roster_capacity> <waitlist_capacity>] Create a new course enrollment
        String[] parts = command.split(" ");
        if (parts.length != 3) {// syntax error
          System.out.println(SYNTAX_ERROR_MSG);
          continue;
        }
        // valid syntax: create lists
        roster = CourseEnrollment.createEmptyList(Integer.parseInt(parts[1]));
        waitlist = CourseEnrollment.createEmptyList(Integer.parseInt(parts[2]));
        continue;
      }
      
      else { // any other type of command.
        // Check whether the course enrollment lists were created
        if (roster == null || waitlist == null) {
          System.out.println(NO_COURSE_ENROLLMENT_MSG);
          continue;
        }
        // process the user command line for the other options
        switch (command.charAt(0)) {
          // Enroll student
//          case '2': // [2 <name>:<wisc_email>:<campus_ID>:boolean(true/false)] Enroll student
//            // The boolean indicates whether the pre-requisites of the course are satisfied or not
//            // TODO process and execute the user command line to enroll a student in the course
          case '2': // Enroll student
            String[] userInfo = command.toString().split(":");

            if (userInfo.length == 4) {
              String name = userInfo[0];
              String wisc_email = userInfo[1];
              String campus_ID = userInfo[2];
              boolean prereqSatisfied = Boolean.parseBoolean(userInfo[3]);

              // Check if the course roster is not full
              if (size < roster.length) {
                // Check if pre-requisites are satisfied
                if (prereqSatisfied) {
                  // Enroll the student in the course
                  size = enrollOneStudent(name, wisc_email, campus_ID, prereqSatisfied, roster, size, waitlist);
//                  System.out.println("You are successfully enrolled in this class.");
                } else {
                  System.out.println("Error: You do not meet the prerequisite(s) for this course.");
                }
              } else {
                // Check if there is room in the waitlist
                if (size < roster.length + waitlist.length) {
                  // Check if pre-requisites are satisfied
                  if (prereqSatisfied) {
                    // Add the student to the waitlist
                    addWaitlist(name, wisc_email, campus_ID, prereqSatisfied, waitlist);
                    System.out.println("You are successfully added to the waitlist of this course.");
                  } else {
                    System.out.println("Error: You do not meet the prerequisite(s) for this course.");
                  }
                } else {
                  System.out.println("Error: Course closed! Waitlist full.");
                }
              }
            } else {
              System.out.println("Invalid input format. Please use the format: name:wisc_email:campus_ID:boolean");
            }
            break;


//          case '3': // [3 <name>:<wisc_email>:<campus_ID>:boolean] Add student to waitlist
//            // TODO process and execute the user command line to add a student record to the waitlist
          case '3': // Add student to waitlist
            String[] userInfo1 = command.split(":");

            if (userInfo1.length == 4) {
              String name = userInfo1[0];
              String wisc_email = userInfo1[1];
              String campus_ID = userInfo1[2];
              boolean prereqSatisfied = Boolean.parseBoolean(userInfo1[3]);

              // Check if the waitlist is not full
              if (waitlist.length < 5) {
                // Add the student to the waitlist
                addWaitlist(name, wisc_email, campus_ID, prereqSatisfied, waitlist);
                System.out.println("You are successfully added to the waitlist of this course.");
              } else {
                System.out.println("Error: Waitlist full.");
              }
            } else {
              System.out.println("Invalid input format. Please use the format: name:wisc_email:campus_ID:boolean");
            }
            break;

//          case '4': // [4 <campus_ID>] Drop the course
//            // TODO process and execute the user command line to drop the course
          case '4': // Drop the course
            // Parse user input to extract the campus_ID

            String[] userInfo2 = command.toString().split(" ");


            String campusId=userInfo2[1];
            // Search for the student's record in the roster
            int studentIndex = indexOf(campusId, roster, size);

            if (studentIndex != -1) {
              // Remove the student's record from the roster
              size = dropCourse(campusId, roster, size);
//              System.out.println("You just dropped the course. This action cannot be revoked.");
            } else {
              System.out.println("Error: You are not enrolled in the course!");
            }
            break;

          case '5': // [5] Print roster
            CourseEnrollment.printRoster(roster, size);
            break;

          case '6': // [6] Print waitlist
            CourseEnrollment.printWaitlist(waitlist);
            break;

          default:
            System.out.println(SYNTAX_ERROR_MSG); // Syntax Error

        }
      }
    }while(command.charAt(0) != '7');
  }
}


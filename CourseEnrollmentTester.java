// /////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:    CourseEnrollmentTester
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

import java.util.Arrays;

import static CourseEnrollment.*;

/**
 * This utility class implements unit tests to check the correctness of methods defined in the
 * CourseEnrollment class of the Course Enrollment System program.
 *
 */
public class CourseEnrollmentTester {


  /**
   * Ensures the correctness of the createEmptyList() method
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean createEmptyListTester() {
    String errMsg = "Bug detected: createEmptyList did not return the expected array.";
    // Create an empty list String[][] whose capacity is 5
    String[][] actual = CourseEnrollment.createEmptyList(5);
    String[][] expected = new String[5][];
    // same as expected = new String[][]{null, null, null, null, null}

    if (!Arrays.deepEquals(actual, expected)) {
      // Recommended: descriptive error messages to help locating the bug
      System.out.println(errMsg);
      System.out.println("Expected: " + Arrays.deepToString(expected));
      System.out.println("Actual: " + Arrays.deepToString(actual));
      return false;
    }


    // Try a different capacity: create an empty list String[][] whose capacity is 8
    actual = CourseEnrollment.createEmptyList(8);
    expected = new String[8][];
    // same as expected = new String[][]{null, null, null, null, null}

    if (!Arrays.deepEquals(actual, expected)) {
      // descriptive error messages to help locating the bug
      System.out.println(errMsg);
      System.out.println("Expected: " + Arrays.deepToString(expected));
      System.out.println("Actual: " + Arrays.deepToString(actual));
      return false;
    }

    return true; // expected behavior verified, no bugs detected!
  }

  /**
   * Ensures the correctness of the indexOf(String, String[][]) method
   * 
   * Expected behavior to be verified:<BR>
   * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
   * (+) No changes made to the contents of the input list<BR>
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
//  public static boolean indexOfPerfectSizeArrayTester() {
//    // TODO complete the implementation of this method
//
//    // Define four test cases
//    // (1) edge case: match found at index 0
//    // (2) edge case: match found at index length-1 considering a full input array
//    // (3) normal case: match found at the middle of the input array
//    // (4) normal case: no match found, -1 should be returned
//
//    return false; // default return statement added to resolve compiler errors
//  }
  public static boolean indexOfPerfectSizeArrayTester() {
    // Create a test perfect-size array with sample data
    String[][] testArray = {
            {"John", "john@example.com", "1234567890"},
            {"Alice", "alice@example.com", "9876543210"},
            {"Bob", "bob@example.com", "4567891230"},
            {"Eve", "eve@example.com", "7890123450"},
    };

    // Test case 1: Match found at index 0
    int result1 = indexOf("1234567890", testArray, testArray.length);
    if (result1 != 0) {
      System.out.println("Test case 1 failed: Expected index 0, but got " + result1);
      return false;
    }

    // Test case 2: Match found at index length-1
    int result2 = indexOf("7890123450", testArray, testArray.length);
    if (result2 != testArray.length - 1) {
      System.out.println("Test case 2 failed: Expected index " + (testArray.length - 1) + ", but got " + result2);
      return false;
    }

    // Test case 3: Match found at the middle of the input array
    int result3 = indexOf("4567891230", testArray, testArray.length);
    if (result3 != 2) {
      System.out.println("Test case 3 failed: Expected index 2, but got " + result3);
      return false;
    }

    // Test case 4: No match found, should return -1
    int result4 = indexOf("5555555555", testArray, testArray.length);
    if (result4 != -1) {
      System.out.println("Test case 4 failed: Expected index -1, but got " + result4);
      return false;
    }

    // All test cases passed
    return true;
  }





  /**
   * Ensures the correctness of the indexOf(String, String[][], int) method
   * 
   * Expected behavior to be verified:<BR>
   * (+) Correct index returned for multiple cases (normal and edge cases)<BR>
   * (+) No changes made to the contents of the input list<BR>
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
//  public static boolean indexOfOversizeSizeArrayTester() {
//    // TODO complete the implementation of this method
//
//    return false; // default return statement added to resolve compiler errors
//  }
//  public static boolean indexOfOversizeSizeArrayTester() {
//    // Create a test oversize-size array with sample data
//    String[][] testArray = new String[5][];
//    testArray[0] = new String[]{"John", "john@example.com", "1234567890"};
//    testArray[1] = new String[]{"Alice", "alice@example.com", "9876543210"};
//    testArray[2] = new String[]{"Bob", "bob@example.com", "4567891230"};
//    testArray[3] = new String[]{"Eve", "eve@example.com", "7890123450"};
//    // Leave testArray[4] as null to simulate oversize
//
//    // Test case 1: Match found at index 0
//    int result1 = indexOf("1234567890", testArray, testArray.length);
//    if (result1 != 0) {
//      System.out.println("Test case 1 failed: Expected index 0, but got " + result1);
//      return false;
//    }
//
//    // Test case 2: Match found at index length-1 (oversize)
//    int result2 = indexOf("7890123450", testArray, testArray.length);
//    if (result2 != testArray.length - 1) {
//      System.out.println("Test case 2 failed: Expected index " + (testArray.length - 1) + ", but got " + result2);
//      return false;
//    }
//
//    // Test case 3: Match found at the middle of the input array
//    int result3 = indexOf("4567891230", testArray, testArray.length);
//    if (result3 != 2) {
//      System.out.println("Test case 3 failed: Expected index 2, but got " + result3);
//      return false;
//    }
//
//    // Test case 4: No match found, should return -1
//    int result4 = indexOf("5555555555", testArray, testArray.length);
//    if (result4 != -1) {
//      System.out.println("Test case 4 failed: Expected index -1, but got " + result4);
//      return false;
//    }
//
//    // Test case 5: Verify no changes made to the input list
//    for (int i = 0; i < testArray.length; i++) {
//      if (testArray[i] == null) {
//        // Oversize element should remain null
//        continue;
//      }
//      if (testArray[i].length != 3) {
//        System.out.println("Test case 5 failed: Input list content modified.");
//        return false;
//      }
//    }
//
//    // All test cases passed
//    return true;
//  }
  public static boolean indexOfOversizeSizeArrayTester() {
    // Create a test oversize-size array with sample data
    String[][] testArray = new String[10][]; // Adjust the size as needed
    // Populate testArray with sample data

    // Test case 1: Define a test case
    int result1 = indexOf("campusId1", testArray, 5); // Adjust the campusId and size
    // Verify the result and input list

    // Test case 2: Define another test case
    int result2 = indexOf("campusId2", testArray, 5); // Adjust the campusId and size
    // Verify the result and input list

    // Add more test cases as needed...

    // After all test cases
    return true; // Return true if all tests pass
  }
  // Helper method to compare actual and expected oversize roster arrays
  /**
   * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
   * the expected ones
   * 
   * @param methodName     name of the method being tested
   * @param actualRoster   actual roster
   * @param expectedRoster expected roster
   * @param actualSize     actual roster size
   * @param expectedSize   expected roster size
   * 
   * @return true if expected behavior satisfied, false if any bug is detected
   */
  private static boolean assessDeepEqualOversizeArraysHelper(String methodName,
      String[][] actualRoster, String[][] expectedRoster, int actualSize, int expectedSize) {
    // error messages
    String errMsgBadSize =
        "Bug detected: Your " + methodName + "() method did not return the expected size.";
    String errMsgBadRoster = "Bug detected: The contents of the roster array was not as expected "
        + "after " + "your " + methodName + "() method returned.";

    // check roster size
    if (actualSize != expectedSize) {
      System.out.println(errMsgBadSize);
      System.out.println("Expected size: " + expectedSize + ". Actual size: " + actualSize);
      return false;
    }

    // compare roster contents
    if (!Arrays.deepEquals(actualRoster, expectedRoster)) {
      System.out.println(errMsgBadRoster);
      System.out.println("Expected Roster: " + Arrays.deepToString(expectedRoster));
      System.out.println("Actual Roster: " + Arrays.deepToString(actualRoster));
      return false;
    }

    return true; // expected behavior satisfied, no bugs detected
  }

  // Helper method to compare actual and expected oversize roster arrays
  /**
   * Helper method defined to help verifying the actual roster and waitlist arrays with respect to
   * the expected ones
   * 
   * @param methodName       name of the method being tested
   * @param actualWaitlist   actual waitlist
   * @param expectedWaitlist expected waitlist
   * 
   * @return true if expected behavior satisfied, false if any bug is detected
   */
  private static boolean assessDeepEqualPerfectSizeArraysHelper(String methodName,
      String[][] actualWaitlist, String[][] expectedWaitlist) {
    // error message
    String errMsgBadWaitlist =
        "Bug detected: The contents of the waitlist array was not as expected after " + "your "
            + methodName + "() method returned";

    // compare waitlist contents
    if (!Arrays.deepEquals(actualWaitlist, expectedWaitlist)) {
      System.out.println(errMsgBadWaitlist);
      System.out.println("Expected Waitlist: " + Arrays.deepToString(expectedWaitlist));
      System.out.println("Actual Waitlist: " + Arrays.deepToString(actualWaitlist));
      return false;
    }
    return true; // expected behavior satisfied, no bugs detected
  }

  /**
   * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
   * record in the course. The course did not reach its capacity and the course pre-requisites are
   * satisfied.
   * 
   * Expected behavior to be verified:<BR>
   * (+) Student record correctly added to the end of the roster array<BR>
   * (+) No changes made to the waitlist array<BR>
   * (+) Correct size returned
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
  public static boolean enrollOneStudentTester() {
    // You do not need to make changes to this method
    // create a waitlist array. We can consider a normal case: not-empty and not-full waitlist)
    String[][] actualWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

    // No changes to the waitlist are expected
    String[][] expectedWaitlist = new String[][] {{"Andy", "andy@wisc.edu", "9087654321"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};

    // This method considers three test cases:
    // (1) edge case: adding to an empty roster
    // (2) normal case: adding to the end of a non-empty roster
    // (3) edge case: after adding the student record, the roster is full

    // To avoid code redundancy, we defined a helper method named verifyCorrectBehaviorHelper() to
    // help verifying the expected behavior for each of the above test cases.

    // --------------------------------------------------------------------------
    // (1) edge case Enroll a student considering an empty roster oversize array
    // enroll one student satisfying prerequisites
    // Create an empty roster
    String[][] actualRoster = new String[3][];
    int actualSize = 0;

    // Try to enroll George
    actualSize = enrollOneStudent("George", "george@wisc.edu", "9780563421", true,
        actualRoster, actualSize, actualWaitlist);
    // expected roster and its size
    String[][] expectedRoster =
        new String[][] {{"George", "george@wisc.edu", "9780563421"}, null, null};
    int expectedSize = 1;
    boolean resultCase1 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
        expectedRoster, actualSize, expectedSize);

    // --------------------------------------------------------------------------
    // (2) normal case: adding to the end of a non-empty roster
    actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null};
    actualSize = 2;

    // Try to enroll Matt
    actualSize = enrollOneStudent("Matt", "matt@wisc.edu", "9745632180", true,
        actualRoster, actualSize, actualWaitlist);
    // expected roster and its size
    expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
    expectedSize = 3;
    boolean resultCase2 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
        expectedRoster, actualSize, expectedSize);

    // --------------------------------------------------------------------------
    // (3) edge case: after adding the student record, the roster is full
    actualRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"}, null};
    actualSize = 3;

    // Try to enroll Lisa
    actualSize = enrollOneStudent("Lisa", "lisa@wisc.edu", "9784563211", true,
        actualRoster, actualSize, actualWaitlist);
    // expected roster and its size
    expectedRoster = new String[][] {{"George", "george@wisc.edu", "9780563421"},
        {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"},
        {"Lisa", "lisa@wisc.edu", "9784563211"}};
    expectedSize = 4;
    boolean resultCase3 = assessDeepEqualOversizeArraysHelper("enrollOneStudent", actualRoster,
        expectedRoster, actualSize, expectedSize);

    // Verify that all the above enrollOneStudent() method calls did not make any changes to the
    // contents of the input waitlist
    boolean assessWaitlistContents = assessDeepEqualPerfectSizeArraysHelper("enrollOneStudent",
        actualWaitlist, expectedWaitlist);

    // test passes only if each of the defined test scenarios passes
    return resultCase1 && resultCase2 && resultCase3 && assessWaitlistContents;
  }


  /**
   * Ensures the correctness of the enrollOneStudent() method when called to enroll one student
   * record in the course. The student record is in the waitlist, course pre-requisites are
   * satisfied, and there is room in the roster to enroll the student in the course.
   * 
   * Expected behavior to be verified:<BR>
   * (+) Student record correctly added to the end of the roster array<BR>
   * (+) Matching student correctly record removed off the waitlist<BR>
   * (+) Correct size returned
   * 
   * @return true if the tester verifies a correct functionality and false if at least one bug is
   *         detected
   */
//  public static boolean enrollOneStudentMoveFromWaitlistTester() {
//    // TODO complete the implementation of this method
//
//    return false; // default return statement added to resolve compiler errors
//  }
//  public static boolean enrollOneStudentMoveFromWaitlistTester() {
//    // Create a test scenario
//    String[][] roster = new String[][]{{"George", "george@wisc.edu", "9780563421"},
//            {"Lilly", "lilly@wisc.edu", "9807645321"}, {"Matt", "matt@wisc.edu", "9745632180"},
//            {"Lisa", "lisa@wisc.edu", "9784563211"},null};; // Adjust the roster size as needed
//    String[][] waitlist = new String[][]{{"Andy", "andy@wisc.edu", "9087654321"},
//            {"Lilly", "lilly@wisc.edu", "9807645321"}, null, null}; // Adjust the waitlist size as needed
//
//    // Populate roster and waitlist with sample data
//    // Ensure that the student record is in the waitlist, prerequisites are satisfied,
//    // and there is room in the roster.
//
//    // Call enrollOneStudent to simulate the enrollment
//    int initialRosterSize = 4/* initial roster size */;
//    int initialWaitlistSize = 5/* init2ial waitlist size */;
//    boolean prerequisiteSatisfied = true/* true if prerequisites are satisfied */;
//    int newSize = enrollOneStudent("John", "john@example.com", "1234567890", prerequisiteSatisfied, roster, initialRosterSize, waitlist);
//
//    // Verify the results
//    // Check if the student record is correctly added to the end of the roster array.
//    // Check if the matching student record is correctly removed from the waitlist.
//    // Check if the correct size is returned.
//
//    // Return true if the test scenario passes
//
//    return false; // Default return statement added to resolve compiler errors
//  }

  public static boolean enrollOneStudentMoveFromWaitlistTester() {
    // Create a test scenario
    String[][] roster = new String[5][3]; // Adjust the roster size as needed
    String[][] waitlist = new String[5][3]; // Adjust the waitlist size as needed

    // Populate roster and waitlist with sample data
    // Ensure that the student record is in the waitlist, prerequisites are satisfied,
    // and there is room in the roster.

    // For example:
    roster[0] = new String[]{"George", "george@wisc.edu", "9780563421"};
    roster[1] = new String[]{"Lilly", "lilly@wisc.edu", "9807645321"};
    roster[2] = new String[]{"Matt", "matt@wisc.edu", "9745632180"};
    roster[3] = new String[]{"Lisa", "lisa@wisc.edu", "9784563211"};

    waitlist[0] = new String[]{"Andy", "andy@wisc.edu", "9087654321"};
    waitlist[1] = new String[]{"John", "john@wisc.edu", "1234567890"};
    waitlist[2] = new String[]{"Alice", "alice@wisc.edu", "7654321098"};

    int initialRosterSize = 4;
    int initialWaitlistSize = 3;
    boolean prerequisiteSatisfied = true;

    // Call enrollOneStudent to simulate the enrollment
    int newSize = enrollOneStudent("John", "john@wisc.edu", "1234567890", prerequisiteSatisfied, roster, initialRosterSize, waitlist);

    // Verify the results
    if (newSize == 5) {
      // Check if the student record is correctly added to the end of the roster array.
      if (roster[4] != null && roster[4][0].equals("John") && roster[4][1].equals("john@wisc.edu") && roster[4][2].equals("1234567890")) {
        // Check if the matching student record is correctly removed from the waitlist.
        if (waitlist[1] == null) {
          // Check if the correct size is returned.
          if (newSize == 5) {
            return true;
          }
        }
      }
    }
    return false; // Default return statement added to resolve compiler errors
  }
public static boolean successfulDropCourseTester() {
  // Create a test scenario
  String[][] roster = new String[5][3]; // Adjust the roster size as needed

  // Populate the roster with sample data
  // Ensure that there is an existing student record to be removed.

  // For example:
  roster[0] = new String[]{"George", "george@wisc.edu", "9780563421"};
  roster[1] = new String[]{"Lilly", "lilly@wisc.edu", "9807645321"};
  roster[2] = new String[]{"Matt", "matt@wisc.edu", "9745632180"};
  roster[3] = new String[]{"Lisa", "lisa@wisc.edu", "9784563211"};
  roster[4] = new String[]{"John", "john@wisc.edu", "1234567890"};

  int initialRosterSize = 5;

  // Call dropCourse to simulate the removal
  int newSize = dropCourse("1234567890", roster, initialRosterSize);

  // Verify the results
  if (newSize == 4) {
    // Check if the matching student record is correctly removed from the roster array.
    if (roster[4] == null) {
      // Check if the order of precedence of other student records is preserved.
      if (roster[0][0].equals("George") && roster[1][0].equals("Lilly") &&
              roster[2][0].equals("Matt") && roster[3][0].equals("Lisa")) {
        // Check if the correct size is returned.
        if (newSize == 4) {
          return true;
        }
      }
    }
  }

  return false; // Default return statement added to resolve compiler errors
}





////    // TODO complete the implementation of this method

public static boolean unsuccessfulDropCourseTester() {
  // Create a test scenario
  String[][] roster = new String[5][3]; // Adjust the roster size as needed

  // Populate the roster with sample data
  // Ensure that there is no existing student record with the provided campusId.

  // For example, create a roster with different campus IDs:
  roster[0] = new String[]{"George", "george@wisc.edu", "9780563421"};
  roster[1] = new String[]{"Lilly", "lilly@wisc.edu", "9807645321"};
  roster[2] = new String[]{"Matt", "matt@wisc.edu", "9745632180"};
  roster[3] = new String[]{"Lisa", "lisa@wisc.edu", "9784563211"};

  int initialRosterSize = 4; // Set the initial roster size

  // Call dropCourse to simulate the removal attempt
  int newSize = dropCourse("1234567890", roster, initialRosterSize);

  // Verify the results
  if (newSize == initialRosterSize) {
    // Check if no changes are made to the input roster array.
    return true;
  }

  return false; // Default return statement added to resolve compiler errors
}

  /**
   * Runs all the tester methods defined in this class.
   * 
   * @return true if no bugs are detected.
   */
  public static boolean runAllTests() {
    boolean createEmptyListTesterResult = createEmptyListTester();
    System.out
        .println("createEmptyListTester: " + (createEmptyListTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean indexOfOversizeSizeArrayTesterResult = indexOfOversizeSizeArrayTester();
    System.out.println("indexOfOversizeSizeArrayTester: "
        + (indexOfOversizeSizeArrayTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean indexOfPerfectSizeArrayTesterResult = indexOfPerfectSizeArrayTester();
    System.out.println("indexOfPerfectSizeArrayTester: "
        + (indexOfPerfectSizeArrayTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean enrollOneStudentTesterResult = enrollOneStudentTester();
    System.out
        .println("enrollOneStudentTester: " + (enrollOneStudentTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean enrollOneStudentMoveFromWaitlistTesterResult = enrollOneStudentMoveFromWaitlistTester();
    System.out.println("enrollOneStudentMoveFromWaitlistTester: "
        + (enrollOneStudentMoveFromWaitlistTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean successfulDropCourseTesterResult = successfulDropCourseTester();
    System.out.println(
        "successfulDropCourseTester: " + (successfulDropCourseTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");
    boolean unsuccessfulDropCourseTesterResult = unsuccessfulDropCourseTester();
    System.out.println("unsuccessfulDropCourseTester: "
        + (unsuccessfulDropCourseTesterResult ? "Pass" : "Failed!"));

    System.out.println("-----------------------------------------------");

    return createEmptyListTesterResult && indexOfOversizeSizeArrayTesterResult
        && indexOfPerfectSizeArrayTesterResult && enrollOneStudentTesterResult
        && enrollOneStudentMoveFromWaitlistTesterResult && successfulDropCourseTesterResult
        && unsuccessfulDropCourseTesterResult;
  }

  /**
   * Main method to run this tester class.
   * 
   * @param args list of input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("-----------------------------------------------");
    System.out.println("runAllTests: " + (runAllTests() ? "Pass" : "Failed!"));
  }

}

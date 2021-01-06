/*
* This program sorts a set of 250 or greater numbers located in an arraylist.
* It also allows for the user to choose a number to find in said arraylist, and 
* the arraylist will return the location of one instance of it in the list.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-11
*/

// Import the Scanner class
import java.util.Scanner;

public class BinarySearchMain {

  /**
  * This program sorts a set of 250 or greater numbers located in an arraylist.
  * It also allows for the user to choose a number to find in said arraylist, 
  * and the arraylist will return the location of one instance of it in the
  * list.
  */

  public static void main(String[] args) {

    // create scanner object
    Scanner userInput = new Scanner(System.in);
    
    /* 
    * create second scanner because the first one bugs out when being used 
    * with the finder method.
    */
    Scanner newScan = new Scanner(System.in);

    // references BinarySearcher class
    BinarySearcher classSearch = new BinarySearcher();

    // ensures that user inputs only integer values
    try {
      
      // calls numAdder method which generates random integers from 1-100
      System.out.println("Generating random integers...");
      System.out.println();
      classSearch.numAdder();

      // allows user to enter an input if they choose
      System.out.println("Would you like to enter an additional number?(Yes/No)");
      String extraNumCheck = userInput.nextLine();

      // converts input to upper to prevent case based errors
      String extraNumCheckUp = extraNumCheck.toUpperCase();

      // checks if user wants input new numbers
      if (extraNumCheckUp.equals("YES")) {
        System.out.println();

        // accepts input on how many integers program should accept
        System.out.println("Enter the amount of integers you wish to push: ");
        int numInput = userInput.nextInt();

        // checks if inputs are valid
        if (numInput < 1) {
          System.out.println("Invalid Input. Input only integers above 0"
                             + " Skipping...");
        } else {
          for (int counter = 0; counter < numInput; counter++) {
  
            // receive user input
            System.out.println("Enter an integer to push into the arraylist: ");
            int numberChosen = userInput.nextInt();
            System.out.println();
  
            // Pushes user input into arraylist in BinarySearcher 
            classSearch.push(numberChosen);
          }
          // tells user that their numbers were added
          System.out.println();
          System.out.println("Numbers accepted. continuing...");
          System.out.println();
        }

      // if they dont want to add numbers acknowledge their response
      } else if (extraNumCheckUp.equals("NO")) {
        System.out.println();
        System.out.println("Answer acknowledged, continuing ...");
        System.out.println();

      // if they input something wrong, tell them
      } else {
        System.out.println();
        System.out.println("Invalid input, presuming you dont want to "
                           + "enter extra numbers.");
        System.out.println();
      }
      
      // run list sorting method
      System.out.println("Sorting list....");
      System.out.println(classSearch.sorter());
      
      // receive user input on the number they wish to find
      System.out.println("Enter the number that you wish to find in the "
                         + "ArrayList: ");
      int searchNum = newScan.nextInt();

      // calls finder method and tells them where their number is located
      System.out.println();
      System.out.println("First determined location in array: " 
                         + classSearch.finder(searchNum));

      // states current values located in arraylist
      System.out.println();
      System.out.println(classSearch.currentArray());

    // catch invalid errors. this one for if null is returned.
    } catch (NullPointerException e) {
      System.out.println("Number chosen not present in arraylist!");
      System.out.println();
      System.out.println(classSearch.currentArray());
    // this one for general problems like bad user inputs
    } catch (Exception e) {
      System.out.println("Invalid Input");
    }
  }
}

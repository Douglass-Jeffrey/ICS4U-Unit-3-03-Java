/* 
* This class creates an arraylist and holds methods that add numbers to it,
* sort it, and eventually find a number in it, as well as print it out.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2020-12-11
*/

// Import the ArrayList class
import java.util.ArrayList;

public class BinarySearcher {
  
  // Private fields that will be used in methods
  private int amountOfNums;
  private int maxNum;
  private int topIndex;
  private int botIndex;
  private int midIndex;
  
  // Creates arraylist that will be filled with numbers
  private ArrayList<Integer> numArray = new ArrayList<Integer>();
  
  /**
  * Method for adding random numbers to list.
  */
  public BinarySearcher() {
    this.amountOfNums = 250;
    this.maxNum = 100;
    this.topIndex = numArray.size() - 1;
    this.botIndex = 0;
    this.midIndex = 0 ;
  }

  /**
  * Method for adding random numbers to list.
  */
  public void numAdder() {
    for (int counter = 0; counter < amountOfNums; counter++) {
      int randomInt = (int) (Math.random() * maxNum + 1);
      numArray.add(randomInt);
    }
  }

  /**
  * Method for adding user inputs to list.
  */
  public void push(int receivedNum) {
    numArray.add(receivedNum);
  }


  /**
   * method that sorts the user all values in the stack.
   */
  public String sorter() {
    String sortCheck = "Numbers sorted successfully!";
    // Sorting all numbers using a bubble sort.
    for (int sortCounter = 0; sortCounter < numArray.size(); sortCounter++) {
      for (int midCounter = (sortCounter + 1); midCounter < numArray.size();
           midCounter++) {
        if (numArray.get(sortCounter) > numArray.get(midCounter)) {
          int valHolder = numArray.get(sortCounter);
          numArray.set(sortCounter, numArray.get(midCounter));
          numArray.set(midCounter, valHolder);
        }
      }
    }
    return sortCheck;
  }

  /**
   * method that finds the users number in the sorted list.
   */
  public int finder(int searchNum) {

    this.midIndex = (int) Math.floor((botIndex + topIndex) / 2);
    if (searchNum > numArray.get(midIndex)) {
      this.botIndex = midIndex + 1; 
      return (finder(searchNum));

    } else if (searchNum < numArray.get(midIndex)) {
      this.topIndex = midIndex - 1;
      return (finder(searchNum));

    } else {
      // Returning the index spot of the number in the array
      return (midIndex + 1);
    }
  }


  /**
   * Getter that tells the user all values in the stack.
   */

  public String currentArray() {
    String arrayVal = "Current ArrayList: ";
    for (int counter = 0; counter < numArray.size(); counter++) {
      arrayVal = arrayVal + numArray.get(counter) + ", ";
    }
    return arrayVal;
  }
}


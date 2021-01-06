/* 
* This class creates an arraylist and holds methods   that add numbers to it,
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
  private int topIndex;
  private int botIndex;
  private int midIndex;
  
  // Creates arraylist that will be filled with numbers
  private ArrayList<Integer> numArray = new ArrayList<Integer>();

  /**
  * Method for adding random numbers to list.
  */
  public void numAdder() {
    for (int counter = 0; counter < 250; counter++) {
      int randomInt = (int) (Math.random() * 100 + 1);
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
  * Method for defining low bounds and high bounds of search. Begins search
  * at the end of the method.
  */
  public int searchFinder(int searchNum) {
    
    this.topIndex = numArray.size() - 1;
    this.botIndex = 0;
    return (finder(searchNum, topIndex, botIndex));
  }


  /**
   * method that finds the users number in the sorted list.
   */
  private int finder(int searchNum, int topIndex, int botIndex) {

    this.midIndex = (int) Math.floor((botIndex + topIndex) / 2);
    if (searchNum > numArray.get(midIndex)) {
      botIndex = midIndex + 1; 
      return (finder(searchNum, topIndex, botIndex));

    } else if (searchNum < numArray.get(midIndex)) {
      topIndex = midIndex - 1;
      return (finder(searchNum, topIndex, botIndex));

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


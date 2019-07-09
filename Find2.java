package comp1406a1;

/** Assignment 1 - Winter 2019
  * <p>
  * Problem 1
  * <p>
  * In the provided Find.java file, complete the locateSequence method.
  * For a given target sequence (non-empty array of integers), the method
  * searches the input array (of integers) to find an occurrence of the
  * target sequence if it is present. If the sequence is present, the
  * method returns the array index position of where it starts in the array.
  * If the sequence is not present, the method returns -1.
  */

public class Find{

  /** Finds the last occurrence of the sequence in the array or indicates that
    * the sequence is not present.
    *
    * @param sequence is an array of one or more integers.
    *        It is the target sequence we are looking for.
    *
    * @param array is an array integers.
    *
    * @return the starting position of the last occurrence of the target sequence in the
    *         array if it exists. Returns -1 otherwise.
    */

  public static int locateSequence(int[] sequence, int[] array){
    int counter = sequence.length - 1;
    int index = 0;
    if(sequence.length == 0 || array.length == 0 || sequence.length > array.length){
      return -1;
    }
    else{
      for(int i = array.length-1; i > -1; i--){
        index = i;
        if (sequence[counter] == (array[i])){
          counter -= 1;
        }
        else {
          counter = sequence.length - 1;
        }

        if (counter == -1){
          break;
        }

      }
      if (counter == -1){
        return index;
      }
      else {
        return -1;
      }
    }

  }
  public static void main(String [] args){
	  int[] sequence = {1,2,3,5,6,7,8,8,5};
    int[] array = {2,3,1,2,3,4,7,6};
    System.out.println(locateSequence(sequence, array));
  }

}

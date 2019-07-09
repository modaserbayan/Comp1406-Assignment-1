package comp1406a1;


public class FindAgain{


  public static int[] locateAllSequenceLocations(int[] target, int[] array){
    int counter = target.length - 1;
    int index = array.length;
    int occurence = 0;
    for(int i = array.length-1; i > -1; i--){
      index = i;
      if (target[counter] == (array[i])){
        counter--;
      }
      else {
        counter = target.length - 1;
      }

      if (counter == -1){
        occurence += 1;
        counter = target.length - 1;
      }

    }
    if (occurence > 0){
      int [] answer = new int[occurence + 1];
      answer[0] = occurence;
      int counter2 = target.length - 1;
      int index2 = 0;
      int locate = occurence;
      for(int i = array.length-1; i > -1; i--){
        index2 = i;
        if (target[counter2] == (array[i])){
          counter2--;
        }
        else {
          counter2 = target.length - 1;
        }

        if (counter2 == -1){
          answer[locate] = index2;
          locate -= 1;
          counter2 = target.length - 1;
        }
    }
    return answer;
    }
    else {
      int [] answer = new int[1];
      answer[0] = 0;
      return answer;
    }
  }

}

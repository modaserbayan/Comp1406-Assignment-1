package comp1406a1;
/** Assignment 1 - Winter 2019
  * <p>
  * Problem 3
  * <p> In the provided Grades.java files, complete the finalExamGradeNeeded method.
  * <p>
  * This method takes several input parameters: a target letter grade (String),
  * a list of assignment grades (double[]), a list of tutorial grades (double[])
  * and a list of midterm grades (double[]).
  * <p>
  * The method returns the minimum grade needed on the final exam to achieve the
  * target letter grade based on the other input grades.
  * <p>
  * You must use the grading scheme as specified in the course outline.
  * Be careful to read and understand the condition for passing the course.
  * If the needed final exam grade is more than 100.0, then the method should return -1.0.
  * If the target grade will be achieved (or surpassed) regardless of the final exam mark,
  * the method should return 0.0.
  */


public class Grades{

  /** Computes the minimum final exam grade needed to achieve a desired
    * target letter grade based on provided assignment, tutorial and midterm
    * grades.
    * <p>
    * The Grade determination is based on that given in the course outline.
    * (See Piazza and be sure to read the course outline!)
    *
    * @param target is the desired letter grade.
    * @param assignments contains all nine assignment grades (each out of 100). The first six are the main assignments and the last three are the study assignments.
    * @param tutorials contains all 10 tutorial grades (each out of 100).
    * @param midterms contains all 3 midterm grades (each out of 100).
    *
    * @return the minimum grade needed to achieve the target letter grade based on
    *         the provided assignment/tutorial/midterm grades and the description
    *         provided in the course outline. If the needed final exam grade is more
    *         than 100.0, return -1.0. If the target grade will be achieved (or surpassed)
    *         regardless of the final exam mark, returns 0.0.
    */
  public static double finalExamGradeNeeded(String   target,
                                            double[] assignments,
                                            double[] tutorials,
                                            double[] midterms){

       int goal = 0;
       switch (target) {
           case "A+":
               goal = 90;
               break;
           case "A":
               goal = 85;
               break;
           case "A-":
               goal = 80;
               break;
           case "B+":
               goal = 77;
               break;
           case "B":
               goal = 73;
               break;
           case "B-":
               goal = 70;
               break;
           case "C+":
               goal = 67;
               break;
           case "C":
               goal = 63;
               break;
           case "C-":
               goal = 60;
               break;
           case "D+":
               goal = 57;
               break;
           case "D":
               goal = 53;
               break;
           case "D-":
               goal = 50;
               break;
           case "F":
                   goal = 49;
               break;

       }

//assignment grade calculation
       double assignmentgrade = 0;
       for(int i = 0; i<6;i++){
         assignmentgrade += assignments[i];
       }
       assignmentgrade = (assignmentgrade/6)*0.3;

//studyassignment grade calculation
       double studygrade = 0;
       double marka = assignments[6];
       double markb = -1;
       for(int x = 7; x < 9; x++){
         if(assignments[x] > marka){
           markb = marka;
           marka = assignments[x];
         }
         else if(assignments[x]>markb){
           markb = assignments[x];
         }
       }
       studygrade = ((marka + markb)/2)*0.02;


//tutorial grade calculation
       double tutorialgrade = 0;
       double[] top8 = new double[8];
       double max = 0;
       int ind = 0;
       for(int j=0; j<8;j++){
         max = 0;
         for(int i = 0; i < 10;i++){
           if(max<tutorials[i]){
             max = tutorials[i];
             ind = i;
           }
         }
         top8[j] = max;
         tutorials[ind] = 0;
       }
       for(int i = 0; i < top8.length; i++){
         tutorialgrade += top8[i];
       }
       tutorialgrade = (tutorialgrade/8)*0.08;

//midterm grade calculation
       double midtermgrade = 0;
       double mark1 = midterms[0];
       double mark2 = -1;
       for(int x = 1; x < 3; x++){
         if(midterms[x] > mark1){
           mark2 = mark1;
           mark1 = midterms[x];
         }
         else if(midterms[x]>mark2){
           mark2 = midterms[x];
         }
       }
       midtermgrade = ((mark1 + mark2)/2)*0.3;

//required mark on final to achieve goal grade
       double combinedgrade = midtermgrade + tutorialgrade + studygrade + assignmentgrade;
       double required1 = goal - combinedgrade;
       required1 = (required1/30)*100;

       double required2 = 30 - midtermgrade;
       required2 = (required2/30)*100;



       if(required1 >= required2){
         double finalexam = required1;
         if(finalexam>100){
           return -1;
         }
         else if(finalexam<0){
           return 0;
         }
         else{
           return finalexam;
         }
       }
       else{
         double finalexam = required2;
         if(finalexam>100){
           return -1;
         }
         else if(finalexam<0){
           return 0;
         }
         else{
           return finalexam;
         }
       }


  }
  public static void main(String [] args){
    double[] assignments = {100, 100, 94, 100, 100, 100, 100, 100, 100};
    double[] tutorials = {100, 100, 100, 100, 100, 100, 100, 100, 0, 0};
    double[] midterms = {86.25,85,90};
    String target = "A+";
    System.out.println(finalExamGradeNeeded(target,assignments,tutorials,midterms));
  }



}

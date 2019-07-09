package comp1406a1;

/** Assignment 1 - Winter 2019
  * <p>
  * Problem 4
  * <p>
  * In this problem, you will complete three methods to check if a SUDOKU game is valid or not.
  */
  public class SudokuChecker{



  	/** checks if row 'row' is OK in the grid */
    public static boolean checkRow(int row, byte[][] grid){
      boolean checker = false;
      for(int i = 1; i< 10;i++){
        checker = false;
        for(int x = 0; x < 9; x++){
          if(grid[row][x] == i){
            checker = true;
            break;
          }
        }
        if(checker == false){
          break;
        }
      }

      return checker;
    }

  	/** checks if column 'col' is OK in the grid */
    public static boolean checkColumn(int col, byte[][] grid){
      boolean checker1 = false;
      for(int i = 1; i< 10;i++){
        checker1 = false;
        for(int x = 0; x < 9; x++){
          if(grid[x][col] == i){
            checker1 = true;
            break;
          }
        }
        if(checker1 == false){
          break;
        }
      }
      return checker1;
    }

  	/** checks if the subregion 'region' is OK in the grid */
    public static boolean checkSubregion(int region, byte[][] grid){
      boolean checker2 = false;
      for(int i = 1; i <10; i++){
        checker2 = false;

        if(region < 3){
          for(int z = 0; z < 3; z++){
            for(int x = 0+3*region; x < 3+3*region; x++){
              if(grid[z][x] == i){
                checker2 = true;
                break;
              }
            }
          }
          if(checker2 == false){
            break;
          }
        }

        else if(region < 6){
          for(int z = 3; z < 6; z++){
            for(int x = 0+3*(region-3); x < 3+3*(region-3); x++){
              if(grid[z][x] == i){
                checker2 = true;
                break;
              }
            }
          }
          if(checker2 == false){
            break;
          }
        }

        else{
          for(int z = 6; z < 9; z++){
            for(int x = 0+3*(region-6); x < 3+3*(region-6); x++){
              if(grid[z][x] == i){
                checker2 = true;
                break;
              }
            }
          }
          if(checker2 == false){
            break;
          }
        }
      }
      return checker2;
    }


    public static boolean check(byte[][] grid){
      // check the subregions
      for(int subregion=0; subregion<9; subregion+=1){
        if( !checkSubregion(subregion, grid) ){
          return false;
        }
      }

      // check the rows
      for(int row=0; row<9; row+=1){
        if( !checkRow(row, grid) ){
          return false;
        }
      }

     // check the columns
     for(int col=0; col<9; col+=1){
        if( !checkColumn(col, grid) ){
          return false;
        }
      }


  		// if we get this far then we conclude that the grid
  		// must be valid (because if it was not, we would have
  		// returned false somewhere above)
      return true;
    }






      /** sample valid game */
    public static byte[][] example1 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,4},
      {2,8,7,4,1,9,6,3,5},
      {3,4,5,2,8,6,1,7,9}};

    /** sample invalid game */
    public static byte[][] example2 = new byte[][]{
      {5,3,4,6,7,8,9,1,2},
      {6,7,2,1,9,5,3,4,8},
      {1,9,8,3,4,2,5,6,7},
      {8,5,9,7,6,1,4,2,3},
      {4,2,6,8,5,3,7,9,1},
      {7,1,3,9,2,4,8,5,6},
      {9,6,1,5,3,7,2,8,3},
      {2,8,7,4,1,9,6,2,6},
      {3,4,5,2,8,6,1,8,8}};

      public static void main(String[] args){
        byte[][] example2 = new byte[][]{
          {5,4,4,6,7,8,9,0,2},
          {6,7,2,1,9,5,3,4,8},
          {1,9,8,3,4,2,5,6,7},
          {8,5,8,7,6,1,4,2,3},
          {4,2,6,8,5,3,7,9,1},
          {7,1,3,9,2,4,8,5,6},
          {10,6,1,5,3,7,2,8,3},
          {2,8,7,4,1,9,6,2,6},
          {3,4,5,2,8,6,1,8,8}};
          System.out.println(checkRow(0, example2));
        /*System.out.print("exmample1 | expected output is true  | actual output is ");
        System.out.println(check(example1));

        System.out.print("exmample2 | expected output is false | actual output is ");
        System.out.println(check(example2));*/

      }

  }

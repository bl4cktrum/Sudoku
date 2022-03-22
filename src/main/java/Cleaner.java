/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BL4CKTRUM
 */
import java.util.Arrays;

public class Cleaner {
    private int counter = 0;
    private final Solver solver4Del= new Solver();

    /**
     *
     * @param grid is will be cleaned grid.
     * @return cleaned grid to introduce.
     */
    protected int[][] cleanFull(int [][]grid) {
        /**
         int a=grid.length;
         int b=grid[1].length;
         **/
        //start with random location(random x index, random y index)
        int row = (((int)(Math.random()*10))%9);
        int col = (((int)(Math.random()*10))%9);
        del(row,col,grid);
        return grid;
    }



    /**
     * Delete cells recursively
     * @param row current row index.
     * @param col current column index.
     * @return false if Sudoku was not cleaned. true if Sudoku is cleaned.
     */
    private boolean del(int row,int col,int[][] grid) {
        int initiateclue = DifficultySelectionScreen.getInitiateClue();
        boolean okay = false;
        while (!okay) {

            if (initiateclue == 17) {
                //Delete 64 cells to give 17 clue.
                if (counter == 64) {
                    okay = true;
                    return true;
                }
            } else {//Delete 56 cells to give 25 clue.
                if (counter == 56) {
                    okay = true;
                    return true;
                }
            }

            //if already cell has no value, try another random cell.
            if (grid[row][col] == 0) {
                del((((int) (Math.random() * 10)) % 9), (((int) (Math.random() * 10)) % 9), grid);
                return true;
            } else {
                //Deep copy to dont effect the solution.
                //copyGrid for the solve method
                //copyGrid2 for the isUnique method.
                int[][] copyGrid = new int[9][9];
                int[][] copyGrid2 = new int[9][9];
                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        copyGrid[i][j] = grid[i][j];
                        copyGrid2[i][j] = grid[i][j];
                    }
                }
                int backup = grid[row][col];
                copyGrid[row][col] = 0;
                copyGrid2[row][col] = 0;

                if (solver4Del.solve(0, 0, copyGrid)) { /// HAVE2ADD (&& isUNIQUE?)Current isUnique method doesnt working !!!!!!!!!!!!!!!
                    grid[row][col] = 0;
                    counter++;
                    if (del((((int) (Math.random() * 10)) % 9), (((int) (Math.random() * 10)) % 9), grid))
                        return true;
                    else {
                        grid[row][col] = backup;
                        return false;
                    }
                }
            }
        }
        return true;
    }

    //To compare to figure out solutioun is unique or not.
    private int[][] solve2array(int[][]grid){
        solver4Del.solve(0,0,grid);
        return grid;
    }

    /**
     * @param grid is current grid.
     * copy the grid, send them to solve2array() and get back solved grids as arrays. then compare them.
     * @return true if solved grids are equals, false if solved grids are not equals.
     */
    private boolean isUnique(int[][]grid){
        int[][] copyOfGrid = new int[9][9];
        for(int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                copyOfGrid[i][j] = grid[i][j];
            }
        }if (Arrays.equals(solve2array(grid),solve2array(copyOfGrid))) return true;
        else return false;
    }

}

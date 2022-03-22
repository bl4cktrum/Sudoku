/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BL4CKTRUM
 */
import java.util.ArrayList;
import java.util.Collections;

public class Solver {

    /**
     * generate a completely solved sudoku board with give 9x9 multidimensional Array
     * @return soduku grid generated fully.
     */
    protected int[][] generateFull() {
        int[][] grid = new int[9][9];
        /** set all values of puzzle to 0
         * 0 denotes an empty square
         */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = 0;
            }
        }
        /** start solving the board at the first square
         */
        solve(0, 0,grid);
        return grid;
    }


    /**
     * Solve Sudoku recursively.
     * @param row current row index.
     * @param col current column index.
     * @return false if Sudoku was not solved. true if Sudoku is solved.
     */
    protected boolean solve(int row, int col, int[][] grid) {

        // If it has passed through all cells, start quitting
        if (row == 9)
            return true;

        // If this cell is already set(fixed), skip to the next cell
        if (grid[row][col] != 0) {
            if (solve(col == 8? (row + 1): row, (col + 1) % 9,grid))
                return true;
        }
        else {
            // Random numbers 1 - 9
            Integer[] randoms = generateRandomNumbers();
            for (int i = 0; i < 9; i++) {

                // If no duplicates in this row, column, 3x3, assign the value and go to the next
                if (!containedInRowCol(row, col, randoms[i],grid) &&
                        !containedIn3x3Box(row, col, randoms[i],grid)) {
                    grid[row][col] = randoms[i];

                    // Move to the next cell left-to-right and top-to-bottom
                    if (solve(col == 8? (row + 1) : row, (col + 1) % 9,grid))
                        return true;
                    else { // Initialize the cell when backtracking (case when the value in the next cell was not valid)
                        grid[row][col] = 0;
                    }
                }
            }
        }
        return false;
    }



    /**
     * Check if a value contains in its 3x3 box for a cell.
     * @param row current row index.
     * @param col current column index.
     * @return true if this cell is incorrect or duplicated in its 3x3 box.
     */
    private boolean containedIn3x3Box(int row, int col, int value,int[][]grid) {
        // Find the top left of its 3x3 box to start validating from
        int startRow = row / 3 * 3;
        int startCol = col / 3 * 3;

        // Check within its 3x3 box except its cell
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++) {
                if (!(i == row && j == col)) {
                    if (grid[i][j] == value){
                        return true;
                    }
                }
            }
        return false;
    }

    /**
     * Check if a value is contained within its row and column.
     * Used when solving the puzzle.
     * @param row current row index.
     * @param col current column index.
     * @param value value in this cell.
     * @return true if this value is duplicated in its row and column.
     */
    private boolean containedInRowCol(int row, int col, int value,int[][]grid) {
        for (int i = 0; i < 9; i++) {
            // Don't check the same cell
            if (i != col)
                if (grid[row][i] == value)
                    return true;
            if (i != row)
                if (grid[i][col] == value)
                    return true;
        }
        return false;
    }

    /**
     * Generate 9 unique random numbers.
     * @return array containing 9 random unique numbers.
     */
    protected Integer[] generateRandomNumbers() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 9; i++)
            randoms.add(i + 1);
        Collections.shuffle(randoms);
        return randoms.toArray(new Integer[9]);
    }
}
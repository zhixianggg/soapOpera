/*
Name: Oon Zhi Xiang
Matric No. :
*/

import java.util.*;

public class SO12_2048{ 
    public static void main(String[] args) {

        int[][] board = readInput();
        printBoard(board);
    }
    
    //Returns the board array after it has been shifted
    public static int[][] readInput() {

        int[][] board = new int[4][4];

        Scanner sc = new Scanner(System.in);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = sc.nextInt();
            }
        }

        //d represents the move.
        //"0" represents shiftLeft,
        //"1" represents shiftUp,
        //"2" represents shiftRight,
        //"3" represents shiftDown
        int d  = sc.nextInt();
        
        if (d == 0) {
            shiftLeft(board);
        } else if (d == 1) {
            shiftUp(board);
        } else if (d == 2) {
            shiftRight(board);
        } else {
            shiftDown(board);
        }
        
        return board;
    }

    //Performs the move, shiftLeft on board
    public static void shiftLeft(int[][] board) {
        
        for (int row = 0; row < board.length; row++ ) {
            for (int col = 0; col < board[row].length-1; col++) {
                boolean merged = false;
                for (int i = col +1; i < board[row].length; i++) {
                    if (board[row][col] != 0 
                        && !merged
                        && board[row][col] == board[row][i]
                        && checkObstacle(board,row,col,row,i)) {
                        merge(board,row,col,row,i);
                        merged = true;
                    } else if (board[row][col] == 0 
                            && board[row][i] != 0) {
                        swap(board,row,col,row,i);
                    }
                }
            }
        }
    }
    

    //Perform the move, shiftUp on board
    public static void shiftUp(int[][] board) { 
        for (int col = 0; col < board.length; col++) {
            for (int row = 0; row < board.length -1; row++) {
                boolean merged = false;
                for (int i = row+1; i < board.length; i++) {
                    if (board[row][col] != 0
                        && !merged
                        && board[row][col] == board[i][col]
                        && checkObstacle(board,row,col,i,col)) {
                        merge(board,row,col,i,col);
                        merged = true;
                    } else if (board[row][col] == 0
                            && board[i][col] != 0) {
                        swap(board,row,col,i,col);
                    }
                }
            }
        }
    }
    
    //returns true if there are numbers that prevent a merge 
    // in between board[row1][col1] and board[row2][col2]
    public static boolean checkObstacle(int[][] board, int row1, int col1, int row2, int col2) {
        
        if (row1 == row2) {
            if (col1 > col2) {
                int temp = col1;
                col1 = col2;
                col2 = temp;
            }
            for (int i = col1 + 1; i < col2; i++) {
                if (board[row1][i] != 0) {
                    return false;
                }
            }
        } else { //col1 == col2
            
            if (row1 > row2) {
                int temp = row1;
                row1 = row2;
                row2 = temp;
            }

            for (int i = row1 +1; i < row2; i++) {
                if (board[i][col1] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Performs the move shiftRight on board
    public static void shiftRight(int[][] board) {
        for (int row = board.length-1; row >= 0; row--) {
            for (int col = board.length -1 ; col > 0; col--) {
                boolean merged = false;
                for (int i = col - 1; i >= 0; i--) {
                    if (board[row][col] != 0
                        && !merged
                        && board[row][col] == board[row][i]
                        && checkObstacle(board,row,col,row,i)) {
                        merge(board,row,col,row,i);
                        merged = true;
                    } else if (board[row][col] == 0
                            && board[row][i] != 0) {
                        swap(board,row,col,row,i);
                    }
                }
            }
        }
    }
    
    //Performs the move shiftDown on board
    public static void shiftDown(int[][] board) {
        for (int col = 0; col < board.length; col++) {
            for (int row = board.length-1; row > 0; row--) {
                boolean merged = false;
                for (int i = row -1; i >= 0; i--) {
                    if (board[row][col] != 0
                        && !merged
                        && board[row][col] == board[i][col]
                        && checkObstacle(board,row,col,i,col)) {
                        merge(board,row,col,i,col);
                        merged = true;
                    } else if (board[row][col] == 0
                            && board[i][col] != 0) {
                        swap(board,row,col,i,col);
                    }
                }
            }
        }
    }
    
    //Performs a merge between board[row1][col1] and board[row2][col2]
    // board[row2][col2] will become 0.
    public static void merge(int[][] board, int row1, int col1, int row2,int col2) {
        board[row1][col1] *= 2;
        board[row2][col2] = 0;
    }
    
    //Performs a swap between board[row1][col1] and board[row2][col2]
    public static void swap(int[][] board, int row1, int col1, int row2, int col2) {
        int temp = board[row1][col1];
        board[row1][col1] = board[row2][col2];
        board[row2][col2] = temp;
    }
    
    //Prints output of board
    public static void printBoard(int[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col]);
                if (col != board[row].length -1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}



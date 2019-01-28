import java.util.*;

//Generate a N*N magic square where N is an odd number
class SO11_MagicNumber {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Validate Input
        while (n % 2 != 1) {
            n = sc.nextInt();
        }
        int[][] magicSquare = getMagicSquare(n);

        printOutput(magicSquare);
    }
    
    //Solve for magicSquare
    public static int[][] getMagicSquare(int n) {
        int[][] arr = new int[n][n];

        int row = 0;
        //col = middleIndex of the entire row
        int col = ((n+1) / 2 ) - 1;
        for (int i = 1; i <= n*n ; i++) {
            arr[row][col] = i;
            if (checkEmpty(arr,row-1,col+1)) {
                row = wrapAround(row-1,n);
                col = wrapAround(col+1,n);
            } else {
                row = wrapAround(row+1,n);
            }
        }
        return arr;
        
    }
    
    //Return true if  arr[row][col] is empty. 
    public static boolean checkEmpty(int[][] arr, int row, int col) {
        row = wrapAround(row, arr.length);
        col = wrapAround(col, arr.length);
        if (arr[row][col] == 0) {
            return true;
        }
        return false;
    }
    
    //Return the correct row/col that is adjusted after wrapAround
    //e.g. if num = 3 and size = 3, return value will be 0.
    public static int wrapAround(int num, int size) {
        if (num < 0) {
            num += size;
        } else if (num >= size) {
            num -= size;
        }
        return num;
    }
    
    //Print output in arr
    public static void printOutput(int[][] arr) {
        for (int row = 0; row < arr.length;row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]);
                if (col != arr[row].length -1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

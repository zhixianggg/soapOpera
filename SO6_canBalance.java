import java.util.*;

class SO6_canBalance {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] a ={1,1,1,2,1}; 
        int[] b = {2,1,1,2,1};
        int[] c = {10,10};
        //Array must have at least 2 elements
        System.out.println(canBalance(a));
        System.out.println(canBalance(b));
        System.out.println(canBalance(c));
    }
    //
    //Return true if there is a place to split the array
    // so that sum of numbers on LHS = sum of numbers on RHS
    //LHS: Left Hand Side
    //RHS: Right Hand Side
   public static boolean canBalance(int[] arr) {
        
        //Loop from first element to second last element
        //because there must be at least 1 element on LHS and RHS each.
        for (int i = 0; i < arr.length - 1; i++) {
            //get Sum of Left Hand Side
            int sumLHS = getSum(arr,0,i);

            //get Sum of Right Hand Side
            int sumRHS = getSum(arr,i+1,arr.length-1);
            if (sumLHS == sumRHS) {
                return true;
            }
        }
        return false;
    }
    
    //Return sum of elements from startIdx to endIdx in array
    public static int getSum(int[] arr, int startIdx, int endIdx) {
        
        
        int sum = 0;
        for (int i = startIdx; i <= endIdx; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

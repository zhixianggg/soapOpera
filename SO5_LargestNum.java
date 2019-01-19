// Author: Oon Zhi Xiang
// Given a list of non-negative Integers, arrange them such that they form the largest possible number.

import java.util.*;

public class SO5_LargestNum {
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
    
        System.out.print("Enter the Integers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortArray(arr);
        
        int largest = getLargestNum(arr);
		
        System.out.println("Largest number that can be formed: " + largest);
    }

    public static void sortArray(int[] arr) {
        
        for (int end = arr.length - 1; end > 0; end--) {
            
            for (int i = 0; i < end; i++) {
                if (checkSwap(arr[i],arr[i+1])) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    public static boolean checkSwap(int num1, int num2) {
      
        
        //get length of num1
        int length1 = getLength(num1);
        String str1 = Integer.toString(num1);
        
        //get length of num2
        int length2 = getLength(num2);
        String str2 = Integer.toString(num2);
        
        String permutation1 = str1+str2;
        String permutation2 = str2+str1;
        
        if (Integer.valueOf(permutation1)> Integer.valueOf(permutation2)) {
        	return true;
        }
        return false;
    }

    public static int getLength(int num) {
        String numString = Integer.toString(num);
        return numString.length();

    }
    
	
    public static int getLargestNum(int[] arr) {
		
		int result = 0;
		int multiplier = 1;
		for (int i = 0 ; i < arr.length; i++) {
			result += arr[i] * multiplier;
			multiplier *= Math.pow(10,getLength(arr[i]));
		}	
		return result;

	}
}

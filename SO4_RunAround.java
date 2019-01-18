import java.util.*;

public class SO4_RunAround {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter N digits, each of which is between 1 and 9, inclusively: ");
    int num = sc.nextInt();
    
    while (! checkValidNum(num)) {
       System.out.print("Enter N digits, each of which is between 1 and 9, inclusively: ");
       num = sc.nextInt();
   
    }
    boolean runAround = checkRunAroundNum(num);
    if (runAround) {
      System.out.println("Number is a run-around number");
    } else {
      System.out.println("Number is not a run-around number");
    }
  }
  
  //Returns true if number is valid or false otherwise.
  public static boolean checkValidNum(int num) {
    String numString = Integer.toString(num);
    int[] numArr = new int[numString.length()];
    //Store digits in num in numArr
    for (int i = 0; i < numString.length(); i++) {
      if (!Character.isDigit(numString.charAt(i))) {
        return false;  
      }
      numArr[i] = Character.getNumericValue(numString.charAt(i));
    }
    //Return false if there are duplicate digits and zeroes
    for (int i = 0; i < numString.length() - 1;i++){
      for (int j = i + 1; j < numString.length(); j++ ) {
        
        if (numArr[i] == numArr[j]||numArr[i] == 0||numArr[j] == 0 ) {
           return false;        
        }
      }
    }
    return true;
  }

  //Returns true if number is a run-around number or false otherwise.
  public static boolean checkRunAroundNum(int num) {
    int[] countArr = getCountArr(num);
    int[] checkArr = new int[9];
    String numString = Integer.toString(num);
    int index = 0;
    //Count to the right and add to the checkArr 
    // which is a counter for digits 1-9 to track which digits the counting stops at
    for (int i = 0 ; i < numString.length();i++) {
      index = (index +  Character.getNumericValue(numString.charAt(index)))  % numString.length();
      checkArr[Character.getNumericValue(numString.charAt(index))-1]++;
    }
    for (int i = 0; i < 9; i++) {
      if (countArr[i] != checkArr[i]) {
        return false;
      }
    }
    return true;
  }
  
  
  //Returns an array that counts the number of times a digit appears in num. 
  // index 0 refers to 1, index 1 refers to 2,... index 8 refers to 9.
  public static int[] getCountArr(int num) {
    int[] countArr = new int[9];
    while (num != 0) {
      countArr[(num%10)-1]++;
      num /= 10;
    }
    return countArr;
  }
}

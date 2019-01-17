import java.util.*;

class SO3_Arrange {
  
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a 4 digit number: ");
    int num = sc.nextInt();
    
    if (num >9999 || num <1000) {
      System.out.print("Enter a 4 digit number: ");
      num = sc.nextInt();
    }
    if (! checkValidNum(num)) {
      System.out.println("Number is invalid");
    } else {
      int largestNum = getLargestNum(num);
      int smallestNum = getSmallestNum(num);

      System.out.println("Largest number: "+ largestNum);
      System.out.println("Smallest number: " + smallestNum);      


    }
  } 

  public static int[] getCountArr(int num) {
    int[] countArr = new int[10];
    while (num != 0) {
      countArr[num%10]++;
      num /= 10;
    }
    return countArr;
  }

  public static boolean checkValidNum(int num) {
    
    int[] countArr = getCountArr(num);
    for (int i = 0; i < 10; i++) {
      if (countArr[i] == 4) {
        return false;
      }
    }
    return true;
  }

  public static int getLargestNum(int num){
    int[] countArr = getCountArr(num);
    int result = 0;
    int multiplier = 1;
    for (int i = 9; i >= 0; i--) {
      while (countArr[i] > 0) {
        result += multiplier * i;
        multiplier *= 10;
        countArr[i]--;
      }
    }
    return result;
      
  }
  
  public static int getSmallestNum(int num){
    int[] countArr = getCountArr(num);
    int result = 0;
    int multiplier = 1;
    for (int i = 0; i < 10; i++) {
      while (countArr[i] > 0) {
        result += multiplier * i;
        multiplier *= 10;
        countArr[i]--;
      }
    }
    return result;
 }
}

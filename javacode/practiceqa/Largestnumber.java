package shivam.javacode.practiceqa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Largestnumber {
 public static void main(String[] srgs)
 {
     Scanner sc = new Scanner(System.in);
     System.out.println("total number in array");
     int n = sc.nextInt();
     System.out.println("kth number");
     int k = sc.nextInt();

     int[] arr = new int[n];
     for(int i=0;i<arr.length;i++)
     {
         arr[i]=sc.nextInt();
     }
       Arrays.sort(arr);
     if(k<arr.length) {
         System.out.println("smallest kth number" + arr[k]);
         System.out.println("largest kth number" + arr[n - k]);
     }
 }
}

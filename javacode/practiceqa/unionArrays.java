package shivam.javacode.practiceqa;

import java.util.HashSet;
import java.util.Scanner;

public class unionArrays {
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("first array count");
        int n1 = sc.nextInt();
        System.out.println("enter values");
        int[] arr1 = new int[n1];
        for(int i=0;i<arr1.length;i++)
        {
            arr1[i]=sc.nextInt();
        }
        System.out.println("second array count");
        int n2 = sc.nextInt();
        System.out.println("enter values");
        int[] arr2 = new int[n2];
        for(int i=0;i<arr1.length;i++)
        {
            arr2[i]=sc.nextInt();
        }

        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            s.add(arr1[i]);
        }

        for (int i = 0; i < n2; i++) {
            s.add(arr2[i]);
        }

        System.out.print(s.toString() + " ");

    }
}

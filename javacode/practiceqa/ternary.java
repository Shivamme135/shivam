package shivam.javacode.practiceqa;

import java.util.Scanner;

public class ternary {
    public static void main(String[] args)
    {
        int first, second, third, largest, temp;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        first = s.nextInt();
        System.out.print("Enter the second number: ");
        second = s.nextInt();
        System.out.print("Enter the third number: ");
        third= s.nextInt();
        temp = ( first > second ? first : second ) ;
        largest = ( third > temp ? third : temp ) ;
        System.out.println("Largest number: " + largest);
    }
}

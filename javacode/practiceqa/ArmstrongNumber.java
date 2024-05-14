package shivam.javacode.practiceqa;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int Number = sc.nextInt();
        int temp = Number;
        int last = Number;
        int rem;
        int countNumber = 0;
        int sum =0;

        while(Number>0)
        {
            Number = Number/10;
            countNumber++;
        }
        System.out.println("number of digit in the Number " + countNumber);

        for(int i=1;i<=countNumber;i++)
        {
            rem = temp%10;
            sum += Math.pow(rem,countNumber);
            temp = temp/10;
        }
        System.out.println(sum);
        if(sum==last)
        {
            System.out.println(last + " is a Armstrong Number");
        }
        System.out.println(last+ " is not a ArmStrong Number");

        }


    }


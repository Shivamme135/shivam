package shivam.javacode.practiceqa;

import java.util.Scanner;

public class Factorial {

    static int factorial(int n)
    {
        if(n==0)
        {
            return 1;
        }
        else{
            return (n*factorial(n-1));
        }
    }


    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      int Number = sc.nextInt();
      System.out.println("factorial of " + Number +" is "+factorial(Number));
    }
}


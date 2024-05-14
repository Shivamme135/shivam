package shivam.javacode.practiceqa;

import java.util.Scanner;

public class primeNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count;
        int total = 0;

        for (int i = 1; i < num; i++) {
            count = 0;
            for (int j = 2; j < num / 2; j++) {
                if (i % j == 0) {
                    count++;
                    break;
                }
            }

            if (count == 0) {
                System.out.println(i + "= is a prime number between 1 to " + num);
                total++;
            }
        }
        System.out.println("total prime number between 1 to "+ num + " is " + total);
    }
}

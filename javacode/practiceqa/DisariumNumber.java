package shivam.javacode.practiceqa;

import java.util.Scanner;

public class DisariumNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Number = sc.nextInt();
        int temp = Number;
        int last = Number;
        int rem;
        int countNumber = 0;
        int sum = 0;

        while (Number > 0) {
            Number = Number / 10;
            countNumber++;
        }
        System.out.println("number of digit in the Number " + countNumber);
        while(countNumber>0) {
            rem = temp % 10;
            sum += Math.pow(rem,countNumber);
            temp = temp / 10;
            countNumber--;
        }
        System.out.println(sum);
        if (sum == last) {
            System.out.println(last + " is a DisariumNumber");
        }
        else {
            System.out.println(last + " is not a DisariumNumber");
        }

    }

}

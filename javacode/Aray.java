package shivam.javacode;

import java.util.*;
public class Aray {
    public static void main (String[]args)
    {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();

        int array[][] = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                array[i][j]=sc.nextInt();
            }
        }
//        this is for printlnig an array2
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println("");
        }

        System.out.println("this is for transpose");

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                System.out.print(array[j][i]+ " ");
            }
            System.out.println("");
        }

        System.out.println("this is for printlng diagonal elements");

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(i==j) {
                    System.out.print(array[j][i] + " ");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println("");
        }

        System.out.println("diagonal from right to left");

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(i+j==a-1) {
                    System.out.print(array[j][i] + " ");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println("");
        }

        System.out.println("printlng right triangle in the matrix");

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(i+j>=a-1) {
                    System.out.print(array[j][i] + " ");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println("");
        }

        System.out.println("printing left part");

        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                if(i+j<a-1) {
                    System.out.print(array[j][i] + " ");
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println("");
        }
    }
}

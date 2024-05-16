package shivam.javacode.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayList1 {


    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> arraylist1 = new ArrayList<>();
        Person cl = new Person(6,"shivam","manager");
        Person c2 = new Person(5,"mishra","hero");
        Person c3 = new Person(sc.nextInt(), sc.next(), sc.next());

        arraylist1.add(cl);
        arraylist1.add(c2);
        arraylist1.add(c3);
//        arraylist1.remove(c2);

        System.out.println(arraylist1);


        Collections.sort(arraylist1, new PersonComparator());
        System.out.println("sorted list " + arraylist1);
    }
}

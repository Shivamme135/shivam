package shivam.javacode.collection;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person>
{

    @Override
    public int compare(Person c1, Person c2 ) {
        return  c1.geteId() - c2.geteId();
    }
}

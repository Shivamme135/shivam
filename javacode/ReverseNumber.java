package shivam.javacode;

public class ReverseNumber{
public static void main(String[] args)
{
    int x = 5;
    System.out.println("value of x="+x);
    int y = 6;
    System.out.println("value of y="+y);

    x = x + y;
    y = x - y;
    System.out.println("reverse value of y = "+y);
    x = x - y;
    System.out.println("resverse value of x = "+x);


}
}
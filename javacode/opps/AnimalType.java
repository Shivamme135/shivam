package shivam.javacode.opps;

interface Animal {
    public void eat();
    public void grow();
    public void run();
}

abstract class Herbivores implements Animal{

    @Override
    public void eat() {
        System.out.println("eating plants");
    }

    @Override
    public void grow() {
        System.out.println("herbivores is growing");
    }
}

abstract class Carnivores implements Animal{

    @Override
    public void eat() {
        System.out.println("eating meat");
    }

    @Override
    public void grow() {
        System.out.println("carnivores is growing");
    }
}


abstract class Omnivores implements Animal{

    @Override
    public void eat() {
        System.out.println("eating meat and plant based food");
    }

    @Override
    public void grow() {
        System.out.println("omnivores is growing");
    }
}

class Sheep extends Herbivores{

    private int numberOfLegs;
    private String name;
    private boolean hasTail;
    private int speed;

    public Sheep(int numberOfLegs, String name, boolean hasTail, int speed) {
        super();
        this.numberOfLegs = numberOfLegs;
        this.name = name;
        this.hasTail = hasTail;
        this.speed = speed;
    }

    public Sheep() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    @Override
    public void run() {

        System.out.println("sheep is running at " + this.speed + " miles per hour");

    }

    @Override
    public String toString() {
        return "Sheep [numberOfLegs=" + numberOfLegs + ", name=" + name + ", hasTail=" + hasTail + ", speed=" + speed
                + "]";
    }


}

class Lion extends Carnivores {

    private int numberOfLegs;
    private String name;
    private boolean hasTail;
    private int speed;

    public Lion(int numberOfLegs, String name, boolean hasTail, int speed) {
        super();
        this.numberOfLegs = numberOfLegs;
        this.name = name;
        this.hasTail = hasTail;
        this.speed = speed;
    }

    public Lion() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    @Override
    public void run() {

        System.out.println("lion is running at " + this.speed + " miles per hour");

    }

    @Override
    public String toString() {
        return "Lion [numberOfLegs=" + numberOfLegs + ", name=" + name + ", hasTail=" + hasTail + ", speed=" + speed
                + "]";
    }


}

class Dog extends Omnivores {

    private int numberOfLegs;
    private String name;
    private boolean hasTail;
    private int speed;

    public Dog(int numberOfLegs, String name, boolean hasTail, int speed) {
        super();
        this.numberOfLegs = numberOfLegs;
        this.name = name;
        this.hasTail = hasTail;
        this.speed = speed;
    }

    public Dog() {

    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasTail() {
        return hasTail;
    }

    public void setHasTail(boolean hasTail) {
        this.hasTail = hasTail;
    }

    @Override
    public void run() {

        System.out.println("dog is running at " + this.speed + " miles per hour");

    }

    public void run(String breed, int speed) {

        System.out.println(breed + " runs " + speed + " miles per hour");

    }

    @Override
    public String toString() {
        return "Dog [numberOfLegs=" + numberOfLegs + ", name=" + name + ", hasTail=" + hasTail + ", speed=" + speed
                + "]";
    }



}

public class AnimalType {

    public static void main(String[] args) {

        Herbivores sheep = new Sheep(4, "Luna", true, 25);
        Carnivores lion = new Lion(4, "Simba", true, 50);
        Omnivores dog = new Dog(4, "Aaku", true, 35);

        System.out.println(sheep.toString() + "\n");
        sheep.eat();
        sheep.grow();
        sheep.run();

        System.out.println("\n\n **************** \n\n");

        System.out.println(lion.toString() + "\n");
        lion.eat();
        lion.grow();
        lion.run();

        System.out.println("\n\n **************** \n\n");

        System.out.println(dog.toString() + "\n");
        dog.eat();
        dog.grow();
        dog.run();

        System.out.println("\n\n **************** \n\n");

        Dog dog2 = new Dog();
        dog2.setNumberOfLegs(4);
        dog2.setName("Bob");
        dog2.setHasTail(true);
        dog2.setSpeed(35);

        System.out.println(dog2.toString() + "\n");

        dog2.run();
        dog2.run("Greyhound", 45);
    }

}

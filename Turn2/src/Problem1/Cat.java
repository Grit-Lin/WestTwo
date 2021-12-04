package Problem1;

public abstract class Cat {
    protected String name;
    protected int age;
    protected String gender;
    protected double price;

    public Cat(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public abstract String toString();
}

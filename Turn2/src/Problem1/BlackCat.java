package Problem1;

public class BlackCat extends Cat{


    public BlackCat(String name, int age, String gender) {
        super(name, age, gender);
        price = 350;
    }

    @Override
    public String toString() {
        return name;
    }
}

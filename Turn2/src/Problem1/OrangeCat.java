package Problem1;

public class OrangeCat extends Cat{
    boolean isFat;

    public OrangeCat(String name, int age, String gender,boolean isFat) {
        super(name, age, gender);
        this.isFat = isFat;
        price = 200;
    }

    @Override
    public String toString() {
        return name;
    }
}

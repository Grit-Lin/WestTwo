package Problem1;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        MyCatCafe myCatCafe = new MyCatCafe();
        myCatCafe.catList = new ArrayList<Cat>();
        myCatCafe.customerList = new ArrayList<Customer>();
        myCatCafe.balance = 600;

        Customer jack = new Customer("jack", 5, LocalDate.now());

        myCatCafe.buyCat(new BlackCat("xiaoguai",5,"公"));
        myCatCafe.buyCat(new OrangeCat("xiaohei",4,"母",true));

        myCatCafe.bringCustomer(jack);

        myCatCafe.closeCafe();

    }

}

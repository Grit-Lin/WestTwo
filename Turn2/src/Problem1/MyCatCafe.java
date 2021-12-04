package Problem1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe{

    double balance;
    ArrayList<Cat> catList = new ArrayList<>();
    ArrayList<Customer> customerList = new ArrayList<>();

    @Override
    public void buyCat(Cat cat) {
        if(balance < cat.price) throw new InsufficientBalanceException();
        balance -= cat.price;
        catList.add(cat);
    }

    @Override
    public void bringCustomer(Customer customer) {
        customerList.add(customer);
        if(catList == null) throw new CatNotFoundException();
        Random random = new Random();

        for(int i = 0;i < customer.ruaTimes;i++){
            System.out.println(customer.name + " rua了 " + catList.get(random.nextInt(catList.size())).toString());
        }

        balance += (customer.ruaTimes*15);
    }

    @Override
    public void closeCafe() {
        double profit = 0;
        System.out.println("--------------------------");
        System.out.println("关店辣，今天的顾客列表如下：");
        for(Customer customer : customerList){
            if(customer.arrivalTime.equals(LocalDate.now())) {
                System.out.println(customer);
                profit += customer.ruaTimes * 15;
            }
        }
        System.out.println("今天的利润是" + profit + "元");
        System.out.println("--------------------------");
    }
}

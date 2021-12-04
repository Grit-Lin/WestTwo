package Problem1;

import java.time.LocalDate;

public class Customer {
    protected String name;
    protected int ruaTimes;
    protected LocalDate arrivalTime;

    public Customer(String name, int ruaTimes, LocalDate arrivalTime) {
        this.name = name;
        this.ruaTimes = ruaTimes;
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ruaTimes=" + ruaTimes +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}

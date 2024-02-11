package BusinessObject;

import java.util.List;

public class Customer {
    int id;
    String name;

    List<Cake> orderList;

    public Customer() {
    }

    public Customer(int id, String name, List<Cake> orderList) {
        this.id = id;
        this.name = name;
        this.orderList = orderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cake> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Cake> orderList) {
        this.orderList = orderList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}


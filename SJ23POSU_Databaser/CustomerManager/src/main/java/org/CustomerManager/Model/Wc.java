package org.CustomerManager.Model;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name= "WC")
public class Wc {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name = "Thomas Tha Man";

    //@OneToMany(mappedBy = "wc")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="concert_id")
    private Concert concert;

    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;


    public Wc() {
    }

    public Wc(String name, Concert concert, Customer customer) {
        this.name = name;
        this.concert = concert;
        this.customer = customer;
    }

    public Wc(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Wc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", concert=" + concert +
                ", customer=" + customer +
                '}';
    }
}
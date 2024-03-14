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
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wc_id")
    private List<Concert> concerts;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "wc_id")
    private List<Customer> customers;
    public Wc() {
    }
    public Wc(int id, String name, List<Concert> concerts, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.concerts = concerts;
        this.customers = customers;
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
    public List<Concert> getConcerts() {
        return concerts;
    }
    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    @Override
    public String toString() {
        return "Wc{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", concerts=" + concerts +
                ", customers=" + customers +
                '}';
    }
}

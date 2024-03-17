package org.CustomerManager.Model;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name= "ARENA")
public class Arena {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(targetEntity = Concert.class, mappedBy = "arena", cascade=CascadeType.ALL)
    private List<Concert> concert;

    public Arena() {
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Concert> getConcert() {
        return concert;
    }

    public void setConcert(List<Concert> concert) {
        this.concert = concert;
    }

    @Override
    public String toString() {
        return "Arena{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
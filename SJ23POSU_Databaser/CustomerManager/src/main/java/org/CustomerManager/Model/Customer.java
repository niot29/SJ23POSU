package org.CustomerManager.Model;


import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

@Entity
@Table(name= "CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(length=100)
    private String forname;
    @Column(length=100)
    private String enamne;
    @Column(length=10)
    private String birthdate;
    @Column(length=15)
    private String phone;

    @OneToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private Address address;

    public Customer() {
    }

    public Customer(int id, String forname, String enamne, String birthdate, String phone) {
        this.id = id;
        this.forname = forname;
        this.enamne = enamne;
        this.birthdate = birthdate;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForname() {
        return forname;
    }

    public void setForname(String forname) {
        this.forname = forname;
    }

    public String getEnamne() {
        return enamne;
    }

    public void setEnamne(String enamne) {
        this.enamne = enamne;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", forname='" + forname + '\'' +
                ", enamne='" + enamne + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

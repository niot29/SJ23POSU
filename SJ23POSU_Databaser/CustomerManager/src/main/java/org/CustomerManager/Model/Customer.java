package org.CustomerManager.Model;


import jakarta.persistence.*;

@Entity
@Table(name= "CUSTOMER2")
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    @Column(name="forname",length=100)
    private String forname;
    @Column(name="enamne",length=100)
    private String enamne;
    @Column(name="birthdate",length=10)
    private String birthdate;
    @Column(name="phone",length=15)
    private String phone;

    @Column(name="address_id")
    private int address;

    public Customer() {
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

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
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
                ", address=" + address +
                '}';
    }
}

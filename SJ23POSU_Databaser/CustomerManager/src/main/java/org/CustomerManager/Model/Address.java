package org.CustomerManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "ADDRESS")
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
   // @Column(name="street",length=100)
    private String street;
    //@Column(name="streetnr",length=20)
    private int streetnr;
    //@Column(name="postcode",length=100)
    private String postcode;
    //@Column(name="city",length=100)
    private String city;

    @OneToOne(mappedBy = "address")
    private Customer customer;

    @OneToOne(mappedBy = "address")
    private Arena arena;

    public Address() {
    }


    public Address(int id, String street, int streetnr, String postcode, String city) {
        this.id = id;
        this.street = street;
        this.streetnr = streetnr;
        this.postcode = postcode;
        this.city = city;
    }

    public Address(String street, int streetnr, String postcode, String city) {
        this.street = street;
        this.streetnr = streetnr;
        this.postcode = postcode;
        this.city = city;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetnr() {
        return streetnr;
    }

    public void setStreetnr(int streetnr) {
        this.streetnr = streetnr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetnr=" + streetnr +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

package org.CustomerManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "CONSERT")
public class Consert {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(length=100)
    private String artistname;
    private String date;
    private int ticketprice;
    @Column(name="arena_id")
    private int arenaid;
    private int age;


    public Consert() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(int ticketprice) {
        this.ticketprice = ticketprice;
    }

    public int getArenaid() {
        return arenaid;
    }

    public void setArenaid(int arenaid) {
        this.arenaid = arenaid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Consert{" +
                "id=" + id +
                ", artistname='" + artistname + '\'' +
                ", date='" + date + '\'' +
                ", ticketprice=" + ticketprice +
                ", arenaid=" + arenaid +
                ", age=" + age +
                '}';
    }
}

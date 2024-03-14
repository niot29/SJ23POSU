package org.CustomerManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "CONSERT")
public class Concert {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "artist_name",length = 255)
    private String artistName;
    @Column(name = "date")
    private String date;
    @Column(name = "ticket_price")
    private int ticketPrice;
    @Column(name = "age_limit")
    private int ageLimit;
    @ManyToOne
    @JoinColumn(name="arena_id")
    private Arena arena;
    @ManyToOne
    @JoinColumn(name = "wc_id")
    private Wc wc;
    private int age;


    public Concert() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    public Wc getWc() {
        return wc;
    }

    public void setWc(Wc wc) {
        this.wc = wc;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "id=" + id +
                ", artistName='" + artistName + '\'' +
                ", date='" + date + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", ageLimit=" + ageLimit +
                ", arena=" + arena +
                ", wc=" + wc +
                ", age=" + age +
                '}';
    }
}

package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @Column(name = "country_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private int id;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

    public CountryEntity(int id, String country) {
        this.id = id;
        this.country = country;
    }

    public CountryEntity() {
    }

    public CountryEntity(String country) {
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}


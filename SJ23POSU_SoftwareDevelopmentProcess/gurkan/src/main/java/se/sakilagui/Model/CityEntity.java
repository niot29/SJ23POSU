package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity
@Table(name= "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;

    @Column(name = "city", length = 50)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

    public CityEntity(int id, String city, CountryEntity country) {
        this.id = id;
        this.city = city;
        this.country = country;
    }

    public CityEntity() {
    }


}

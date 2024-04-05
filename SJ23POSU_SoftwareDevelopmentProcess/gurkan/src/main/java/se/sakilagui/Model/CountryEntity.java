package se.sakilagui.Model;

import java.security.Timestamp;

import jakarta.persistence.*;


@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id", columnDefinition = "smallint UNSIGNED not null")
    private int id;

    @Column(name = "country", length = 50)
    private String country;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @OneToMany
    @JoinColumn(name = "city")
    private CityEntity cityEntity;

    public CountryEntity(int id, String country) {
        this.id = id;
        this.country = country;
    }

    public CountryEntity() {
    }


}


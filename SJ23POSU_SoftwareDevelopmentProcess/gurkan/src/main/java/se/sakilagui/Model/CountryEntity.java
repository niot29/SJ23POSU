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


}


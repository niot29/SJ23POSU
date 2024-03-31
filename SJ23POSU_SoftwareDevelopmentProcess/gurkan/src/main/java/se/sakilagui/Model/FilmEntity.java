package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Calendar;

@Entity
@Table(name = "film")
public class FilmEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "film_id")
    private int filmId;

    private String title;
    private String description;
    @Column(name = "release_year")
    private Date releaseYear;

    @Column(name = "language_id")
    private long languageId;

    @Column(name = "original_language_id")
    private long orgLanguageId;

    @Column(name = "rental_duration")
    private int rentalDuration = 3;

    @Column(name = "rental_rate")
    private double rentalRate = 4.99;  //decimal(4,2)

    private int length;
    @Column(name = "replacement_cost")
    private double replacementCost = 19.99; //decimal(5,2)

    private String rating = "G";

    @Column(name = "special_features")
    private String specialFeatures;

    @Column(name = "last_update")
    private Timestamp lastUpdate;


    public long getId() {
        return filmId;
    }

    public void setId(int id) {
        this.filmId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Date releaseYear) {
        this.releaseYear = releaseYear;
    }

    public long getLanguageId() {
        return languageId;
    }

    public void setLanguageId(long languageId) {
        this.languageId = languageId;
    }

    public long getOrgLanguageId() {
        return orgLanguageId;
    }

    public void setOrgLanguageId(long orgLanguageId) {
        this.orgLanguageId = orgLanguageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        DecimalFormat df = new DecimalFormat("####.##");
        String roundedNumber = df.format(rentalRate);
        rentalRate = Double.valueOf(roundedNumber);
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(double replacementCost) {
        DecimalFormat df = new DecimalFormat("#####.##");
        String roundedNumber = df.format(replacementCost);
        replacementCost = Double.valueOf(roundedNumber);
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate() {

        this.lastUpdate = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}

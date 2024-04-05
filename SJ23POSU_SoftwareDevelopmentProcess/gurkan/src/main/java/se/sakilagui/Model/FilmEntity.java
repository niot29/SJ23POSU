package se.sakilagui.Model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;


@Entity
@Table(name = "film")
public class FilmEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED not null")
    private short filmId;

    @Column(name = "title", nullable = false, length = 128)
    private String title;
    private String description;
    @Column(name = "release_year")
    private Date releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageEntity language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private LanguageEntity orgLanguage;

    @Column(name = "rental_duration", columnDefinition = "tinyint UNSIGNED")
    private int rentalDuration = 3;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate = BigDecimal.valueOf(4.99);  //decimal(4,2)
    @Column(name = "length", columnDefinition = "smallint UNSIGNED",nullable = false)
    private int length;
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost = BigDecimal.valueOf(19.99); //decimal(5,2)

    @Column(name = "rating")
    @Enumerated(EnumType.STRING)
    private Rating rating;

    // TODO fiset cul mappig
    @Column(name = "special_features",columnDefinition = "SET('Trailers','Commentaries','Deleted Scenes','Behind the Scenes')")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

    public FilmEntity() {
    }

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
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

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public LanguageEntity getOrgLanguage() {
        return orgLanguage;
    }

    public void setOrgLanguage(LanguageEntity orgLanguage) {
        this.orgLanguage = orgLanguage;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
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

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmEntity{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear=" + releaseYear +
                ", language=" + language +
                ", orgLanguage=" + orgLanguage +
                ", rentalDuration=" + rentalDuration +
                ", rentalRate=" + rentalRate +
                ", length=" + length +
                ", replacementCost=" + replacementCost +
                ", rating=" + rating +
                ", specialFeatures='" + specialFeatures + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
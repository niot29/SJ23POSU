package se.sakilagui.jpa.model;

import jakarta.persistence.*;
import se.sakilagui.Model.LanguageEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "category", schema = "sakila")
public class Category {
    @Id
    @Column(name = "category_id", columnDefinition = "tinyint UNSIGNED not null")
    private Short id;

    @Column(name = "name", nullable = false, length = 25)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Entity
    @Table(name = "film")
    public static class FilmEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "film_id")
        private short filmId;
        @Column(name = "title", nullable = false, length = 128)
        private String title;

        @Column(name = "description")
        private String description;
        @Column(name = "release_year")
        private Date releaseYear;

        //@ManyToOne(fetch = FetchType.LAZY, optional = false)
        @ManyToOne
        @JoinColumn(name = "language_id", nullable = false)
        private LanguageEntity language;

        //@ManyToOne(fetch = FetchType.LAZY)
        @ManyToOne
        @JoinColumn(name = "original_language_id")
        private LanguageEntity orgLanguageId;

        @Column(name = "rental_duration")
        private int rentalDuration = 3;

        @Column(name = "rental_rate")
        private double rentalRate = 4.99;  //decimal(4,2)

        @Column(name = "length", nullable = false)
        private int length;
        @Column(name = "replacement_cost")
        private double replacementCost = 19.99; //decimal(5,2)

        @Column(name = "rating")
        private String rating = "G";

        @Column(name = "special_features")
        private String specialFeatures;

        @Column(name = "last_update", nullable = false)
        private Timestamp lastUpdate;

        public FilmEntity() {
        }

        public FilmEntity(String title, String description, Date releaseYear, LanguageEntity language, LanguageEntity orgLanguageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
            this.title = title;
            this.description = description;
            this.releaseYear = releaseYear;
            this.language = language;
            this.orgLanguageId = orgLanguageId;
            this.rentalDuration = rentalDuration;
            this.rentalRate = rentalRate;
            this.length = length;
            this.replacementCost = replacementCost;
            this.rating = rating;
            this.specialFeatures = specialFeatures;
        }

        public FilmEntity(FilmEntity filmById) {
        }

        public int getFilmId() {
            return filmId;
        }

        public void setFilmId(Short filmId) {
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

        public void setLanguage(LanguageEntity languageId) {
            this.language = languageId;
        }

        public LanguageEntity getOrgLanguageId() {
            return orgLanguageId;
        }

        public void setOrgLanguageId(LanguageEntity orgLanguageId) {
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
                    ", orgLanguageId=" + orgLanguageId +
                    ", rentalDuration=" + rentalDuration +
                    ", rentalRate=" + rentalRate +
                    ", length=" + length +
                    ", replacementCost=" + replacementCost +
                    ", rating='" + rating + '\'' +
                    ", specialFeatures='" + specialFeatures + '\'' +
                    ", lastUpdate=" + lastUpdate +
                    '}';
        }
    }
}
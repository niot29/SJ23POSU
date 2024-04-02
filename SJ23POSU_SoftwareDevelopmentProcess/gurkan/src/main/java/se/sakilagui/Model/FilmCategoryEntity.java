package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "film_category")
public class FilmCategoryEntity {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private FilmEntity film;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(name = "last_update")
    private Timestamp lastUpdate;


    public FilmCategoryEntity() {
    }

    @Override
    public String toString() {
        return "FilmCategoryEntity{" +
                "film=" + film +
                ", category=" + category +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

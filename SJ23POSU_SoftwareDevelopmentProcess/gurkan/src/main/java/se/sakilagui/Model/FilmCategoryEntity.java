package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

/*
select f.title,f.description,c.name from film_category fc inner  join film f on fc.film_id = f.film_id
    inner join category c  on fc.category_id = c.category_id;
 */
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

package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "film_category")
public class FilmCategoryEntity {

    @Column(name = "film_id")
    private int filmId;

    @Column(name = "category_id")
    private int CategoryId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;


    public FilmCategoryEntity() {
    }

    public FilmCategoryEntity(int filmId, int categoryId, Timestamp lastUpdate) {
        this.filmId = filmId;
        CategoryId = categoryId;
        this.lastUpdate = lastUpdate;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmCategory{" +
                "filmId=" + filmId +
                ", CategoryId=" + CategoryId +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

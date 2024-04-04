package se.sakilagui.Model;

import jakarta.persistence.*;



import java.time.Instant;

@Entity
@Table(name = "film_category", schema = "sakila")
public class FilmCategoryEntity {
    @EmbeddedId
    private FilmCategoryEntityId id;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private FilmEntity film;

    @MapsId("categoryId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public FilmCategoryEntityId getId() {
        return id;
    }

    public void setId(FilmCategoryEntityId id) {
        this.id = id;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
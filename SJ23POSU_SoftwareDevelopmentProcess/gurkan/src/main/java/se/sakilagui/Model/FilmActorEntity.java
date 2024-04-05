package se.sakilagui.Model;

import jakarta.persistence.*;
import se.sakilagui.jpa.model.Actor;
import se.sakilagui.jpa.model.Film;
import se.sakilagui.jpa.model.FilmActorId;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "film_actor")
public class FilmActorEntity {
    @EmbeddedId
    private FilmActorId id;

    @MapsId("actorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actor_id", nullable = false)
    private ActorEntity actor;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false)
    private FilmEntity film;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    public FilmActorEntity() {
    }

    public FilmActorId getId() {
        return id;
    }

    public void setId(FilmActorId id) {
        this.id = id;
    }

    public ActorEntity getActor() {
        return actor;
    }

    public void setActor(ActorEntity actor) {
        this.actor = actor;
    }

    public FilmEntity getFilm() {
        return film;
    }

    public void setFilm(FilmEntity film) {
        this.film = film;
    }

    public Instant getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Instant lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "FilmActorEntity{" +
                "id=" + id +
                ", actor=" + actor +
                ", film=" + film +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

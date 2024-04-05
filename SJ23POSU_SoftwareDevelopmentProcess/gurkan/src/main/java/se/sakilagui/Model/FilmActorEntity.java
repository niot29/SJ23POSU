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
    @JoinColumn(name = "actor_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private ActorEntity actor;

    @MapsId("filmId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private FilmEntity film;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
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

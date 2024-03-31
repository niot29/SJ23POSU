package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "film_actor")
public class FilmActorEntity {
    @Column(name = "actor_id")
    private int actorId;

    @Column(name = "film_id")
    private int filmId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

}

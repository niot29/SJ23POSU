package se.sakilagui.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text")
public class FilmTextEntity {
    @Id
    @Column(name = "film_id", columnDefinition = "smallint UNSIGNED not null")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;
}

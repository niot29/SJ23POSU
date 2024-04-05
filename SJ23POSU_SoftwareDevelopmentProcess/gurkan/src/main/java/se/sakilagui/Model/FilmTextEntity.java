package se.sakilagui.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "film_text")
public class FilmTextEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "film_id", nullable = false, columnDefinition = "smallint UNSIGNED")
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;
}

package se.sakilagui.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "language")
public class LanguageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="language_id")
    private int id;
    @Column(name="name",length=20)
    private String name;
    @Column(name="last_update")
    private String last_update;

}

package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Time;

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
    private Time last_update;

    public LanguageEntity(int id, String name, Time last_update) {
        this.id = id;
        this.name = name;
        this.last_update = last_update;
    }

    public LanguageEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Time getLast_update() {
        return last_update;
    }

    public void setLast_update(Time last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "LanguageEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}

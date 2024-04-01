package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name= "language")
public class LanguageEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "language")
    private Byte language_id;
    @Column(name="name",length=20)
    private String name;
    @Column(name="last_update")
    private Time last_update;


    public LanguageEntity() {

    }

    public LanguageEntity(Byte language_id, String name, Time last_update) {
        this.language_id = language_id;
        this.name = name;
        this.last_update = last_update;
    }

    public byte getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(Byte language_id) {
        this.language_id = language_id;
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
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}

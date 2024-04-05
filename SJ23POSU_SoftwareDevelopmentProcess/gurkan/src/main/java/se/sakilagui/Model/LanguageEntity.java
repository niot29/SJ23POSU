package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name= "language")
public class LanguageEntity {
    @Id
    @Column(name = "language_id", columnDefinition = "tinyint UNSIGNED not null")
    private Byte language_id;
    @Column(name="name", nullable = false,length = 20,columnDefinition = "char")
    private String name;
    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;


    public LanguageEntity() {

    }

    public Byte getLanguage_id() {
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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "LanguageEntity{" +
                "language_id=" + language_id +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

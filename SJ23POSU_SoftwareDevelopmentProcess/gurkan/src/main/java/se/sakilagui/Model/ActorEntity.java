package se.sakilagui.Model;
import jakarta.persistence.*;
import java.sql.Time;
@Entity
@Table(name= "actor")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", columnDefinition = "smallint UNSIGNED not null")
    private int id;
    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 45)
    private String last_name;
    @Column(name = "last_update", nullable = false)
    private Time last_update;


    public ActorEntity(int id, String name, String last_name, Time last_update) {
        this.id = id;
        this.first_name = name;
        this.last_name = last_name;
        this.last_update = last_update;
    }

    public ActorEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Time getLast_update() {
        return last_update;
    }

    public void setLast_update(Time last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "ActorEntity{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
package se.sakilagui.Model;
import jakarta.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name= "actor")
public class ActorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private int id;
    @Column(name = "first_name", nullable = false, length = 45)
    private String first_name;
    @Column(name = "last_name", nullable = false, length = 45)
    private String last_name;
    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "ActorEntity{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
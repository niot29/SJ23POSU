package se.sakilagui.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "hibernate_sequences", schema = "sakila")
public class HibernateSequence {
    @Id
    @Column(name = "sequence_name", nullable = false)
    private String sequenceName;

    @Column(name = "next_val")
    private Long nextVal;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

}
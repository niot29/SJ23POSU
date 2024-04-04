package se.sakilagui.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "language_SEQ", schema = "sakila")
public class LanguageSeq {
    @Column(name = "next_val")
    private Long nextVal;

    public Long getNextVal() {
        return nextVal;
    }

    public void setNextVal(Long nextVal) {
        this.nextVal = nextVal;
    }

    //TODO [JPA Buddy] generate columns from DB
}
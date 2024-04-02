package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Byte categoryId;

    private String name;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public CategoryEntity(String name, Timestamp lastUpdate) {
        this.name = name;
        this.lastUpdate = lastUpdate;
    }

    public CategoryEntity() {

    }

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Byte categoryId) {
        this.categoryId = categoryId;
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
        return "CategoryEntity{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

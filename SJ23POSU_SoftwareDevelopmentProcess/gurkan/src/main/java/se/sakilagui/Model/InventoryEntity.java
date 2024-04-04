package se.sakilagui.Model;

import jakarta.persistence.*;
import se.sakilagui.jpa.model.Category;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private int inventoryId;

    private Category.FilmEntity filmId;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

package se.sakilagui.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventory_id")
    private int inventoryId;

    private FilmEntity filmId;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}

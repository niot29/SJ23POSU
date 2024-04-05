package se.sakilagui.Model;

import jakarta.persistence.*;
import se.sakilagui.jpa.model.Category;
import se.sakilagui.jpa.model.Film;
import se.sakilagui.jpa.model.Store;

import java.sql.Timestamp;

@Entity
@Table(name = "inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "film_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private FilmEntity film;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false, columnDefinition = "tinyint UNSIGNED")
    private StoreEntity store;

}

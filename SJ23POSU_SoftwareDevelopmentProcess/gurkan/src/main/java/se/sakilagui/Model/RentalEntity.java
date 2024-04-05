package se.sakilagui.Model;

import jakarta.persistence.*;
import se.sakilagui.jpa.model.Customer;

import java.sql.Timestamp;


@Entity
@Table(name = "rental")
public class RentalEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id", nullable = false, columnDefinition = "tinyint UNSIGNED")
    private int id;

    @Column(name = "rental_date",columnDefinition = "datetime")
    private Timestamp rentalDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventory;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @Column(name = "return_date",columnDefinition = "datetime")
    private Timestamp returnDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "staff_id", nullable = false, columnDefinition = "tinyint UNSIGNED")
    private StaffEntity staff;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;
}

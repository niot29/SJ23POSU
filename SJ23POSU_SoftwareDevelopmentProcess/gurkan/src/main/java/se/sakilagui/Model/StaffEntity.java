package se.sakilagui.Model;

import jakarta.persistence.*;


import java.sql.Timestamp;
import java.time.Instant;
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id", nullable = false,columnDefinition = "tinyint UNSIGNED")
    private Short id;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false,columnDefinition = "smallint UNSIGNED")
    private AddressEntity address;

    @Column(name = "picture")
    private byte[] picture;

    @Column(name = "email", length = 50)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false,columnDefinition = "tinyint UNSIGNED")
    private StoreEntity store;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "username", nullable = false, length = 16)
    private String username;

    @Column(name = "password", length = 40)
    private String password;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

}

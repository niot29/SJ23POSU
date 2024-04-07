package se.sakilagui.Model;

import jakarta.persistence.*;


import java.sql.Timestamp;

@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id", nullable = false, columnDefinition = "tinyint UNSIGNED")
    private Short id;
    @OneToOne()
    @JoinColumn(name = "manager_staff_id", nullable = false, columnDefinition = "tinyint UNSIGNED")
    private StaffEntity managerStaff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", nullable = false, columnDefinition = "smallint UNSIGNED")
    private AddressEntity address;

    @Column(name = "last_update", nullable = false, columnDefinition = "timestamp")
    private Timestamp lastUpdate;

    public StoreEntity() {
    }

    public StoreEntity(StaffEntity managerStaff, AddressEntity address, Timestamp lastUpdate) {
        this.managerStaff = managerStaff;
        this.address = address;
        this.lastUpdate = lastUpdate;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public StaffEntity getManagerStaff() {
        return managerStaff;
    }

    public void setManagerStaff(StaffEntity managerStaff) {
        this.managerStaff = managerStaff;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "StoreEntity{" +
                "id=" + id +
                ", managerStaff=" + managerStaff +
                ", address=" + address +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}

package org.CustomerManager.Model;

import jakarta.persistence.*;

@Entity
@Table(name= "WC")
public class Wc {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private int customer_id;
    private int consert_id;
}

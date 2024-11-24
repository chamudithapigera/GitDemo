package com.springbootacademy.batch8.pos.entity;

import com.springbootacademy.batch8.pos.entity.enums.MeasuringUnitType;

import javax.persistence.*;

@Entity
@Table (name = "item")
public class Item {
    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 100, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", length = 100, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 100, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 100, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 0")
    private boolean activeState;

}

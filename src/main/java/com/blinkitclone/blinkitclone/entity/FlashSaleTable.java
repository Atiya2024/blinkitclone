package com.blinkitclone.blinkitclone.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "flash_sale")
public class FlashSaleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer saleId;

    String saleName;
    Integer discountPercentage;
    LocalDate startDate;
    LocalDate endDate;
    Integer categoryId;
}

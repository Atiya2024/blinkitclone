package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "flash_sale")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlashSaleTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer saleId;

    String saleName;
    Integer discountPercentage;
    LocalDate startDate;
    LocalDate endDate;
    Integer categoryId;
    DeletionStatus deletionStatus;
}

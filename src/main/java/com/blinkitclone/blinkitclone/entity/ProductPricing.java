package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "product_pricing")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPricing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer productPriceId;
    Integer productId;
    Integer minPrice;
    Integer maxPrice;
    Integer merchantPrice;
    Integer finalPriceBeforeDiscount;
    Integer slashPrice;
    Integer taxId;
    Integer taxAmount;
    Integer finalPrice;
    Integer categoryId;
    Integer priceRuleId;
    LocalDate createdDate;
    LocalDate updatedDate;
    DeletionStatus deletionStatus;

}

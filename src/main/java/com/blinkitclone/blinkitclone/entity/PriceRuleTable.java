package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import com.blinkitclone.blinkitclone.Enums.applicableCategory;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "price_rule_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PriceRuleTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer ruleId;
    String ruleName;
    applicableCategory applicableCategory;
    LocalDate startDate;
    LocalDate endDate;
    Integer discountPercentage;
    Integer minPurchaseQuantity;
    Integer maxDiscountValue;
    DeletionStatus deletionStatus;
}

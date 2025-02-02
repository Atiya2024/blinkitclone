package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.applicableCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "price_rule_table")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
}

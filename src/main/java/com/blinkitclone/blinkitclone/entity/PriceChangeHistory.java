package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@Table(name = "price_change_history")
@Builder
public class PriceChangeHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Long productId;
    Integer oldPrice;
    Integer newPrice;
    LocalDateTime changedAt;
    String reasonForChange;
    DeletionStatus deletionStatus;
}

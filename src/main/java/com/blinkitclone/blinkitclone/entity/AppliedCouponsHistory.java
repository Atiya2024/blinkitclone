package com.blinkitclone.blinkitclone.entity;

import com.blinkitclone.blinkitclone.Enums.DeletionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "applied_coupon_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppliedCouponsHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    Integer userId;
    Long orderId;
    String couponId;
    Integer discountAmount;
    LocalDateTime appliedAt;
    Integer orderTotalAfterDiscount;
    DeletionStatus deletionStatus;
}

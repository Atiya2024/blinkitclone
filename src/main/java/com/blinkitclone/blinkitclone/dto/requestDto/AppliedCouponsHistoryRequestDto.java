package com.blinkitclone.blinkitclone.dto.requestDto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppliedCouponsHistoryRequestDto {
    Integer userId;
    Long orderId;
    String couponId;
    Integer discountAmount;
    LocalDateTime appliedAt;
    Integer orderTotalAfterDiscount;
}

package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.entity.AppliedCouponsHistory;
import com.blinkitclone.blinkitclone.exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.exception.AppliedCouponHistoryNotFound;
import com.blinkitclone.blinkitclone.repo.AppliedCouponsHistoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.blinkitclone.blinkitclone.Enums.DeletionStatus.Deleted;

@Service
public class AppliedCouponsHistoryService {

    @Autowired
    private AppliedCouponsHistoryRepo appliedCouponsHistoryRepo;


    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        AppliedCouponsHistory appliedCouponsHistory = convertAppliedCouponsHistoryRequestDtoToEntity(appliedCouponsHistoryRequestDto);
        appliedCouponsHistoryRepo.save(appliedCouponsHistory);
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory);
    }

    private AppliedCouponsHistoryResponseDto convertEntityToAppliedCouponsHistoryResponseDto(AppliedCouponsHistory appliedCouponsHistory) {
        return AppliedCouponsHistoryResponseDto.builder()
                .appliedAt(appliedCouponsHistory.getAppliedAt())
                .couponId(appliedCouponsHistory.getCouponId())
                .discountAmount(appliedCouponsHistory.getDiscountAmount())
                .orderId(appliedCouponsHistory.getOrderId())
                .userId(appliedCouponsHistory.getUserId())
                .orderTotalAfterDiscount(appliedCouponsHistory.getOrderTotalAfterDiscount())
                .build();
    }

    private AppliedCouponsHistory convertAppliedCouponsHistoryRequestDtoToEntity(AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) {
        return AppliedCouponsHistory.builder()
                .appliedAt(appliedCouponsHistoryRequestDto.getAppliedAt())
                .couponId(appliedCouponsHistoryRequestDto.getCouponId())
                .discountAmount(appliedCouponsHistoryRequestDto.getDiscountAmount())
                .userId(appliedCouponsHistoryRequestDto.getUserId())
                .orderTotalAfterDiscount(appliedCouponsHistoryRequestDto.getOrderTotalAfterDiscount())
                .orderId(appliedCouponsHistoryRequestDto.getOrderId())
                .build();
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryById(Integer id) throws AppliedCouponHistoryNotFound {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findById(id);
        if(appliedCouponsHistory.isEmpty()) throw new AppliedCouponHistoryNotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public AppliedCouponsHistoryResponseDto updateAppliedCouponsHistoryById(Integer id, AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto) throws AppliedCouponHistoryNotFound {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findById(id);
        if(appliedCouponsHistory.isEmpty()) throw new AppliedCouponHistoryNotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has been deleted");
        ////updating data/////
        if(appliedCouponsHistoryRequestDto.getAppliedAt() != null) appliedCouponsHistory.get().setAppliedAt(appliedCouponsHistoryRequestDto.getAppliedAt());
        if(appliedCouponsHistoryRequestDto.getCouponId() != null) appliedCouponsHistory.get().setCouponId(appliedCouponsHistoryRequestDto.getCouponId());
        if(appliedCouponsHistoryRequestDto.getDiscountAmount() != null) appliedCouponsHistory.get().setDiscountAmount(appliedCouponsHistoryRequestDto.getDiscountAmount());
        if(appliedCouponsHistoryRequestDto.getUserId() != null) appliedCouponsHistory.get().setUserId(appliedCouponsHistoryRequestDto.getUserId());
        if(appliedCouponsHistoryRequestDto.getOrderId() != null) appliedCouponsHistory.get().setOrderId(appliedCouponsHistoryRequestDto.getOrderId());
        if(appliedCouponsHistoryRequestDto.getOrderTotalAfterDiscount() != null) appliedCouponsHistory.get().setOrderTotalAfterDiscount(appliedCouponsHistoryRequestDto.getOrderTotalAfterDiscount());


        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public String deleteAppliedCouponsHistoryById(Integer id) throws AppliedCouponHistoryNotFound, AlreadyDeletedException {

        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findById(id);
        if(appliedCouponsHistory.isEmpty()) throw new AppliedCouponHistoryNotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has already been deleted");
        appliedCouponsHistory.get().setDeletionStatus(Deleted);
        return "successfully deleted applied coupon history with id : " + id;
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistoryByCouponId(Integer couponId) throws AppliedCouponHistoryNotFound, AlreadyDeletedException {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findByCouponId(couponId);
        if(appliedCouponsHistory.isEmpty()) throw new AppliedCouponHistoryNotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }

    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyOrderId(Integer orderId) throws AppliedCouponHistoryNotFound, AlreadyDeletedException {
        Optional<AppliedCouponsHistory> appliedCouponsHistory = appliedCouponsHistoryRepo.findByOrderId(orderId);
        if(appliedCouponsHistory.isEmpty()) throw new AppliedCouponHistoryNotFound("Applied coupon history with id : " + id + " does not exist");
        if (appliedCouponsHistory.get().getDeletionStatus() == Deleted) throw new AlreadyDeletedException("Applied coupon history with id : " + id + " has been deleted");
        return convertEntityToAppliedCouponsHistoryResponseDto(appliedCouponsHistory.get());
    }
}

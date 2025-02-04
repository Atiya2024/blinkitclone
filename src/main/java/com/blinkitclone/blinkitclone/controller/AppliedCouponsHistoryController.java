package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.requestDto.AppliedCouponsHistoryRequestDto;
import com.blinkitclone.blinkitclone.dto.responseDto.AppliedCouponsHistoryResponseDto;
import com.blinkitclone.blinkitclone.exception.AlreadyDeletedException;
import com.blinkitclone.blinkitclone.exception.AppliedCouponHistoryNotFound;
import com.blinkitclone.blinkitclone.service.AppliedCouponsHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appliedCouponHistory")
public class AppliedCouponsHistoryController {

    @Autowired
    private AppliedCouponsHistoryService appliedCouponsHistoryService;

    @PostMapping("/create")
    public AppliedCouponsHistoryResponseDto createAppliedCouponsHistory(@RequestBody AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto){
        return appliedCouponsHistoryService.createAppliedCouponsHistory(appliedCouponsHistoryRequestDto);
    }

    @GetMapping("/getById")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyId(@RequestParam Integer id){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistoryById(id);
        }
        catch (AppliedCouponHistoryNotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }

    }

    @GetMapping("/getByCouponId")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyCouponId(@RequestParam Integer CouponId){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistoryByCouponId(CouponId);
        }
        catch (AppliedCouponHistoryNotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }

    }

    @GetMapping("/getByOrderId")
    public AppliedCouponsHistoryResponseDto getAppliedCouponsHistorybyOrderId(@RequestParam Integer orderId){
        try {
            return appliedCouponsHistoryService.getAppliedCouponsHistorybyOrderId(orderId);
        }
        catch (AppliedCouponHistoryNotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }

    }

    @PatchMapping("/updateById")
    public AppliedCouponsHistoryResponseDto updateAppliedCouponsHistoryById(@RequestParam Integer id, @RequestBody AppliedCouponsHistoryRequestDto appliedCouponsHistoryRequestDto){
        try {
            return appliedCouponsHistoryService.updateAppliedCouponsHistoryById(id, appliedCouponsHistoryRequestDto);
        }
        catch (AppliedCouponHistoryNotFound | AlreadyDeletedException e){
            return AppliedCouponsHistoryResponseDto.builder().Error(e.getMessage()).build();
        }
    }

    @DeleteMapping("/deleteById")
    public String deleteAppliedCouponsHistoryById(@RequestParam Integer id){

        try {
            return appliedCouponsHistoryService.deleteAppliedCouponsHistoryById(id);
        }
        catch (AppliedCouponHistoryNotFound | AlreadyDeletedException e){
            return e.getMessage();
        }
    }
}

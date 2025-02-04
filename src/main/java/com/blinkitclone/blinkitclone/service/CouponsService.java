package com.blinkitclone.blinkitclone.service;

import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.entity.Coupons;
import com.blinkitclone.blinkitclone.exception.CouponNotFoundException;
import com.blinkitclone.blinkitclone.repo.CouponsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CouponsService {

    @Autowired
    private CouponsRepo couponsRepo;


    public Boolean createCoupons(String str) {
        return true;
    }

    public CouponsResponseDto getCouponsById(Integer id) throws CouponNotFoundException {
        Optional<Coupons> coupons = couponsRepo.findById(id);
        if(coupons == null){
            throw new CouponNotFoundException("Coupon with coupon id : " + id+ " does not exist");
        }
        return new CouponsResponseDto();
    }

    public CouponsResponseDto updateCouponsById(Integer id) {
        return new CouponsResponseDto();
    }

    public CouponsResponseDto deleteCouponsById(Integer id) {
        return new CouponsResponseDto();
    }
}

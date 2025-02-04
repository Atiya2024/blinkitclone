package com.blinkitclone.blinkitclone.controller;

import com.blinkitclone.blinkitclone.dto.responseDto.CouponsResponseDto;
import com.blinkitclone.blinkitclone.entity.Coupons;
import com.blinkitclone.blinkitclone.exception.CouponNotFoundException;
import com.blinkitclone.blinkitclone.service.CouponsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupons")
public class CouponsController {
    @Autowired
    private CouponsService couponsService;

    @PostMapping("/create")
    public Boolean createCouponsService(@RequestBody String str){
        return couponsService.createCoupons(str);
    }

    @GetMapping("/getById")
    public CouponsResponseDto getCouponsById(@RequestParam Integer id){

        try {
            return couponsService.getCouponsById(id);
        }

        catch (CouponNotFoundException e){
            return CouponsResponseDto.builder().Error(e.getMessage()).build();
        }
    }

    @PatchMapping("/updateById")
    public CouponsResponseDto updateCouponsById(@RequestParam Integer id){
        try{
            return couponsService.updateCouponsById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @DeleteMapping("/deleteById")
    public CouponsResponseDto deleteCouponsById(@RequestParam Integer id){
        return couponsService.deleteCouponsById(id);
    }
}

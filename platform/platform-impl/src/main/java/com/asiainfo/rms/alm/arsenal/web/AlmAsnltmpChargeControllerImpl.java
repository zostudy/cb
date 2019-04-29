package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChargeDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpChargeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmAsnltmpChargeControllerImpl implements AlmAsnltmpChargeController {
    private final AlmAsnltmpChargeService almAsnltmpChargeService;

    public AlmAsnltmpChargeControllerImpl(AlmAsnltmpChargeService almAsnltmpChargeService) {
        this.almAsnltmpChargeService = almAsnltmpChargeService;
    }

    @Override
    public String saveAlmAsnltmpCharge(@RequestBody AlmAsnltmpChargeDTO almAsnltmpChargeDTO) {
        return almAsnltmpChargeService.saveAlmAsnltmpCharge(almAsnltmpChargeDTO);
    }

    @Override
    public String updateAlmAsnltmpCharge(@PathVariable("ac_id")Integer acId, @RequestBody AlmAsnltmpChargeDTO almAsnltmpChargeDTO) {
        almAsnltmpChargeDTO.setAcId(acId);
        return almAsnltmpChargeService.updateAlmAsnltmpCharge(almAsnltmpChargeDTO);
    }


    @Override
    public AlmAsnltmpChargeDTO selectAlmAsnltmpChargeByAarId(@RequestParam("aat_id")Integer aatId) {
        return almAsnltmpChargeService.selectAlmAsnltmpChargeByAarId(aatId);
    }

}

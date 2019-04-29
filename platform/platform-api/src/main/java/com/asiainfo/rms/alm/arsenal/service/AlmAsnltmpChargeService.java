package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChargeDTO;

public interface AlmAsnltmpChargeService {
    String saveAlmAsnltmpCharge(AlmAsnltmpChargeDTO almAsnltmpChargeDTO);

    String updateAlmAsnltmpCharge(AlmAsnltmpChargeDTO almAsnltmpChargeDTO);

    AlmAsnltmpChargeDTO selectAlmAsnltmpChargeByAarId(Integer aatId);

}

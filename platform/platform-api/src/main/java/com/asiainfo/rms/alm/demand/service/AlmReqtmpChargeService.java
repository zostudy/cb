package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpChargeDTO;
import com.asiainfo.rms.alm.demand.dto.ChargeDTO;

import java.util.List;

public interface AlmReqtmpChargeService {

    String saveAlmReqtmpCharge(ChargeDTO chargeDTO);

    String updateAlmReqtmpCharge(ChargeDTO chargeDTO);

    String deleteAlmReqtmpCharge(Integer archId);

    ChargeDTO selectAlmReqtmpCharge(Integer archId);

    ChargeDTO selectCharge(Integer artId);

    List<AlmReqtmpChargeDTO> selectAllAlmReqtmpCharge(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpCharge(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);
}

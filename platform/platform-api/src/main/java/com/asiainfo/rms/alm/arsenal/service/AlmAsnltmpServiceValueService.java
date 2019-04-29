package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmServiceValueDTO;

public interface AlmAsnltmpServiceValueService {
    String saveAlmAsnltmpServiceValue(AlmServiceValueDTO almServiceValueDTO);

//    String updateAlmAsnltmpServiceValue(AlmAsnltmpServiceValueDTO almAsnltmpServiceValueDTO);

    String deleteAlmAsnltmpServiceValue(Integer asvId);

//    AlmAsnltmpServiceValueDTO selectAlmAsnltmpServiceValue(Integer asvId);
//
//    List<AlmAsnltmpServiceValueDTO> selectAllAlmAsnltmpServiceValue(String keyword, Integer pageNo, Integer pageSize);
//
//    Integer getAllAlmAsnltmpServiceValueCouont(String keyword);
}

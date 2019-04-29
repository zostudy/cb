package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChgeExtendDTO;

import java.util.List;

public interface AlmAsnltmpChgeExtendService {
    String saveAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO);

    String updateAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO);

    String deleteAlmAsnltmpChgeExtend(Integer aceId);

    AlmAsnltmpChgeExtendDTO selectAlmAsnltmpChgeExtendById(Integer aceId);

    List<AlmAsnltmpChgeExtendDTO> selectAllAlmAsnltmpChgeExtend(Integer aatId,Integer pageNo,Integer pageSize);

    Integer getAllAlmAsnltmpChgeExtendCount(Integer aatId);

}

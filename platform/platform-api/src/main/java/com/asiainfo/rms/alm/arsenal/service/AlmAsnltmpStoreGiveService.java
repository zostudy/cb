package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;

import java.util.List;

public interface AlmAsnltmpStoreGiveService {

//    String saveAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO);
//
//    String updateAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO);

    String deleteAlmAsnltmpStoreGive(Integer aasId);

    AlmAsnltmpStoreGiveDTO selectAlmAsnltmpStoreGive(Integer aasId);

    List<AlmAsnltmpStoreGiveDTO> selectAllAlmAsnltmpStoreGive(Integer aatId,Integer pageNo,Integer pageSize);

    Integer getAllAlmAsnltmpStoreGiveCount(Integer aatId);
}

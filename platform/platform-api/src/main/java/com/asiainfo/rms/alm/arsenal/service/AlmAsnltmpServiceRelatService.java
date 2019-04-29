package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceRelatDTO;

import java.util.List;

public interface AlmAsnltmpServiceRelatService {

    String saveAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO);

    String updateAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO);

    String deleteAlmAsnltmpServiceRelat(Integer asrId);

//    AlmAsnltmpServiceRelatDTO selectAlmAsnltmpServiceRelat(Integer asrId);

    List<AlmAsnltmpServiceRelatDTO> selectAllAlmAsnltmpServiceRelat(Integer artType, Integer pageNo, Integer pageSize);

    List<AlmAsnltmpServiceRelatDTO> selectAlmAsnltmpServiceRelatByArtType(Integer artType, Integer aatId, Integer objId);

    Integer getAllAlmAsnltmpServiceRelatCount(Integer artType);
}

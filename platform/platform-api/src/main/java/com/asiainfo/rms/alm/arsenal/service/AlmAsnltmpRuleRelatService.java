package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleRelatDTO;

import java.util.List;

public interface AlmAsnltmpRuleRelatService {
    String saveAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO);

    String updateAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO);

    String deleteAlmAsnltmpRuleRelat(Integer atrrId);

//    AlmAsnltmpRuleRelatDTO selectAlmAsnltmpRuleRela(Integer atrrId);

    List<AlmAsnltmpRuleRelatDTO> selectAllAlmAsnltmpRuleRela(Integer artType,Integer pageNo, Integer pageSize);

    List<AlmAsnltmpRuleRelatDTO> selectAlmAsnltmpServiceRelatByArtType(Integer artType, Integer aatId, Integer objId);

    Integer getAllAlmAsnltmpRuleRelaCount(Integer artType);


}

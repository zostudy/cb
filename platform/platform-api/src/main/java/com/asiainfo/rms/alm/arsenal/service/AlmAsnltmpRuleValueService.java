package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmRuleValueDTO;

public interface AlmAsnltmpRuleValueService {
    String saveAlmAsnltmpRuleValue(AlmRuleValueDTO almRuleValueDTO);

//    String updateAlmAsnltmpRuleValue(AlmAsnltmpRuleValueDTO almAsnltmpRuleValueDTO);

    String deleteAlmAsnltmpRuleValue(Integer aarvId);

//    AlmAsnltmpRuleValueDTO selectAlmAsnltmpRuleValue(Integer aarvId);
}

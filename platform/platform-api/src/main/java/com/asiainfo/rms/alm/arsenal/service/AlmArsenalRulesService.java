package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalRulesDTO;

import java.util.List;

public interface AlmArsenalRulesService {
    String saveAlmArsenalRules(AlmArsenalRulesDTO almArsenalRulesDTO);

    String updateAlmArsenalRules(AlmArsenalRulesDTO almArsenalRulesDTO);

    String deleteAlmArsenalRules(Integer arId);

    AlmArsenalRulesDTO selectArsenalRulesById(Integer arId);

    List<AlmArsenalRulesDTO> selectAllArsenalRules(String keyword, Integer pageNo, Integer pageSize);

    Integer getAllArsenalRules(String keyword);
}

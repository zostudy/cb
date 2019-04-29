package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpLabelConfigDTO;

import java.util.List;

public interface AlmAsnltmpLabelConfigService {
    String saveAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO);

    String updateAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO);

    String deleteAlmAsnltmpLabelConfig(Integer lmId);

    AlmAsnltmpLabelConfigDTO selectAlmAsnltmpLabelConfigById(Integer lmId);

    List<AlmAsnltmpLabelConfigDTO> selectAllAlmAsnltmpLabelConfig(String keyword, Integer pageNo, Integer pageSize);

    Integer getAllAlmAsnltmpLabelConfigCount(String keyword);
}

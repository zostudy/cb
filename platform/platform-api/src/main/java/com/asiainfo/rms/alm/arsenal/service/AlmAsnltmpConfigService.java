package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpConfigDTO;

import java.util.List;

public interface AlmAsnltmpConfigService {

    String saveAlmAsnltmpConfig(AlmAsnltmpConfigDTO almAsnltmpConfigDTO);

    String updateAlmAsnltmpConfig(AlmAsnltmpConfigDTO almAsnltmpConfigDTO);

    String deleteAlmAsnltmpConfig(Integer aacId);

    AlmAsnltmpConfigDTO selectAlmAsnltmpConfigById(Integer aacId);

    List<AlmAsnltmpConfigDTO> selectAllAlmAsnltmpConfig(String keyword, Integer pageNo, Integer pageSize);

    Integer getAllAlmAsnltmpConfigCount(String keyword);
}

package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmReqtmpConfigDTO;

import java.util.List;

public interface AlmReqtmpConfigService {
    String saveAlmReqtmpConfig(AlmReqtmpConfigDTO almReqtmpConfigDTO);

    String updateAlmReqtmpConfig(AlmReqtmpConfigDTO almReqtmpConfigDTO);

    String deleteAlmReqtmpConfig(Integer id);

    AlmReqtmpConfigDTO selectAlmReqtmpConfig(Integer id);

    List<AlmReqtmpConfigDTO> selectAllAlmReqtmpConfig(String keyword, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpConfigCount(String keyword);
}

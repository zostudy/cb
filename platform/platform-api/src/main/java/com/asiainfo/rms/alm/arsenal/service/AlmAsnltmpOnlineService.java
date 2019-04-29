package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpOnlineDTO;

import java.util.List;

public interface AlmAsnltmpOnlineService {
    String saveAlmAsnltmpOnline(AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO);

    String updateAlmAsnltmpOnline(AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO);

    String deleteAlmAsnltmpOnline(Integer aaoId);

    AlmAsnltmpOnlineDTO selectAlmAsnltmpOnline(Integer aaoId);

    List<AlmAsnltmpOnlineDTO> selectAllAlmAsnltmpOnline(String keyword,Integer pageNo,Integer pageSize);

    Integer getAllAlmAsnltmpOnlineCount(String keyword);
}

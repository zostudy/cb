package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStationWfRoleDTO;

import java.util.List;

public interface SysStationWfRoleService {
    String saveStationWfRole(SysStationWfRoleDTO stationWfRoleDTO);

    String deleteStationWfRole(Integer relId);

    List<SysStationWfRoleDTO> selectStationWfRoleByStationId(Integer stationId, String keyword, Integer pageNo, Integer pageSize);

    Integer getStationWfRoleCount(Integer stationId, String keyword);
}

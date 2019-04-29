package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;

import java.util.List;

public interface SysStationDataRoleService {

    String saveStationDataRole(SysStationDataRoleDTO stationDataRoleDTO);

    String deleteStationDataRole(Integer relId);

    List<SysStationDataRoleDTO> selectStationDataRoleByStationId(Integer stationId, String keyword, Integer pageNo, Integer pageSize);

    Integer getStationDataRoleCount(Integer stationId,String keyword);
}

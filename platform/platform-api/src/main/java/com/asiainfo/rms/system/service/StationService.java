package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStationDTO;

import java.util.List;

public interface StationService {
    String saveStation(SysStationDTO stationDTO);

    String updateStation(SysStationDTO stationDTO);

    String deleteStationById(Integer stationId);

    SysStationDTO selectByStationId(Integer stationId);

    List<SysStationDTO> selectAllStation(String keyWord,Integer selectedStaffId, Integer pageNo, Integer pageSize);

    int getStationCount(String keyWord,Integer selectedStaffId);
}

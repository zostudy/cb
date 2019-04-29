package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStationFuncDTO;
import com.asiainfo.rms.system.dto.SysStationFunctionDTO;

import java.util.List;

public interface StationFunctionService {
    String saveStationFunc(SysStationFunctionDTO sysStationFunctionDTO);

//    String updateStationFunc(SysStationFuncDTO stationFuncDTO);
//
//    String deleteStationFuncById(Integer stationFuncRelatId);

    SysStationFuncDTO selectByStationFuncRelatId(Integer stationFuncRelatId);

    SysStationFuncDTO selectStationFuncByStaffId(Integer staffId);

    List<SysStationFuncDTO> selectStationFuncByStationId(Integer stationId);
}

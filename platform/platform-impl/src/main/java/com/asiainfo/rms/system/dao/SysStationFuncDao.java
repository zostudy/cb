package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStationFuncRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStationFuncDao {
    Integer saveStationFunc(SysStationFuncRepository stationFuncRepository);

    Integer updateStationFunc(SysStationFuncRepository stationFuncRepository);

    Integer deleteStationFuncById(@Param("stationFuncRelatId")Integer stationFuncRelatId);

    Integer deleteStationFuncByStationId(@Param("stationId")Integer stationId);

    SysStationFuncRepository selectByStationFuncRelatId(@Param("stationFuncRelatId")Integer stationFuncRelatId);

    SysStationFuncRepository selectStationFuncByStaffId(@Param("staffId")Integer staffId);

    List<SysStationFuncRepository> selectStationFuncByStationId(@Param("stationId")Integer stationId);
}

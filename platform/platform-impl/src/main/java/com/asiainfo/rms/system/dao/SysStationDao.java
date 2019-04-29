package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStationRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStationDao {
    Integer saveStation(SysStationRepository stationRepository);

    Integer updateStation(SysStationRepository stationRepository);

    Integer deleteStationById(@Param("stationId")Integer stationId);

    SysStationRepository selectByStationId(@Param("stationId")Integer stationId);

    int getStationCount(@Param("keyWord") String keyWord,
                        @Param("selectedStaffId")Integer selectedStaffId);

    List<SysStationRepository> selectAllStation(@Param("keyWord")String keyWord,
                                                @Param("selectedStaffId")Integer selectedStaffId,
                                                @Param("offset") Integer offset,
                                                @Param("size") Integer size);

    List<SysStationRepository> selectAllCode();
}

package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStationDataRoleRepository;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SysStationDataRoleDao {

    Integer saveStationDataRole(SysStationDataRoleRepository stationDataRoleRepository);

    Integer deleteStationDataRole(@Param("state")Integer state, @Param("endDate")Date endDate, @Param("relId")Integer relId);

    List<SysStationDataRoleRepository> selectStationDataRoleByStationId(@Param("stationId")Integer stationId,
                                                                         @Param("keyword")String keyword,
                                                                         @Param("offset") Integer offset,
                                                                         @Param("size") Integer size);

    Integer getStationDataRoleCount(@Param("stationId")Integer stationId,@Param("keyword")String keyword);

    Integer getOpIdAndRoleIdCount(@Param("opId")Integer opId,@Param("dataRoleId")Integer dataRoleId,@Param("stationId")Integer stationId);
}

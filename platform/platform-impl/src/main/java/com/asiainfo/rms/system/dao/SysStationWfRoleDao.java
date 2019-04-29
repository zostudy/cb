package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStationWfRoleRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStationWfRoleDao {

    Integer saveStationWfRole(SysStationWfRoleRepository stationWfRoleRepository);

    Integer deleteStationWfRole(@Param("relId")Integer relId);

    List<SysStationWfRoleRepository> selectStationWfRoleByStationId(@Param("stationId")Integer stationId,
                                                                    @Param("keyword")String keyword,
                                                                    @Param("offset") Integer offset,
                                                                    @Param("size") Integer size);
    Integer getStationWfRoleCount(@Param("stationId")Integer stationId,
                                  @Param("keyword")String keyword);
}

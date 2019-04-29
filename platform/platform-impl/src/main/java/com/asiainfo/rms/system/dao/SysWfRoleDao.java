package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysWfRoleRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysWfRoleDao {

    Integer saveSysWfRole(SysWfRoleRepository wfRoleRepository);

    Integer updateSysWfRole(SysWfRoleRepository wfRoleRepository);

    Integer deleteSysWfRoleById(@Param("wfRoleId") Integer wfRoleId);

    List<SysWfRoleRepository> selectSysWfRole(@Param("keyword")String keyword,
                                              @Param("selectedStationId")Integer selectedStationId,
                                              @Param("processKey")String processKey,
                                              @Param("offset") Integer offset,
                                              @Param("size") Integer size);

    Integer getSysWfRoleCount(@Param("keyword")String keyword,
                              @Param("selectedStationId")Integer selectedStationId,
                              @Param("processKey")String processKey);

    List<SysWfRoleRepository> selectAllCode();

    Integer getCountRemoveId(@Param("keyword")String keyword,@Param("wfRoleId") Integer wfRoleId);
}

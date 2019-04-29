package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysDataRoleRepostitory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysDataRoleDao {
    Integer saveSysDataRole(SysDataRoleRepostitory dataRoleRepostitory);

    Integer updateSysDataRole(SysDataRoleRepostitory dataRoleRepostitory);

    Integer deleteSysDataRoleById(@Param("dataRoleId")Integer dataRoleId);

    List<SysDataRoleRepostitory> selectSysDataRole(@Param("keyword")String keyword,
                                                   @Param("organizeId")Integer organizeId,
                                                   @Param("offset") Integer offset,
                                                   @Param("size") Integer size);

    Integer getSysDataRoleCount(@Param("keyword")String keyword,@Param("organizeId")Integer organizeId);

    List<SysDataRoleRepostitory> selectAllCode();
}

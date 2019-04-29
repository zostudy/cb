package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStaffOrgRelatRepository;
import org.apache.ibatis.annotations.Param;

public interface SysStaffOrgRelatDao {
    Integer saveStaffOrgRelat(SysStaffOrgRelatRepository staffOrgRelatRepository);

    Integer updateStaffOrgRelat(SysStaffOrgRelatRepository staffOrgRelatRepository);

    Integer deleteStaffOrgRelat(@Param("staffOrgRelatId")Integer staffOrgRelatId);

    Integer deleteStaffByStaffId(@Param("staffId")Integer staffId);

//    SysStaffOrgRelatRepository selectByStaffOrgRelatId(@Param("staffOrgRelatId")Integer staffOrgRelatId);

    SysStaffOrgRelatRepository selectStaffOrgRelatByStaffId(@Param("staffId")Integer staffId);

    Integer selectCountByStaffId(@Param("staffId")Integer staffId);
}

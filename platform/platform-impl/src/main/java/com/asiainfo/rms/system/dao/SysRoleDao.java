package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysRoleRepository;
import org.apache.ibatis.annotations.Param;

public interface SysRoleDao {
    void saveRole(SysRoleRepository roleRepository);

    void updateRole(SysRoleRepository roleRepository);

    SysRoleRepository selectByRoleId(@Param("roleId")Integer roleId);

    SysRoleRepository selectRoleInfoByStaffId(@Param("staffId")Integer staffId);
}

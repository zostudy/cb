package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStaffRoleAuthorRepository;
import org.apache.ibatis.annotations.Param;

public interface SysStaffRoleAuthorDao {
    int saveStaffRoleAuthor(SysStaffRoleAuthorRepository staffRoleAuthorRepository);

    int updateStaffRoleAuthor(SysStaffRoleAuthorRepository staffRoleAuthorRepository);

    SysStaffRoleAuthorRepository selectByStaffRoleAuthorId(@Param("staffRoleAuthorId")Integer staffRoleAuthorId);
}

package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysLoginLogRepository;
import org.apache.ibatis.annotations.Param;

public interface SysLoginLogDao {
    Integer saveLoginLog(SysLoginLogRepository loginLogRepository);

    void updateLoginLog(SysLoginLogRepository loginLogRepository);

    SysLoginLogRepository selectLogIdByUser(@Param("staffCode")String  staffCode);


}

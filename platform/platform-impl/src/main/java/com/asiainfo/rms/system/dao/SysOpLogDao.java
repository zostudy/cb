package com.asiainfo.rms.system.dao;


import com.asiainfo.rms.system.domain.SysOpLogRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysOpLogDao {

    Integer saveOpLog(SysOpLogRepository opLogRepository);

    List<SysOpLogRepository> selectAllOpLog(@Param("opTypeId")Integer opTypeId,
                                            @Param("opContent")String opContent,
                                            @Param("keyword")String keyword,
                                            @Param("startTime")String startTime,
                                            @Param("endTime")String endTime,
                                            @Param("offset") Integer offset,
                                            @Param("size") Integer size);

    Integer getOpTLogCount(@Param("opTypeId")Integer opTypeId,
                           @Param("opContent")String opContent,
                           @Param("keyword")String keyword,
                           @Param("startTime")String startTime,
                           @Param("endTime")String endTime);

    SysOpLogRepository selectByopLogId(@Param("opLogId")Integer opLogId);


}

package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysOpLogDTO;

import java.util.List;

public interface SysOpLogService {
    String saveOpLog(SysOpLogDTO opLogDTO);

    List<SysOpLogDTO> selectAllOpLog(Integer opTypeId,String opContent,String keyword,String startTime,String endTime,Integer pageNo, Integer pageSize);

    Integer getOpTLogCount(Integer opTypeId,String opContent,String keyword,String startTime,String endTime);

    SysOpLogDTO selectByopLogId(Integer opLogId);

}

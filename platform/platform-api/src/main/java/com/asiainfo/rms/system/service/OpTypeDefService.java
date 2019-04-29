package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysOpTypeDefDTO;

import java.util.List;
import java.util.Map;

public interface OpTypeDefService {
    //操作类型
    String saveOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO);

    String updateOpTypeDef(SysOpTypeDefDTO sysOpTypeDefDTO);

    String deleteOpTypeDefById(Integer opTypeId);

    List<SysOpTypeDefDTO> selectAllOpType(String code, String opTypeName, Integer pageNo, Integer pageSize);

    int getOpTypeCount(String code,String opTypeName);
}

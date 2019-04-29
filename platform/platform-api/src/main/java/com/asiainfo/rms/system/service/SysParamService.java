package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysParamDTO;

import java.util.List;

public interface SysParamService {
    List<SysParamDTO> selectParamByType(String paramType,Integer paramReleId);

    List<SysParamDTO> selectParams(String paramType);

}

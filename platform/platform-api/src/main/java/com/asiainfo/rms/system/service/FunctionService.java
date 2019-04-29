package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysFunctionDTO;

import java.util.List;

public interface FunctionService {
    String saveFunction(SysFunctionDTO functionDTO);

    String updateFunction(SysFunctionDTO functionDTO);

    String deleteFunctionById(Integer funcId);

    SysFunctionDTO selectByFuncId(Integer funcId);

    List<SysFunctionDTO> selectAllFunction(Integer state);

    List<SysFunctionDTO> selectFunctionByStaffId(Integer staffId);
}

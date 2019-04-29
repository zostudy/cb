package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpFunctionDTO;
import com.asiainfo.rms.alm.demand.dto.FunctionDTO;

import java.util.List;

public interface AlmReqtmpFunctionService {

    String saveAlmReqtmpFunction(FunctionDTO functionDTO);

    String updateAlmReqtmpFunction(FunctionDTO functionDTO);

    String deleteAlmReqtmpFunction(Integer arfId);

    FunctionDTO selectAlmReqtmpFunction(Integer arfId);

    FunctionDTO selectFunction(Integer artId);

    List<AlmReqtmpFunctionDTO> selectAllAlmReqtmpFunction(String keyword, Integer artType, String artName, String artTag, Integer artRegion, Integer urgentLevel, String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpFunctionCount(String keyword, Integer artType, String artName, String artTag, Integer artRegion, Integer urgentLevel, String submitStaffName);
}

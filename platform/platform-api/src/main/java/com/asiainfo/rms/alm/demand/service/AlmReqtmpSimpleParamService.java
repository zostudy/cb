package com.asiainfo.rms.alm.demand.service;

import java.util.List;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamDTO;

public interface AlmReqtmpSimpleParamService {

    String saveAlmReqtmpSimpleParam(SimpleParamDTO simpleParamDTO);

    String updateAlmReqtmpSimpleParam(SimpleParamDTO simpleParamDTO);

    String deleteAlmReqtmpSimpleParam(Integer arspId);

    SimpleParamDTO selectAlmReqtmpSimpleParam(Integer arspId);

    SimpleParamDTO selectSimpleParam(Integer artId);

    List<AlmReqtmpSimpleParamDTO> selectAllAlmReqtmpSimpleParam(Integer artId,Integer modifyType, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpSimpleParam(Integer artId,Integer modifyType);
    
    List<Integer> getAllAlmReqtmpSimpleParamType( Integer artId);
}

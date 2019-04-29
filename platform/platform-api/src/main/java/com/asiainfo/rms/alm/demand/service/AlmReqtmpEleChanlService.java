package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpEleChanlDTO;
import com.asiainfo.rms.alm.demand.dto.EleChanlDTO;

import java.util.List;

public interface AlmReqtmpEleChanlService {

    String saveAlmReqtmpEleChanl(EleChanlDTO eleChanlDTO);

    String updateAlmReqtmpEleChanl(EleChanlDTO eleChanlDTO);

    String deleteAlmReqtmpEleChanl(Integer areId);

    EleChanlDTO selectAlmReqtmpEleChanl(Integer areId);

    EleChanlDTO selectEleChanl(Integer artId);

    List<AlmReqtmpEleChanlDTO> selectAllAlmReqtmpEleChanl(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpEleChanlCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);
}
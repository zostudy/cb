package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.demand.dto.BusiayaDTO;

import java.util.List;

public interface AlmReqtmpBusiayaService {

    String saveAlmReqtmpBusiaya(BusiayaDTO busiayaDTO);

    String updateAlmReqtmpBusiaya(BusiayaDTO busiayaDTO);

    String deleteAlmReqtmpBusiaya(Integer arbaId);

    BusiayaDTO selectAlmReqtmpBusiaya(Integer arbaId);

    List<AlmReqtmpBusiayaDTO> selectAllAlmReqtmpBusiaya(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpBusiayaCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);

    BusiayaDTO selectBusiaya(Integer artId);
}

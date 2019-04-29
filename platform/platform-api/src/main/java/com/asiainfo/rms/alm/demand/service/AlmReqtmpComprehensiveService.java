package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpComprehensiveDTO;
import com.asiainfo.rms.alm.demand.dto.ComprehensiveDTO;

import java.util.List;

public interface AlmReqtmpComprehensiveService {

    String saveAlmReqtmpComprehensive(ComprehensiveDTO comprehensiveDTO);

    String updateAlmReqtmpComprehensive(ComprehensiveDTO comprehensiveDTO);

    String deleteAlmReqtmpComprehensive(Integer arcId);

    ComprehensiveDTO selectAlmReqtmpComprehensive(Integer arcId);

    ComprehensiveDTO selectComprehensive(Integer artId);

    List<AlmReqtmpComprehensiveDTO> selectAllAlmReqtmpComprehensive(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpComprehensive(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);


}

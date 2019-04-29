package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;

import java.util.List;

public interface AlmReqtmpTopicService {

    String saveAlmReqtmpTopic(AlmReqtmpTopicDTO almReqtmpTopicDTO);

    String updateAlmReqtmpTopic(AlmReqtmpTopicDTO almReqtmpTopicDTO);

    String deleteAlmReqtmpTopic(Integer artId);

    AlmReqtmpTopicDTO selectAlmReqtmpTopicById(Integer artId);

    List<AlmReqtmpTopicDTO> selectAllAlmReqtmpTopic(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName,Integer pageNo,Integer pageSize);

    Integer getAllAlmReqtmpTopicCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);
}

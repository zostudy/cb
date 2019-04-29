package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpTopicDTO;

import java.util.List;

public interface AlmAsnltmpTopicService {
    String saveAlmAsnltmpTopic(AlmAsnltmpTopicDTO almAsnltmpTopicDTO);

    String updateAlmAsnltmpTopic(AlmAsnltmpTopicDTO almAsnltmpTopicDTO);

    String deleteAlmAsnltmpTopic(Integer aatId);

    AlmAsnltmpTopicDTO selectAlmAsnltmpTopic(Integer aatId);

    List<AlmAsnltmpTopicDTO> selectAllAlmAsnltmpTopic(String keyword,
                                                      String artType,
                                                      String aatName,
                                                      String aatTag,
                                                      String aatRegion,
                                                      Integer aatDepart,
                                                      String submitStaffName,
                                                      Integer onlineState,
                                                      String startTime,
                                                      String endTime,
                                                      Integer pageNo,
                                                      Integer pageSize);

    Integer getAllAlmAsnltmpTopic(String keyword,
                                  String artType,
                                  String aatName,
                                  String aatTag,
                                  String aatRegion,
                                  Integer aatDepart,
                                  String submitStaffName,
                                  Integer onlineState,
                                  String startTime,
                                  String endTime);
}



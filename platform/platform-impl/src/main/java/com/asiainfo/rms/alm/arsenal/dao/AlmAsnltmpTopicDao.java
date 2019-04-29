package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpTopicRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpTopicDao {
    Integer saveAlmAsnltmpTopic(AlmAsnltmpTopicRepository almAsnltmpTopicRepository);

    Integer updateAlmAsnltmpTopic(AlmAsnltmpTopicRepository almAsnltmpTopicRepository);

    Integer deleteAlmAsnltmpTopic(@Param("aatId")Integer aatId);

    AlmAsnltmpTopicRepository selectAlmAsnltmpTopic(@Param("aatId")Integer aatId);

    List<AlmAsnltmpTopicRepository> selectAllAlmAsnltmpTopic(@Param("keyword")String keyword,
                                                             @Param("artType")String artType,
                                                             @Param("aatName")String aatName,
                                                             @Param("aatTag")String aatTag,
                                                             @Param("aatRegion")String aatRegion,
                                                             @Param("aatDepart")Integer aatDepart,
                                                             @Param("submitStaffName")String submitStaffName,
                                                             @Param("onlineState")Integer onlineState,
                                                             @Param("startTime")String startTime,
                                                             @Param("endTime")String endTime,
                                                             @Param("offset") Integer offset,
                                                             @Param("size") Integer size);

    Integer getAllAlmAsnltmpTopic(@Param("keyword")String keyword,
                                  @Param("artType")String artType,
                                  @Param("aatName")String aatName,
                                  @Param("aatTag")String aatTag,
                                  @Param("aatRegion")String aatRegion,
                                  @Param("aatDepart")Integer aatDepart,
                                  @Param("submitStaffName")String submitStaffName,
                                  @Param("onlineState")Integer onlineState,
                                  @Param("startTime")String startTime,
                                  @Param("endTime")String endTime);
}

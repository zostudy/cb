package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpTopicRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpTopicDao {
    Integer saveAlmReqtmpTopic(AlmReqtmpTopicRepository almReqtmpTopicRepository);

    Integer updateAlmReqtmpTopic(AlmReqtmpTopicRepository almReqtmpTopicRepository);

    Integer deleteAlmReqtmpTopic(@Param("artId")Integer artId);

    AlmReqtmpTopicRepository selectAlmReqtmpTopicById(@Param("artId")Integer artId);

    List<AlmReqtmpTopicRepository> selectAllAlmReqtmpTopic(@Param("keyword")String keyword,
												    		@Param("artType")Integer artType,
												    		@Param("artName")String artName, 
												    		@Param("artTag")String artTag,
												    		@Param("artRegion")Integer artRegion,
												    		@Param("urgentLevel")Integer urgentLevel,
												    		@Param("submitStaffName")String submitStaffName,
                                                           @Param("offset") Integer offset,
                                                           @Param("size") Integer size);

    Integer getAllAlmReqtmpTopicCount(@Param("keyword")String keyword,
    		@Param("artType")Integer artType,
    		@Param("artName")String artName, 
    		@Param("artTag")String artTag,
    		@Param("artRegion")Integer artRegion,
    		@Param("urgentLevel")Integer urgentLevel,
    		@Param("submitStaffName")String submitStaffName);
}

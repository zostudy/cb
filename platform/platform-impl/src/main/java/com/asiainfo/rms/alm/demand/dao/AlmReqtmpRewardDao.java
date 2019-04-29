package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpRewardDao {

    Integer saveAlmReqtmpReward(AlmReqtmpRewardRepository almReqtmpRewardRepository);

    Integer updateAlmReqtmpReward(AlmReqtmpRewardRepository almReqtmpRewardRepository);

    Integer deleteAlmReqtmpReward(@Param("arrId")Integer arrId);

    AlmReqtmpRewardRepository selectAlmReqtmpReward(@Param("arrId")Integer arrId);

    AlmReqtmpRewardRepository selectAlmReqtmpRewardByArtId(@Param("artId")Integer artId);

    List<AlmReqtmpRewardRepository> selectAllAlmReqtmpReward(@Param("keyword")String keyword,
												    		@Param("artType")Integer artType,
												    		@Param("artName")String artName, 
												    		@Param("artTag")String artTag,
												    		@Param("artRegion")Integer artRegion,
												    		@Param("urgentLevel")Integer urgentLevel,
												    		@Param("submitStaffName")String submitStaffName,
                                                             @Param("offset") Integer offset,
                                                             @Param("size") Integer size);

    Integer getAllAlmReqtmpRewardCount(@Param("keyword")String keyword,
							    		@Param("artType")Integer artType,
							    		@Param("artName")String artName, 
							    		@Param("artTag")String artTag,
							    		@Param("artRegion")Integer artRegion,
							    		@Param("urgentLevel")Integer urgentLevel,
							    		@Param("submitStaffName")String submitStaffName);
}

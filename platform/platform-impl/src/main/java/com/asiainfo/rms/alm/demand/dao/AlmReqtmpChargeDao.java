package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpChargeRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpChargeDao {

    Integer saveAlmReqtmpCharge(AlmReqtmpChargeRepository almReqtmpChargeRepository);

    Integer updateAlmReqtmpCharge(AlmReqtmpChargeRepository almReqtmpChargeRepository);

    Integer deleteAlmReqtmpCharge(@Param("archId")Integer archId);

    AlmReqtmpChargeRepository selectAlmReqtmpCharge(@Param("archId")Integer archId);

    AlmReqtmpChargeRepository selectAlmReqtmpChargeByArtId(@Param("artId")Integer artId);

    List<AlmReqtmpChargeRepository> selectAllAlmReqtmpCharge(@Param("keyword")String keyword,
												    		@Param("artType")Integer artType,
												    		@Param("artName")String artName, 
												    		@Param("artTag")String artTag,
												    		@Param("artRegion")Integer artRegion,
												    		@Param("urgentLevel")Integer urgentLevel,
												    		@Param("submitStaffName")String submitStaffName
												    		, @Param("offset") Integer offset,
												    		@Param("size") Integer size);

    Integer getAllAlmReqtmpCharge(@Param("keyword")String keyword,
						    		@Param("artType")Integer artType,
						    		@Param("artName")String artName, 
						    		@Param("artTag")String artTag,
								    @Param("artRegion")Integer artRegion,
						    		@Param("urgentLevel")Integer urgentLevel,
						    		@Param("submitStaffName")String submitStaffName);
}

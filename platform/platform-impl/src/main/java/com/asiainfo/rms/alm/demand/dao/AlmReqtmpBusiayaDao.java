package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpBusiayaDao {
    Integer saveAlmReqtmpBusiaya(AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository);

    Integer updateAlmReqtmpBusiaya(AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository);

    Integer deleteAlmReqtmpBusiaya(@Param("arbaId")Integer arbaId);

    AlmReqtmpBusiayaRepository selectAlmReqtmpBusiaya(@Param("arbaId")Integer arbaId);

    List<AlmReqtmpBusiayaRepository> selectAllAlmReqtmpBusiaya(@Param("keyword")String keyword,
													    		@Param("artType")Integer artType,
													    		@Param("artName")String artName, 
													    		@Param("artTag")String artTag,
													    		@Param("artRegion")Integer artRegion,
													    		@Param("urgentLevel")Integer urgentLevel,
													    		@Param("submitStaffName")String submitStaffName,
                                                               @Param("offset") Integer offset,
                                                               @Param("size") Integer size);

    Integer getAllAlmReqtmpBusiayaCount(@Param("keyword")String keyword,
							    		@Param("artType")Integer artType,
							    		@Param("artName")String artName, 
							    		@Param("artTag")String artTag,
							    		@Param("artRegion")Integer artRegion,
							    		@Param("urgentLevel")Integer urgentLevel,
							    		@Param("submitStaffName")String submitStaffName);

    AlmReqtmpBusiayaRepository selectAlmReqtmpBusiayaByArtId(@Param("artId")Integer artId);

}

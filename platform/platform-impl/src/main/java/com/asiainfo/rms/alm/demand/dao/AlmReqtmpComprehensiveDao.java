package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpComprehensiveRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpComprehensiveDao {
    Integer saveAlmReqtmpConprehensive(AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository);

    Integer updateAlmReqtmpConprehensive(AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository);

    Integer deleteAlmReqtmpConprehensive(@Param("arcId") Integer arcId);

    AlmReqtmpComprehensiveRepository selectAlmReqtmpConprehensive(@Param("arcId") Integer arcId);

    AlmReqtmpComprehensiveRepository selectAlmReqtmpConprehensiveByArtId(@Param("artId") Integer artId);

    List<AlmReqtmpComprehensiveRepository> selectAllAlmReqtmpConprehensive(@Param("keyword") String keyword,
                                                                           @Param("artType") Integer artType,
                                                                           @Param("artName") String artName,
                                                                           @Param("artTag") String artTag,
                                                                           @Param("artRegion") Integer artRegion,
                                                                           @Param("urgentLevel") Integer urgentLevel,
                                                                           @Param("submitStaffName") String submitStaffName,
                                                                           @Param("offset") Integer offset,
                                                                           @Param("size") Integer size);

    Integer getAlmReqtmpConprehensive(@Param("keyword") String keyword,
                                      @Param("artType") Integer artType,
                                      @Param("artName") String artName,
                                      @Param("artTag") String artTag,
                                      @Param("artRegion") Integer artRegion,
                                      @Param("urgentLevel") Integer urgentLevel,
                                      @Param("submitStaffName") String submitStaffName);
}

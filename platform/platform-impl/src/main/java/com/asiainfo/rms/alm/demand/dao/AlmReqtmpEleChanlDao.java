package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpEleChanlRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpEleChanlDao {

    Integer saveAlmReqtmpEleChanl(AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository);

    Integer updateAlmReqtmpEleChanl(AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository);

    Integer deleteAlmReqtmpEleChanl(@Param("areId") Integer areId);

    AlmReqtmpEleChanlRepository selectAlmReqtmpEleChanl(@Param("areId") Integer areId);

    AlmReqtmpEleChanlRepository selectAlmReqtmpEleChanlByArtId(@Param("artId") Integer artId);

    List<AlmReqtmpEleChanlRepository> selectAllAlmReqtmpEleChanl(@Param("keyword") String keyword,
                                                                 @Param("artType") Integer artType,
                                                                 @Param("artName") String artName,
                                                                 @Param("artTag") String artTag,
                                                                 @Param("artRegion") Integer artRegion,
                                                                 @Param("urgentLevel") Integer urgentLevel,
                                                                 @Param("submitStaffName") String submitStaffName,
                                                                 @Param("offset") Integer offset,
                                                                 @Param("size") Integer size);

    Integer getAllAlmReqtmpEleChanlCount(@Param("keyword") String keyword,
                                         @Param("artType") Integer artType,
                                         @Param("artName") String artName,
                                         @Param("artTag") String artTag,
                                         @Param("artRegion") Integer artRegion,
                                         @Param("urgentLevel") Integer urgentLevel,
                                         @Param("submitStaffName") String submitStaffName);
}

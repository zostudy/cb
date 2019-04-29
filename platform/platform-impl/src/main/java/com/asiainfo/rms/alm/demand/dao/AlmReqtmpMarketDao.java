package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpMarketRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpMarketDao {
    Integer saveAlmReqtmpMarket(AlmReqtmpMarketRepository almReqtmpMarketRepository);

    Integer updateAlmReqtmpMarket(AlmReqtmpMarketRepository almReqtmpMarketRepository);

    Integer deletaAlmReqtmpMarket(@Param("armId") Integer armId);

    AlmReqtmpMarketRepository selectAlmReqtmpMarket(@Param("armId") Integer armId);

    AlmReqtmpMarketRepository selectAlmReqtmpMarketByArtId(@Param("artId") Integer artId);

    Integer getAllAlmReqtmpMarket(@Param("keyword") String keyword,
                                  @Param("artType") Integer artType,
                                  @Param("artName") String artName,
                                  @Param("artTag") String artTag,
                                  @Param("artRegion") Integer artRegion,
                                  @Param("urgentLevel") Integer urgentLevel,
                                  @Param("submitStaffName") String submitStaffName);

    List<AlmReqtmpMarketRepository> selectAllAlmReqtmpMarket(@Param("keyword") String keyword,
                                                             @Param("artType") Integer artType,
                                                             @Param("artName") String artName,
                                                             @Param("artTag") String artTag,
                                                             @Param("artRegion") Integer artRegion,
                                                             @Param("urgentLevel") Integer urgentLevel,
                                                             @Param("submitStaffName") String submitStaffName,
                                                             @Param("offset") Integer offset, @Param("size") Integer size);

}

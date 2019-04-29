package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpFunctionRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpFunctionDao {
    Integer saveAlmReqtmpFunction(AlmReqtmpFunctionRepository almReqtmpFunctionRepository);

    Integer updateAlmReqtmpFunction(AlmReqtmpFunctionRepository almReqtmpFunctionRepository);

    Integer deleteAlmReqtmpFunction(@Param("arfId") Integer arfId);

    AlmReqtmpFunctionRepository selectAlmReqtmpFunction(@Param("arfId") Integer arfId);

    AlmReqtmpFunctionRepository selectAlmReqtmpFunctionByArtId(@Param("artId") Integer artId);

    List<AlmReqtmpFunctionRepository> selectAllAlmReqtmpFunction(@Param("keyword") String keyword,
                                                                 @Param("artType") Integer artType,
                                                                 @Param("artName") String artName,
                                                                 @Param("artTag") String artTag,
                                                                 @Param("artRegion") Integer artRegion,
                                                                 @Param("urgentLevel") Integer urgentLevel,
                                                                 @Param("submitStaffName") String submitStaffName,
                                                                 @Param("offset") Integer offset, @Param("size") Integer size);

    Integer getAllAlmReqtmpFunctionCount(@Param("keyword") String keyword,
                                         @Param("artType") Integer artType,
                                         @Param("artName") String artName,
                                         @Param("artTag") String artTag,
                                         @Param("artRegion") Integer artRegion,
                                         @Param("urgentLevel") Integer urgentLevel,
                                         @Param("submitStaffName") String submitStaffName);
}

package com.asiainfo.rms.alm.demand.dao;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpSimpleParamRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpSimpleParamDao {

    Integer saveAlmReqtmpSimpleParam(AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository);

    Integer updateAlmReqtmpSimpleParam(AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository);

    Integer deleteAlmReqtmpSimpleParam(@Param("arspId")Integer arspId);

    AlmReqtmpSimpleParamRepository selectAlmReqtmpSimpleParam(@Param("arspId")Integer arspId);

    AlmReqtmpSimpleParamRepository selectAlmReqtmpSimpleParamByArtId(@Param("artId")Integer artId);

    List<AlmReqtmpSimpleParamRepository> selectAllAlmReqtmpSimpleParam(@Param("artId")Integer artId,
    		 															@Param("modifyType")Integer modifyType,
                                                                       @Param("offset") Integer offset,
                                                                       @Param("size") Integer size);

    Integer getAllAlmReqtmpSimpleParam(@Param("artId")Integer artId,@Param("modifyType")Integer modifyType);
    
    List<Integer> getAllAlmReqtmpSimpleParamType(@Param("artId")Integer artId);
}

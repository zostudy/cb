package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmReqtmpConfigRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmReqtmpConfigDao {
    Integer saveAlmReqtmpConfig(AlmReqtmpConfigRepository almReqtmpConfigRepository);

    Integer updateAlmReqtmpConfig(AlmReqtmpConfigRepository almReqtmpConfigRepository);

    Integer deleteAlmReqtmpConfig(@Param("id")Integer id);

    AlmReqtmpConfigRepository selectAlmReqtmpConfig(@Param("id")Integer id);

    List<AlmReqtmpConfigRepository> selectAllAlmReqtmpConfig(@Param("keyword")String keyword,
                                                             @Param("offset") Integer offset,
                                                             @Param("size") Integer size);

    Integer getAllAlmReqtmpConfigCount(@Param("keyword")String keyword);


}

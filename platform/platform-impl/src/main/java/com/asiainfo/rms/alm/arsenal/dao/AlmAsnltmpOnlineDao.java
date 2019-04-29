package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpOnlineRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpOnlineDao {
    Integer saveAlmAsnltmpOnline(AlmAsnltmpOnlineRepository almAsnltmpOnlineRepository);

    Integer updateAlmAsnltmpOnline(AlmAsnltmpOnlineRepository almAsnltmpOnlineRepository);

    Integer deleteAlmAsnltmpOnline(@Param("aaoId")Integer aaoId);

    AlmAsnltmpOnlineRepository selectAlmAsnltmpOnline(@Param("aaoId")Integer aaoId);

    Integer getAllAlmAsnltmpOnlineCount(@Param("keyword")String keyword);

    List<AlmAsnltmpOnlineRepository> selectAllAlmAsnltmpOnline(@Param("keyword")String keyword,
                                                               @Param("offset") Integer offset,
                                                               @Param("size") Integer size);
}

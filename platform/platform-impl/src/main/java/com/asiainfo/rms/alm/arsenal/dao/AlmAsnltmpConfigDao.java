package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpConfigRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpConfigDao {
    Integer saveAlmAsnltmpConfig(AlmAsnltmpConfigRepository almAsnltmpConfigRepository);

    Integer updateAlmAsnltmpConfig(AlmAsnltmpConfigRepository almAsnltmpConfigRepository);

    Integer deleteAlmAsnltmpConfig(@Param("aacId")Integer aacId);

    AlmAsnltmpConfigRepository selectAlmAsnltmpConfigById(@Param("aacId")Integer aacId);

    List<AlmAsnltmpConfigRepository> selectAllAlmAsnltmpConfig(@Param("keyword")String keyword,
                                                               @Param("offset") Integer offset,
                                                               @Param("size") Integer size);

    Integer getAllAlmAsnltmpConfigCount(@Param("keyword")String keyword);
}

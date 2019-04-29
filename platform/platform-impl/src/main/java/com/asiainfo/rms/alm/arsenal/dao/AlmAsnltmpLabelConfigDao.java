package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpLabelConfigRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpLabelConfigDao {
    Integer saveAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigRepository almAsnltmpLabelConfigRepository);

    Integer updateAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigRepository almAsnltmpLabelConfigRepository);

    Integer deleteAlmAsnltmpLabelConfig(@Param("lmId")Integer lmId);

    AlmAsnltmpLabelConfigRepository selectAlmAsnltmpLabelConfigById(@Param("lmId")Integer lmId);

    List<AlmAsnltmpLabelConfigRepository> selectAllAlmAsnltmpLabelConfig(@Param("keyword")String keyword,
                                                                         @Param("offset") Integer offset,
                                                                         @Param("size") Integer size);

    Integer getAllAlmAsnltmpLabelConfigCount(@Param("keyword")String keyword);
}

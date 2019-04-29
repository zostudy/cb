package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceRelatRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpServiceRelatDao {
    Integer saveAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatRepository almAsnltmpServiceRelatRepository);

    Integer updateAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatRepository almAsnltmpServiceRelatRepository);

    Integer deleteAlmAsnltmpServiceRelat(@Param("asrId")Integer asrId);

    AlmAsnltmpServiceRelatRepository selectAlmAsnltmpServiceRelat(@Param("asrId")Integer asrId);

    List<AlmAsnltmpServiceRelatRepository> selectAllAlmAsnltmpServiceRelat(@Param("artType")Integer artType,
                                                                           @Param("offset") Integer offset,
                                                                           @Param("size") Integer size);

    Integer getAllAlmAsnltmpServiceRelatCount(@Param("artType")Integer artType);

    List<AlmAsnltmpServiceRelatRepository> selectAlmAsnltmpServiceRelatByArtType(@Param("artType")Integer artType,
                                                                           @Param("aatId")Integer aatId,
                                                                           @Param("objId")Integer objId);

    Integer getServiceByTypeAndId(@Param("artType")Integer artType,@Param("asId")Integer asId);
}

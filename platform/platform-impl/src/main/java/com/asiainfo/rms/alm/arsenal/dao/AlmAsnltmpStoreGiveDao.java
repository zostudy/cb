package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpStoreGiveRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpStoreGiveDao {
    Integer saveAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository);

    Integer updateAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository);

    Integer deleteAlmAsnltmpStoreGive(@Param("aasId")Integer aasId);

    AlmAsnltmpStoreGiveRepository selectAlmAsnltmpStoreGive(@Param("aasId")Integer aasId);

    List<AlmAsnltmpStoreGiveRepository> selectAllAlmAsnltmpStoreGive(@Param("aatId")Integer aatId,
                                                                     @Param("offset") Integer offset,
                                                                     @Param("size") Integer size);

    Integer getAllAlmAsnltmpStoreGive(@Param("aatId")Integer aatId);

    AlmAsnltmpStoreGiveRepository selectStoreGiveInfo(@Param("aatId")Integer aatId);
}

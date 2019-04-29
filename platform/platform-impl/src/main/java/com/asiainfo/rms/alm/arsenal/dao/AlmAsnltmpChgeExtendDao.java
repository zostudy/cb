package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChgeExtendRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpChgeExtendDao {
    Integer saveAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendRepository almAsnltmpChgeExtendRepository);

    Integer updateAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendRepository almAsnltmpChgeExtendRepository);

    Integer deleteAlmAsnltmpChgeExtend(@Param("aceId")Integer aceId);

    AlmAsnltmpChgeExtendRepository selectAlmAsnltmpChgeExtendById(@Param("aceId")Integer aceId);

    List<AlmAsnltmpChgeExtendRepository> selectAllAlmAsnltmpChgeExtend(@Param("aatId")Integer aatId,
                                                                       @Param("offset") Integer offset,
                                                                       @Param("size") Integer size);

    Integer getAllAlmAsnltmpChgeExtend(@Param("aatId")Integer aatId);
}

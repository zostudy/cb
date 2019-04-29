package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpSgExtendRepository;
import org.apache.ibatis.annotations.Param;

public interface AlmAsnltmpSgExtendDao {
    Integer saveAlmAsnltmpSgExtend(AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository);
//
    Integer updateAlmAsnltmpSgExtend(AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository);
//
//    Integer deleteAlmAsnltmpSgExtend(Integer aasId);

    AlmAsnltmpSgExtendRepository selectAlmAsnltmpSgExtend(Integer aasId);

//    List<AlmAsnltmpSgExtendRepository> selectAllAlmAsnltmpSgExtend(@Param("aatId")Integer aatId,
//                                                                   @Param("offset") Integer offset,
//                                                                   @Param("size") Integer size);
//
//    Integer getAllAlmAsnltmpSgExtend(@Param("aatId")Integer aatId);

    AlmAsnltmpSgExtendRepository selectSgExtendInfo(@Param("aatId")Integer aatId);


}

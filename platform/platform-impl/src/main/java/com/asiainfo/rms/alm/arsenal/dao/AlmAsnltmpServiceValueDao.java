package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceValueRepository;
import org.apache.ibatis.annotations.Param;

public interface AlmAsnltmpServiceValueDao {
    Integer saveAlmAsnltmpServiceValue(AlmAsnltmpServiceValueRepository almAsnltmpServiceValueRepository);

    Integer updateAlmAsnltmpServiceValue(AlmAsnltmpServiceValueRepository almAsnltmpServiceValueRepository);

    Integer deleteAlmAsnltmpServiceValue(@Param("asvId")Integer asvId);

//    AlmAsnltmpServiceValueRepository selectAlmAsnltmpServiceValue(@Param("asvId")Integer asvId);

//    List<AlmAsnltmpServiceValueRepository> selectAllAlmAsnltmpServiceValue(@Param("keyword")String keyword,
//                                                                           @Param("offset") Integer offset,
//                                                                           @Param("size") Integer size);
//
//    Integer getAllAlmAsnltmpServiceValueCount(@Param("keyword")String keyword);
}

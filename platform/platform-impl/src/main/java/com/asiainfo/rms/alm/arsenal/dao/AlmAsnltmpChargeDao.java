package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChargeRepository;
import org.apache.ibatis.annotations.Param;

public interface AlmAsnltmpChargeDao {
    Integer saveAlmAsnltmpCharge(AlmAsnltmpChargeRepository almAsnltmpChargeRepository);

    Integer updateAlmAsnltmpCharge(AlmAsnltmpChargeRepository almAsnltmpChargeRepository);

    AlmAsnltmpChargeRepository selectAlmAsnltmpChargeByAarId(@Param("aatId")Integer aatId);

    Integer getChargeByAatId(@Param("aatId")Integer aatId);

}

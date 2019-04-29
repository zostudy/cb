package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleValueRepository;
import org.apache.ibatis.annotations.Param;

public interface AlmAsnltmpRuleValueDao {
    Integer saveAlmAsnltmpRuleValue(AlmAsnltmpRuleValueRepository almAsnltmpRuleValueRepository);

    Integer updateAlmAsnltmpRuleValue(AlmAsnltmpRuleValueRepository almAsnltmpRuleValueRepository);

    Integer deleteAlmAsnltmpRuleValue(@Param("aarvId")Integer aarvId);

//    AlmAsnltmpRuleValueRepository selectAlmAsnltmpRuleValue(@Param("aarvId")Integer aarvId);
}

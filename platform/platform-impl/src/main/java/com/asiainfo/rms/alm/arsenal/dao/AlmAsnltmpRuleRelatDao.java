package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleRelatRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmAsnltmpRuleRelatDao {
    Integer saveAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatRepository almAsnltmpRuleRelatRepository);

    Integer updateAlmAsnltmpRuleRelat(AlmAsnltmpRuleRelatRepository almAsnltmpRuleRelatRepository);

    Integer deleteAlmAsnltmpRuleRelat(@Param("atrrId")Integer atrrId);

    AlmAsnltmpRuleRelatRepository selectAlmAsnltmpRuleRela(@Param("atrrId")Integer atrrId);

    List<AlmAsnltmpRuleRelatRepository> selectAllAlmAsnltmpRuleRela(@Param("artType")Integer artType,
                                                                    @Param("offset") Integer offset,
                                                                    @Param("size") Integer size);

    Integer getAllAlmAsnltmpRuleRelaCount(@Param("artType")Integer artType);

    List<AlmAsnltmpRuleRelatRepository> selectAlmAsnltmpServiceRelatByArtType(@Param("artType")Integer artType,
                                                                    @Param("aatId")Integer aatId,
                                                                    @Param("objId")Integer objId);

    Integer getRuleRelaByTypeAndId(@Param("artType")Integer artType,@Param("arId")Integer arId);
}

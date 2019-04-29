package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalRulesRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlmArsenalRulesDao {

    Integer saveAlmArsenalRules(AlmArsenalRulesRepository almArsenalRulesRepository);

    Integer updateAlmArsenalRules(AlmArsenalRulesRepository almArsenalRulesRepository);

    Integer deleteAlmArsenalRules(@Param("arId")Integer arId);

    AlmArsenalRulesRepository selectArsenalRulesById(@Param("arId")Integer arId);


    List<AlmArsenalRulesRepository> selectAllArsenalRules(@Param("keyword")String keyword,
                                                          @Param("offset") Integer offset,
                                                          @Param("size") Integer size);

    Integer getAllArsenalRules(@Param("keyword")String keyword);

    Integer getRuleTagCount(@Param("ruleTag")String ruleTag);
}

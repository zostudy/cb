package com.asiainfo.rms.system.dao;


import com.asiainfo.rms.system.domain.SysStructureDefRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStructureDefDao {
    Integer saveStructure(SysStructureDefRepository sysStructureDefRepository);

    Integer updateStructure(SysStructureDefRepository sysStructureDefRepository);

    Integer deleteStructure(@Param("structureId")Integer structureId);

    SysStructureDefRepository selectByStructureId(@Param("structureId")Integer structureId);

    List<SysStructureDefRepository> selectAllStructure();

    Integer getStructureByKeywordCount(@Param("keyword")String keyword,@Param("structureParentId")Integer structureParentId);

    List<SysStructureDefRepository> selectStructureByKeyword(@Param("keyword")String keyword,
                                                               @Param("structureParentId")Integer structureParentId,
                                                               @Param("offset") Integer offset,
                                                               @Param("size") Integer size);
}

package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStructureInfoRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStructureInfoDao {
    Integer saveStructureInfo(SysStructureInfoRepository sysStructureInfoRepository);

    Integer updateStructureInfo(SysStructureInfoRepository sysStructureInfoRepository);

    Integer deleteStructureInfo(@Param("structureId")Integer structureId);

    SysStructureInfoRepository selectInfoByStructureId(@Param("structureId")Integer structureId);

    List<SysStructureInfoRepository> selectAllStructureInfo();
}

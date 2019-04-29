package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStructureDTO;
import com.asiainfo.rms.system.dto.SysStructureDefDTO;

import java.util.List;

public interface SysStructureService {
    String saveStructure( SysStructureDTO sysStructureDTO);

    String updateStructure(Integer structureId,SysStructureDTO sysStructureDTO);

    String deleteStructure(Integer structureId);

    SysStructureDTO selectByStructureId(Integer structureId);

    List<SysStructureDefDTO> selectAllStructure();


    List<SysStructureDefDTO> selectStructureByKeyword(String keyword,Integer structureParentId, Integer pageNo,Integer pageSize);

    Integer getStructureByKeywordCount(String keyWord,Integer structureParentId);
}

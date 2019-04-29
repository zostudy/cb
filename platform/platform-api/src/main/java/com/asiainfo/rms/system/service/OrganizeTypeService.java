package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysOrganizeTypeDTO;

import java.util.List;

public interface OrganizeTypeService {
    String saveOrganizeType(SysOrganizeTypeDTO organizeTypeDTO);

    String updateOrganizeType(SysOrganizeTypeDTO organizeTypeDTO);

    String deleteOrganizeTypeById(Integer organizeTypeId );

    List<SysOrganizeTypeDTO> selectOrganizeType(String keywork,Integer pageNo, Integer pageSize);

    Integer getOrganizeTypeCount(String keywork);
}

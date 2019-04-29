package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysDataRoleDTO;

import java.util.List;

public interface SysDataRoleService {

    String saveSysDataRole(SysDataRoleDTO dataRoleDTO);

    String updateSysDataRole(SysDataRoleDTO dataRoleDTO);

    String deleteSysDataRoleById(Integer dataRoleId);

    List<SysDataRoleDTO> selectSysDataRole(String keyword,Integer organizeId,Integer pageNo, Integer pageSize);

    Integer getSysDataRoleCount(String keyword,Integer organizeId);
}

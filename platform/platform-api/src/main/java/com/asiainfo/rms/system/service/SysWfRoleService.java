package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysWfRoleDTO;

import java.util.List;

public interface SysWfRoleService {

    String saveSysWfRole(SysWfRoleDTO wfRoleDTO);

    String updateSysWfRole(SysWfRoleDTO wfRoleDTO);

    String deleteSysWfRoleById(Integer wfRoleId);

    List<SysWfRoleDTO> selectSysWfRole(String keyword,Integer selectedStationId,String processKey, Integer pageNo, Integer pageSize);

    Integer getSysWfRoleCount(String keyword,Integer selectedStationId,String processKey);
}

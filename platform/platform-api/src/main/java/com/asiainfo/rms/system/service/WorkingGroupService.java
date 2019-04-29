package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysWorkingGroupDTO;

import java.util.List;

public interface WorkingGroupService {
    String saveWorkingGroup(SysWorkingGroupDTO workingGroupDTO);

    String updateWorkingGroup(SysWorkingGroupDTO workingGroupDTO);

    String deleteWorkingGroupById(Integer workGroupId);

    List<SysWorkingGroupDTO> selectAllWorkingGroup(String workGroupName, Integer pageNo, Integer pageSize );

    int getWorkingGroupCount(String workGroupName);
}

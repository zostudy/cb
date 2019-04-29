package com.asiainfo.rms.system.service;

import com.asiainfo.rms.system.dto.SysStaffWorkingGroupDTO;

import java.util.List;

public interface StaffWorkingGroupService {
    String saveStaffWorkingGroup(SysStaffWorkingGroupDTO staffWorkingGroupDTO);

    String deleteStaffWorkingGroup(Integer relId);

    List<SysStaffWorkingGroupDTO> selectStaffWorkingGroup(Integer workGroupId,String keyword,Integer pageNo, Integer pageSize);

    Integer getStaffWorkingGroupCount(Integer workGroupId,String keyword);

    List<SysStaffWorkingGroupDTO> selectStaffByWorkGroupId(Integer workGroupId,String keyword,Integer pageNo, Integer pageSize);

    Integer getStaffByWorkGroupIdCount(Integer workGroupId,String keyword);
}

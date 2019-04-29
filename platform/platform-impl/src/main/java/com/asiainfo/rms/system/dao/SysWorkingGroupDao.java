package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysWorkingGroupRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysWorkingGroupDao {
    Integer saveWorkingGroup(SysWorkingGroupRepository workingGroupRepository);

    Integer updateWorkingGroup(SysWorkingGroupRepository workingGroupRepository);

    Integer deleteWorkingGroupById(@Param("workGroupId")Integer workGroupId);

    List<SysWorkingGroupRepository> selectAllWorkingGroup(@Param("workGroupName") String workGroupName, @Param("offset") Integer offset, @Param("size") Integer size);

    Integer getWorkingGroupCount(@Param("workGroupName") String workGroupName);

    List<SysWorkingGroupRepository> selectAllCode();
}

package com.asiainfo.rms.system.dao;

import com.asiainfo.rms.system.domain.SysStaffWorkingGroupRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysStaffWorkingGroupDao {

    Integer saveStaffWorkingGroup(SysStaffWorkingGroupRepository staffWorkingGroupRepository);

    Integer deleteStaffWorkingGroup(@Param("relId")Integer relId);

    List<SysStaffWorkingGroupRepository> selectStaffWorkingGroup(@Param("workGroupId")Integer workGroupId, @Param("keyword")String keyword, @Param("offset") Integer offset, @Param("size") Integer size);

    Integer getStaffWorkingGroupCount(@Param("workGroupId")Integer workGroupId, @Param("keyword")String keyword);

    List<SysStaffWorkingGroupRepository> selectStaffByWorkGroupId(@Param("workGroupId")Integer workGroupId, @Param("keyword")String keyword, @Param("offset") Integer offset, @Param("size") Integer size);

    Integer getStaffByWorkGroupIdCount(@Param("workGroupId")Integer workGroupId, @Param("keyword")String keyword);

    Integer getWorkGroupById(@Param("staffId")Integer staffId,@Param("workGroupId")Integer workGroupId);
}

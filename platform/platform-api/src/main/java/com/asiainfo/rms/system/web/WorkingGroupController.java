package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysWorkingGroupDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface WorkingGroupController {

    /**
     * 新增工作组
     * @param workingGroupDTO
     */
    @RequestMapping(value="/work_group",method = RequestMethod.POST)
    String saveWorkingGroup(@RequestBody SysWorkingGroupDTO workingGroupDTO);

    /**
     * 修改工作组
     * @param workGroupId
     * @param workingGroupDTO
     */
    @RequestMapping(value="/work_group/{work_group_id}",method = RequestMethod.PUT)
    String updateWorkingGroup(@PathVariable("work_group_id")Integer workGroupId,SysWorkingGroupDTO workingGroupDTO);

    /**
     * 删除工作组
     * @param workGroupId
     */
    @RequestMapping(value="/work_group/{work_group_id}",method = RequestMethod.DELETE)
    String deleteWorkingGroupById(@PathVariable("work_group_id")Integer workGroupId);

    /**
     * 查询工作组
     * @param workGroupName
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/work_group/all",method = RequestMethod.GET)
    Page<SysWorkingGroupDTO> selectAllWorkingGroup(@RequestParam(value = "work_group_name", required = false)String workGroupName,
                                                   @RequestParam(value = "page_no") Integer pageNo,
                                                   @RequestParam(value = "page_size") Integer pageSize);


}

package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStaffWorkingGroupDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface StaffWorkingGroupController {

    /**
     * 新增人员工作组关系
     * @param staffWorkingGroupDTO
     */
    @RequestMapping(value="/staff_working_group",method = RequestMethod.POST)
    String saveStaffWorkingGroup(@RequestBody SysStaffWorkingGroupDTO staffWorkingGroupDTO);

    /**
     * 删除人员工作组关系
     * @param relId
     */
    @RequestMapping(value="/staff_working_group/{rel_id}",method = RequestMethod.DELETE)
    String deleteStaffWorkingGroup(@PathVariable("rel_id")Integer relId);

    /**
     * 查询所有工作组
     * @param workGroupId
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/staff_working_group/all",method = RequestMethod.GET)
    Page<SysStaffWorkingGroupDTO> selectStaffWorkingGroup(@RequestParam("work_group_id")Integer workGroupId,
                                                          @RequestParam(value = "keyword",required = false)String keyword,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize);


    @RequestMapping(value="/staff_working_group/staffs",method = RequestMethod.GET)
    Page<SysStaffWorkingGroupDTO> selectStaffByWorkGroupId(@RequestParam("work_group_id")Integer workGroupId,
                                                           @RequestParam(value = "keyword",required = false)String keyword,
                                                           @RequestParam(value = "page_no") Integer pageNo,
                                                           @RequestParam(value = "page_size") Integer pageSize);

}

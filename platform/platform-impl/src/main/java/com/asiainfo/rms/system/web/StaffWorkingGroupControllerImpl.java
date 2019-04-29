package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStaffWorkingGroupDTO;
import com.asiainfo.rms.system.service.StaffWorkingGroupService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class StaffWorkingGroupControllerImpl implements StaffWorkingGroupController {
    private final StaffWorkingGroupService staffWorkingGroupService;

    public StaffWorkingGroupControllerImpl(StaffWorkingGroupService staffWorkingGroupService) {
        this.staffWorkingGroupService = staffWorkingGroupService;
    }

    @Override
    public String saveStaffWorkingGroup(@RequestBody SysStaffWorkingGroupDTO staffWorkingGroupDTO) {
        return staffWorkingGroupService.saveStaffWorkingGroup(staffWorkingGroupDTO);
    }

    @Override
    public String deleteStaffWorkingGroup(@PathVariable("rel_id")Integer relId) {
        return staffWorkingGroupService.deleteStaffWorkingGroup(relId);

    }

    @Override
    public Page<SysStaffWorkingGroupDTO> selectStaffWorkingGroup(@RequestParam("work_group_id")Integer workGroupId,
                                                                 @RequestParam(value = "keyword",required = false)String keyword,
                                                                 @RequestParam(value = "page_no") Integer pageNo,
                                                                 @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStaffWorkingGroupDTO> page = new Page<>();
        int cnt = staffWorkingGroupService.getStaffWorkingGroupCount(workGroupId,keyword);
        if (cnt == 0) {
            return page;
        }
        List<SysStaffWorkingGroupDTO> items = staffWorkingGroupService.selectStaffWorkingGroup(workGroupId,keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }

    @Override
    public Page<SysStaffWorkingGroupDTO> selectStaffByWorkGroupId(@RequestParam("work_group_id")Integer workGroupId,
                                                                  @RequestParam(value = "keyword",required = false)String keyword,
                                                                  @RequestParam(value = "page_no") Integer pageNo,
                                                                  @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStaffWorkingGroupDTO> page = new Page<>();
        int cnt = staffWorkingGroupService.getStaffByWorkGroupIdCount(workGroupId,keyword);
        if (cnt == 0) {
            return page;
        }
        List<SysStaffWorkingGroupDTO> items = staffWorkingGroupService.selectStaffByWorkGroupId(workGroupId,keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

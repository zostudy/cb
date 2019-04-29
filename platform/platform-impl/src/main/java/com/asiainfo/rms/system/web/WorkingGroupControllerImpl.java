package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.domain.SysWorkingGroupRepository;
import com.asiainfo.rms.system.dto.SysWorkingGroupDTO;
import com.asiainfo.rms.system.service.WorkingGroupService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class WorkingGroupControllerImpl implements WorkingGroupController {
    private final WorkingGroupService workingGroupService;

    public WorkingGroupControllerImpl(WorkingGroupService workingGroupService) {
        this.workingGroupService = workingGroupService;
    }

    @Override
    public String saveWorkingGroup(@RequestBody SysWorkingGroupDTO workingGroupDTO) {

        return workingGroupService.saveWorkingGroup(workingGroupDTO);
    }

    @Override
    public String updateWorkingGroup(@PathVariable("work_group_id")Integer workGroupId,
                                   @RequestBody SysWorkingGroupDTO workingGroupDTO) {
        workingGroupDTO.setWorkGroupId(workGroupId);
        return workingGroupService.updateWorkingGroup(workingGroupDTO);

    }

    @Override
    public String deleteWorkingGroupById(@PathVariable("work_group_id")Integer workGroupId) {
        return workingGroupService.deleteWorkingGroupById(workGroupId);

    }

    @Override
    public Page<SysWorkingGroupDTO> selectAllWorkingGroup(@RequestParam(value = "work_group_name", required = false)String workGroupName,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysWorkingGroupDTO> page = new Page<>();
        int cnt = workingGroupService.getWorkingGroupCount(workGroupName);
        if (cnt == 0) {
            return page;
        }
        List<SysWorkingGroupDTO> workGroupList = workingGroupService.selectAllWorkingGroup(workGroupName,pageNo,pageSize);
        if (CollectionUtils.isEmpty(workGroupList)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(workGroupList);
        return page;
    }
}

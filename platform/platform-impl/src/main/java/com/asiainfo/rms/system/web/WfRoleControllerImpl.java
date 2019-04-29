package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysWfRoleDTO;
import com.asiainfo.rms.system.service.SysWfRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class WfRoleControllerImpl implements SysWfRoleController {
    private final SysWfRoleService wfRoleService;

    public WfRoleControllerImpl(SysWfRoleService wfRoleService) {
        this.wfRoleService = wfRoleService;
    }

    @Override
    public String saveSysWfRole(@RequestBody SysWfRoleDTO wfRoleDTO) {
        return wfRoleService.saveSysWfRole(wfRoleDTO);
    }

    @Override
    public String updateSysWfRole(@PathVariable("wf_role_id") Integer wfRoleId, @RequestBody SysWfRoleDTO wfRoleDTO) {
        wfRoleDTO.setWfRoleId(wfRoleId);
        return wfRoleService.updateSysWfRole(wfRoleDTO);

    }

    @Override
    public String deleteSysWfRoleById(@PathVariable("wf_role_id") Integer wfRoleId) {
        return wfRoleService.deleteSysWfRoleById(wfRoleId);

    }

    @Override
    public Page<SysWfRoleDTO> selectSysWfRole(@RequestParam(value = "keyword", required = false) String keyword,
                                              @RequestParam(value ="selected_station_id",required = false)Integer selectedStationId,
                                              @RequestParam(value = "process_key", required = false) String processKey,
                                              @RequestParam(value = "page_no") Integer pageNo,
                                              @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysWfRoleDTO> page = new Page<>();
        int cnt = wfRoleService.getSysWfRoleCount(keyword, selectedStationId,processKey);
        if (cnt == 0) {
            return page;
        }
        List<SysWfRoleDTO> items = wfRoleService.selectSysWfRole(keyword, selectedStationId,processKey, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

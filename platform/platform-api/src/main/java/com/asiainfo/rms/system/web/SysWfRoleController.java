package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysWfRoleDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface SysWfRoleController {

    /**
     * 新增流程角色
     *
     * @param wfRoleDTO
     */
    @RequestMapping(value = "/wf_role", method = RequestMethod.POST)
    String saveSysWfRole(@RequestBody SysWfRoleDTO wfRoleDTO);

    /**
     * 修改流程角色
     *
     * @param wfRoleId
     * @param wfRoleDTO
     */
    @RequestMapping(value = "/wf_role/{wf_role_id}", method = RequestMethod.PUT)
    String updateSysWfRole(@PathVariable("wf_role_id") Integer wfRoleId, @RequestBody SysWfRoleDTO wfRoleDTO);

    /**
     * 删除流程角色
     *
     * @param wfRoleId
     */
    @RequestMapping(value = "/wf_role/{wf_role_id}", method = RequestMethod.DELETE)
    String deleteSysWfRoleById(@PathVariable("wf_role_id") Integer wfRoleId);

    @RequestMapping(value = "/wf_role/all", method = RequestMethod.GET)
    Page<SysWfRoleDTO> selectSysWfRole(@RequestParam(value = "keyword", required = false) String keyword,
                                       @RequestParam(value ="selected_station_id",required = false)Integer selectedStationId,
                                       @RequestParam(value = "process_key", required = false) String processKey,
                                       @RequestParam(value = "page_no") Integer pageNo,
                                       @RequestParam(value = "page_size") Integer pageSize);
}

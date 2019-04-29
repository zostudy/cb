package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import com.asiainfo.rms.system.dto.SysStationWfRoleDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface SysStationWfRoleController {

    /**
     * 新增岗位流程角色关系
     * @param stationWfRoleDTO
     */
    @RequestMapping(value="/station_wf_role",method = RequestMethod.POST)
    String saveStationWfRole(@RequestBody SysStationWfRoleDTO stationWfRoleDTO);

    /**
     * 删除岗位流程角色关系
     * @param relId
     */
    @RequestMapping(value="/station_wf_role/{rel_id}",method = RequestMethod.DELETE)
    String deleteStationWfRole(@PathVariable("rel_id")Integer relId);

    @RequestMapping(value = "/station_wf_role/all",method = RequestMethod.GET)
    Page<SysStationWfRoleDTO> selectStationWfRoleByStationId(@RequestParam("station_id")Integer stationId,
                                                             @RequestParam(value = "keyword",required = false)String keyword,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize);
}

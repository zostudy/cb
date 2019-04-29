package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface SysStationDataRoleController {

    /**
     * 新增岗位数据角色关系
     * @param stationDataRoleDTO
     */
    @RequestMapping(value="/station_data_role",method = RequestMethod.POST)
    String saveStationDataRole(@RequestBody SysStationDataRoleDTO stationDataRoleDTO);

    /**
     * 删除岗位数据角色关系
     * @param relId
     */
    @RequestMapping(value="/station_data_role/{rel_id}",method = RequestMethod.DELETE)
    String deleteStationDataRole(@PathVariable("rel_id")Integer relId);

    @RequestMapping(value="/station_data_role/all",method = RequestMethod.GET)
    Page<SysStationDataRoleDTO> selectStationDataRoleByStationId(@RequestParam("station_id")Integer stationId,
                                                                 @RequestParam(value = "keyword",required = false)String keyword,
                                                                 @RequestParam(value = "page_no") Integer pageNo,
                                                                 @RequestParam(value = "page_size") Integer pageSize);
}

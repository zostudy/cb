package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysDataRoleDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface SysDataRoleController {

    /**
     * 新增数据角色
     * @param dataRoleDTO
     */
    @RequestMapping(value="/data_role",method = RequestMethod.POST)
    String saveSysDataRole(@RequestBody SysDataRoleDTO dataRoleDTO);

    /**
     * 修改数据角色
     * @param dataRoleId
     * @param dataRoleDTO
     */
    @RequestMapping(value="/data_role/{data_role_id}",method = RequestMethod.PUT)
    String updateSysDataRole(@PathVariable("data_role_id")Integer dataRoleId,@RequestBody SysDataRoleDTO dataRoleDTO);

    /**
     * 删除数据角色
     * @param dataRoleId
     */
    @RequestMapping(value="/data_role/{data_role_id}",method = RequestMethod.DELETE)
    String deleteSysDataRoleById(@PathVariable("data_role_id")Integer dataRoleId);

    @RequestMapping(value = "/data_role/all",method = RequestMethod.GET)
    Page<SysDataRoleDTO> selectSysDataRole(@RequestParam(value = "keyword",required = false)String keyword,
                                           @RequestParam(value="organize_id",required = false)Integer organizeId,
                                           @RequestParam(value = "page_no") Integer pageNo,
                                           @RequestParam(value = "page_size") Integer pageSize);
}

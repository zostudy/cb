package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysDataRoleDTO;
import com.asiainfo.rms.system.service.SysDataRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class DataRoleControllerImpl implements SysDataRoleController {
    private final SysDataRoleService dataRoleService;

    public DataRoleControllerImpl(SysDataRoleService dataRoleService) {
        this.dataRoleService = dataRoleService;
    }

    @Override
    public String saveSysDataRole(@RequestBody SysDataRoleDTO dataRoleDTO) {
        return dataRoleService.saveSysDataRole(dataRoleDTO);
    }

    @Override
    public String updateSysDataRole(@PathVariable("data_role_id")Integer dataRoleId, @RequestBody SysDataRoleDTO dataRoleDTO) {
        dataRoleDTO.setDataRoleId(dataRoleId);
       return dataRoleService.updateSysDataRole(dataRoleDTO);
    }

    @Override
    public String deleteSysDataRoleById(@PathVariable("data_role_id")Integer dataRoleId) {
        return dataRoleService.deleteSysDataRoleById(dataRoleId);

    }

    @Override
    public Page<SysDataRoleDTO> selectSysDataRole(@RequestParam(value = "keyword",required = false)String keyword,
                                                  @RequestParam(value="organize_id",required = false)Integer organizeId,
                                                  @RequestParam(value = "page_no") Integer pageNo,
                                                  @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysDataRoleDTO> page = new Page<>();
        int cnt = dataRoleService.getSysDataRoleCount(keyword,organizeId);
        if (cnt == 0) {
            return page;
        }
        List<SysDataRoleDTO> items = dataRoleService.selectSysDataRole(keyword,organizeId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

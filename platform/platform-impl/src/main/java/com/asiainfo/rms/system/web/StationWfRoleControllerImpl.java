package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationWfRoleDTO;
import com.asiainfo.rms.system.service.SysStationWfRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class StationWfRoleControllerImpl implements SysStationWfRoleController {
    private final SysStationWfRoleService stationWfRoleService;

    public StationWfRoleControllerImpl(SysStationWfRoleService stationWfRoleService) {
        this.stationWfRoleService = stationWfRoleService;
    }

    @Override
    public String saveStationWfRole(@RequestBody SysStationWfRoleDTO stationWfRoleDTO) {
        return stationWfRoleService.saveStationWfRole(stationWfRoleDTO);
    }

    @Override
    public String deleteStationWfRole(@PathVariable("rel_id")Integer relId) {
        return stationWfRoleService.deleteStationWfRole(relId);
    }

    @Override
    public Page<SysStationWfRoleDTO> selectStationWfRoleByStationId(@RequestParam("station_id")Integer stationId,
                                                                    @RequestParam(value = "keyword",required = false)String keyword,
                                                                    @RequestParam(value = "page_no") Integer pageNo,
                                                                    @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStationWfRoleDTO> page = new Page<>();
        int cnt = stationWfRoleService.getStationWfRoleCount(stationId,keyword);
        if (cnt == 0) {
            return page;
        }
        List<SysStationWfRoleDTO> items = stationWfRoleService.selectStationWfRoleByStationId(stationId,keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

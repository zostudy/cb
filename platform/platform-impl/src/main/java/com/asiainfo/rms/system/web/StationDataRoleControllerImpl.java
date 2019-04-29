package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationDataRoleDTO;
import com.asiainfo.rms.system.service.SysStationDataRoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class StationDataRoleControllerImpl implements SysStationDataRoleController {
    private final SysStationDataRoleService stationDataRoleService;

    public StationDataRoleControllerImpl(SysStationDataRoleService stationDataRoleService) {
        this.stationDataRoleService = stationDataRoleService;
    }

    @Override
    public String saveStationDataRole(@RequestBody SysStationDataRoleDTO stationDataRoleDTO) {
        return stationDataRoleService.saveStationDataRole(stationDataRoleDTO);
    }

    @Override
    public String deleteStationDataRole(@PathVariable("rel_id")Integer relId) {
        return stationDataRoleService.deleteStationDataRole(relId);
    }

    @Override
    public Page<SysStationDataRoleDTO> selectStationDataRoleByStationId(@RequestParam("station_id")Integer stationId,
                                                                        @RequestParam(value = "keyword",required = false)String keyword,
                                                                        @RequestParam(value = "page_no") Integer pageNo,
                                                                        @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStationDataRoleDTO> page = new Page<>();
        int cnt = stationDataRoleService.getStationDataRoleCount(stationId,keyword);
        if (cnt == 0) {
            return page;
        }
        List<SysStationDataRoleDTO> items = stationDataRoleService.selectStationDataRoleByStationId(stationId,keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationDTO;
import com.asiainfo.rms.system.service.StationService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class StationControllerImpl implements StationController {
    private final StationService stationService;

    public StationControllerImpl(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public String saveStation(@RequestBody SysStationDTO stationDTO) {

        return stationService.saveStation(stationDTO);
    }

    @Override
    public String updateStation(@PathVariable("station_id") Integer stationId,
                             @RequestBody SysStationDTO stationDTO) {
        stationDTO.setStationId(stationId);
        return stationService.updateStation(stationDTO);
    }

    @Override
    public String deleteStationById(@PathVariable("station_id")Integer stationId) {
        return stationService.deleteStationById(stationId);
    }

    @Override
    public SysStationDTO selectByStationId(@PathVariable("station_id")Integer stationId) {
        return stationService.selectByStationId(stationId);
    }

    @Override
    public Page<SysStationDTO> selectAllStation(@RequestParam(value = "keyword", required = false) String keyWord,
                                                @RequestParam(value ="selected_staff_id",required = false)Integer selectedStaffId,
                                                @RequestParam(value = "page_no") Integer pageNo,
                                                @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysStationDTO> page = new Page<>();
        int cnt = stationService.getStationCount(keyWord,selectedStaffId);
        if (cnt == 0) {
            return page;
        }
        List<SysStationDTO> stationList = stationService.selectAllStation(keyWord,selectedStaffId,pageNo,pageSize);
        if (CollectionUtils.isEmpty(stationList)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(stationList);
        return page;
    }
}

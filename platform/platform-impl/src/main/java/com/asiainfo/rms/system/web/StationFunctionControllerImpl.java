package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysStationFuncDTO;
import com.asiainfo.rms.system.dto.SysStationFunctionDTO;
import com.asiainfo.rms.system.service.StationFunctionService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class StationFunctionControllerImpl implements StationFunctionController {
    private final StationFunctionService stationFunctionService;

    public StationFunctionControllerImpl(StationFunctionService stationFunctionService) {
        this.stationFunctionService = stationFunctionService;
    }



//    @Override
//    public String updateStationFunc(@PathVariable("station_func_relat_id ") Integer stationFuncRelatId,
//                                 @RequestBody SysStationFuncDTO stationFuncDTO) {
//        stationFuncDTO.setStationFuncRelatId(stationFuncRelatId);
//        return stationFunctionService.updateStationFunc(stationFuncDTO);
//    }
//
//    @Override
//    public String deleteStationFuncById(@PathVariable("station_func_relat_id ")Integer stationFuncRelatId) {
//        return stationFunctionService.deleteStationFuncById(stationFuncRelatId);
//    }

    @Override
    public String saveStationFunc(@RequestBody SysStationFunctionDTO sysStationFunctionDTO) {
            return stationFunctionService.saveStationFunc(sysStationFunctionDTO);

    }

    @Override
    public SysStationFuncDTO selectByStationFuncRelatId(@PathVariable("station_func_relat_id ")Integer stationFuncRelatId) {
        return stationFunctionService.selectByStationFuncRelatId(stationFuncRelatId);
    }

    @Override
    public SysStationFuncDTO selectStationFuncByStaffId(@PathVariable("staff_id ")Integer staffId) {
        return stationFunctionService.selectStationFuncByStaffId(staffId);
    }

    @Override
    public List<SysStationFuncDTO> selectStationFuncByStationId(@RequestParam("station_id") Integer stationId) {
        return stationFunctionService.selectStationFuncByStationId(stationId);
    }
}

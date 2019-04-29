package com.asiainfo.rms.system.web;

import com.asiainfo.rms.system.dto.SysStationFuncDTO;
import com.asiainfo.rms.system.dto.SysStationFunctionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/system")
public interface StationFunctionController {

    /**
     * 增岗位菜单权限信息
     * @param sysStationFunctionDTO
     * @return
     */
    @RequestMapping(value = "/station_function", method = RequestMethod.POST)
    String saveStationFunc(@RequestBody SysStationFunctionDTO sysStationFunctionDTO);

//    /**
//     * 修改岗位菜单权限
//     *
//     * @param stationFuncRelatId
//     * @param stationFuncDTO
//     * @return
//     */
//    @RequestMapping(value = "/station_function/{station_func_relat_id }", method = RequestMethod.POST)
//    String updateStationFunc(@PathVariable("station_func_relat_id ") Integer stationFuncRelatId,
//                          @RequestBody SysStationFuncDTO stationFuncDTO);
//
//    /**
//     * 删除岗位菜单权限
//     * @param stationFuncRelatId
//     */
//    @RequestMapping(value = "/station_function/{station_func_relat_id }", method = RequestMethod.DELETE)
//    String deleteStationFuncById(@PathVariable("station_func_relat_id ") Integer stationFuncRelatId);
    /**
     * 根据id查询岗位菜单权限
     *
     * @param stationFuncRelatId
     * @return
     */
    @RequestMapping(value = "/station_function/{station_func_relat_id }", method = RequestMethod.GET)
    SysStationFuncDTO selectByStationFuncRelatId(@PathVariable("station_func_relat_id") Integer stationFuncRelatId);

    /**
     * 根据staffId查询岗位菜单权限
     *
     * @param staffId
     * @return
     */
    @RequestMapping(value = "/station_function/staff/{staff_id}", method = RequestMethod.GET)
    SysStationFuncDTO selectStationFuncByStaffId(@PathVariable("staff_id") Integer staffId);

    /**
     * 根据stationId查询所有菜单信息
     * @param stationId
     * @return
     */
    @RequestMapping(value = "/station_function/all",method = RequestMethod.GET)
    List<SysStationFuncDTO> selectStationFuncByStationId(@RequestParam("station_id")Integer stationId);


}

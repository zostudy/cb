package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysStationDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface StationController {
    /**
     * 新增岗位信息
     *
     * @param stationDTO
     * @return
     */
    @RequestMapping(value = "/station", method = RequestMethod.POST)
    String saveStation(@RequestBody SysStationDTO stationDTO);

    /**
     * 修改岗位信息
     *
     * @param stationId
     * @param stationDTO
     * @return
     */
    @RequestMapping(value = "/station/{station_id}", method = RequestMethod.PUT)
    String updateStation(@PathVariable("station_id") Integer stationId,
                      @RequestBody SysStationDTO stationDTO);

    /**
     * 删除岗位信息
     * @param stationId
     */
    @RequestMapping(value = "/station/{station_id}", method = RequestMethod.DELETE)
    String deleteStationById(@PathVariable("station_id") Integer stationId);

    /**
     * 根据id查询岗位信息
     *
     * @param stationId
     * @return
     */
    @RequestMapping(value = "/station/{station_id}", method = RequestMethod.GET)
    SysStationDTO selectByStationId(@PathVariable("station_id") Integer stationId);

    /**
     * 查询所有的岗位信息
     *
     * @param keyWord
     * @param pageNo
     * @param pageSize
     * @return
     */

    @RequestMapping(value = "/station/all", method = RequestMethod.GET)
    Page<SysStationDTO> selectAllStation(@RequestParam(value = "keyword", required = false) String keyWord,
                                         @RequestParam(value ="selected_staff_id",required = false)Integer selectedStaffId,
                                         @RequestParam(value = "page_no") Integer pageNo,
                                         @RequestParam(value = "page_size") Integer pageSize);
}

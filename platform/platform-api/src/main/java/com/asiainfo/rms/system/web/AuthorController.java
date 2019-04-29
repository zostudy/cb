package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysAuthorDTO;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/system")
public interface AuthorController {
    /**
     * 新增员工岗位关系
     *
     * @param authorDTO
     * @return
     */
    @RequestMapping(value = "/author", method = RequestMethod.POST)
    String saveAuthor(@RequestBody SysAuthorDTO authorDTO);

    /**
     * 修改员工岗位关系
     *
     * @param authorId
     * @param authorDTO
     * @return
     */
    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.PUT)
    String updateAuthor(@PathVariable("author_id") Integer authorId, @RequestBody SysAuthorDTO authorDTO);

    /**
     *删除员工岗位关系
     * @param authorId
     */
    @RequestMapping(value="/author/{author_id}", method = RequestMethod.DELETE)
    String deleteAuthorById(@PathVariable("author_id") Integer authorId);
    /**
     * 根据authorId查询员工岗位关系
     *
     * @param authorId
     * @return
     */
    @RequestMapping(value = "/author/{author_id}", method = RequestMethod.GET)
    SysAuthorDTO selectByAuthorId(@PathVariable("author_id") Integer authorId);
    /**
     * 根据stationId查询员工岗位关系
     *
     * @param stationId
     * @return
     */
    @RequestMapping(value = "/author/station/{station_id}", method = RequestMethod.GET)
    List<SysAuthorDTO> selectByStationId(@PathVariable("station_id") Integer stationId);

    /**
     * 根据staffId查询员工岗位关系
     * @param StaffId
     * @return
     */
    @RequestMapping(value = "/author/staffs",method = RequestMethod.GET)
    Page<SysAuthorDTO> selectAuthorByStaffId(@PathVariable("staff_id")Integer StaffId,
                                              @RequestParam(value = "page_no") Integer pageNo,
                                              @RequestParam(value = "page_size") Integer pageSize);
    
    /**
     * 批量新增员工岗位关系
     * @param StaffId
     * @return
     */
    @RequestMapping(value = "/author/batchAddAuthor",method = RequestMethod.PUT)
    public Map<String, Object> batchAdd(@RequestBody List<SysAuthorDTO> authorDTOs);
    
    
    /**
     * 批量删除员工岗位关系
     * @param StaffId
     * @return
     */
    @RequestMapping(value = "/author/batchDelAuthor",method = RequestMethod.PUT)
    public Map<String, Object> batchDel(@RequestBody List<SysAuthorDTO> authorDTOs);
    
}

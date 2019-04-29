package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpComprehensiveDTO;
import com.asiainfo.rms.alm.demand.dto.ComprehensiveDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpComprehensiveController {

    /**
     * 新增综合需求模板信息
     * @param comprehensiveDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive",method = RequestMethod.POST)
    String saveAlmReqtmpComprehensive(@RequestBody ComprehensiveDTO comprehensiveDTO);

    /**
     * 修改综合需求模板信息
     * @param comprehensiveDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive",method = RequestMethod.PUT)
    String updateAlmReqtmpComprehensive(@RequestBody ComprehensiveDTO comprehensiveDTO);

    /**
     * 删除综合需求模板信息
     * @param arcId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive/{arc_id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpComprehensive(@PathVariable("arc_id")Integer arcId);

    /**
     * 查询综合需求模板信息
     * @param arcId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive/{arc_id}",method = RequestMethod.GET)
    ComprehensiveDTO selectAlmReqtmpComprehensive(@PathVariable("arc_id")Integer arcId);

    /**
     * 根据artId查询资费需求模板信息
     * @param artId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive/comprehensive/{art_id}",method = RequestMethod.GET)
    ComprehensiveDTO selectComprehensive(@PathVariable("art_id")Integer artId);

    /**
     * 带分页查询
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_comprehensive/all",method = RequestMethod.GET)
    Page<AlmReqtmpComprehensiveDTO> selectAllAlmReqtmpComprehensive(@RequestParam(value = "keyword",required = false)String keyword,
														    		@RequestParam(value = "art_type", required = false) Integer artType,
														    		@RequestParam(value = "art_name", required = false) String artName,
														    		@RequestParam(value = "art_tag", required = false) String artTag,
                                                                    @RequestParam(value = "art_region", required = false) Integer artRegion,
														    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
														    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
														    		@RequestParam(value = "page_no") Integer pageNo,
                                                           @RequestParam(value = "page_size") Integer pageSize);
}

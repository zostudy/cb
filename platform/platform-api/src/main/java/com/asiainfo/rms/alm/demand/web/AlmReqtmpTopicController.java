package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpTopicController {

    /**
     * 新增需求模板基本信息
     *
     * @param almReqtmpTopicDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_topic", method = RequestMethod.POST)
    String saveAlmReqtmpTopic(@RequestBody AlmReqtmpTopicDTO almReqtmpTopicDTO);

    /**
     * 修改需求模板信息
     *
     * @param artId
     * @param almReqtmpTopicDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_topic/{art_id}", method = RequestMethod.PUT)
    String updateAlmReqtmpTopic(@PathVariable("art_id") Integer artId, @RequestBody AlmReqtmpTopicDTO almReqtmpTopicDTO);

    /**
     * 删除需求模板信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_topic/{art_id}", method = RequestMethod.DELETE)
    String deleteAlmReqtmpTopic(@PathVariable("art_id") Integer artId);

    /**
     * 根据ID查询求模板信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_topic/{art_id}", method = RequestMethod.GET)
    AlmReqtmpTopicDTO selectAlmReqtmpTopicById(@PathVariable("art_id") Integer artId);

    /**
     * 查询所有需求模板信息
     * @param keyword
     * @param artType
     * @param artName
     * @param artTag
     * @param artRegion
     * @param urgentLevel
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_topic/all",method = RequestMethod.GET)
    Page<AlmReqtmpTopicDTO> selectAllAlmReqtmpTopic(@RequestParam(value = "keyword",required = false)String keyword,
										    		@RequestParam(value = "art_type", required = false) Integer artType,
										    		@RequestParam(value = "art_name", required = false) String artName,
										    		@RequestParam(value = "art_tag", required = false) String artTag,
										    		@RequestParam(value = "art_region", required = false) Integer artRegion,
										    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
										    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                    @RequestParam(value = "page_no") Integer pageNo,
                                                    @RequestParam(value = "page_size") Integer pageSize);


}

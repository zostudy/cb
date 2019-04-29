package com.asiainfo.rms.alm.arsenal.web;


import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpTopicDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpTopicController {

    /**
     * 新增服务库模板
     * @param almAsnltmpTopicDTO
     * @return
     */
    @RequestMapping(value = "/alm_asntmp_topic",method = RequestMethod.POST)
    String saveAlmAsnltmpTopic(@RequestBody AlmAsnltmpTopicDTO almAsnltmpTopicDTO);

    /**
     * 修改服务库模板
     * @param aatId
     * @param almAsnltmpTopicDTO
     * @return
     */
    @RequestMapping(value = "/alm_asntmp_topic/{aat_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpTopic(@PathVariable("aat_id") Integer aatId, @RequestBody AlmAsnltmpTopicDTO almAsnltmpTopicDTO);

    /**
     * 删除武器库模板
     * @param aatId
     * @return
     */
    @RequestMapping(value = "/alm_asntmp_topic/{aat_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpTopic(@PathVariable("aat_id") Integer aatId);

    /**
     * 根据ID查询武器库模板
     * @param aatId
     * @return
     */
    @RequestMapping(value = "/alm_asntmp_topic/{aat_id}",method = RequestMethod.GET)
    AlmAsnltmpTopicDTO selectAlmAsnltmpTopic(@PathVariable("aat_id") Integer aatId);

    /**
     * 查询所有武器库模板
     * @param keyword
     * @param artType
     * @param aatName
     * @param aatTag
     * @param aatRegion
     * @param aatDepart
     * @param submitStaffName
     * @param onlineState
     * @param startTime
     * @param endTime
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_asntmp_topic/all",method = RequestMethod.GET)
    Page<AlmAsnltmpTopicDTO> selectAllAlmAsnltmpTopic(@RequestParam(value = "keyword",required = false)String keyword,
                                                      @RequestParam(value = "art_type",required = false)String artType,
                                                      @RequestParam(value = "aat_name",required = false)String aatName,
                                                      @RequestParam(value = "aat_tag",required = false)String aatTag,
                                                      @RequestParam(value = "aat_region",required = false)String aatRegion,
                                                      @RequestParam(value = "aat_depart",required = false)Integer aatDepart,
                                                      @RequestParam(value = "submit_staff_name",required = false)String submitStaffName,
                                                      @RequestParam(value = "online_state",required = false)Integer onlineState,
                                                      @RequestParam(value = "start_time",required = false)String startTime,
                                                      @RequestParam(value = "end_time",required = false)String endTime,
                                                      @RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);

}

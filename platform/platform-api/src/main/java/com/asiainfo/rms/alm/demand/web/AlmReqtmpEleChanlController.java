package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpEleChanlDTO;
import com.asiainfo.rms.alm.demand.dto.EleChanlDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpEleChanlController {

    /**
     * 新增电渠需求模板信息
     *
     * @param eleChanlDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl", method = RequestMethod.POST)
    String saveAlmReqtmpEleChanl(@RequestBody EleChanlDTO eleChanlDTO);

    /**
     * 修改电渠需求模板信息
     *
     * @param eleChanlDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl", method = RequestMethod.PUT)
    String updateAlmReqtmpEleChanl(@RequestBody EleChanlDTO eleChanlDTO);

    /**
     * 删除电渠需求模板信息
     *
     * @param areId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl/{are_id}", method = RequestMethod.DELETE)
    String deleteAlmReqtmpEleChanl(@PathVariable("are_id") Integer areId);

    /**
     * 查询电渠需求模板信息
     *
     * @param areId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl/{are_id}", method = RequestMethod.GET)
    EleChanlDTO selectAlmReqtmpEleChanl(@PathVariable("are_id") Integer areId);

    /**
     * 根据artId查询资费需求模板信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl/elechanl/{art_id}", method = RequestMethod.GET)
    EleChanlDTO selectEleChanl(@PathVariable("art_id") Integer artId);

    /**
     * 带分页查询所有电渠需求模板信息
     *
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_elechanl/all", method = RequestMethod.GET)
    Page<AlmReqtmpEleChanlDTO> selectAllAlmReqtmpEleChanl(@RequestParam(value = "keyword", required = false) String keyword,
                                                          @RequestParam(value = "art_type", required = false) Integer artType,
                                                          @RequestParam(value = "art_name", required = false) String artName,
                                                          @RequestParam(value = "art_tag", required = false) String artTag,
                                                          @RequestParam(value = "art_region", required = false) Integer artRegion,
                                                          @RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
                                                          @RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize);
}

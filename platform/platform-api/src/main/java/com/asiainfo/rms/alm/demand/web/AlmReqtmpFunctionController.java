package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpFunctionDTO;
import com.asiainfo.rms.alm.demand.dto.FunctionDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpFunctionController {

    /**
     * 新增功能需求模板信息
     *
     * @param functionDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function", method = RequestMethod.POST)
    String saveAlmReqtmpFunction(@RequestBody FunctionDTO functionDTO);

    /**
     * 修改功能需求模板信息
     *
     * @param functionDTO
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function", method = RequestMethod.PUT)
    String updateAlmReqtmpFunction(@RequestBody FunctionDTO functionDTO);

    /**
     * 删除功能需求模板信息
     *
     * @param arfId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function/{arf_id}", method = RequestMethod.DELETE)
    String deleteAlmReqtmpFunction(@PathVariable("arf_id") Integer arfId);

    /**
     * 根据ID查询功能需求模板信息
     *
     * @param arfId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function/{arf_id}", method = RequestMethod.GET)
    FunctionDTO selectAlmReqtmpFunction(@PathVariable("arf_id") Integer arfId);

    /**
     * 根据artId查询资费需求模板信息
     *
     * @param artId
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function/function/{art_id}", method = RequestMethod.GET)
    FunctionDTO selectFunction(@PathVariable("art_id") Integer artId);

    /**
     * 查询所有功能需求模板信息
     *
     * @return
     */
    @RequestMapping(value = "/alm_reqtmp_function/all", method = RequestMethod.GET)
    Page<AlmReqtmpFunctionDTO> selectAllAlmReqtmpFunction(@RequestParam(value = "keyword", required = false) String keyword,
                                                          @RequestParam(value = "art_type", required = false) Integer artType,
                                                          @RequestParam(value = "art_name", required = false) String artName,
                                                          @RequestParam(value = "art_tag", required = false) String artTag,
                                                          @RequestParam(value = "art_region", required = false) Integer artRegion,
                                                          @RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
                                                          @RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize);
}

package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceRelatDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpServiceRelatController {

    /**
     * 新增武器模板和服务关系
     *
     * @param almAsnltmpServiceRelatDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_service_relat", method = RequestMethod.POST)
    String saveAlmAsnltmpServiceRelat(@RequestBody AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO);

    /**
     * 修改
     *
     * @param almAsnltmpServiceRelatDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_service_relat/{asr_id}", method = RequestMethod.PUT)
    String updateAlmAsnltmpServiceRelat(@PathVariable("asr_id") Integer asrId, @RequestBody AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO);

    /**
     * 删除
     *
     * @param asrId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_service_relat/{asr_id}", method = RequestMethod.DELETE)
    String deleteAlmAsnltmpServiceRelat(@PathVariable("asr_id") Integer asrId);

    /**
     * 查询
     *
     * @param artType
     * @param aatId
     * @param objId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_service_value/service_relats", method = RequestMethod.GET)
    Page<AlmAsnltmpServiceRelatDTO> selectAlmAsnltmpServiceRelatByArtType(@RequestParam("art_type") Integer artType,
                                                                          @RequestParam("aat_id") Integer aatId,
                                                                          @RequestParam(value = "obj_id", required = false) Integer objId);

    /**
     * 查询所有服务
     *
     * @param artType
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_service_relat/all", method = RequestMethod.GET)
    Page<AlmAsnltmpServiceRelatDTO> selectAllAlmAsnltmpServiceRelat(@RequestParam(value = "art_type", required = false) Integer artType,
                                                                    @RequestParam(value = "page_no") Integer pageNo,
                                                                    @RequestParam(value = "page_size") Integer pageSize);


}

package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpChargeDTO;
import com.asiainfo.rms.alm.demand.dto.ChargeDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpChargeController {

    /**
     * 新增资费需求模板信息
     * @param chargeDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge",method = RequestMethod.POST)
    String saveAlmReqtmpCharge(@RequestBody ChargeDTO chargeDTO);

    /**
     * 修改资费需求模板信息
     * @param chargeDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge",method = RequestMethod.PUT)
    String updateAlmReqtmpCharge(@RequestBody ChargeDTO chargeDTO);

    /**
     * 删除
     * @param archId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge/{arch_id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpCharge(@PathVariable("arch_id")Integer archId);

    /**
     * 查询
     * @param archID
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge/{arch_id}",method = RequestMethod.GET)
    ChargeDTO selectAlmReqtmpCharge(@PathVariable("arch_id")Integer archID);

    /**
     * 根据artId查询资费需求模板信息
     * @param artId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge/charge/{art_id}",method = RequestMethod.GET)
    ChargeDTO selectCharge(@PathVariable("art_id")Integer artId);

    /**
     * 带分页查询
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_charge/all",method = RequestMethod.GET)
    Page<AlmReqtmpChargeDTO> selectAllAlmReqtmpCharge(@RequestParam(value = "keyword",required = false)String keyword,
											    		@RequestParam(value = "art_type", required = false) Integer artType,
											    		@RequestParam(value = "art_name", required = false) String artName,
											    		@RequestParam(value = "art_tag", required = false) String artTag,
											    		@RequestParam(value = "art_region", required = false) Integer artRegion,
											    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
											    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
											    		@RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);

}

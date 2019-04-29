package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChargeDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpChargeController {

    /**
     *新增资费类模板主表
     * @param almAsnltmpChargeDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_charge",method = RequestMethod.POST)
    String saveAlmAsnltmpCharge(@RequestBody AlmAsnltmpChargeDTO almAsnltmpChargeDTO);

    /**
     * 修改
     * @param acId
     * @param almAsnltmpChargeDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_charge/{ac_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpCharge(@PathVariable("ac_id")Integer acId,@RequestBody AlmAsnltmpChargeDTO almAsnltmpChargeDTO);

    /**
     * 根据aarId查询产品详情
     * @param aatId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_charge/charge",method = RequestMethod.GET)
    AlmAsnltmpChargeDTO selectAlmAsnltmpChargeByAarId(@RequestParam("aat_id")Integer aatId);


}

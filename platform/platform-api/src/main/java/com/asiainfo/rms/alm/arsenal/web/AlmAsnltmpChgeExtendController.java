package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChgeExtendDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpChgeExtendController {

    /**
     * 新增资费类模板附表（幸福卡）
     * @param almAsnltmpChgeExtendDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_chge_extend",method = RequestMethod.POST)
    String saveAlmAsnltmpChgeExtend(@RequestBody AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO);

    /**
     * 修改
     * @param aceId
     * @param almAsnltmpChgeExtendDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_chge_extend/{ace_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpChgeExtend(@PathVariable("ace_id")Integer aceId, @RequestBody AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO);

    /**
     * 删除
     * @param aceId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_chge_extend/{ace_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpChgeExtend(@PathVariable("ace_id")Integer aceId);

    /**
     * 查询
     * @param aceId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_chge_extend/{ace_id}",method = RequestMethod.GET)
    AlmAsnltmpChgeExtendDTO selectAlmAsnltmpChgeExtendById(@PathVariable("ace_id")Integer aceId);

    /**
     * 查询所有资费模板
     * @param aatId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_chge_extend/all",method = RequestMethod.GET)
    Page<AlmAsnltmpChgeExtendDTO> selectAllAlmAsnltmpChgeExtend(@RequestParam("aat_id")Integer aatId,
                                                                @RequestParam(value = "page_no") Integer pageNo,
                                                                @RequestParam(value = "page_size") Integer pageSize);

}

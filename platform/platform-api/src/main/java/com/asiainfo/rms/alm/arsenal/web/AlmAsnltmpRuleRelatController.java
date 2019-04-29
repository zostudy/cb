package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleRelatDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpRuleRelatController {

    /**
     * 新增模板规则关系表
     *
     * @param almAsnltmpRuleRelatDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_rule_relat", method = RequestMethod.POST)
    String saveAlmAsnltmpRuleRelat(@RequestBody AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO);

    /**
     * 修改
     *
     * @param atrrId
     * @param almAsnltmpRuleRelatDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_rule_relat/{artt_id}", method = RequestMethod.PUT)
    String updateAlmAsnltmpRuleRelat(@PathVariable("artt_id") Integer atrrId,
                                     @RequestBody AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO);

    /**
     * 删除
     *
     * @param atrrId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_rule_relat/{artt_id}", method = RequestMethod.DELETE)
    String deleteAlmAsnltmpRuleRelat(@PathVariable("artt_id") Integer atrrId);

    /**
     * 查询
     *
     * @param artType
     * @param aatId
     * @param objId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_rule_value/rule_relats", method = RequestMethod.GET)
    Page<AlmAsnltmpRuleRelatDTO> selectAlmAsnltmpRuleRelaByArtType(@RequestParam("art_type") Integer artType,
                                                                   @RequestParam("aat_id") Integer aatId,
                                                                   @RequestParam(value = "obj_id", required = false) Integer objId);

    /**
     * 查询所有规则
     *
     * @param artType
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_rule_relat/all", method = RequestMethod.GET)
    Page<AlmAsnltmpRuleRelatDTO> selectAllAlmAsnltmpRuleRela(@RequestParam(value = "art_type", required = false) Integer artType,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize);


}

package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmRuleValueDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/alm")
public interface AlmAsnltmpRuleValueController {

    /**
     * 新增武器库模板规则值
     * @param almRuleValueDTO
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_rule_value",method = RequestMethod.POST)
    String saveAlmAsnltmpRuleValue(@RequestBody AlmRuleValueDTO almRuleValueDTO);


    /**
     * 删除
     * @param aarvId
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_rule_value/{aarv_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpRuleValue(@PathVariable("aarv_id")Integer aarvId);

}

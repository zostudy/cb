package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalRulesDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/alm")
public interface AlmArsenalRulesController {

    /**
     * 新增武器库规则
     * @param almArsenalRulesDTO
     * @return
     */
    @RequestMapping(value="/arsenal_rules",method = RequestMethod.POST)
    String saveAlmArsenalRules(@RequestBody AlmArsenalRulesDTO almArsenalRulesDTO);

    /**
     * 修改武器库规则
     * @param arId
     * @param almArsenalRulesDTO
     * @return
     */
    @RequestMapping(value="/arsenal_rules/{ar_id}",method = RequestMethod.PUT)
    String updateAlmArsenalRules(@PathVariable("ar_id")Integer arId,@RequestBody AlmArsenalRulesDTO almArsenalRulesDTO);

    /**
     * 删除武器库规则
     * @param arId
     * @return
     */
    @RequestMapping(value="/arsenal_rules/{ar_id}",method = RequestMethod.DELETE)
    String deleteAlmArsenalRules(@PathVariable("ar_id")Integer arId);

    /**
     * 查询武器库规则
     * @param arId
     * @return
     */
    @RequestMapping(value="/arsenal_rules/{ar_id}",method = RequestMethod.GET)
    AlmArsenalRulesDTO selectArsenalRulesById(@PathVariable("ar_id")Integer arId);

    /**
     * 查询所有武器库规则
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/arsenal_rules/all",method = RequestMethod.GET)
    Page<AlmArsenalRulesDTO> selectAllArsenalRules(@RequestParam(value = "keyword",required = false)String keyword,
                                                   @RequestParam(value = "page_no") Integer pageNo,
                                                   @RequestParam(value = "page_size") Integer pageSize);

}

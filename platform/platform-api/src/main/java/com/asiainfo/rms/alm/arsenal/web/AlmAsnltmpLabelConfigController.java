package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpLabelConfigDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpLabelConfigController {

    /**
     * 新增标签信息
     * @param almAsnltmpLabelConfigDTO
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_label_config",method = RequestMethod.POST)
    String saveAlmAsnltmpLabelConfig(@RequestBody AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO);

    /**
     * 修改
     * @param lmId
     * @param almAsnltmpLabelConfigDTO
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_label_config/{im_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpLabelConfig(@PathVariable("im_id")Integer lmId,@RequestBody AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO);

    /**
     * 删除
     * @param lmId
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_label_config/{im_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpLabelConfig(@PathVariable("im_id")Integer lmId);

    /**
     * 查询
     * @param lmId
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_label_config/{im_id}",method = RequestMethod.GET)
    AlmAsnltmpLabelConfigDTO selectAlmAsnltmpLabelConfigById(@PathVariable("im_id")Integer lmId);

    /**
     * 查询所有带分页
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value ="/alm_asnltmp_label_config/all",method = RequestMethod.GET)
    Page<AlmAsnltmpLabelConfigDTO> selectAllAlmAsnltmpLabelConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                                  @RequestParam(value = "page_no") Integer pageNo,
                                                                  @RequestParam(value = "page_size") Integer pageSize);
}

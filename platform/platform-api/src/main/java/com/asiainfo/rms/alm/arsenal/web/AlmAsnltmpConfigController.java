package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpConfigDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpConfigController {

    /**
     * 新增配置
     * @param almAsnltmpConfigDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_config",method = RequestMethod.POST)
    String saveAlmAsnltmpConfig(@RequestBody AlmAsnltmpConfigDTO almAsnltmpConfigDTO);

    /**
     * 修改
     * @param aacId
     * @param almAsnltmpConfigDTO
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_config/{aac_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpConfig(@PathVariable("aac_id")Integer aacId,@RequestBody AlmAsnltmpConfigDTO almAsnltmpConfigDTO);

    /**
     * 删除
     * @param aacId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_config/{aac_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpConfig(@PathVariable("aac_id")Integer aacId);

    /**
     * 查询
     * @param aacId
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_config/{aac_id}",method = RequestMethod.GET)
    AlmAsnltmpConfigDTO selectAlmAsnltmpConfigById(@PathVariable("aac_id")Integer aacId);

    /**
     * 查询所有带分页
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_config/all",method = RequestMethod.GET)
    Page<AlmAsnltmpConfigDTO> selectAllAlmAsnltmpConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                        @RequestParam(value = "page_no") Integer pageNo,
                                                        @RequestParam(value = "page_size") Integer pageSize);
}

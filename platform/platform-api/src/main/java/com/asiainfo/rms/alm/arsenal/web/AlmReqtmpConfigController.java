package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmReqtmpConfigDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpConfigController {

    /**
     * 新增模板地址配置
     * @param almReqtmpConfigDTO
     * @return
     */
    @RequestMapping(value ="/alm_reqtmp_config",method = RequestMethod.POST)
    String saveAlmReqtmpConfig(@RequestBody AlmReqtmpConfigDTO almReqtmpConfigDTO);

    /**
     * 修改模板地址配置
     * @param id
     * @param almReqtmpConfigDTO
     * @return
     */
    @RequestMapping(value ="/alm_reqtmp_config/{id}",method = RequestMethod.PUT)
    String updateAlmReqtmpConfig(@PathVariable("id") Integer id,@RequestBody AlmReqtmpConfigDTO almReqtmpConfigDTO);

    /**
     * 删除模板地址配置
     * @param id
     * @return
     */
    @RequestMapping(value ="/alm_reqtmp_config/{id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpConfig(Integer id);

    /**
     * 根据ID查询模板地址配置
     * @param id
     * @return
     */
    @RequestMapping(value ="/alm_reqtmp_config/{id}",method = RequestMethod.GET)
    AlmReqtmpConfigDTO selectAlmReqtmpConfig(Integer id);

    /**
     * 查询所有模板地址配置
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_config/all",method = RequestMethod.GET)
    Page<AlmReqtmpConfigDTO> selectAllAlmReqtmpConfig(@RequestParam(value = "keyword",required = false)String keyword,
                                                      @RequestParam(value = "page_no") Integer pageNo,
                                                      @RequestParam(value = "page_size") Integer pageSize);
}

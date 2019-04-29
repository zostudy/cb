package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalServiceDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmArsenalServiceController {

    /**
     * 新增服务器服务
     * @param almArsenalServiceDTO
     * @return
     */
    @RequestMapping(value = "/alm_arsenal_service",method = RequestMethod.POST)
    String saveAlmArsenalService(@RequestBody AlmArsenalServiceDTO almArsenalServiceDTO);

    /**
     * 修改
     * @param asId
     * @param almArsenalServiceDTO
     * @return
     */
    @RequestMapping(value = "/alm_arsenal_service/{as_id}",method = RequestMethod.PUT)
    String updateAlmArsenalService(@PathVariable("as_id")Integer asId,@RequestBody AlmArsenalServiceDTO almArsenalServiceDTO);

    /**
     * 删除
     * @param asId
     * @return
     */
    @RequestMapping(value = "/alm_arsenal_service/{as_id}",method = RequestMethod.DELETE)
    String deleteAlmArsenalService(@PathVariable("as_id")Integer asId);

    /**
     * 查询
     * @param asId
     * @return
     */
    @RequestMapping(value = "/alm_arsenal_service/{as_id}",method = RequestMethod.GET)
    AlmArsenalServiceDTO selectAlmArsenalServiceById(@PathVariable("as_id")Integer asId);

    /**
     * 查询所有带分页
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_arsenal_service/all",method = RequestMethod.GET)
    Page<AlmArsenalServiceDTO> selectAllAlmArsenalService(@RequestParam(value = "keyword",required = false)String keyword,
                                                          @RequestParam(value = "page_no") Integer pageNo,
                                                          @RequestParam(value = "page_size") Integer pageSize);
}

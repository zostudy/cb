package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpOnlineDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpOnlineController {

    /**
     * 新增上线状态
     * @param almAsnltmpOnlineDTO
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_online",method = RequestMethod.POST)
    String saveAlmAsnltmpOnline(@RequestBody AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO);

    /**
     * 修改
     * @param aaoId
     * @param almAsnltmpOnlineDTO
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_online/{aao_id}",method = RequestMethod.PUT)
    String updateAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId, @RequestBody AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO);

    /**
     * 删除
     * @param aaoId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_online/{aao_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId);

    /**
     * 查询
     * @param aaoId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_online/{aao_id}",method = RequestMethod.GET)
    AlmAsnltmpOnlineDTO selectAlmAsnltmpOnline(@PathVariable("aao_id")Integer aaoId);

    /**
     * 查询所有上线状态
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_online/all",method = RequestMethod.GET)
    Page<AlmAsnltmpOnlineDTO> selectAllAlmAsnltmpOnline(@RequestParam(value = "keyword",required = false)String keyword,
                                                        @RequestParam(value = "page_no") Integer pageNo,
                                                        @RequestParam(value = "page_size") Integer pageSize);

}

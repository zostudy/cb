package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmStoreGiveDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/alm")
public interface AlmStoreGiveController {
    /**
     * 新增存送主表和存送附表
     * @param almStoreGiveDTO
     * @return
     */
    @RequestMapping(value="/alm_store_give",method = RequestMethod.POST)
    String saveStoreGive(@RequestBody AlmStoreGiveDTO almStoreGiveDTO);

    /**
     * 修改存送主表和存送附表
     * @param almStoreGiveDTO
     * @return
     */
    @RequestMapping(value="/alm_store_give",method = RequestMethod.PUT)
    String updateStoreGive(@RequestBody AlmStoreGiveDTO almStoreGiveDTO);

    /**
     * 查询存送主表和存送附表
     * @param aatId
     * @return
     */
    @RequestMapping(value="/alm_store_give/{aat_id}",method = RequestMethod.GET)
    AlmStoreGiveDTO selectStoreGive(@PathVariable("aat_id")Integer aatId);

}

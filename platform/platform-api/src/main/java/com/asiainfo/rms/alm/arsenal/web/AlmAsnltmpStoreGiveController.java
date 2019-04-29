package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmAsnltmpStoreGiveController {

    /**
     * 删除
     * @param aasId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_store_give/{aas_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpStoreGive(@PathVariable("aas_id")Integer aasId);

    /**
     * 查询
     * @param aasId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_store_give/{aas_id}",method = RequestMethod.GET)
    AlmAsnltmpStoreGiveDTO selectAlmAsnltmpStoreGive(@PathVariable("aas_id")Integer aasId);

    /**
     * 查询所有存费主表
     * @param aatId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/alm_asnltmp_store_give/all",method = RequestMethod.GET)
    Page<AlmAsnltmpStoreGiveDTO> selectAllAlmAsnltmpStoreGive(@RequestParam("aat_id")Integer aatId,
                                                              @RequestParam(value = "page_no") Integer pageNo,
                                                              @RequestParam(value = "page_size") Integer pageSize);
}

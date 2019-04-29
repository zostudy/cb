package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmServiceValueDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/alm")
public interface AlmAsnltmpServiceValueController {

    /**
     * 新增服务值
     * @param almServiceValueDTO
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_service_value",method = RequestMethod.POST)
    String saveAlmAsnltmpServiceValue(@RequestBody AlmServiceValueDTO almServiceValueDTO);

    /**
     * 删除
     * @param asvId
     * @return
     */
    @RequestMapping(value="/alm_asnltmp_service_value/{asv_id}",method = RequestMethod.DELETE)
    String deleteAlmAsnltmpServiceValue(@PathVariable("asv_id")Integer asvId);


}

package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.demand.dto.BusiayaDTO;
import com.asiainfo.rms.core.api.Page;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmReqtmpBusiayaController {

    /**
     * 新增经分需求模板信息
     * @param busiayaDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_busiaya",method= RequestMethod.POST)
    String saveAlmReqtmpBusiaya(@RequestBody BusiayaDTO busiayaDTO);

    /**
     * 修改经分需求模板信息
     * @param busiayaDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_busiaya",method=RequestMethod.PUT)
    String updateAlmReqtmpBusiaya(@RequestBody BusiayaDTO busiayaDTO);

    /**
     * 删除经分需求模板信息
     * @param arbaId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_busiaya/{arba_id}",method=RequestMethod.DELETE)
    String deleteAlmReqtmpBusiaya(@PathVariable("arba_id")Integer arbaId);

    /**
     * 根据ID查询经分需求模板信息
     * @param arbaId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_busiaya/{arba_id}",method=RequestMethod.GET)
    BusiayaDTO selectAlmReqtmpBusiaya(@PathVariable("arba_id")Integer arbaId);

    /**
     * 根据artId查询经分需求模板信息
     * @param artId
     * @return
     */
    @RequestMapping(value="alm_reqtmp_busiaya/busiaya/{art_id}",method = RequestMethod.GET)
    BusiayaDTO selectBusiaya(@PathVariable("art_id")Integer artId);

    /**
     * 带分页查询所有
     * @param keyword
     * @param artType
     * @param artName
     * @param artTag
     * @param artRegion
     * @param urgentLevel
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_busiaya/all",method = RequestMethod.GET)
    Page<AlmReqtmpBusiayaDTO> selectAllAlmReqtmpBusiaya(@RequestParam(value = "keyword",required = false)String keyword,
											    		@RequestParam(value = "art_type", required = false) Integer artType,
											    		@RequestParam(value = "art_name", required = false) String artName,
											    		@RequestParam(value = "art_tag", required = false) String artTag,
											    		@RequestParam(value = "art_region", required = false) Integer artRegion,
											    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
											    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                        @RequestParam(value = "page_no") Integer pageNo,
                                                        @RequestParam(value = "page_size") Integer pageSize);
}

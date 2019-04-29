package com.asiainfo.rms.alm.demand.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamDTO;
import com.asiainfo.rms.alm.demand.dto.SimpleParamTypeDTO;
import com.asiainfo.rms.core.api.Page;

@RequestMapping("/alm")
public interface AlmReqtmpSimpleParamController {

    /**
     * 新增简易参数需求模板
     * @param simpleParamDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param",method = RequestMethod.POST)
    String saveAlmReqtmpSimpleParam(@RequestBody SimpleParamDTO simpleParamDTO);

    /**
     * 修改简易参数需求模板
     * @param simpleParamDTO
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param",method = RequestMethod.PUT)
    String updateAlmReqtmpSimpleParam(@RequestBody SimpleParamDTO simpleParamDTO);

    /**
     * 删除简易参数需求模板
     * @param arspId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param/{arsp_id}",method = RequestMethod.DELETE)
    String deleteAlmReqtmpSimpleParam(@PathVariable("arsp_id")Integer arspId);

    /**
     * 查询简易参数需求模板
     * @param arspId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param/{arsp_id}",method = RequestMethod.GET)
    SimpleParamDTO selectAlmReqtmpSimpleParam(@PathVariable("arsp_id")Integer arspId);

    /**
     * 根据artId查询资费需求模板信息
     * @param artId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param/param/{art_id}",method = RequestMethod.GET)
    SimpleParamDTO selectSimpleParam(@PathVariable("art_id")Integer artId);

    /**
     * 带分页查询所有简易参数需求模板
     * @param artId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param/all",method = RequestMethod.GET)
    Page<AlmReqtmpSimpleParamDTO> selectAllAlmReqtmpSimpleParam(@RequestParam(value = "art_id")Integer artId,
    															@RequestParam(value = "modify_type",required=false)Integer modifyType,
                                                                @RequestParam(value = "page_no") Integer pageNo,
                                                                @RequestParam(value = "page_size") Integer pageSize);
    
    /**
     * 根据artId查询简单模版类型
     * @param artId
     * @return
     */
    @RequestMapping(value="/alm_reqtmp_simple_param/paramType/{art_id}",method = RequestMethod.GET)
    SimpleParamTypeDTO getAllAlmReqtmpSimpleParamType(@PathVariable("art_id")Integer artId);

    
}

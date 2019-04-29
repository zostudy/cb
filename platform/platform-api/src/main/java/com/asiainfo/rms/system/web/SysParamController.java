package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysParamDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/system")
public interface SysParamController {

    /**
     * 根据类型精确查询数据字典
     * @param paramType
     * @return
     */
    @RequestMapping(value = "/sys_param/{param_type}", method = RequestMethod.GET)
    Page<SysParamDTO> selectParamByType(@PathVariable("param_type") String paramType,
    		                            @RequestParam(value = "paramReleId",required = false)Integer paramReleId);

    /**
     * 根据类型模糊查询数据字典
     * @param paramType
     * @return
     */
    @RequestMapping(value = "/sys_param/params",method = RequestMethod.GET)
    Page<SysParamDTO> selectParams(@RequestParam("param_type") String paramType);

}
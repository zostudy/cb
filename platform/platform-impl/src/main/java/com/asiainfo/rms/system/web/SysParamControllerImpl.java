package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysParamDTO;
import com.asiainfo.rms.system.service.SysParamService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class SysParamControllerImpl implements SysParamController {
    private final SysParamService sysParamService;

    public SysParamControllerImpl(SysParamService sysParamService) {
        this.sysParamService = sysParamService;
    }

    @Override
    public Page<SysParamDTO> selectParamByType(@PathVariable("param_type")String paramType,
    		                                   @RequestParam(value = "paramReleId",required = false)Integer paramReleId) {
        Page<SysParamDTO> page = new Page<>();
        List<SysParamDTO> items = sysParamService.selectParamByType(paramType,paramReleId);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(items.size());
        page.setPageCount(1);
        page.setPageData(items);
        return page;
    }

    @Override
    public Page<SysParamDTO> selectParams(@RequestParam("param_type")String paramType) {
        Page<SysParamDTO> page = new Page<>();
        List<SysParamDTO> items = sysParamService.selectParams(paramType);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(items.size());
        page.setPageCount(1);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.system.web;

import com.asiainfo.rms.core.api.Page;
import com.asiainfo.rms.system.dto.SysOpTypeDefDTO;
import com.asiainfo.rms.system.service.OpTypeDefService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class OpTypeDefControllerImpl implements OpTypeDefController {
    private final OpTypeDefService opTypeDefService;

    public OpTypeDefControllerImpl(OpTypeDefService opTypeDefService) {
        this.opTypeDefService = opTypeDefService;
    }

    @Override
    public String saveOpTypeDef(@RequestBody SysOpTypeDefDTO sysOpTypeDefDTO) {
        return opTypeDefService.saveOpTypeDef(sysOpTypeDefDTO);
    }

    @Override
    public String updateOpTypeDef(@PathVariable("op_type_id") Integer opTypeId,
                               @RequestBody SysOpTypeDefDTO sysOpTypeDefDTO) {
        sysOpTypeDefDTO.setOpTypeId(opTypeId);
        return opTypeDefService.updateOpTypeDef(sysOpTypeDefDTO);
    }

    @Override
    public String deleteOpTypeDefById(@PathVariable("op_type_id")Integer opTypeId) {
        return opTypeDefService.deleteOpTypeDefById(opTypeId);
    }

    @Override
    public Page<SysOpTypeDefDTO> selectAllOpType(@RequestParam(value = "code", required = false) String code,
                                                 @RequestParam(value = "op_type_name", required = false) String opTypeName,
                                                 @RequestParam(value = "page_no") Integer pageNo,
                                                 @RequestParam(value = "page_size") Integer pageSize) {
        Page<SysOpTypeDefDTO> page = new Page<>();
        int cnt = opTypeDefService.getOpTypeCount(code,opTypeName);
        if (cnt == 0) {
            return page;
        }
        List<SysOpTypeDefDTO> opTypeDefList = opTypeDefService.selectAllOpType(code,opTypeName,pageNo,pageSize);
        if (CollectionUtils.isEmpty(opTypeDefList)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(opTypeDefList);
        return page;
    }
}

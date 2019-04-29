package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpFunctionDTO;
import com.asiainfo.rms.alm.demand.dto.FunctionDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpFunctionService;
import com.asiainfo.rms.core.api.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class AlmReqtmpFunctionControllerImpl implements AlmReqtmpFunctionController {
    private final AlmReqtmpFunctionService almReqtmpFunctionService;

    public AlmReqtmpFunctionControllerImpl(AlmReqtmpFunctionService almReqtmpFunctionService) {
        this.almReqtmpFunctionService = almReqtmpFunctionService;
    }

    @Override
    public String saveAlmReqtmpFunction(@RequestBody FunctionDTO functionDTO) {
        return almReqtmpFunctionService.saveAlmReqtmpFunction(functionDTO);
    }

    @Override
    public String updateAlmReqtmpFunction(@RequestBody FunctionDTO functionDTO) {
        return almReqtmpFunctionService.updateAlmReqtmpFunction(functionDTO);
    }

    @Override
    public String deleteAlmReqtmpFunction(@PathVariable("arf_id")Integer arfId) {
        return almReqtmpFunctionService.deleteAlmReqtmpFunction(arfId);
    }

    @Override
    public FunctionDTO selectAlmReqtmpFunction(@PathVariable("arf_id")Integer arfId) {
        return almReqtmpFunctionService.selectAlmReqtmpFunction(arfId);
    }

    @Override
    public FunctionDTO selectFunction(@PathVariable("art_id")Integer artId) {
        return almReqtmpFunctionService.selectFunction(artId);
    }

    @Override
    public Page<AlmReqtmpFunctionDTO> selectAllAlmReqtmpFunction(@RequestParam(value = "keyword",required = false)String keyword,
													    		@RequestParam(value = "art_type", required = false) Integer artType,
													    		@RequestParam(value = "art_name", required = false) String artName,
													    		@RequestParam(value = "art_tag", required = false) String artTag,
                                                                 @RequestParam(value = "art_region", required = false) Integer artRegion,
													    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
													    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
													    		@RequestParam(value = "page_no") Integer pageNo,
                                                                 @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpFunctionDTO> page = new Page<>();
        int cnt = almReqtmpFunctionService.getAllAlmReqtmpFunctionCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpFunctionDTO> items = almReqtmpFunctionService.selectAllAlmReqtmpFunction(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.demand.dto.BusiayaDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpBusiayaService;
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
public class AlmReqtmpBusiayaControllerImpl implements AlmReqtmpBusiayaController {
    private final AlmReqtmpBusiayaService almReqtmpBusiayaService;

    public AlmReqtmpBusiayaControllerImpl(AlmReqtmpBusiayaService almReqtmpBusiayaService) {
        this.almReqtmpBusiayaService = almReqtmpBusiayaService;
    }

    @Override
    public String saveAlmReqtmpBusiaya(@RequestBody BusiayaDTO busiayaDTO) {
        return almReqtmpBusiayaService.saveAlmReqtmpBusiaya(busiayaDTO);
    }

    @Override
    public String updateAlmReqtmpBusiaya(@RequestBody BusiayaDTO busiayaDTO) {
        return almReqtmpBusiayaService.updateAlmReqtmpBusiaya(busiayaDTO);
    }

    @Override
    public String deleteAlmReqtmpBusiaya(@PathVariable("arba_id")Integer arbaId) {
        return almReqtmpBusiayaService.deleteAlmReqtmpBusiaya(arbaId);
    }

    @Override
    public BusiayaDTO selectAlmReqtmpBusiaya(@PathVariable("arba_id")Integer arbaId) {
        return almReqtmpBusiayaService.selectAlmReqtmpBusiaya(arbaId);
    }

    @Override
    public BusiayaDTO selectBusiaya(@PathVariable("art_id")Integer artId) {
        return almReqtmpBusiayaService.selectBusiaya(artId);
    }

    @Override
    public Page<AlmReqtmpBusiayaDTO> selectAllAlmReqtmpBusiaya(@RequestParam(value = "keyword",required = false)String keyword,
													    		@RequestParam(value = "art_type", required = false) Integer artType,
													    		@RequestParam(value = "art_name", required = false) String artName,
													    		@RequestParam(value = "art_tag", required = false) String artTag,
                                                               @RequestParam(value = "art_region", required = false) Integer artRegion,
													    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
													    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
													    		@RequestParam(value = "page_no") Integer pageNo,
                                                               @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpBusiayaDTO> page = new Page<>();
        int cnt = almReqtmpBusiayaService.getAllAlmReqtmpBusiayaCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpBusiayaDTO> items = almReqtmpBusiayaService.selectAllAlmReqtmpBusiaya(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

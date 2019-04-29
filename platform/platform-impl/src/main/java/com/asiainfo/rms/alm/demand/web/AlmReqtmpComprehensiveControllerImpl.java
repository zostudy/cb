package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpComprehensiveDTO;
import com.asiainfo.rms.alm.demand.dto.ComprehensiveDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpComprehensiveService;
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
public class AlmReqtmpComprehensiveControllerImpl implements AlmReqtmpComprehensiveController {
    private final AlmReqtmpComprehensiveService almReqtmpComprehensiveService;

    public AlmReqtmpComprehensiveControllerImpl(AlmReqtmpComprehensiveService almReqtmpComprehensiveService) {
        this.almReqtmpComprehensiveService = almReqtmpComprehensiveService;
    }

    @Override
    public String saveAlmReqtmpComprehensive(@RequestBody ComprehensiveDTO comprehensiveDTO) {
        return almReqtmpComprehensiveService.saveAlmReqtmpComprehensive(comprehensiveDTO);
    }

    @Override
    public String updateAlmReqtmpComprehensive(@RequestBody ComprehensiveDTO comprehensiveDTO) {
        return almReqtmpComprehensiveService.updateAlmReqtmpComprehensive(comprehensiveDTO);
    }

    @Override
    public String deleteAlmReqtmpComprehensive(@PathVariable("arc_id")Integer arcId) {
        return almReqtmpComprehensiveService.deleteAlmReqtmpComprehensive(arcId);
    }

    @Override
    public ComprehensiveDTO selectAlmReqtmpComprehensive(@PathVariable("arc_id")Integer arcId) {
        return almReqtmpComprehensiveService.selectAlmReqtmpComprehensive(arcId);
    }

    @Override
    public ComprehensiveDTO selectComprehensive(@PathVariable("art_id")Integer artId) {
        return almReqtmpComprehensiveService.selectComprehensive(artId);
    }

    @Override
    public Page<AlmReqtmpComprehensiveDTO> selectAllAlmReqtmpComprehensive(@RequestParam(value = "keyword",required = false)String keyword,
																    		@RequestParam(value = "art_type", required = false) Integer artType,
																    		@RequestParam(value = "art_name", required = false) String artName,
																    		@RequestParam(value = "art_tag", required = false) String artTag,
                                                                           @RequestParam(value = "art_region", required = false) Integer artRegion,
																    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
																    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
																    		@RequestParam(value = "page_no") Integer pageNo,
                                                                           @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpComprehensiveDTO> page = new Page<>();
        int count = almReqtmpComprehensiveService.getAllAlmReqtmpComprehensive(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if(count == 0){
            return page;
        }
        List<AlmReqtmpComprehensiveDTO> items = almReqtmpComprehensiveService.selectAllAlmReqtmpComprehensive(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(count);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

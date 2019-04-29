package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpTopicService;
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
public class AlmReqtmpTopicControllerImpl implements AlmReqtmpTopicController {
    private final AlmReqtmpTopicService almReqtmpTopicService;

    public AlmReqtmpTopicControllerImpl(AlmReqtmpTopicService almReqtmpTopicService) {
        this.almReqtmpTopicService = almReqtmpTopicService;
    }

    @Override
    public String saveAlmReqtmpTopic(@RequestBody AlmReqtmpTopicDTO almReqtmpTopicDTO) {
        return almReqtmpTopicService.saveAlmReqtmpTopic(almReqtmpTopicDTO);
    }

    @Override
    public String updateAlmReqtmpTopic(@PathVariable("art_id")Integer artId, @RequestBody AlmReqtmpTopicDTO almReqtmpTopicDTO) {
        almReqtmpTopicDTO.setArtId(artId);
        return almReqtmpTopicService.updateAlmReqtmpTopic(almReqtmpTopicDTO);
    }

    @Override
    public String deleteAlmReqtmpTopic(@PathVariable("art_id")Integer artId) {
        return almReqtmpTopicService.deleteAlmReqtmpTopic(artId);
    }

    @Override
    public AlmReqtmpTopicDTO selectAlmReqtmpTopicById(@PathVariable("art_id")Integer artId) {
        return almReqtmpTopicService.selectAlmReqtmpTopicById(artId);
    }

    @Override
    public Page<AlmReqtmpTopicDTO> selectAllAlmReqtmpTopic(@RequestParam(value = "keyword",required = false)String keyword,
												    		@RequestParam(value = "art_type", required = false) Integer artType,
												    		@RequestParam(value = "art_name", required = false) String artName,
												    		@RequestParam(value = "art_tag", required = false) String artTag,
												    		@RequestParam(value = "art_region", required = false) Integer artRegion,
												    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
												    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
												    		@RequestParam(value = "page_no") Integer pageNo,
												            @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpTopicDTO> page = new Page<>();
        int cnt = almReqtmpTopicService.getAllAlmReqtmpTopicCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpTopicDTO> items = almReqtmpTopicService.selectAllAlmReqtmpTopic(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpTopicDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpTopicService;
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
public class AlmAsnltmpTopicControllerImpl implements AlmAsnltmpTopicController {
    private final AlmAsnltmpTopicService almAsnltmpTopicService;

    public AlmAsnltmpTopicControllerImpl(AlmAsnltmpTopicService almAsnltmpTopicService) {
        this.almAsnltmpTopicService = almAsnltmpTopicService;
    }

    @Override
    public String saveAlmAsnltmpTopic(@RequestBody AlmAsnltmpTopicDTO almAsnltmpTopicDTO) {
        return almAsnltmpTopicService.saveAlmAsnltmpTopic(almAsnltmpTopicDTO);
    }

    @Override
    public String updateAlmAsnltmpTopic(@PathVariable("aat_id") Integer aatId, @RequestBody AlmAsnltmpTopicDTO almAsnltmpTopicDTO) {
        almAsnltmpTopicDTO.setAatId(aatId);
        return almAsnltmpTopicService.updateAlmAsnltmpTopic(almAsnltmpTopicDTO);
    }

    @Override
    public String deleteAlmAsnltmpTopic(@PathVariable("aat_id")Integer aatId) {
        return almAsnltmpTopicService.deleteAlmAsnltmpTopic(aatId);
    }

    @Override
    public AlmAsnltmpTopicDTO selectAlmAsnltmpTopic(@PathVariable("aat_id")Integer aatId) {
        return almAsnltmpTopicService.selectAlmAsnltmpTopic(aatId);
    }

    @Override
    public Page<AlmAsnltmpTopicDTO> selectAllAlmAsnltmpTopic(@RequestParam(value = "keyword",required = false)String keyword,
                                                             @RequestParam(value = "art_type",required = false)String artType,
                                                             @RequestParam(value = "aat_name",required = false)String aatName,
                                                             @RequestParam(value = "aat_tag",required = false)String aatTag,
                                                             @RequestParam(value = "aat_region",required = false)String aatRegion,
                                                             @RequestParam(value = "aat_depart",required = false)Integer aatDepart,
                                                             @RequestParam(value = "submit_staff_name",required = false)String submitStaffName,
                                                             @RequestParam(value = "online_state",required = false)Integer onlineState,
                                                             @RequestParam(value = "start_time",required = false)String startTime,
                                                             @RequestParam(value = "end_time",required = false)String endTime,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpTopicDTO> page = new Page<>();
        int cnt = almAsnltmpTopicService.getAllAlmAsnltmpTopic(keyword,artType,aatName,aatTag,aatRegion,aatDepart,submitStaffName,onlineState,startTime,endTime);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpTopicDTO> items = almAsnltmpTopicService.selectAllAlmAsnltmpTopic(keyword,artType,aatName,aatTag,aatRegion,aatDepart,submitStaffName,onlineState,startTime,endTime, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

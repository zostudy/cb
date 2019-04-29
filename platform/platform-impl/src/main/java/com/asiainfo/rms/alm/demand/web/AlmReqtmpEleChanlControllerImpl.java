package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpEleChanlDTO;
import com.asiainfo.rms.alm.demand.dto.EleChanlDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpEleChanlService;
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
public class AlmReqtmpEleChanlControllerImpl implements AlmReqtmpEleChanlController {

    private final AlmReqtmpEleChanlService almReqtmpEleChanlService;

    public AlmReqtmpEleChanlControllerImpl(AlmReqtmpEleChanlService almReqtmpEleChanlService) {
        this.almReqtmpEleChanlService = almReqtmpEleChanlService;
    }

    @Override
    public String saveAlmReqtmpEleChanl(@RequestBody EleChanlDTO eleChanlDTO) {
        return almReqtmpEleChanlService.saveAlmReqtmpEleChanl(eleChanlDTO);
    }

    @Override
    public String updateAlmReqtmpEleChanl(@RequestBody EleChanlDTO eleChanlDTO) {
        return almReqtmpEleChanlService.updateAlmReqtmpEleChanl(eleChanlDTO);
    }

    @Override
    public String deleteAlmReqtmpEleChanl(@PathVariable("are_id") Integer areId) {
        return almReqtmpEleChanlService.deleteAlmReqtmpEleChanl(areId);
    }

    @Override
    public EleChanlDTO selectAlmReqtmpEleChanl(@PathVariable("are_id") Integer areId) {
        return almReqtmpEleChanlService.selectAlmReqtmpEleChanl(areId);
    }

    @Override
    public EleChanlDTO selectEleChanl(@PathVariable("art_id") Integer artId) {
        return almReqtmpEleChanlService.selectEleChanl(artId);
    }

    @Override
    public Page<AlmReqtmpEleChanlDTO> selectAllAlmReqtmpEleChanl(@RequestParam(value = "keyword", required = false) String keyword,
                                                                 @RequestParam(value = "art_type", required = false) Integer artType,
                                                                 @RequestParam(value = "art_name", required = false) String artName,
                                                                 @RequestParam(value = "art_tag", required = false) String artTag,
                                                                 @RequestParam(value = "art_region", required = false) Integer artRegion,
                                                                 @RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
                                                                 @RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                                 @RequestParam(value = "page_no") Integer pageNo,
                                                                 @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpEleChanlDTO> page = new Page<>();
        int cnt = almReqtmpEleChanlService.getAllAlmReqtmpEleChanlCount(keyword, artType, artName, artTag, artRegion, urgentLevel, submitStaffName);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpEleChanlDTO> items = almReqtmpEleChanlService.selectAllAlmReqtmpEleChanl(keyword, artType, artName, artTag, artRegion, urgentLevel, submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

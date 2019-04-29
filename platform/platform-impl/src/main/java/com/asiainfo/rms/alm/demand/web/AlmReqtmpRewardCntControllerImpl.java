package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardCntDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpRewardCntService;
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
public class AlmReqtmpRewardCntControllerImpl implements AlmReqtmpRewardCntController {
    private final AlmReqtmpRewardCntService almReqtmpRewardCntService;

    public AlmReqtmpRewardCntControllerImpl(AlmReqtmpRewardCntService almReqtmpRewardCntService) {
        this.almReqtmpRewardCntService = almReqtmpRewardCntService;
    }

    @Override
    public String saveAlmReqtmpRewardCnt(@RequestBody AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO) {
        return almReqtmpRewardCntService.saveAlmReqtmpRewardCnt(almReqtmpRewardCntDTO);
    }

    @Override
    public String updateAlmReqtmpRewardCnt(@PathVariable("content_id") Integer contentId, @RequestBody AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO) {
        almReqtmpRewardCntDTO.setContentId(contentId);
        return almReqtmpRewardCntService.updateAlmReqtmpRewardCnt(almReqtmpRewardCntDTO);
    }

    @Override
    public String deleteAlmReqtmpRewardCnt(@PathVariable("content_id")Integer contentId) {
        return almReqtmpRewardCntService.deleteAlmReqtmpRewardCnt(contentId);
    }

    @Override
    public AlmReqtmpRewardCntDTO selectAlmReqtmpRewardCnt(@PathVariable("content_id")Integer contentId) {
        return almReqtmpRewardCntService.selectAlmReqtmpRewardCnt(contentId);
    }

    @Override
    public Page<AlmReqtmpRewardCntDTO> selectAllAlmReqtmpRewardCnt(@RequestParam("arr_id")Integer arrId,
                                                                   @RequestParam(value = "keyword",required = false)String keyword,
                                                                   @RequestParam(value = "page_no") Integer pageNo,
                                                                   @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpRewardCntDTO> page = new Page<>();
        int cnt = almReqtmpRewardCntService.getAllAlmReqtmpRewardCntCount(arrId,keyword);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpRewardCntDTO> items = almReqtmpRewardCntService.selectAllAlmReqtmpRewardCnt(arrId,keyword, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardDTO;
import com.asiainfo.rms.alm.demand.dto.RewardDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpRewardService;
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
public class AlmReqtmpRewardControllerImpl implements AlmReqtmpRewardController {
    private final AlmReqtmpRewardService almReqtmpRewardService;

    public AlmReqtmpRewardControllerImpl(AlmReqtmpRewardService almReqtmpRewardService) {
        this.almReqtmpRewardService = almReqtmpRewardService;
    }

    @Override
    public String saveAlmReqtmpReward(@RequestBody RewardDTO rewardDTO) {
        return almReqtmpRewardService.saveAlmReqtmpReward(rewardDTO);
    }

    @Override
    public String updateAlmReqtmpReward(@RequestBody RewardDTO rewardDTO) {
        return almReqtmpRewardService.updateAlmReqtmpReward(rewardDTO);
    }

    @Override
    public String deleteAlmReqtmpReward(@PathVariable("arr_id")Integer arrId) {
        return almReqtmpRewardService.deleteAlmReqtmpReward(arrId);
    }

    @Override
    public RewardDTO selectAlmReqtmpReward(@PathVariable("arr_id")Integer arrId) {
        return almReqtmpRewardService.selectAlmReqtmpReward(arrId);
    }

    @Override
    public RewardDTO selectReward(@PathVariable("art_id")Integer artId) {
        return almReqtmpRewardService.selectReward(artId);
    }

    @Override
    public Page<AlmReqtmpRewardDTO> selectAllAlmReqtmpReward(@RequestParam(value = "keyword",required = false)String keyword,
												    		@RequestParam(value = "art_type", required = false) Integer artType,
												    		@RequestParam(value = "art_name", required = false) String artName,
												    		@RequestParam(value = "art_tag", required = false) String artTag,
												    		@RequestParam(value = "art_region", required = false) Integer artRegion,
												    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
												    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
												    		@RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpRewardDTO> page = new Page<>();
        int cnt = almReqtmpRewardService.getAllAlmReqtmpRewardCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (cnt == 0) {
            return page;
        }
        List<AlmReqtmpRewardDTO> items = almReqtmpRewardService.selectAllAlmReqtmpReward(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

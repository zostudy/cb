package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpMarketDTO;
import com.asiainfo.rms.alm.demand.dto.MarketDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpMarketService;
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
public class AlmReqtmpMarketControllerImpl implements AlmReqtmpMarketController {
    private final AlmReqtmpMarketService almReqtmpMarketService;

    public AlmReqtmpMarketControllerImpl(AlmReqtmpMarketService almReqtmpMarketService) {
        this.almReqtmpMarketService = almReqtmpMarketService;
    }

    @Override
    public String saveAlmReqtmpMarket(@RequestBody MarketDTO marketDTO) {
        return almReqtmpMarketService.saveAlmReqtmpMarket(marketDTO);
    }

    @Override
    public String updateAlmReqtmpMarket(@RequestBody MarketDTO marketDTO) {
        return almReqtmpMarketService.updateAlmReqtmpMarket(marketDTO);
    }

    @Override
    public String deletaAlmReqtmpMarket(@PathVariable("arm_id")Integer armId) {
        return almReqtmpMarketService.deletaAlmReqtmpMarket(armId);
    }

    @Override
    public MarketDTO selectAlmReqtmpMarket(@PathVariable("arm_id")Integer armId) {
        return almReqtmpMarketService.selectAlmReqtmpMarket(armId);
    }

    @Override
    public MarketDTO selectMarket(@PathVariable("art_id")Integer artId) {
        return almReqtmpMarketService.selectMarket(artId);
    }

    @Override
    public Page<AlmReqtmpMarketDTO> selectAllAlmReqtmpMarket(@RequestParam(value = "keyword",required = false)String keyword,
												    		@RequestParam(value = "art_type", required = false) Integer artType,
												    		@RequestParam(value = "art_name", required = false) String artName,
												    		@RequestParam(value = "art_tag", required = false) String artTag,
                                                             @RequestParam(value = "art_region", required = false) Integer artRegion,
												    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel,
												    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpMarketDTO> page = new Page<>();
        int count = almReqtmpMarketService.getAllAlmReqtmpMarket(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (count == 0) {
            return page;
        }
        List<AlmReqtmpMarketDTO> items = almReqtmpMarketService.selectAllAlmReqtmpMarket(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(count);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }

}

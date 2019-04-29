package com.asiainfo.rms.alm.demand.web;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpChargeDTO;
import com.asiainfo.rms.alm.demand.dto.ChargeDTO;
import com.asiainfo.rms.alm.demand.service.AlmReqtmpChargeService;
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
public class AlmReqtmpChargeControllerImpl implements AlmReqtmpChargeController {
    private final AlmReqtmpChargeService almReqtmpChargeService;

    public AlmReqtmpChargeControllerImpl(AlmReqtmpChargeService almReqtmpChargeService) {
        this.almReqtmpChargeService = almReqtmpChargeService;
    }

    @Override
    public String saveAlmReqtmpCharge(@RequestBody ChargeDTO chargeDTO) {
        return almReqtmpChargeService.saveAlmReqtmpCharge(chargeDTO);
    }

    @Override
    public String updateAlmReqtmpCharge(@RequestBody ChargeDTO chargeDTO) {
        return almReqtmpChargeService.updateAlmReqtmpCharge(chargeDTO);
    }

    @Override
    public String deleteAlmReqtmpCharge(@PathVariable("arch_id") Integer archId) {
        return almReqtmpChargeService.deleteAlmReqtmpCharge(archId);
    }

    @Override
    public ChargeDTO selectAlmReqtmpCharge(@PathVariable("arch_id") Integer archID) {
        return almReqtmpChargeService.selectAlmReqtmpCharge(archID);
    }

    @Override
    public ChargeDTO selectCharge(@PathVariable("art_id")Integer artId) {
        return almReqtmpChargeService.selectCharge(artId);
    }

    @Override
    public Page<AlmReqtmpChargeDTO> selectAllAlmReqtmpCharge(@RequestParam(value = "keyword",required = false)String keyword,
												    		@RequestParam(value = "art_type", required = false) Integer artType,
												    		@RequestParam(value = "art_name", required = false) String artName,
												    		@RequestParam(value = "art_tag", required = false) String artTag,
												    		@RequestParam(value = "art_region", required = false) Integer artRegion,
												    		@RequestParam(value = "urgent_level", required = false) Integer urgentLevel ,
												    		@RequestParam(value = "submit_staff_name", required = false) String submitStaffName,
                                                             @RequestParam(value = "page_no") Integer pageNo,
                                                             @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmReqtmpChargeDTO> page = new Page<>();
        int count = almReqtmpChargeService.getAllAlmReqtmpCharge(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
        if (count == 0) {
            return page;
        }
        List<AlmReqtmpChargeDTO> items = almReqtmpChargeService.selectAllAlmReqtmpCharge(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(count);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

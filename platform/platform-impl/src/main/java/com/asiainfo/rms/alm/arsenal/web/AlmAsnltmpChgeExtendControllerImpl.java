package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChgeExtendDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpChgeExtendService;
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
public class AlmAsnltmpChgeExtendControllerImpl implements AlmAsnltmpChgeExtendController {
    private final AlmAsnltmpChgeExtendService almAsnltmpChgeExtendService;

    public AlmAsnltmpChgeExtendControllerImpl(AlmAsnltmpChgeExtendService almAsnltmpChgeExtendService) {
        this.almAsnltmpChgeExtendService = almAsnltmpChgeExtendService;
    }

    @Override
    public String saveAlmAsnltmpChgeExtend(@RequestBody AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO) {
        return almAsnltmpChgeExtendService.saveAlmAsnltmpChgeExtend(almAsnltmpChgeExtendDTO);
    }

    @Override
    public String updateAlmAsnltmpChgeExtend(@PathVariable("ace_id")Integer aceId, @RequestBody AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO) {
        almAsnltmpChgeExtendDTO.setAceId(aceId);
        return almAsnltmpChgeExtendService.updateAlmAsnltmpChgeExtend(almAsnltmpChgeExtendDTO);
    }

    @Override
    public String deleteAlmAsnltmpChgeExtend(@PathVariable("ace_id")Integer aceId) {
        return almAsnltmpChgeExtendService.deleteAlmAsnltmpChgeExtend(aceId);
    }

    @Override
    public AlmAsnltmpChgeExtendDTO selectAlmAsnltmpChgeExtendById(@PathVariable("ace_id")Integer aceId) {
        return almAsnltmpChgeExtendService.selectAlmAsnltmpChgeExtendById(aceId);
    }

    @Override
    public Page<AlmAsnltmpChgeExtendDTO> selectAllAlmAsnltmpChgeExtend(@RequestParam("aat_id")Integer aatId,
                                                                       @RequestParam(value = "page_no") Integer pageNo,
                                                                       @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpChgeExtendDTO> page = new Page<>();
        int cnt = almAsnltmpChgeExtendService.getAllAlmAsnltmpChgeExtendCount(aatId);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpChgeExtendDTO> items = almAsnltmpChgeExtendService.selectAllAlmAsnltmpChgeExtend(aatId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

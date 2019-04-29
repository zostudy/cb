package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpStoreGiveService;
import com.asiainfo.rms.core.api.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class AlmAsnltmpStoreGiveControllerImpl implements AlmAsnltmpStoreGiveController {
    private final AlmAsnltmpStoreGiveService almAsnltmpStoreGiveService;

    public AlmAsnltmpStoreGiveControllerImpl(AlmAsnltmpStoreGiveService almAsnltmpStoreGiveService) {
        this.almAsnltmpStoreGiveService = almAsnltmpStoreGiveService;
    }

//    @Override
//    public String saveAlmAsnltmpStoreGive(@RequestBody AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO) {
//        return almAsnltmpStoreGiveService.saveAlmAsnltmpStoreGive(almAsnltmpStoreGiveDTO);
//    }
//
//    @Override
//    public String updateAlmAsnltmpStoreGive(@PathVariable("aas_id") Integer aasId, @RequestBody AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO) {
//        almAsnltmpStoreGiveDTO.setAasId(aasId);
//        return almAsnltmpStoreGiveService.updateAlmAsnltmpStoreGive(almAsnltmpStoreGiveDTO);
//    }

    @Override
    public String deleteAlmAsnltmpStoreGive(@PathVariable("aas_id")Integer aasId) {
        return almAsnltmpStoreGiveService.deleteAlmAsnltmpStoreGive(aasId);
    }

    @Override
    public AlmAsnltmpStoreGiveDTO selectAlmAsnltmpStoreGive(@PathVariable("aas_id")Integer aasId) {
        return almAsnltmpStoreGiveService.selectAlmAsnltmpStoreGive(aasId);
    }

    @Override
    public Page<AlmAsnltmpStoreGiveDTO> selectAllAlmAsnltmpStoreGive(@RequestParam("aat_id")Integer aatId,
                                                                     @RequestParam(value = "page_no") Integer pageNo,
                                                                     @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpStoreGiveDTO> page = new Page<>();
        int cnt = almAsnltmpStoreGiveService.getAllAlmAsnltmpStoreGiveCount(aatId);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpStoreGiveDTO> items = almAsnltmpStoreGiveService.selectAllAlmAsnltmpStoreGive(aatId, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

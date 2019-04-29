package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceRelatDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpServiceRelatService;
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
public class AlmAsnltmpServiceRelatControllerImpl implements AlmAsnltmpServiceRelatController {
    private final AlmAsnltmpServiceRelatService almAsnltmpServiceRelatService;

    public AlmAsnltmpServiceRelatControllerImpl(AlmAsnltmpServiceRelatService almAsnltmpServiceRelatService) {
        this.almAsnltmpServiceRelatService = almAsnltmpServiceRelatService;
    }

    @Override
    public String saveAlmAsnltmpServiceRelat(@RequestBody AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO) {
        return almAsnltmpServiceRelatService.saveAlmAsnltmpServiceRelat(almAsnltmpServiceRelatDTO);
    }

    @Override
    public String updateAlmAsnltmpServiceRelat(@PathVariable("asr_id") Integer asrId, @RequestBody AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO) {
        almAsnltmpServiceRelatDTO.setAsrId(asrId);
        return almAsnltmpServiceRelatService.updateAlmAsnltmpServiceRelat(almAsnltmpServiceRelatDTO);
    }

    @Override
    public String deleteAlmAsnltmpServiceRelat(@PathVariable("asr_id") Integer asrId) {
        return almAsnltmpServiceRelatService.deleteAlmAsnltmpServiceRelat(asrId);
    }

//    @Override
//    public AlmAsnltmpServiceRelatDTO selectAlmAsnltmpServiceRelat(@PathVariable("asr_id")Integer asrId) {
//        return almAsnltmpServiceRelatService.selectAlmAsnltmpServiceRelat(asrId);
//    }

    @Override
    public Page<AlmAsnltmpServiceRelatDTO> selectAlmAsnltmpServiceRelatByArtType(@RequestParam("art_type") Integer artType,
                                                                                 @RequestParam("aat_id") Integer aatId,
                                                                                 @RequestParam(value = "obj_id", required = false) Integer objId) {

        Page<AlmAsnltmpServiceRelatDTO> page = new Page<>();
        List<AlmAsnltmpServiceRelatDTO> items = almAsnltmpServiceRelatService.selectAlmAsnltmpServiceRelatByArtType(artType, aatId, objId);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(items.size());
        page.setPageCount(1);
        page.setPageData(items);
        return page;
    }

    @Override
    public Page<AlmAsnltmpServiceRelatDTO> selectAllAlmAsnltmpServiceRelat(@RequestParam(value = "art_type", required = false) Integer artType,
                                                                           @RequestParam(value = "page_no") Integer pageNo,
                                                                           @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpServiceRelatDTO> page = new Page<>();
        int cnt = almAsnltmpServiceRelatService.getAllAlmAsnltmpServiceRelatCount(artType);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpServiceRelatDTO> items = almAsnltmpServiceRelatService.selectAllAlmAsnltmpServiceRelat(artType, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleRelatDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpRuleRelatService;
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
public class AlmAsnltmpRuleRelatControllerImpl implements AlmAsnltmpRuleRelatController {
    private final AlmAsnltmpRuleRelatService almAsnltmpRuleRelatService;

    public AlmAsnltmpRuleRelatControllerImpl(AlmAsnltmpRuleRelatService almAsnltmpRuleRelatService) {
        this.almAsnltmpRuleRelatService = almAsnltmpRuleRelatService;
    }

    @Override
    public String saveAlmAsnltmpRuleRelat(@RequestBody AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO) {
        return almAsnltmpRuleRelatService.saveAlmAsnltmpRuleRelat(almAsnltmpRuleRelatDTO);
    }

    @Override
    public String updateAlmAsnltmpRuleRelat(@PathVariable("artt_id") Integer atrrId,
                                            @RequestBody AlmAsnltmpRuleRelatDTO almAsnltmpRuleRelatDTO) {
        almAsnltmpRuleRelatDTO.setAtrrId(atrrId);
        return almAsnltmpRuleRelatService.updateAlmAsnltmpRuleRelat(almAsnltmpRuleRelatDTO);
    }

    @Override
    public String deleteAlmAsnltmpRuleRelat(@PathVariable("artt_id") Integer atrrId) {
        return almAsnltmpRuleRelatService.deleteAlmAsnltmpRuleRelat(atrrId);
    }

//    @Override
//    public AlmAsnltmpRuleRelatDTO selectAlmAsnltmpRuleRela(@PathVariable("artt_id")Integer atrrId) {
//        return almAsnltmpRuleRelatService.selectAlmAsnltmpRuleRela(atrrId);
//    }

    @Override
    public Page<AlmAsnltmpRuleRelatDTO> selectAlmAsnltmpRuleRelaByArtType(@RequestParam("art_type") Integer artType,
                                                                          @RequestParam("aat_id") Integer aatId,
                                                                          @RequestParam(value = "obj_id", required = false) Integer objId) {
        Page<AlmAsnltmpRuleRelatDTO> page = new Page<>();
        List<AlmAsnltmpRuleRelatDTO> items = almAsnltmpRuleRelatService.selectAlmAsnltmpServiceRelatByArtType(artType, aatId, objId);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(items.size());
        page.setPageCount(1);
        page.setPageData(items);
        return page;
    }

    @Override
    public Page<AlmAsnltmpRuleRelatDTO> selectAllAlmAsnltmpRuleRela(@RequestParam(value = "art_type", required = false) Integer artType,
                                                                    @RequestParam(value = "page_no") Integer pageNo,
                                                                    @RequestParam(value = "page_size") Integer pageSize) {
        Page<AlmAsnltmpRuleRelatDTO> page = new Page<>();
        int cnt = almAsnltmpRuleRelatService.getAllAlmAsnltmpRuleRelaCount(artType);
        if (cnt == 0) {
            return page;
        }
        List<AlmAsnltmpRuleRelatDTO> items = almAsnltmpRuleRelatService.selectAllAlmAsnltmpRuleRela(artType, pageNo, pageSize);
        if (CollectionUtils.isEmpty(items)) {
            return page;
        }
        page.setRowCount(cnt);
        page.generatePageCount(pageSize);
        page.setPageData(items);
        return page;
    }
}

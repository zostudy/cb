package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmRuleValueDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmAsnltmpRuleValueService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmAsnltmpRuleValueControllerImpl implements AlmAsnltmpRuleValueController {
    private final AlmAsnltmpRuleValueService almAsnltmpRuleValueService;

    public AlmAsnltmpRuleValueControllerImpl(AlmAsnltmpRuleValueService almAsnltmpRuleValueService) {
        this.almAsnltmpRuleValueService = almAsnltmpRuleValueService;
    }

    @Override
    public String saveAlmAsnltmpRuleValue(@RequestBody AlmRuleValueDTO almRuleValueDTO) {
        return almAsnltmpRuleValueService.saveAlmAsnltmpRuleValue(almRuleValueDTO);
    }

//    @Override
//    public String updateAlmAsnltmpRuleValue(@PathVariable("aarv_id")Integer aarvId,
//                                            @RequestBody AlmAsnltmpRuleValueDTO almAsnltmpRuleValueDTO) {
//        almAsnltmpRuleValueDTO.setAarvId(aarvId);
//        return almAsnltmpRuleValueService.updateAlmAsnltmpRuleValue(almAsnltmpRuleValueDTO);
//    }

    @Override
    public String deleteAlmAsnltmpRuleValue(@PathVariable("aarv_id")Integer aarvId) {
        return almAsnltmpRuleValueService.deleteAlmAsnltmpRuleValue(aarvId);
    }

//    @Override
//    public AlmAsnltmpRuleValueDTO selectAlmAsnltmpRuleValue(@PathVariable("aarv_id")Integer aarvId) {
//        return almAsnltmpRuleValueService.selectAlmAsnltmpRuleValue(aarvId);
//    }
}

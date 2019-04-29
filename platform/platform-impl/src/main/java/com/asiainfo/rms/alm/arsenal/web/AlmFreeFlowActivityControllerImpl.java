package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmFreeFlowActivityDTO;
import com.asiainfo.rms.alm.arsenal.service.AlmFreeFlowActivityService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
public class AlmFreeFlowActivityControllerImpl implements AlmFreeFlowActivityController {
    private final AlmFreeFlowActivityService almFreeFlowActivityService;

    public AlmFreeFlowActivityControllerImpl(AlmFreeFlowActivityService almFreeFlowActivityService) {
        this.almFreeFlowActivityService = almFreeFlowActivityService;
    }

    @Override
    public String saveFreeFlowActivity(@RequestBody AlmFreeFlowActivityDTO almFreeFlowActivityDTO) {
        return almFreeFlowActivityService.saveFreeFlowActivity(almFreeFlowActivityDTO);
    }

    @Override
    public String updateFreeFlowActivity(@PathVariable("activity_id")Long activityId,@RequestBody AlmFreeFlowActivityDTO almFreeFlowActivityDTO) {
        almFreeFlowActivityDTO.setActivityId(activityId);
        return almFreeFlowActivityService.updateFreeFlowActivity(almFreeFlowActivityDTO);
    }

    @Override
    public AlmFreeFlowActivityDTO findFreeFlowActivity(@PathVariable("activity_id")Long activityId) {
        return almFreeFlowActivityService.findFreeFlowActivity(activityId);
    }

}

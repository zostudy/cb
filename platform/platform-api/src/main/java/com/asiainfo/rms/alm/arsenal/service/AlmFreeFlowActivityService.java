package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmFreeFlowActivityDTO;

public interface AlmFreeFlowActivityService {
    String saveFreeFlowActivity(AlmFreeFlowActivityDTO almFreeFlowActivityDTO);

    String updateFreeFlowActivity(AlmFreeFlowActivityDTO almFreeFlowActivityDTO);

    AlmFreeFlowActivityDTO findFreeFlowActivity(Long activityId);
}

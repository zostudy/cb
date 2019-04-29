package com.asiainfo.rms.alm.arsenal.dao;

import com.asiainfo.rms.alm.arsenal.domain.AlmFreeFlowActivityRepository;
import org.apache.ibatis.annotations.Param;

public interface AlmFreeFlowActivityDao {
    Long saveFreeFlowActivity(AlmFreeFlowActivityRepository almFreeFlowActivityRepository);

    Long updateFreeFlowActivity(AlmFreeFlowActivityRepository almFreeFlowActivityRepository);

    AlmFreeFlowActivityRepository findFreeFlowActivity(@Param("activityId")Long activityId);
}

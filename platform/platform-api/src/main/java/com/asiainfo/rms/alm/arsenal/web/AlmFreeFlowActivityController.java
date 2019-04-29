package com.asiainfo.rms.alm.arsenal.web;

import com.asiainfo.rms.alm.arsenal.dto.AlmFreeFlowActivityDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/alm")
public interface AlmFreeFlowActivityController {

    @RequestMapping(value = "/free_flow_activity",method = RequestMethod.POST)
    String saveFreeFlowActivity(@RequestBody AlmFreeFlowActivityDTO almFreeFlowActivityDTO);

    @RequestMapping(value = "/free_flow_activity/{activity_id}",method = RequestMethod.PUT)
    String updateFreeFlowActivity(@PathVariable("activity_id")Long activityId,@RequestBody AlmFreeFlowActivityDTO almFreeFlowActivityDTO);

    @RequestMapping(value = "/free_flow_activity/{activity_id}",method = RequestMethod.GET)
    AlmFreeFlowActivityDTO findFreeFlowActivity(@PathVariable("activity_id") Long activityId);
}

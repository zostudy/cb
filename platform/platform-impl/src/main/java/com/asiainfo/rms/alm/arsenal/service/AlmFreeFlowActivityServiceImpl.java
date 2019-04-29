package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmFreeFlowActivityConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmFreeFlowActivityDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmFreeFlowActivityRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmFreeFlowActivityDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AlmFreeFlowActivityServiceImpl implements AlmFreeFlowActivityService {
    private final AlmFreeFlowActivityDao almFreeFlowActivityDao;

    public AlmFreeFlowActivityServiceImpl(AlmFreeFlowActivityDao almFreeFlowActivityDao) {
        this.almFreeFlowActivityDao = almFreeFlowActivityDao;
    }

    @Override
    public String saveFreeFlowActivity(AlmFreeFlowActivityDTO almFreeFlowActivityDTO) {
        JSONObject json = new JSONObject();
        AlmFreeFlowActivityRepository almFreeFlowActivityRepository;
        almFreeFlowActivityRepository = AlmFreeFlowActivityConvert.INSTANCE.toSYS(almFreeFlowActivityDTO);
        if(almFreeFlowActivityDao.saveFreeFlowActivity(almFreeFlowActivityRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("activity_id",almFreeFlowActivityRepository.getActivityId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateFreeFlowActivity(AlmFreeFlowActivityDTO almFreeFlowActivityDTO) {
        JSONObject json = new JSONObject();
        AlmFreeFlowActivityRepository almFreeFlowActivityRepository;
        almFreeFlowActivityRepository = AlmFreeFlowActivityConvert.INSTANCE.toSYS(almFreeFlowActivityDTO);
        if(almFreeFlowActivityDao.updateFreeFlowActivity(almFreeFlowActivityRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public AlmFreeFlowActivityDTO findFreeFlowActivity(Long activityId) {
        return AlmFreeFlowActivityConvert.INSTANCE.toDTO(almFreeFlowActivityDao.findFreeFlowActivity(activityId));
    }
}

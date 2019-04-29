package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpRuleValueConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpRuleValueDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleValueRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleValueDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmRuleValueDTO;
import com.asiainfo.rms.core.exception.BusinessException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpRuleValueServiceImpl implements AlmAsnltmpRuleValueService {
    private final AlmAsnltmpRuleValueDao almAsnltmpRuleValueDao;

    public AlmAsnltmpRuleValueServiceImpl(AlmAsnltmpRuleValueDao almAsnltmpRuleValueDao) {
        this.almAsnltmpRuleValueDao = almAsnltmpRuleValueDao;
    }

    @Override
    public String saveAlmAsnltmpRuleValue(AlmRuleValueDTO almRuleValueDTO) {
        JSONObject json = new JSONObject();
        int count=0;
        List<AlmAsnltmpRuleValueDTO> ruleValueDTOList = almRuleValueDTO.getRuleValueDTOS();
        if (ruleValueDTOList.size() > 0) {
            for (AlmAsnltmpRuleValueDTO ruleValueDTO : ruleValueDTOList) {
                AlmAsnltmpRuleValueRepository almAsnltmpRuleValueRepository;
                almAsnltmpRuleValueRepository = AlmAsnltmpRuleValueConvert.INSTANCE.toSYS(ruleValueDTO);
                switch (almAsnltmpRuleValueRepository.getOperateType()) {
                    case "C":
                        almAsnltmpRuleValueDao.saveAlmAsnltmpRuleValue(almAsnltmpRuleValueRepository);
                        count++;
                        break;
                    case "U":
                        almAsnltmpRuleValueDao.updateAlmAsnltmpRuleValue(almAsnltmpRuleValueRepository);
                        count++;
                        break;
                    default:
                        throw new BusinessException("");
                }
            }
        }
        try {
            json.put("code",1);
            json.put("msg","success");
            json.put("row_count",count);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }
//
//    @Override
//    public String updateAlmAsnltmpRuleValue(AlmAsnltmpRuleValueDTO almAsnltmpRuleValueDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpRuleValueRepository almAsnltmpRuleValueRepository;
//        almAsnltmpRuleValueRepository = AlmAsnltmpRuleValueConvert.INSTANCE.toSYS(almAsnltmpRuleValueDTO);
//        if (almAsnltmpRuleValueDao.updateAlmAsnltmpRuleValue(almAsnltmpRuleValueRepository) > 0) {
//            try {
//                json.put("code", 1);
//                json.put("msg", "success");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }

    @Override
    public String deleteAlmAsnltmpRuleValue(Integer aarvId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpRuleValueDao.deleteAlmAsnltmpRuleValue(aarvId);
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

//    @Override
//    public AlmAsnltmpRuleValueDTO selectAlmAsnltmpRuleValue(Integer aarvId) {
//        return AlmAsnltmpRuleValueConvert.INSTANCE.toDTO(almAsnltmpRuleValueDao.selectAlmAsnltmpRuleValue(aarvId));
//    }
}

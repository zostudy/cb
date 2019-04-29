package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpChargeConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpChargeDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChargeRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChargeDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AlmAsnltmpChargeServiceImpl implements AlmAsnltmpChargeService {
    private final AlmAsnltmpChargeDao almAsnltmpChargeDao;

    public AlmAsnltmpChargeServiceImpl(AlmAsnltmpChargeDao almAsnltmpChargeDao) {
        this.almAsnltmpChargeDao = almAsnltmpChargeDao;
    }

    @Override
    public String saveAlmAsnltmpCharge(AlmAsnltmpChargeDTO almAsnltmpChargeDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpChargeRepository almAsnltmpChargeRepository;
        almAsnltmpChargeRepository = AlmAsnltmpChargeConvert.INSTANCE.toSYS(almAsnltmpChargeDTO);
        String str = almAsnltmpChargeRepository.getConsultPrdct();
        if (str.length() <= 6) {
            int aatId = almAsnltmpChargeRepository.getAatId();
            if (almAsnltmpChargeDao.getChargeByAatId(aatId) == 0) {
                almAsnltmpChargeRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
                almAsnltmpChargeRepository.setOnlineState(0);
                if (almAsnltmpChargeDao.saveAlmAsnltmpCharge(almAsnltmpChargeRepository) > 0) {
                    try {
                        json.put("code", 1);
                        json.put("msg", "success");
                        json.put("ac_id", almAsnltmpChargeRepository.getAcId());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    json.put("code", 0);
                    json.put("msg", "该模板已存在数据！");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                json.put("code", 0);
                json.put("msg", "继承可选优惠包字段超长，请填写6位数字！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpCharge(AlmAsnltmpChargeDTO almAsnltmpChargeDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpChargeRepository almAsnltmpChargeRepository;
        almAsnltmpChargeRepository = AlmAsnltmpChargeConvert.INSTANCE.toSYS(almAsnltmpChargeDTO);
        String str = almAsnltmpChargeRepository.getConsultPrdct();
        if (str.length() <= 6) {
            if (almAsnltmpChargeDao.updateAlmAsnltmpCharge(almAsnltmpChargeRepository) > 0) {
                try {
                    json.put("code", 1);
                    json.put("msg", "success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                json.put("code", 0);
                json.put("msg", "继承可选优惠包字段超长，请填写6位数字！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public AlmAsnltmpChargeDTO selectAlmAsnltmpChargeByAarId(Integer aatId) {
        return AlmAsnltmpChargeConvert.INSTANCE.toDTO(almAsnltmpChargeDao.selectAlmAsnltmpChargeByAarId(aatId));
    }
}

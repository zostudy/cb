package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpLabelConfigConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpLabelConfigDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpLabelConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpLabelConfigDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpLabelConfigServiceImpl implements AlmAsnltmpLabelConfigService {
    private final AlmAsnltmpLabelConfigDao almAsnltmpLabelConfigDao;

    public AlmAsnltmpLabelConfigServiceImpl(AlmAsnltmpLabelConfigDao almAsnltmpLabelConfigDao) {
        this.almAsnltmpLabelConfigDao = almAsnltmpLabelConfigDao;
    }

    @Override
    public String saveAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpLabelConfigRepository almAsnltmpLabelConfigRepository;
        almAsnltmpLabelConfigRepository = AlmAsnltmpLabelConfigConvert.INSTANCE.toSYS(almAsnltmpLabelConfigDTO);
        almAsnltmpLabelConfigRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        if(almAsnltmpLabelConfigDao.saveAlmAsnltmpLabelConfig(almAsnltmpLabelConfigRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("lmId",almAsnltmpLabelConfigRepository.getLmId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpLabelConfig(AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpLabelConfigRepository almAsnltmpLabelConfigRepository;
        almAsnltmpLabelConfigRepository = AlmAsnltmpLabelConfigConvert.INSTANCE.toSYS(almAsnltmpLabelConfigDTO);
        if(almAsnltmpLabelConfigDao.updateAlmAsnltmpLabelConfig(almAsnltmpLabelConfigRepository)>0){
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
    public String deleteAlmAsnltmpLabelConfig(Integer lmId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpLabelConfigDao.deleteAlmAsnltmpLabelConfig(lmId);
        if(count >0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("row_count",count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public AlmAsnltmpLabelConfigDTO selectAlmAsnltmpLabelConfigById(Integer lmId) {
        return AlmAsnltmpLabelConfigConvert.INSTANCE.toDTO(almAsnltmpLabelConfigDao.selectAlmAsnltmpLabelConfigById(lmId));
    }

    @Override
    public List<AlmAsnltmpLabelConfigDTO> selectAllAlmAsnltmpLabelConfig(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpLabelConfigRepository> itemList = almAsnltmpLabelConfigDao.selectAllAlmAsnltmpLabelConfig(keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpLabelConfigConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpLabelConfigCount(String keyword) {
        return almAsnltmpLabelConfigDao.getAllAlmAsnltmpLabelConfigCount(keyword);
    }
}

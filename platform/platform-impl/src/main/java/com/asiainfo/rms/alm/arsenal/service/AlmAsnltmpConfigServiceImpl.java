package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpConfigConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpConfigDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpConfigDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpConfigServiceImpl implements AlmAsnltmpConfigService {
    private final AlmAsnltmpConfigDao almAsnltmpConfigDao;

    public AlmAsnltmpConfigServiceImpl(AlmAsnltmpConfigDao almAsnltmpConfigDao) {
        this.almAsnltmpConfigDao = almAsnltmpConfigDao;
    }

    @Override
    public String saveAlmAsnltmpConfig(AlmAsnltmpConfigDTO almAsnltmpConfigDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpConfigRepository almAsnltmpConfigRepository;
        almAsnltmpConfigRepository = AlmAsnltmpConfigConvert.INSTANCE.toSYS(almAsnltmpConfigDTO);
        if(almAsnltmpConfigDao.saveAlmAsnltmpConfig(almAsnltmpConfigRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("aac_id",almAsnltmpConfigRepository.getAacId());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpConfig(AlmAsnltmpConfigDTO almAsnltmpConfigDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpConfigRepository almAsnltmpConfigRepository;
        almAsnltmpConfigRepository = AlmAsnltmpConfigConvert.INSTANCE.toSYS(almAsnltmpConfigDTO);
        if(almAsnltmpConfigDao.updateAlmAsnltmpConfig(almAsnltmpConfigRepository)>0){
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
    public String deleteAlmAsnltmpConfig(Integer aacId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpConfigDao.deleteAlmAsnltmpConfig(aacId);
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
    public AlmAsnltmpConfigDTO selectAlmAsnltmpConfigById(Integer aacId) {
        return AlmAsnltmpConfigConvert.INSTANCE.toDTO(almAsnltmpConfigDao.selectAlmAsnltmpConfigById(aacId));
    }

    @Override
    public List<AlmAsnltmpConfigDTO> selectAllAlmAsnltmpConfig(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpConfigRepository> itemList = almAsnltmpConfigDao.selectAllAlmAsnltmpConfig(keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpConfigConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpConfigCount(String keyword) {
        return almAsnltmpConfigDao.getAllAlmAsnltmpConfigCount(keyword);
    }
}

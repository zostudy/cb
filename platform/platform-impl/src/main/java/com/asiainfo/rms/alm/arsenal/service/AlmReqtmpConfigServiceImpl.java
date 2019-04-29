package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmReqtmpConfigConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmReqtmpConfigDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmReqtmpConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmReqtmpConfigDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpConfigServiceImpl implements AlmReqtmpConfigService {

    private final AlmReqtmpConfigDao almReqtmpConfigDao;

    public AlmReqtmpConfigServiceImpl(AlmReqtmpConfigDao almReqtmpConfigDao) {
        this.almReqtmpConfigDao = almReqtmpConfigDao;
    }

    @Override
    public String saveAlmReqtmpConfig(AlmReqtmpConfigDTO almReqtmpConfigDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpConfigRepository almReqtmpConfigRepository;
        almReqtmpConfigRepository = AlmReqtmpConfigConvert.INSTANCE.toSYS(almReqtmpConfigDTO);
        if(almReqtmpConfigDao.saveAlmReqtmpConfig(almReqtmpConfigRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("id",almReqtmpConfigRepository.getId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpConfig(AlmReqtmpConfigDTO almReqtmpConfigDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpConfigRepository almReqtmpConfigRepository;
        almReqtmpConfigRepository = AlmReqtmpConfigConvert.INSTANCE.toSYS(almReqtmpConfigDTO);
        if(almReqtmpConfigDao.updateAlmReqtmpConfig(almReqtmpConfigRepository)>0){
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
    public String deleteAlmReqtmpConfig(Integer id) {
        JSONObject json = new JSONObject();
        Integer count = almReqtmpConfigDao.deleteAlmReqtmpConfig(id);

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
    public AlmReqtmpConfigDTO selectAlmReqtmpConfig(Integer id) {
        return AlmReqtmpConfigConvert.INSTANCE.toDTO(almReqtmpConfigDao.selectAlmReqtmpConfig(id));
    }

    @Override
    public List<AlmReqtmpConfigDTO> selectAllAlmReqtmpConfig(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpConfigRepository> itemList = almReqtmpConfigDao.selectAllAlmReqtmpConfig(keyword, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpConfigConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpConfigCount(String keyword) {
        return almReqtmpConfigDao.getAllAlmReqtmpConfigCount(keyword);
    }
}

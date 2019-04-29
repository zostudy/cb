package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpOnlineConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpOnlineDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpOnlineRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpOnlineDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpOnlineServiceImpl implements AlmAsnltmpOnlineService {
    private final AlmAsnltmpOnlineDao almAsnltmpOnlineDao;

    public AlmAsnltmpOnlineServiceImpl(AlmAsnltmpOnlineDao almAsnltmpOnlineDao) {
        this.almAsnltmpOnlineDao = almAsnltmpOnlineDao;
    }

    @Override
    public String saveAlmAsnltmpOnline(AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpOnlineRepository almAsnltmpOnlineRepository;
        almAsnltmpOnlineRepository = AlmAsnltmpOnlineConvert.INSTANCE.toSYS(almAsnltmpOnlineDTO);
        if(almAsnltmpOnlineDao.saveAlmAsnltmpOnline(almAsnltmpOnlineRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("aao_id",almAsnltmpOnlineRepository.getAaoId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpOnline(AlmAsnltmpOnlineDTO almAsnltmpOnlineDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpOnlineRepository almAsnltmpOnlineRepository;
        almAsnltmpOnlineRepository = AlmAsnltmpOnlineConvert.INSTANCE.toSYS(almAsnltmpOnlineDTO);
        if(almAsnltmpOnlineDao.updateAlmAsnltmpOnline(almAsnltmpOnlineRepository)>0){
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
    public String deleteAlmAsnltmpOnline(Integer aaoId) {
        JSONObject json = new JSONObject();
        Integer count =almAsnltmpOnlineDao.deleteAlmAsnltmpOnline(aaoId);
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
    public AlmAsnltmpOnlineDTO selectAlmAsnltmpOnline(Integer aaoId) {
        return AlmAsnltmpOnlineConvert.INSTANCE.toDTO(almAsnltmpOnlineDao.selectAlmAsnltmpOnline(aaoId));
    }

    @Override
    public List<AlmAsnltmpOnlineDTO> selectAllAlmAsnltmpOnline(String keyword, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpOnlineRepository> itemList = almAsnltmpOnlineDao.selectAllAlmAsnltmpOnline(keyword,offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpOnlineConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpOnlineCount(String keyword) {
        return almAsnltmpOnlineDao.getAllAlmAsnltmpOnlineCount(keyword);
    }
}

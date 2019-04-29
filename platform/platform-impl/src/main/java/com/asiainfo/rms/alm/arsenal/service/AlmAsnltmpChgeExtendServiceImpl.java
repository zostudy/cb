package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpChgeExtendConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpChgeExtendDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpChgeExtendRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpChgeExtendDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpChgeExtendServiceImpl implements AlmAsnltmpChgeExtendService {
    private final AlmAsnltmpChgeExtendDao almAsnltmpChgeExtendDao;

    public AlmAsnltmpChgeExtendServiceImpl(AlmAsnltmpChgeExtendDao almAsnltmpChgeExtendDao) {
        this.almAsnltmpChgeExtendDao = almAsnltmpChgeExtendDao;
    }

    @Override
    public String saveAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpChgeExtendRepository almAsnltmpChgeExtendRepository;
        almAsnltmpChgeExtendRepository = AlmAsnltmpChgeExtendConvert.INSTANCE.toSYS(almAsnltmpChgeExtendDTO);
        if(almAsnltmpChgeExtendDao.saveAlmAsnltmpChgeExtend(almAsnltmpChgeExtendRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("ace_id",almAsnltmpChgeExtendRepository.getAceId());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpChgeExtend(AlmAsnltmpChgeExtendDTO almAsnltmpChgeExtendDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpChgeExtendRepository almAsnltmpChgeExtendRepository;
        almAsnltmpChgeExtendRepository = AlmAsnltmpChgeExtendConvert.INSTANCE.toSYS(almAsnltmpChgeExtendDTO);
        almAsnltmpChgeExtendRepository.setOnlineState(0);
        if(almAsnltmpChgeExtendDao.updateAlmAsnltmpChgeExtend(almAsnltmpChgeExtendRepository)>0){
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
    public String deleteAlmAsnltmpChgeExtend(Integer aceId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpChgeExtendDao.deleteAlmAsnltmpChgeExtend(aceId);
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
    public AlmAsnltmpChgeExtendDTO selectAlmAsnltmpChgeExtendById(Integer aceId) {
        return AlmAsnltmpChgeExtendConvert.INSTANCE.toDTO(almAsnltmpChgeExtendDao.selectAlmAsnltmpChgeExtendById(aceId));
    }

    @Override
    public List<AlmAsnltmpChgeExtendDTO> selectAllAlmAsnltmpChgeExtend(Integer aatId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpChgeExtendRepository> itemList = almAsnltmpChgeExtendDao.selectAllAlmAsnltmpChgeExtend(aatId, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpChgeExtendConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpChgeExtendCount(Integer aatId) {
        return almAsnltmpChgeExtendDao.getAllAlmAsnltmpChgeExtend(aatId);
    }
}

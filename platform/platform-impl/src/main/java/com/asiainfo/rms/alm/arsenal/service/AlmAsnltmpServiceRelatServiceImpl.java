package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpServiceRelatConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpServiceRelatDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpServiceRelatRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpServiceRelatDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpServiceRelatServiceImpl implements AlmAsnltmpServiceRelatService {
    private final AlmAsnltmpServiceRelatDao almAsnltmpServiceRelatDao;

    public AlmAsnltmpServiceRelatServiceImpl(AlmAsnltmpServiceRelatDao almAsnltmpServiceRelatDao) {
        this.almAsnltmpServiceRelatDao = almAsnltmpServiceRelatDao;
    }

    @Override
    public String saveAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpServiceRelatRepository almAsnltmpServiceRelatRepository;
        almAsnltmpServiceRelatRepository = AlmAsnltmpServiceRelatConvert.INSTANCE.toSYS(almAsnltmpServiceRelatDTO);
        //同一个类型下，同一个服务只能新增一条数据
        Integer artTypoe = almAsnltmpServiceRelatRepository.getArtType();
        Integer asId = almAsnltmpServiceRelatRepository.getAsId();

        if(almAsnltmpServiceRelatDao.getServiceByTypeAndId(artTypoe,asId) == 0){
            if(almAsnltmpServiceRelatDao.saveAlmAsnltmpServiceRelat(almAsnltmpServiceRelatRepository)>0){
                try {
                    json.put("code",1);
                    json.put("msg","success");
                    json.put("asr_id",almAsnltmpServiceRelatRepository.getAsrId());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                json.put("code",0);
                json.put("msg","该服务已存在！！");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpServiceRelat(AlmAsnltmpServiceRelatDTO almAsnltmpServiceRelatDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpServiceRelatRepository almAsnltmpServiceRelatRepository;
        almAsnltmpServiceRelatRepository = AlmAsnltmpServiceRelatConvert.INSTANCE.toSYS(almAsnltmpServiceRelatDTO);
        if(almAsnltmpServiceRelatDao.updateAlmAsnltmpServiceRelat(almAsnltmpServiceRelatRepository)>0){
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
    public String deleteAlmAsnltmpServiceRelat(Integer asrId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpServiceRelatDao.deleteAlmAsnltmpServiceRelat(asrId);
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

//    @Override
//    public AlmAsnltmpServiceRelatDTO selectAlmAsnltmpServiceRelat(Integer asrId) {
//        return AlmAsnltmpServiceRelatConvert.INSTANCE.toDTO(almAsnltmpServiceRelatDao.selectAlmAsnltmpServiceRelat(asrId));
//    }

    @Override
    public List<AlmAsnltmpServiceRelatDTO> selectAlmAsnltmpServiceRelatByArtType(Integer artType, Integer aatId, Integer objId) {
        return AlmAsnltmpServiceRelatConvert.INSTANCE.toDTOs(almAsnltmpServiceRelatDao.selectAlmAsnltmpServiceRelatByArtType(artType, aatId, objId));
    }

    @Override
    public List<AlmAsnltmpServiceRelatDTO> selectAllAlmAsnltmpServiceRelat(Integer artType, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpServiceRelatRepository> itemList = almAsnltmpServiceRelatDao.selectAllAlmAsnltmpServiceRelat(artType, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpServiceRelatConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpServiceRelatCount(Integer artType) {
        return almAsnltmpServiceRelatDao.getAllAlmAsnltmpServiceRelatCount(artType);
    }
}

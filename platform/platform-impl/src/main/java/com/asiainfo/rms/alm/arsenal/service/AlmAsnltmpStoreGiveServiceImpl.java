package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpStoreGiveConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpStoreGiveDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpStoreGiveRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpStoreGiveDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmAsnltmpStoreGiveServiceImpl implements AlmAsnltmpStoreGiveService {
    private final AlmAsnltmpStoreGiveDao almAsnltmpStoreGiveDao;

    public AlmAsnltmpStoreGiveServiceImpl(AlmAsnltmpStoreGiveDao almAsnltmpStoreGiveDao) {
        this.almAsnltmpStoreGiveDao = almAsnltmpStoreGiveDao;
    }

//    @Override
//    public String saveAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository;
//        almAsnltmpStoreGiveRepository = AlmAsnltmpStoreGiveConvert.INSTANCE.toSYS(almAsnltmpStoreGiveDTO);
//        almAsnltmpStoreGiveRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
//        almAsnltmpStoreGiveRepository.setOnlineState(0);
//        if(almAsnltmpStoreGiveDao.saveAlmAsnltmpStoreGive(almAsnltmpStoreGiveRepository)>0){
//            try {
//                json.put("code",1);
//                json.put("msg","success");
//                json.put("aas_id",almAsnltmpStoreGiveRepository.getAasId());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return json.toString();
//    }

//    @Override
//    public String updateAlmAsnltmpStoreGive(AlmAsnltmpStoreGiveDTO almAsnltmpStoreGiveDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpStoreGiveRepository almAsnltmpStoreGiveRepository;
//        almAsnltmpStoreGiveRepository = AlmAsnltmpStoreGiveConvert.INSTANCE.toSYS(almAsnltmpStoreGiveDTO);
//        if(almAsnltmpStoreGiveDao.updateAlmAsnltmpStoreGive(almAsnltmpStoreGiveRepository)>0){
//            try {
//                json.put("code",1);
//                json.put("msg","success");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//        return json.toString();
//    }

    @Override
    public String deleteAlmAsnltmpStoreGive(Integer aasId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpStoreGiveDao.deleteAlmAsnltmpStoreGive(aasId);

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
    public AlmAsnltmpStoreGiveDTO selectAlmAsnltmpStoreGive(Integer aasId) {
        return AlmAsnltmpStoreGiveConvert.INSTANCE.toDTO(almAsnltmpStoreGiveDao.selectAlmAsnltmpStoreGive(aasId));
    }

    @Override
    public List<AlmAsnltmpStoreGiveDTO> selectAllAlmAsnltmpStoreGive(Integer aatId, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpStoreGiveRepository> itemList = almAsnltmpStoreGiveDao.selectAllAlmAsnltmpStoreGive(aatId, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpStoreGiveConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpStoreGiveCount(Integer aatId) {
        return almAsnltmpStoreGiveDao.getAllAlmAsnltmpStoreGive(aatId);
    }
}

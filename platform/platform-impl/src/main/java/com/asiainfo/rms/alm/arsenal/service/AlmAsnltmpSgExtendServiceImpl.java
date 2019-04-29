package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpSgExtendConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpSgExtendDao;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpSgExtendDTO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class AlmAsnltmpSgExtendServiceImpl implements AlmAsnltmpSgExtendService{

    private final AlmAsnltmpSgExtendDao almAsnltmpSgExtendDao;

    public AlmAsnltmpSgExtendServiceImpl(AlmAsnltmpSgExtendDao almAsnltmpSgExtendDao) {
        this.almAsnltmpSgExtendDao = almAsnltmpSgExtendDao;
    }

//    @Override
//    public String saveAlmAsnltmpSgExtend(AlmAsnltmpSgExtendDTO almAsnltmpSgExtendDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository;
//        almAsnltmpSgExtendRepository = AlmAsnltmpSgExtendConvert.INSTANCE.toSYS(almAsnltmpSgExtendDTO);
//        almAsnltmpSgExtendRepository.setOnlineState(0);
//        if(almAsnltmpSgExtendDao.saveAlmAsnltmpSgExtend(almAsnltmpSgExtendRepository)>0){
//            try {
//                json.put("code",1);
//                json.put("msg","success");
//                json.put("aas_id",almAsnltmpSgExtendRepository.getAasId());
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }
//
//    @Override
//    public String updateAlmAsnltmpSgExtend(AlmAsnltmpSgExtendDTO almAsnltmpSgExtendDTO) {
//        JSONObject json = new JSONObject();
//        AlmAsnltmpSgExtendRepository almAsnltmpSgExtendRepository;
//        almAsnltmpSgExtendRepository = AlmAsnltmpSgExtendConvert.INSTANCE.toSYS(almAsnltmpSgExtendDTO);
//        if(almAsnltmpSgExtendDao.updateAlmAsnltmpSgExtend(almAsnltmpSgExtendRepository)>0){
//            try {
//                json.put("code",1);
//                json.put("msg","success");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }

//    @Override
//    public String deleteAlmAsnltmpSgExtend(Integer aasId) {
//        JSONObject json = new JSONObject();
//        Integer count = almAsnltmpSgExtendDao.deleteAlmAsnltmpSgExtend(aasId);
//        if(count >0){
//            try {
//                json.put("code",1);
//                json.put("msg","success");
//                json.put("row_count",count);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return json.toString();
//    }

    @Override
    public AlmAsnltmpSgExtendDTO selectAlmAsnltmpSgExtend(Integer aasId) {
        return AlmAsnltmpSgExtendConvert.INSTANCE.toDTO(almAsnltmpSgExtendDao.selectAlmAsnltmpSgExtend(aasId));
    }

//    @Override
//    public List<AlmAsnltmpSgExtendDTO> selectAllAlmAsnltmpSgExtend(Integer aarId, Integer pageNo, Integer pageSize) {
//        Integer offset = null;
//        if ((pageNo != null) && (pageSize != null)) {
//            offset = pageNo;
//
//        }
//        List<AlmAsnltmpSgExtendRepository> itemList = almAsnltmpSgExtendDao.selectAllAlmAsnltmpSgExtend(aarId, offset, pageSize);
//        if (itemList.size() > 0) {
//            return AlmAsnltmpSgExtendConvert.INSTANCE.toDTOs(itemList);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public Integer getAllAllAlmAsnltmpSgExtend(Integer aatId) {
//        return almAsnltmpSgExtendDao.getAllAlmAsnltmpSgExtend(aatId);
//    }
}

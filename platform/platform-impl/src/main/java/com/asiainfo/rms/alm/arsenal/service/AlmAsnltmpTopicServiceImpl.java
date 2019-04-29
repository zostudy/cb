package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.convert.AlmAsnltmpTopicConvert;
import com.asiainfo.rms.alm.arsenal.dao.AlmAsnltmpTopicDao;
import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpTopicRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpTopicDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Component
@Transactional
public class AlmAsnltmpTopicServiceImpl implements AlmAsnltmpTopicService {
    private final AlmAsnltmpTopicDao almAsnltmpTopicDao;

    public AlmAsnltmpTopicServiceImpl(AlmAsnltmpTopicDao almAsnltmpTopicDao) {
        this.almAsnltmpTopicDao = almAsnltmpTopicDao;
    }

    @Override
    public String saveAlmAsnltmpTopic(AlmAsnltmpTopicDTO almAsnltmpTopicDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpTopicRepository almAsnltmpTopicRepository;
        almAsnltmpTopicRepository = AlmAsnltmpTopicConvert.INSTANCE.toSYS(almAsnltmpTopicDTO);
        almAsnltmpTopicRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));
        //生成需求编码
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        int i =random.nextInt(99)%(100-10+1) + 10;
        long l = System.currentTimeMillis();
        Date date = new Date(l);

        String aatTag = dateFormat.format(date)+i;
        almAsnltmpTopicRepository.setAatTag(aatTag);

        if(almAsnltmpTopicDao.saveAlmAsnltmpTopic(almAsnltmpTopicRepository)>0){
            try {
                json.put("code",1);
                json.put("msg","success");
                json.put("aat_id",almAsnltmpTopicRepository.getAatId());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return json.toString();
    }

    @Override
    public String updateAlmAsnltmpTopic(AlmAsnltmpTopicDTO almAsnltmpTopicDTO) {
        JSONObject json = new JSONObject();
        AlmAsnltmpTopicRepository almAsnltmpTopicRepository;
        almAsnltmpTopicRepository = AlmAsnltmpTopicConvert.INSTANCE.toSYS(almAsnltmpTopicDTO);
        if(almAsnltmpTopicDao.updateAlmAsnltmpTopic(almAsnltmpTopicRepository)>0){
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
    public String deleteAlmAsnltmpTopic(Integer aatId) {
        JSONObject json = new JSONObject();
        Integer count = almAsnltmpTopicDao.deleteAlmAsnltmpTopic(aatId);

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
    public AlmAsnltmpTopicDTO selectAlmAsnltmpTopic(Integer aatId) {
        return AlmAsnltmpTopicConvert.INSTANCE.toDTO(almAsnltmpTopicDao.selectAlmAsnltmpTopic(aatId));
    }

    @Override
    public List<AlmAsnltmpTopicDTO> selectAllAlmAsnltmpTopic(String keyword,
                                                             String artType,
                                                             String aatName,
                                                             String aatTag,
                                                             String aatRegion,
                                                             Integer aatDepart,
                                                             String submitStaffName,
                                                             Integer onlineState,
                                                             String startTime,
                                                             String endTime,
                                                             Integer pageNo,
                                                             Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmAsnltmpTopicRepository> itemList = almAsnltmpTopicDao.selectAllAlmAsnltmpTopic(keyword, artType,aatName,aatTag,aatRegion,aatDepart,submitStaffName,onlineState,startTime,endTime,offset, pageSize);
        if (itemList.size() > 0) {
            return AlmAsnltmpTopicConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmAsnltmpTopic(String keyword,
                                         String artType,
                                         String aatName,
                                         String aatTag,
                                         String aatRegion,
                                         Integer aatDepart,
                                         String submitStaffName,
                                         Integer onlineState,
                                         String startTime,
                                         String endTime) {
        return almAsnltmpTopicDao.getAllAlmAsnltmpTopic(keyword, artType,aatName,aatTag,aatRegion,aatDepart,submitStaffName,onlineState,startTime,endTime);
    }
}

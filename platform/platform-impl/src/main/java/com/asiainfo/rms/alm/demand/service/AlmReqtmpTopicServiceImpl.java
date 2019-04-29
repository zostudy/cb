package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpTopicRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;

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
public class AlmReqtmpTopicServiceImpl implements AlmReqtmpTopicService {
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpTopicServiceImpl(AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }


    @Override
    public String saveAlmReqtmpTopic(AlmReqtmpTopicDTO almReqtmpTopicDTO) {
        Integer artId = 0;
        AlmReqtmpTopicRepository almReqtmpTopicRepository;
        almReqtmpTopicRepository = AlmReqtmpTopicConvert.INSTANCE.toSYS(almReqtmpTopicDTO);
        almReqtmpTopicRepository.setCreateTime(new java.sql.Date(new java.util.Date().getTime()));

        //生成需求编码
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        int i =random.nextInt(99)%(100-10+1) + 10;
        long l = System.currentTimeMillis();
        Date date = new Date(l);

        String artTag = dateFormat.format(date)+i;

        almReqtmpTopicRepository.setArtTag(artTag);

         if(almReqtmpTopicDao.saveAlmReqtmpTopic(almReqtmpTopicRepository)>0){
             artId= almReqtmpTopicRepository.getArtId();
         }
         JSONObject json = new JSONObject();
         try {
			json.put("code", 1);
			json.put("msg", "success");
			json.put("art_id", artId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpTopic(AlmReqtmpTopicDTO almReqtmpTopicDTO) {
        Integer count = 0;
        AlmReqtmpTopicRepository almReqtmpTopicRepository;
        almReqtmpTopicRepository = AlmReqtmpTopicConvert.INSTANCE.toSYS(almReqtmpTopicDTO);
        almReqtmpTopicRepository.setArtTag(null);

        if(almReqtmpTopicDao.updateAlmReqtmpTopic(almReqtmpTopicRepository)>0){
            count++;
        }
        JSONObject json = new JSONObject();
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
       return json.toString();
    }

    @Override
    public String deleteAlmReqtmpTopic(Integer artId) {
        Integer count = almReqtmpTopicDao.deleteAlmReqtmpTopic(artId);
        JSONObject json = new JSONObject();
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public AlmReqtmpTopicDTO selectAlmReqtmpTopicById(Integer artId) {
        return AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
    }

    @Override
    public List<AlmReqtmpTopicDTO> selectAllAlmReqtmpTopic(String keyword,Integer artType,String artName, 
    		String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName,Integer pageNo,Integer pageSize){
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpTopicRepository> itemList = almReqtmpTopicDao.selectAllAlmReqtmpTopic(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName,offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpTopicConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpTopicCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpTopicDao.getAllAlmReqtmpTopicCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }

}

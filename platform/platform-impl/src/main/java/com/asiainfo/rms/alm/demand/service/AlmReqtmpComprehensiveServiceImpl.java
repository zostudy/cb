package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpComprehensiveConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpComprehensiveDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpComprehensiveRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpComprehensiveDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.ComprehensiveDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpComprehensiveServiceImpl implements AlmReqtmpComprehensiveService {
    private final AlmReqtmpComprehensiveDao almReqtmpComprehensiveDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpComprehensiveServiceImpl(AlmReqtmpComprehensiveDao almReqtmpComprehensiveDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpComprehensiveDao = almReqtmpComprehensiveDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpComprehensive(ComprehensiveDTO comprehensiveDTO) {
        JSONObject json = new JSONObject();

        AlmReqtmpTopicDTO almReqtmpTopicDTO = comprehensiveDTO.getTopicDTO();
        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
        String info = almReqtmpTopicService.saveAlmReqtmpTopic(almReqtmpTopicDTO);
        JSONObject jsonReturn;
        String artId = "";
        try {
        	jsonReturn = new JSONObject(info);
        	artId=jsonReturn.getString("art_id");
            json.put("art_id", artId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository;
        almReqtmpComprehensiveRepository = AlmReqtmpComprehensiveConvert.INSTANCE.toSYS(comprehensiveDTO.getComprehensiveDTO());
        almReqtmpComprehensiveRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpComprehensiveDao.saveAlmReqtmpConprehensive(almReqtmpComprehensiveRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arc_id", almReqtmpComprehensiveRepository.getArcId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return json.toString();
    }

    @Override
    public String updateAlmReqtmpComprehensive(ComprehensiveDTO comprehensiveDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = comprehensiveDTO.getTopicDTO();
        if (almReqtmpTopicDTO != null) {
            AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
            String info = almReqtmpTopicService.updateAlmReqtmpTopic(almReqtmpTopicDTO);
            String updateNum = "";
            try {
            	JSONObject jsonReturn = new JSONObject(info);
            	updateNum=jsonReturn.getString("row_count");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //修改基本信息
            if (updateNum.equals("1")) {
                count++;
            }
        }
        AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository;
        almReqtmpComprehensiveRepository = AlmReqtmpComprehensiveConvert.INSTANCE.toSYS(comprehensiveDTO.getComprehensiveDTO());
        if (almReqtmpComprehensiveDao.updateAlmReqtmpConprehensive(almReqtmpComprehensiveRepository) > 0) {
            count++;
        }
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
    public String deleteAlmReqtmpComprehensive(Integer arcId) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository = almReqtmpComprehensiveDao.selectAlmReqtmpConprehensive(arcId);
        Integer artId = almReqtmpComprehensiveRepository.getArtId();
        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
        String num = almReqtmpTopicService.deleteAlmReqtmpTopic(artId);
        String delNum = "";
        try {
        	JSONObject jsonReturn = new JSONObject(num);
        	delNum=jsonReturn.getString("row_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (delNum.equals("1")) {
            count++;
        }
        if (almReqtmpComprehensiveDao.deleteAlmReqtmpConprehensive(arcId) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!!!!!");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public ComprehensiveDTO selectAlmReqtmpComprehensive(Integer arcId) {
        ComprehensiveDTO comprehensiveDTO = new ComprehensiveDTO();
        AlmReqtmpComprehensiveDTO almReqtmpComprehensiveDTO = AlmReqtmpComprehensiveConvert.INSTANCE.toDTO(almReqtmpComprehensiveDao.selectAlmReqtmpConprehensive(arcId));

        comprehensiveDTO.setComprehensiveDTO(almReqtmpComprehensiveDTO);
        if (almReqtmpComprehensiveDTO != null) {

            int artId = almReqtmpComprehensiveDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            comprehensiveDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return comprehensiveDTO;
    }

    @Override
    public ComprehensiveDTO selectComprehensive(Integer artId) {
        ComprehensiveDTO comprehensiveDTO = new ComprehensiveDTO();
        AlmReqtmpComprehensiveDTO almReqtmpComprehensiveDTO = AlmReqtmpComprehensiveConvert.INSTANCE.toDTO(almReqtmpComprehensiveDao.selectAlmReqtmpConprehensiveByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        comprehensiveDTO.setComprehensiveDTO(almReqtmpComprehensiveDTO);
        comprehensiveDTO.setTopicDTO(almReqtmpTopicDTO);
        return comprehensiveDTO;
    }

    @Override
    public List<AlmReqtmpComprehensiveDTO> selectAllAlmReqtmpComprehensive(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpComprehensiveRepository> itemList = almReqtmpComprehensiveDao.selectAllAlmReqtmpConprehensive(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpComprehensiveConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpComprehensive(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpComprehensiveDao.getAlmReqtmpConprehensive(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }
}

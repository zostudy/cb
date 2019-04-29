package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpEleChanlConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpEleChanlDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpEleChanlRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpEleChanlDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.EleChanlDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpEleChanlServiceImpl implements AlmReqtmpEleChanlService {
    private final AlmReqtmpEleChanlDao almReqtmpEleChanlDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpEleChanlServiceImpl(AlmReqtmpEleChanlDao almReqtmpEleChanlDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpEleChanlDao = almReqtmpEleChanlDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpEleChanl(EleChanlDTO eleChanlDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpTopicDTO almReqtmpTopicDTO = eleChanlDTO.getTopicDTO();
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

        AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository;
        almReqtmpEleChanlRepository = AlmReqtmpEleChanlConvert.INSTANCE.toSYS(eleChanlDTO.getEleChanlDTO());
        almReqtmpEleChanlRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpEleChanlDao.saveAlmReqtmpEleChanl(almReqtmpEleChanlRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!");
                json.put("are_id", almReqtmpEleChanlRepository.getAreId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpEleChanl(EleChanlDTO eleChanlDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = eleChanlDTO.getTopicDTO();
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

        AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository;
        almReqtmpEleChanlRepository = AlmReqtmpEleChanlConvert.INSTANCE.toSYS(eleChanlDTO.getEleChanlDTO());

        if (almReqtmpEleChanlDao.updateAlmReqtmpEleChanl(almReqtmpEleChanlRepository) > 0) {
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
    public String deleteAlmReqtmpEleChanl(Integer areId) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository = almReqtmpEleChanlDao.selectAlmReqtmpEleChanl(areId);
        Integer artId = almReqtmpEleChanlRepository.getArtId();
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
        if (almReqtmpEleChanlDao.deleteAlmReqtmpEleChanl(areId) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!!");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public EleChanlDTO selectAlmReqtmpEleChanl(Integer areId) {
        EleChanlDTO eleChanlDTO = new EleChanlDTO();
        AlmReqtmpEleChanlDTO almReqtmpEleChanlDTO = AlmReqtmpEleChanlConvert.INSTANCE.toDTO(almReqtmpEleChanlDao.selectAlmReqtmpEleChanl(areId));

        eleChanlDTO.setEleChanlDTO(almReqtmpEleChanlDTO);
        if (almReqtmpEleChanlDTO != null) {

            int artId = almReqtmpEleChanlDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            eleChanlDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return eleChanlDTO;
    }

    @Override
    public EleChanlDTO selectEleChanl(Integer artId) {
        EleChanlDTO eleChanlDTO = new EleChanlDTO();
        AlmReqtmpEleChanlDTO almReqtmpEleChanlDTO = AlmReqtmpEleChanlConvert.INSTANCE.toDTO(almReqtmpEleChanlDao.selectAlmReqtmpEleChanlByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        eleChanlDTO.setEleChanlDTO(almReqtmpEleChanlDTO);
        eleChanlDTO.setTopicDTO(almReqtmpTopicDTO);
        return eleChanlDTO;
    }

    @Override
    public List<AlmReqtmpEleChanlDTO> selectAllAlmReqtmpEleChanl(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpEleChanlRepository> itemList = almReqtmpEleChanlDao.selectAllAlmReqtmpEleChanl(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpEleChanlConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpEleChanlCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpEleChanlDao.getAllAlmReqtmpEleChanlCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }
}

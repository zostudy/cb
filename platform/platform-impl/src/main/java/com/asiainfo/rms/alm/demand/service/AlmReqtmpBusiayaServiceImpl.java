package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpBusiayaConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpBusiayaDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.BusiayaDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpBusiayaServiceImpl implements AlmReqtmpBusiayaService {
    private final AlmReqtmpBusiayaDao almReqtmpBusiayaDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpBusiayaServiceImpl(AlmReqtmpBusiayaDao almReqtmpBusiayaDao, AlmReqtmpTopicDao almReqtmpTopicDao1) {
        this.almReqtmpBusiayaDao = almReqtmpBusiayaDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao1;
    }

    @Override
    public String saveAlmReqtmpBusiaya(BusiayaDTO busiayaDTO) {
        JSONObject json = new JSONObject();

        AlmReqtmpTopicDTO almReqtmpTopicDTO = busiayaDTO.getTopicDTO();
        AlmReqtmpTopicServiceImpl almReqtmpTopicService = new AlmReqtmpTopicServiceImpl(almReqtmpTopicDao);
        String info = almReqtmpTopicService.saveAlmReqtmpTopic(almReqtmpTopicDTO);
        JSONObject jsonReturn=null;
        String artId = "";
        try {
        	jsonReturn = new JSONObject(info);
        	artId=jsonReturn.getString("art_id");
            json.put("art_id", artId);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository;
        almReqtmpBusiayaRepository = AlmReqtmpBusiayaConvert.INSTANCE.toSYS(busiayaDTO.getBusiayaDTO());
        almReqtmpBusiayaRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpBusiayaDao.saveAlmReqtmpBusiaya(almReqtmpBusiayaRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arba_id", almReqtmpBusiayaRepository.getArbaId());

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpBusiaya(BusiayaDTO busiayaDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = busiayaDTO.getTopicDTO();
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
        AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository;
        almReqtmpBusiayaRepository = AlmReqtmpBusiayaConvert.INSTANCE.toSYS(busiayaDTO.getBusiayaDTO());
        if (almReqtmpBusiayaDao.updateAlmReqtmpBusiaya(almReqtmpBusiayaRepository) > 0) {
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
    public String deleteAlmReqtmpBusiaya(Integer arbaId) {
        JSONObject json = new JSONObject();
        int count = 0;
        //查询
        AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository = almReqtmpBusiayaDao.selectAlmReqtmpBusiaya(arbaId);
        Integer artId = almReqtmpBusiayaRepository.getArtId();
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
        if (almReqtmpBusiayaDao.deleteAlmReqtmpBusiaya(arbaId) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public BusiayaDTO selectAlmReqtmpBusiaya(Integer arbaId) {
        BusiayaDTO busiayaDTO = new BusiayaDTO();
        AlmReqtmpBusiayaDTO almReqtmpBusiayaDTO = AlmReqtmpBusiayaConvert.INSTANCE.toDTO(almReqtmpBusiayaDao.selectAlmReqtmpBusiaya(arbaId));

        busiayaDTO.setBusiayaDTO(almReqtmpBusiayaDTO);
        if (almReqtmpBusiayaDTO != null) {
            int artId = almReqtmpBusiayaDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            busiayaDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return busiayaDTO;
    }

    @Override
    public List<AlmReqtmpBusiayaDTO> selectAllAlmReqtmpBusiaya(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpBusiayaRepository> itemList = almReqtmpBusiayaDao.selectAllAlmReqtmpBusiaya(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpBusiayaConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpBusiayaCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpBusiayaDao.getAllAlmReqtmpBusiayaCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }

    @Override
    public BusiayaDTO selectBusiaya(Integer artId) {
        BusiayaDTO busiayaDTO = new BusiayaDTO();
        AlmReqtmpBusiayaDTO almReqtmpBusiayaDTO = AlmReqtmpBusiayaConvert.INSTANCE.toDTO(almReqtmpBusiayaDao.selectAlmReqtmpBusiayaByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        busiayaDTO.setBusiayaDTO(almReqtmpBusiayaDTO);
        busiayaDTO.setTopicDTO(almReqtmpTopicDTO);
        return busiayaDTO;
    }
}

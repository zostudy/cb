package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpChargeConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpChargeDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpChargeRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpChargeDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.ChargeDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpChargeServiceImpl implements AlmReqtmpChargeService {
    private final AlmReqtmpChargeDao almReqtmpChargeDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpChargeServiceImpl(AlmReqtmpChargeDao almReqtmpChargeDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpChargeDao = almReqtmpChargeDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpCharge(ChargeDTO chargeDTO) {
        JSONObject json = new JSONObject();

        AlmReqtmpTopicDTO almReqtmpTopicDTO = chargeDTO.getTopicDTO();
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

        AlmReqtmpChargeRepository almReqtmpChargeRepository;
        almReqtmpChargeRepository = AlmReqtmpChargeConvert.INSTANCE.toSYS(chargeDTO.getChargeDTO());
        almReqtmpChargeRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpChargeDao.saveAlmReqtmpCharge(almReqtmpChargeRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arch_id", almReqtmpChargeRepository.getArchId());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return json.toString();
    }

    @Override
    public String updateAlmReqtmpCharge(ChargeDTO chargeDTO) {
        JSONObject json = new JSONObject();

        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = chargeDTO.getTopicDTO();
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

        AlmReqtmpChargeRepository almReqtmpChargeRepository;
        almReqtmpChargeRepository = AlmReqtmpChargeConvert.INSTANCE.toSYS(chargeDTO.getChargeDTO());

        if (almReqtmpChargeDao.updateAlmReqtmpCharge(almReqtmpChargeRepository) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String deleteAlmReqtmpCharge(Integer archId) {
        JSONObject json = new JSONObject();
        int count = 0;
        //查询
        AlmReqtmpChargeRepository almReqtmpChargeRepository = almReqtmpChargeDao.selectAlmReqtmpCharge(archId);
        Integer artId = almReqtmpChargeRepository.getArtId();
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
        if (almReqtmpChargeDao.deleteAlmReqtmpCharge(archId) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!!!!");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public ChargeDTO selectAlmReqtmpCharge(Integer archId) {
        ChargeDTO chargeDTO = new ChargeDTO();
        AlmReqtmpChargeDTO almReqtmpChargeDTO = AlmReqtmpChargeConvert.INSTANCE.toDTO(almReqtmpChargeDao.selectAlmReqtmpCharge(archId));

        chargeDTO.setChargeDTO(almReqtmpChargeDTO);
        if (almReqtmpChargeDTO != null) {

            int artId = almReqtmpChargeDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            chargeDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return chargeDTO;

    }

    @Override
    public ChargeDTO selectCharge(Integer artId) {
        ChargeDTO chargeDTO = new ChargeDTO();
        AlmReqtmpChargeDTO almReqtmpChargeDTO = AlmReqtmpChargeConvert.INSTANCE.toDTO(almReqtmpChargeDao.selectAlmReqtmpChargeByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        chargeDTO.setChargeDTO(almReqtmpChargeDTO);
        chargeDTO.setTopicDTO(almReqtmpTopicDTO);
        return chargeDTO;
    }

    @Override
    public List<AlmReqtmpChargeDTO> selectAllAlmReqtmpCharge(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpChargeRepository> itemList = almReqtmpChargeDao.selectAllAlmReqtmpCharge(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpChargeConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpCharge(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpChargeDao.getAllAlmReqtmpCharge(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }
}

package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpMarketConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpMarketDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpMarketRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpMarketDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.MarketDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpMarketServiceImpl implements AlmReqtmpMarketService {
    private final AlmReqtmpMarketDao almReqtmpMarketDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpMarketServiceImpl(AlmReqtmpMarketDao almReqtmpMarketDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpMarketDao = almReqtmpMarketDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpMarket(MarketDTO marketDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpTopicDTO almReqtmpTopicDTO = marketDTO.getTopicDTO();
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

        AlmReqtmpMarketRepository almReqtmpMarketRepository;
        almReqtmpMarketRepository = AlmReqtmpMarketConvert.INSTANCE.toSYS(marketDTO.getMarketDTO());
        almReqtmpMarketRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpMarketDao.saveAlmReqtmpMarket(almReqtmpMarketRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arm_id", almReqtmpMarketRepository.getArmId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpMarket(MarketDTO marketDTO) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = marketDTO.getTopicDTO();
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

        AlmReqtmpMarketRepository almReqtmpMarketRepository;
        almReqtmpMarketRepository = AlmReqtmpMarketConvert.INSTANCE.toSYS(marketDTO.getMarketDTO());
        if (almReqtmpMarketDao.updateAlmReqtmpMarket(almReqtmpMarketRepository) > 0) {
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
    public String deletaAlmReqtmpMarket(Integer armId) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpMarketRepository almReqtmpMarketRepository = almReqtmpMarketDao.selectAlmReqtmpMarket(armId);
        Integer artId = almReqtmpMarketRepository.getArtId();
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
        if (almReqtmpMarketDao.deletaAlmReqtmpMarket(armId) > 0) {
            count++;
        }
        if (count > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success!!!!!!");
                json.put("row_count", count);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return json.toString();
    }

    @Override
    public MarketDTO selectAlmReqtmpMarket(Integer armId) {
        MarketDTO marketDTO = new MarketDTO();
        AlmReqtmpMarketDTO almReqtmpMarketDTO = AlmReqtmpMarketConvert.INSTANCE.toDTO(almReqtmpMarketDao.selectAlmReqtmpMarket(armId));
        marketDTO.setMarketDTO(almReqtmpMarketDTO);
        if (almReqtmpMarketDTO != null) {

            int artId = almReqtmpMarketDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            marketDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return marketDTO;
    }

    @Override
    public MarketDTO selectMarket(Integer artId) {
        MarketDTO marketDTO = new MarketDTO();
        AlmReqtmpMarketDTO almReqtmpMarketDTO = AlmReqtmpMarketConvert.INSTANCE.toDTO(almReqtmpMarketDao.selectAlmReqtmpMarketByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        marketDTO.setMarketDTO(almReqtmpMarketDTO);
        marketDTO.setTopicDTO(almReqtmpTopicDTO);
        return marketDTO;
    }

    @Override
    public Integer getAllAlmReqtmpMarket(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpMarketDao.getAllAlmReqtmpMarket(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }

    @Override
    public List<AlmReqtmpMarketDTO> selectAllAlmReqtmpMarket(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpMarketRepository> itemList = almReqtmpMarketDao.selectAllAlmReqtmpMarket(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpMarketConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }
}

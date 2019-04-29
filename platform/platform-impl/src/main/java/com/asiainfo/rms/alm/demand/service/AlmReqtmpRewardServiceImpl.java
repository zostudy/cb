package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.convert.AlmReqtmpRewardConvert;
import com.asiainfo.rms.alm.demand.convert.AlmReqtmpTopicConvert;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpRewardDao;
import com.asiainfo.rms.alm.demand.dao.AlmReqtmpTopicDao;
import com.asiainfo.rms.alm.demand.domain.AlmReqtmpRewardRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpTopicDTO;
import com.asiainfo.rms.alm.demand.dto.RewardDTO;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AlmReqtmpRewardServiceImpl implements AlmReqtmpRewardService {
    private final AlmReqtmpRewardDao almReqtmpRewardDao;
    private final AlmReqtmpTopicDao almReqtmpTopicDao;

    public AlmReqtmpRewardServiceImpl(AlmReqtmpRewardDao almReqtmpRewardDao, AlmReqtmpTopicDao almReqtmpTopicDao) {
        this.almReqtmpRewardDao = almReqtmpRewardDao;
        this.almReqtmpTopicDao = almReqtmpTopicDao;
    }

    @Override
    public String saveAlmReqtmpReward(RewardDTO rewardDTO) {
        JSONObject json = new JSONObject();
        AlmReqtmpTopicDTO almReqtmpTopicDTO = rewardDTO.getTopicDTO();
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

        AlmReqtmpRewardRepository almReqtmpRewardRepository;
        almReqtmpRewardRepository = AlmReqtmpRewardConvert.INSTANCE.toSYS(rewardDTO.getRewardDTO());
        almReqtmpRewardRepository.setArtId(Integer.parseInt(artId));
        if (almReqtmpRewardDao.saveAlmReqtmpReward(almReqtmpRewardRepository) > 0) {
            try {
                json.put("code", 1);
                json.put("msg", "success");
                json.put("arr_id", almReqtmpRewardRepository.getArrId());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return json.toString();
    }

    @Override
    public String updateAlmReqtmpReward(RewardDTO rewardDTO) {
        JSONObject json = new JSONObject();

        int count = 0;
        AlmReqtmpTopicDTO almReqtmpTopicDTO = rewardDTO.getTopicDTO();
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

        AlmReqtmpRewardRepository almReqtmpRewardRepository;
        almReqtmpRewardRepository = AlmReqtmpRewardConvert.INSTANCE.toSYS(rewardDTO.getRewardDTO());
        if (almReqtmpRewardDao.updateAlmReqtmpReward(almReqtmpRewardRepository) > 0) {
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
    public String deleteAlmReqtmpReward(Integer arrId) {
        JSONObject json = new JSONObject();
        int count = 0;
        AlmReqtmpRewardRepository almReqtmpRewardRepository = almReqtmpRewardDao.selectAlmReqtmpReward(arrId);
        Integer artId = almReqtmpRewardRepository.getArtId();
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
        if (almReqtmpRewardDao.deleteAlmReqtmpReward(arrId) > 0) {
            count++;
        }
        try {
            json.put("code", 1);
            json.put("row_count", count);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    @Override
    public RewardDTO selectAlmReqtmpReward(Integer arrId) {
        RewardDTO rewardDTO = new RewardDTO();
        AlmReqtmpRewardDTO almReqtmpRewardDTO = AlmReqtmpRewardConvert.INSTANCE.toDTO(almReqtmpRewardDao.selectAlmReqtmpReward(arrId));
        rewardDTO.setRewardDTO(almReqtmpRewardDTO);
        if (almReqtmpRewardDTO != null) {

            int artId = almReqtmpRewardDTO.getArtId();
            AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
            rewardDTO.setTopicDTO(almReqtmpTopicDTO);
        }
        return rewardDTO;
    }

    @Override
    public RewardDTO selectReward(Integer artId) {
        RewardDTO rewardDTO = new RewardDTO();
        AlmReqtmpRewardDTO almReqtmpRewardDTO = AlmReqtmpRewardConvert.INSTANCE.toDTO(almReqtmpRewardDao.selectAlmReqtmpRewardByArtId(artId));
        AlmReqtmpTopicDTO almReqtmpTopicDTO = AlmReqtmpTopicConvert.INSTANCE.toDTO(almReqtmpTopicDao.selectAlmReqtmpTopicById(artId));
        rewardDTO.setRewardDTO(almReqtmpRewardDTO);
        rewardDTO.setTopicDTO(almReqtmpTopicDTO);
        return rewardDTO;
    }

    @Override
    public List<AlmReqtmpRewardDTO> selectAllAlmReqtmpReward(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize) {
        Integer offset = null;
        if ((pageNo != null) && (pageSize != null)) {
            offset = pageNo;

        }
        List<AlmReqtmpRewardRepository> itemList = almReqtmpRewardDao.selectAllAlmReqtmpReward(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName, offset, pageSize);
        if (itemList.size() > 0) {
            return AlmReqtmpRewardConvert.INSTANCE.toDTOs(itemList);
        } else {
            return null;
        }
    }

    @Override
    public Integer getAllAlmReqtmpRewardCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName) {
        return almReqtmpRewardDao.getAllAlmReqtmpRewardCount(keyword,artType,artName,artTag,artRegion,urgentLevel,submitStaffName);
    }
}

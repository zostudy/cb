package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardDTO;
import com.asiainfo.rms.alm.demand.dto.RewardDTO;

import java.util.List;

public interface AlmReqtmpRewardService {

    String saveAlmReqtmpReward(RewardDTO rewardDTO);

    String updateAlmReqtmpReward(RewardDTO rewardDTO);

    String deleteAlmReqtmpReward(Integer arrId);

    RewardDTO selectAlmReqtmpReward(Integer arrId);

    RewardDTO selectReward(Integer artId);

    List<AlmReqtmpRewardDTO> selectAllAlmReqtmpReward(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpRewardCount(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);
}

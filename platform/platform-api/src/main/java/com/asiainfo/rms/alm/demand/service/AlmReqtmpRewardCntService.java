package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpRewardCntDTO;

import java.util.List;

public interface AlmReqtmpRewardCntService {

    String saveAlmReqtmpRewardCnt(AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO);

    String updateAlmReqtmpRewardCnt(AlmReqtmpRewardCntDTO almReqtmpRewardCntDTO);

    String deleteAlmReqtmpRewardCnt(Integer contentId);

    AlmReqtmpRewardCntDTO selectAlmReqtmpRewardCnt(Integer contentId);

    List<AlmReqtmpRewardCntDTO> selectAllAlmReqtmpRewardCnt(Integer arrId,String keyword, Integer pageNo, Integer pageSize);

    Integer getAllAlmReqtmpRewardCntCount(Integer arrId,String keyword);
}

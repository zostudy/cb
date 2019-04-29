package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpMarketDTO;
import com.asiainfo.rms.alm.demand.dto.MarketDTO;

import java.util.List;

public interface AlmReqtmpMarketService {
    String saveAlmReqtmpMarket(MarketDTO marketDTO);

    String updateAlmReqtmpMarket(MarketDTO marketDTO);

    String deletaAlmReqtmpMarket(Integer armId);

    MarketDTO selectAlmReqtmpMarket(Integer armId);

    MarketDTO selectMarket(Integer artId);

    Integer getAllAlmReqtmpMarket(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName);

    List<AlmReqtmpMarketDTO> selectAllAlmReqtmpMarket(String keyword,Integer artType,String artName, String artTag,Integer artRegion,Integer urgentLevel,String submitStaffName, Integer pageNo, Integer pageSize);
}

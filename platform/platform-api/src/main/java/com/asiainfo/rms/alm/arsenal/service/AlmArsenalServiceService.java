package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalServiceDTO;

import java.util.List;

public interface AlmArsenalServiceService {

    String saveAlmArsenalService(AlmArsenalServiceDTO almArsenalServiceDTO);

    String updateAlmArsenalService(AlmArsenalServiceDTO almArsenalServiceDTO);

    String deleteAlmArsenalService(Integer asId);

    AlmArsenalServiceDTO selectAlmArsenalServiceById(Integer asId);

    List<AlmArsenalServiceDTO> selectAllAlmArsenalService(String keyword,Integer pageNo, Integer pageSize);

    Integer getAllAlmArsenalService(String keyword);
}

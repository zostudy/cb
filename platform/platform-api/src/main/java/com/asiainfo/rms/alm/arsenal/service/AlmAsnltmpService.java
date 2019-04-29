package com.asiainfo.rms.alm.arsenal.service;


import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpXFSearchDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpYCSearchDTO;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSearchResultDTO;

import java.util.List;

/*
用于对武器库进行全文搜索的接口
 */
public interface AlmAsnltmpService {

    List<AlmAsnltmpXFSearchDTO> searchAsnltmpXF(String searchText, String start_date, String end_date, int start, int end);


    List<AlmAsnltmpYCSearchDTO> searchAsnltmpYC(String searchText, String start_date, String end_date, int start, int end);

}

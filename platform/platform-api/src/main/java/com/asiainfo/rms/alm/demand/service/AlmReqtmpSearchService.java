package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSearchResultDTO;

import java.util.List;


/**
 * 用于需求模板搜索
 */
public interface AlmReqtmpSearchService {

    /**
     * 通过搜索文本进行搜索
     * @param searchText
     * @return
     */
    List<AlmReqtmpSearchResultDTO> searchTopicBySearchText(String searchText, int start, int end);
}

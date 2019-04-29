package com.asiainfo.rms.alm.demand.service;

import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSearchResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmReqtmpSearchServiceImpl implements AlmReqtmpSearchService {

    private static final transient Logger log = LoggerFactory.getLogger(AlmReqtmpSearchServiceImpl.class);

//    @Autowired
//    private TransportClient client;

    @Override
    public List<AlmReqtmpSearchResultDTO> searchTopicBySearchText(String searchText, int start, int end) {
//        log.debug("Start search reqtmp by text: {}", searchText);
//        QueryBuilder qb = boolQuery()
//                .should(matchQuery("_all", searchText))
//                ;
//
//        SearchResponse searchResponse = client.prepareSearch("rms")
//                .setTypes("reqtmp")
//                .setQuery(qb)
//                .setFrom(start).setSize(end).setExplain(true)
//                .execute()
//                .actionGet();
//
//
//        Gson gson = new GsonBuilder().create();
//        return Arrays.stream(searchResponse.getHits().getHits())
//                .map((h)-> gson.fromJson(h.getSourceAsString(), AlmReqtmpSearchResultDTO.class))
//                .collect(Collectors.toList());
return null;

    }
}

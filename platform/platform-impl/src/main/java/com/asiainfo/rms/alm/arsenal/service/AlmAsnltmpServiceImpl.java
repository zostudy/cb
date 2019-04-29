package com.asiainfo.rms.alm.arsenal.service;

import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpXFSearchDTO;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpYCSearchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlmAsnltmpServiceImpl implements AlmAsnltmpService {
    @Override
    public List<AlmAsnltmpXFSearchDTO> searchAsnltmpXF(String searchText, String start_date, String end_date, int start, int end) {
        return null;
    }

    @Override
    public List<AlmAsnltmpYCSearchDTO> searchAsnltmpYC(String searchText, String start_date, String end_date, int start, int end) {
        return null;
    }
//
//    private static final transient Logger log = LoggerFactory.getLogger(AlmAsnltmpServiceImpl.class);
//
//    @Autowired
//    private TransportClient client;
//
//    @Override
//    public List<AlmAsnltmpXFSearchDTO> searchAsnltmpXF(String searchText, String startTime, String endTime, int start, int end) {
//        log.debug("Start search searchAsnltmpXF by text: {}", searchText);
//        QueryBuilder qb = boolQuery().filter(rangeQuery("create_time").from(startTime).to(endTime))
//                    .must(matchQuery("_all", searchText));
//
//
//        SearchResponse searchResponse = client.prepareSearch("rms")
//                .setTypes("asnltmp_xf")
//                .setQuery(qb)
//                .setFrom(start).setSize(end).setExplain(true)
//                .execute()
//                .actionGet();
//
//
//        Gson gson = new GsonBuilder().create();
//        return Arrays.stream(searchResponse.getHits().getHits())
//                .map((h)-> gson.fromJson(h.getSourceAsString(), AlmAsnltmpXFSearchDTO.class))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<AlmAsnltmpYCSearchDTO> searchAsnltmpYC(String searchText, String startTime, String endTime, int start, int end) {
//        log.debug("Start search searchAsnltmpYC by text: {}", searchText);
//        QueryBuilder qb = boolQuery().filter(rangeQuery("create_time").from(startTime).to(endTime))
//                .must(matchQuery("_all", searchText));
//
//        SearchResponse searchResponse = client.prepareSearch("rms")
//                .setTypes("asnltmp_yc")
//                .setQuery(qb)
//                .setFrom(start).setSize(end).setExplain(true)
//                .execute()
//                .actionGet();
//
//
//        Gson gson = new GsonBuilder().create();
//        return Arrays.stream(searchResponse.getHits().getHits())
//                .map((h)-> gson.fromJson(h.getSourceAsString(), AlmAsnltmpYCSearchDTO.class))
//                .collect(Collectors.toList());
//    }
}

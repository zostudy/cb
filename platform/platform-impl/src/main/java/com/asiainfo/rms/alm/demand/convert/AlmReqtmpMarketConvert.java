package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpMarketRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpMarketDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpMarketConvert {
    AlmReqtmpMarketConvert INSTANCE = Mappers.getMapper(AlmReqtmpMarketConvert.class);
    @Mappings({
            @Mapping(target = "activateTimeStart", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "activateTimeEnd", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpMarketDTO toDTO(AlmReqtmpMarketRepository almReqtmpMarketRepository);

    @Mappings({
            @Mapping(target = "activateTimeStart", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "activateTimeEnd", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpMarketRepository toSYS(AlmReqtmpMarketDTO almReqtmpMarketDTO);


    List<AlmReqtmpMarketDTO> toDTOs(List<AlmReqtmpMarketRepository> almReqtmpMarketRepositoryList);
}

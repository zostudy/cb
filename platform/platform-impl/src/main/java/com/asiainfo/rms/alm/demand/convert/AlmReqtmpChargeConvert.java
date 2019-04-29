package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpChargeRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpChargeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpChargeConvert {

    AlmReqtmpChargeConvert INSTANCE = Mappers.getMapper(AlmReqtmpChargeConvert.class);
    @Mappings({
            @Mapping(target = "activateTimeStart", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "activateTimeEnd", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpChargeDTO toDTO(AlmReqtmpChargeRepository almReqtmpChargeRepository);

    @Mappings({
            @Mapping(target = "activateTimeStart", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "activateTimeEnd", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpChargeRepository toSYS(AlmReqtmpChargeDTO almReqtmpChargeDTO);

    List<AlmReqtmpChargeDTO> toDTOs(List<AlmReqtmpChargeRepository> almReqtmpChargeRepositoryList);
}

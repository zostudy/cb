package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpBusiayaRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpBusiayaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpBusiayaConvert {

    AlmReqtmpBusiayaConvert INSTANCE = Mappers.getMapper(AlmReqtmpBusiayaConvert.class);
    @Mappings({
            @Mapping(target = "applyTimeEnd", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "applyTimeStart", dateFormat = "yyyy-MM-dd")
    })
    AlmReqtmpBusiayaDTO toDTO(AlmReqtmpBusiayaRepository almReqtmpBusiayaRepository);
    @Mappings({
            @Mapping(target = "applyTimeEnd", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "applyTimeStart", dateFormat = "yyyy-MM-dd")
    })

    AlmReqtmpBusiayaRepository toSYS(AlmReqtmpBusiayaDTO almReqtmpBusiayaDTO);


    List<AlmReqtmpBusiayaDTO> toDTOs(List<AlmReqtmpBusiayaRepository> almReqtmpBusiayaRepositories);
}

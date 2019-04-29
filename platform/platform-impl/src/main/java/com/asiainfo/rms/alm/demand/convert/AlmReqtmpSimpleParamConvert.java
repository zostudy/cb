package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpSimpleParamRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpSimpleParamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpSimpleParamConvert {
    AlmReqtmpSimpleParamConvert INSTANCE = Mappers.getMapper(AlmReqtmpSimpleParamConvert.class);
    @Mappings({
            @Mapping(target = "offlineTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "onlineTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AlmReqtmpSimpleParamDTO toDTO(AlmReqtmpSimpleParamRepository almReqtmpSimpleParamRepository);

    @Mappings({
            @Mapping(target = "offlineTime", dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "onlineTime", dateFormat = "yyyy-MM-dd HH:mm:ss")
    })
    AlmReqtmpSimpleParamRepository toSYS(AlmReqtmpSimpleParamDTO almReqtmpSimpleParamDTO);


    List<AlmReqtmpSimpleParamDTO> toDTOs(List<AlmReqtmpSimpleParamRepository> almReqtmpSimpleParamRepositories);
}

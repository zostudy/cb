package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpFunctionRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpFunctionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpFunctionConvert {
    AlmReqtmpFunctionConvert INSTANCE = Mappers.getMapper(AlmReqtmpFunctionConvert.class);

    AlmReqtmpFunctionDTO toDTO(AlmReqtmpFunctionRepository almReqtmpFunctionRepository);

    AlmReqtmpFunctionRepository toSYS(AlmReqtmpFunctionDTO almReqtmpFunctionDTO);

    List<AlmReqtmpFunctionDTO> toDTOs(List<AlmReqtmpFunctionRepository> almReqtmpFunctionRepositoryList);
}

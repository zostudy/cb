package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpEleChanlRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpEleChanlDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpEleChanlConvert {

    AlmReqtmpEleChanlConvert INSTANCE = Mappers.getMapper(AlmReqtmpEleChanlConvert.class);

    AlmReqtmpEleChanlDTO toDTO(AlmReqtmpEleChanlRepository almReqtmpEleChanlRepository);

    AlmReqtmpEleChanlRepository toSYS(AlmReqtmpEleChanlDTO almReqtmpEleChanlDTO);

    List<AlmReqtmpEleChanlDTO> toDTOs(List<AlmReqtmpEleChanlRepository> almReqtmpEleChanlRepositoryList);
}

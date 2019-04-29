package com.asiainfo.rms.alm.demand.convert;

import com.asiainfo.rms.alm.demand.domain.AlmReqtmpComprehensiveRepository;
import com.asiainfo.rms.alm.demand.dto.AlmReqtmpComprehensiveDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmReqtmpComprehensiveConvert {
    AlmReqtmpComprehensiveConvert INSTANCE = Mappers.getMapper(AlmReqtmpComprehensiveConvert.class);

    AlmReqtmpComprehensiveDTO toDTO(AlmReqtmpComprehensiveRepository almReqtmpComprehensiveRepository);

    AlmReqtmpComprehensiveRepository toSYS(AlmReqtmpComprehensiveDTO almReqtmpComprehensiveDTO);

    List<AlmReqtmpComprehensiveDTO> toDTOs(List<AlmReqtmpComprehensiveRepository> almReqtmpComprehensiveRepositories);
}

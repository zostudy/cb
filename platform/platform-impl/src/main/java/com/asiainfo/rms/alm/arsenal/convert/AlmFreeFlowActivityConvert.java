package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmFreeFlowActivityRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmFreeFlowActivityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmFreeFlowActivityConvert {
    AlmFreeFlowActivityConvert INSTANCE = Mappers.getMapper(AlmFreeFlowActivityConvert.class);

    AlmFreeFlowActivityDTO toDTO(AlmFreeFlowActivityRepository almFreeFlowActivityRepository);

    AlmFreeFlowActivityRepository toSYS(AlmFreeFlowActivityDTO almFreeFlowActivityDTO);

    List<AlmFreeFlowActivityDTO> toDTOs(List<AlmFreeFlowActivityRepository> almFreeFlowActivityRepositoryList);
}

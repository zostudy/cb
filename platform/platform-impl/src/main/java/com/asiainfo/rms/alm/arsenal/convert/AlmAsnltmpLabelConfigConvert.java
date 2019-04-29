package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpLabelConfigRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpLabelConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpLabelConfigConvert {
    AlmAsnltmpLabelConfigConvert INSTANCE = Mappers.getMapper(AlmAsnltmpLabelConfigConvert.class);

    AlmAsnltmpLabelConfigDTO toDTO(AlmAsnltmpLabelConfigRepository almAsnltmpLabelConfigRepository);

    AlmAsnltmpLabelConfigRepository toSYS(AlmAsnltmpLabelConfigDTO almAsnltmpLabelConfigDTO);

    List<AlmAsnltmpLabelConfigDTO> toDTOs(List<AlmAsnltmpLabelConfigRepository> asnltmpLabelConfigRepositoryList);
}

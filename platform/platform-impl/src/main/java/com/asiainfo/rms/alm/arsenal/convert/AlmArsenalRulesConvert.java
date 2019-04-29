package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmArsenalRulesRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmArsenalRulesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmArsenalRulesConvert {
    AlmArsenalRulesConvert INSTANCE = Mappers.getMapper(AlmArsenalRulesConvert.class);

    AlmArsenalRulesDTO toDTO(AlmArsenalRulesRepository almArsenalRulesRepository);

    AlmArsenalRulesRepository toSYS(AlmArsenalRulesDTO almArsenalRulesDTO);

    List<AlmArsenalRulesDTO> toDTOs(List<AlmArsenalRulesRepository> almArsenalRulesRepositoryList);
}

package com.asiainfo.rms.alm.arsenal.convert;

import com.asiainfo.rms.alm.arsenal.domain.AlmAsnltmpRuleValueRepository;
import com.asiainfo.rms.alm.arsenal.dto.AlmAsnltmpRuleValueDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AlmAsnltmpRuleValueConvert {
    AlmAsnltmpRuleValueConvert INSTANCE = Mappers.getMapper(AlmAsnltmpRuleValueConvert.class);

    AlmAsnltmpRuleValueDTO toDTO(AlmAsnltmpRuleValueRepository almAsnltmpRuleValueRepository);

    AlmAsnltmpRuleValueRepository toSYS(AlmAsnltmpRuleValueDTO almAsnltmpRuleValueDTO);

    List<AlmAsnltmpRuleValueDTO> toDTOs(List<AlmAsnltmpRuleValueRepository> almAsnltmpRuleValueRepositoryList);
}
